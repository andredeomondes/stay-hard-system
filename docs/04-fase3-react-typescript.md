# 📚 FASE 3 — JavaScript + TypeScript + React

## JavaScript ES6+

### Destructuring
```javascript
const user = { name: 'André', age: 25 };
const { name, age } = user;

const colors = ['red', 'green', 'blue'];
const [first, second] = colors;
```

### Spread / Rest
```javascript
// Spread
const arr1 = [1, 2, 3];
const arr2 = [...arr1, 4, 5]; // [1, 2, 3, 4, 5]

const obj1 = { a: 1, b: 2 };
const obj2 = { ...obj1, c: 3 }; // { a: 1, b: 2, c: 3 }

// Rest
function sum(...numbers) {
    return numbers.reduce((a, b) => a + b, 0);
}
```

### Arrow Functions
```javascript
const add = (a, b) => a + b;
const greet = name => `Hello, ${name}!`;
const double = n => n * 2;
```

### Array Methods
```javascript
const numbers = [1, 2, 3, 4, 5];

numbers.map(n => n * 2);           // [2, 4, 6, 8, 10]
numbers.filter(n => n > 3);        // [4, 5]
numbers.reduce((sum, n) => sum + n, 0); // 15
numbers.find(n => n > 3);          // 4
numbers.some(n => n > 3);          // true
numbers.every(n => n > 0);         // true
```

### Async/Await
```javascript
async function fetchUsers() {
    try {
        const response = await fetch('/api/users');
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Erro:', error);
    }
}
```

---

## TypeScript

### Types
```typescript
let name: string = 'André';
let age: number = 25;
let active: boolean = true;
let colors: string[] = ['red', 'green'];
let tuple: [string, number] = ['André', 25];
```

### Interface
```typescript
interface User {
    id: number;
    name: string;
    email: string;
    age?: number;  // opcional
}

interface CreateUserRequest {
    name: string;
    email: string;
    password: string;
}
```

### Type vs Interface
```typescript
// Type (mais flexível)
type Priority = 'LOW' | 'MEDIUM' | 'HIGH';
type Status = 'TODO' | 'IN_PROGRESS' | 'DONE';

// Interface (melhor para objetos)
interface Habit {
    id: number;
    name: string;
    priority: Priority;
    status: Status;
}
```

### Generics
```typescript
interface ApiResponse<T> {
    data: T;
    message: string;
    status: number;
}

type UserResponse = ApiResponse<User>;
type HabitsResponse = ApiResponse<Habit[]>;
```

---

## React + TypeScript

### Componente
```tsx
interface HabitCardProps {
    habit: Habit;
    onComplete: (id: number) => void;
}

export function HabitCard({ habit, onComplete }: HabitCardProps) {
    return (
        <div className="habit-card">
            <h3>{habit.name}</h3>
            <span>{habit.priority}</span>
            <span>{habit.status}</span>
            {habit.status !== 'DONE' && (
                <button onClick={() => onComplete(habit.id)}>
                    Completar
                </button>
            )}
        </div>
    );
}
```

### useState
```tsx
const [habits, setHabits] = useState<Habit[]>([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState<string | null>(null);
```

### useEffect
```tsx
useEffect(() => {
    async function loadHabits() {
        try {
            const response = await api.get<Habit[]>('/api/habits');
            setHabits(response.data);
        } catch (err) {
            setError('Erro ao carregar hábitos');
        } finally {
            setLoading(false);
        }
    }
    loadHabits();
}, []); // [] = roda uma vez ao montar
```

### Context API (Auth)
```tsx
interface AuthContextType {
    user: User | null;
    token: string | null;
    login: (email: string, password: string) => Promise<void>;
    logout: () => void;
    isAuthenticated: boolean;
}

const AuthContext = createContext<AuthContextType>({} as AuthContextType);

export function AuthProvider({ children }: { children: ReactNode }) {
    const [user, setUser] = useState<User | null>(null);
    const [token, setToken] = useState<string | null>(
        localStorage.getItem('token')
    );

    const login = async (email: string, password: string) => {
        const response = await api.post('/api/auth/login', { email, password });
        setToken(response.data.token);
        setUser(response.data.user);
        localStorage.setItem('token', response.data.token);
    };

    const logout = () => {
        setToken(null);
        setUser(null);
        localStorage.removeItem('token');
    };

    return (
        <AuthContext.Provider value={{ user, token, login, logout, isAuthenticated: !!token }}>
            {children}
        </AuthContext.Provider>
    );
}

export const useAuth = () => useContext(AuthContext);
```

### Axios com JWT
```typescript
// src/services/api.ts
import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:8080',
});

api.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

api.interceptors.response.use(
    (response) => response,
    (error) => {
        if (error.response?.status === 401) {
            localStorage.removeItem('token');
            window.location.href = '/login';
        }
        return Promise.reject(error);
    }
);
```

### Protected Route
```tsx
export function ProtectedRoute({ children }: { children: ReactNode }) {
    const { isAuthenticated } = useAuth();

    if (!isAuthenticated) {
        return <Navigate to="/login" />;
    }

    return <>{children}</>;
}
```

### Custom Hook
```tsx
export function useHabits() {
    const [habits, setHabits] = useState<Habit[]>([]);
    const [loading, setLoading] = useState(true);

    const loadHabits = async () => {
        const response = await api.get<Habit[]>('/api/habits');
        setHabits(response.data);
        setLoading(false);
    };

    const completeHabit = async (id: number) => {
        await api.put(`/api/habits/${id}/complete`);
        setHabits(prev =>
            prev.map(h => h.id === id ? { ...h, status: 'DONE' } : h)
        );
    };

    useEffect(() => { loadHabits(); }, []);

    return { habits, loading, completeHabit, reload: loadHabits };
}
```
