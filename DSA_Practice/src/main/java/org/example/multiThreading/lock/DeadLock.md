# Deadlock in Java

In Java, a deadlock occurs when two or more threads are blocked forever, each waiting for a resource
that the other holds. This can happen if threads acquire locks in a different order or if there is a
circular dependency in lock acquisition.

## Example of a Deadlock in Java

Here is a simple example to illustrate a deadlock situation:

```java
public class DeadlockExample {

  private static final Object lock1 = new Object();
  private static final Object lock2 = new Object();

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
      synchronized (lock1) {
        System.out.println("Thread 1: Holding lock1...");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread 1: Waiting for lock2...");
        synchronized (lock2) {
          System.out.println("Thread 1: Acquired lock2!");
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      synchronized (lock2) {
        System.out.println("Thread 2: Holding lock2...");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread 2: Waiting for lock1...");
        synchronized (lock1) {
          System.out.println("Thread 2: Acquired lock1!");
        }
      }
    });

    thread1.start();
    thread2.start();
  }
}
```

## Example of a Deadlock in Java

In this example:

- **Thread 1** acquires `lock1` and then tries to acquire `lock2`.
- **Thread 2** acquires `lock2` and then tries to acquire `lock1`.

If **Thread 1** acquires `lock1` and **Thread 2** acquires `lock2` at almost the same time, both
threads will be waiting indefinitely for the other lock, resulting in a deadlock.

## How to Detect Deadlocks in Java

Java provides tools to help detect deadlocks:

1. **Thread Dump**: You can obtain a thread dump to see which threads are blocked and the resources
   they are waiting for. This can be done using tools like `jstack` or by generating a thread dump
   from within your Java application using `Thread.getAllStackTraces()`.

2. **JVM Options**: Use JVM options like `-XX:+PrintConcurrentLocks` or `-XX:+PrintLockStatistics`
   to enable detailed logging of lock acquisition and contention.

## How to Prevent Deadlocks

1. **Lock Ordering**: Always acquire locks in a consistent global order. For instance, if you have
   multiple locks, always acquire them in a predefined order to avoid circular dependencies.

2. **Timeouts**: Use `tryLock` with a timeout when acquiring locks to avoid indefinite blocking. For
   example:

```java
ReentrantLock lock1 = new ReentrantLock();
ReentrantLock lock2 = new ReentrantLock();

public void process() {
  try {
    if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
      try {
        if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
          try {
            // Critical section
          } finally {
            lock2.unlock();
          }
        }
      } finally {
        lock1.unlock();
      }
    }
  } catch (InterruptedException e) {
    // Handle interruption
  }
}
 ```

By following these practices, you can reduce the likelihood of deadlocks in your Java applications
and improve overall concurrency management.


3. **Deadlock Detection**: Implement algorithms or use tools that detect deadlocks and resolve them, such as by terminating or rolling back processes.

4. **Minimize Lock Scope**: Keep the scope of lock acquisitions as narrow as possible to reduce the chance of encountering a deadlock.

5. **Avoid Nested Locks**: Minimize or avoid acquiring multiple locks simultaneously when possible.

