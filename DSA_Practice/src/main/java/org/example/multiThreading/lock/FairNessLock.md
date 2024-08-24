# Fairness of Locks in Multithreading

The fairness of locks refers to the order in which threads acquire a lock when multiple threads are competing for it. In the context of multithreading, fairness is concerned with ensuring that every thread gets a fair chance to acquire the lock without being indefinitely delayed or "starved."

## Fair vs. Unfair Locks

### Fair Lock

- A fair lock ensures that threads acquire the lock in the order they requested it (typically first-come, first-served).
- When a fair lock is used, the longest-waiting thread will be granted the lock next, preventing thread starvation.
- Fair locks are generally implemented using a queue that holds the threads waiting for the lock.

### Unfair Lock

- An unfair lock does not guarantee any particular order in which threads will acquire the lock.
- The lock might be granted to a thread that requests it even if other threads have been waiting longer.
- Unfair locks are often more efficient because they reduce the overhead of maintaining a queue but may result in thread starvation where some threads are delayed indefinitely.

## Example in Java

In Java, `ReentrantLock` provides an option to create a fair or unfair lock:

### Fair Lock

```java
ReentrantLock fairLock = new ReentrantLock(true);
```

## Unfair Lock

```java
ReentrantLock unfairLock = new ReentrantLock();
```

By default (or with the `false` argument), the lock is unfair. This may result in higher throughput but at the cost of fairness.

## When to Use Fair or Unfair Locks

- **Fair Locks**: Useful when you need to prevent starvation and ensure predictable behavior. However, they can introduce more overhead, potentially reducing performance.
- **Unfair Locks**: Preferred when performance is critical, and the application can tolerate some degree of thread starvation. They generally provide better throughput due to reduced locking overhead.

## Summary

- **Fairness**: Guarantees that threads are granted locks in the order they request them, preventing starvation but potentially at the cost of performance.
- **Unfairness**: Prioritizes performance over fairness, leading to better throughput but possible thread starvation.
