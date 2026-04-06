# Java — Обработка исключений (Глава 5)

## Что изучено

### try...catch...finally
- `try` — блок где может возникнуть исключение
- `catch` — перехват и обработка исключения
- `finally` — выполняется всегда, независимо от того было исключение или нет
- Можно ловить несколько исключений через несколько `catch` блоков

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Ошибка: " + e.getMessage());
} finally {
    System.out.println("Выполнится всегда");
}
```

---

### Иерархия классов исключений

```
Throwable
├── Error          — критические ошибки JVM (не ловить!)
│   ├── StackOverflowError
│   └── OutOfMemoryError
└── Exception      — обычные исключения
    ├── RuntimeException        — Unchecked (не обязательно ловить)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ArithmeticException
    │   ├── ClassCastException
    │   └── IllegalArgumentException
    └── IOException             — Checked (обязательно обрабатывать)
        └── FileNotFoundException
```

**Checked** — компилятор заставляет обработать (try/catch или throws)
**Unchecked** — на усмотрение разработчика (RuntimeException и его наследники)

---

### throws и throw

**throw** — вручную бросить исключение:
```java
throw new IllegalArgumentException("Возраст не может быть отрицательным");
```

**throws** — объявить что метод может бросить исключение (аналог `error` в Go):
```java
public void readFile(String path) throws IOException {
    // ...
}
```

---

### Создание своих исключений

```java
// Unchecked — наследуемся от RuntimeException
public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Checked — наследуемся от Exception
public class ZooCapacityException extends Exception {
    public ZooCapacityException(String message) {
        super(message);
    }
}

// Использование
throw new InvalidAgeException("Возраст не может быть отрицательным: " + age);
```

---

### Assert

- Используется для проверок во время разработки/отладки
- По умолчанию **выключен** в JVM, включается флагом `-ea`
- В продакшене не использовать — только для отладки

```java
assert age > 0 : "Возраст должен быть положительным";
```

---

## Шпаргалка — когда что использовать

| Ситуация | Что делать |
|---|---|
| Ошибка в логике программы | `RuntimeException` (Unchecked) |
| Внешние ресурсы (файлы, сеть) | `Exception` (Checked) |
| Критическая ошибка JVM | Не ловить `Error` |
| Проверка аргументов метода | `throw new IllegalArgumentException` |
| Null значение | `throw new NullPointerException` или проверка |
| Отладка | `assert` |

---

## Аналогия с Go

| Java | Go |
|---|---|
| `try/catch` | `if err != nil` |
| `throws` | возвращаемый `error` в сигнатуре |
| `throw` | `return nil, errors.New(...)` |
| Checked Exception | обязательная обработка `error` |
| Unchecked Exception | `panic` |
| `finally` | `defer` |