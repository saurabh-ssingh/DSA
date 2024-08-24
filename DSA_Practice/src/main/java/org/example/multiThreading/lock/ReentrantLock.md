
# ReentrantLock in Java

`ReentrantLock` is a class in Java's `java.util.concurrent.locks` package that provides a more flexible and powerful alternative to the `synchronized` keyword for managing thread access to shared resources. It is a type of lock that allows a thread to acquire the lock multiple times (hence "reentrant") without causing a deadlock, as long as it releases the lock the same number of times it has acquired it.

## Key Features of ReentrantLock

### Reentrancy

A `ReentrantLock` can be acquired multiple times by the same thread without causing a deadlock. Each time the thread acquires the lock, it increments a hold count, and each time it releases the lock, the hold count is decremented. The lock is fully released when the hold count reaches zero.

### Lock Fairness

`ReentrantLock` can be configured to be "fair" or "unfair."

- A fair lock ensures that threads acquire the lock in the order they requested it, preventing thread starvation. This is done by a first-come, first-served basis.
- An unfair lock (the default) allows the thread to jump ahead of waiting threads if the lock becomes available, which can lead to better throughput but might cause starvation.

### Lock Methods

- **`lock()`**: Acquires the lock, blocking the thread until the lock is available.
- **`lockInterruptibly()`**: Acquires the lock unless the thread is interrupted while waiting.
- **`tryLock()`**: Attempts to acquire the lock immediately without blocking. Returns `true` if the lock is acquired, `false` otherwise.
- **`tryLock(long time, TimeUnit unit)`**: Attempts to acquire the lock within the given time period. If the lock isn't acquired within that time, it returns `false`.

# Methods of ReentrantLock

## `lock()`

- **Description**:
    - Acquires the lock, blocking the current thread until the lock is available.
    - It would block the thread until the lock becomes available, potentially leading to situations where a thread waits indefinitely.
    - If the lock is already held by another thread, the current thread will wait until it can acquire the lock.

## `tryLock()`

- **Description**:
    - Tries to acquire the lock without waiting.
    - Returns `true` if the lock was acquired, `false` otherwise.
    - This is non-blocking, meaning the thread will not wait if the lock is not available.

## `tryLock(long timeout, TimeUnit unit)`

- **Description**:
    - Attempts to acquire the lock, but with a timeout.
    - If the lock is not available, the thread waits for the specified time before giving up.
    - It is used when you want to attempt to acquire the lock without waiting indefinitely.
    - Allows the thread to proceed with other work if the lock isn't available within the specified time.
    - This approach is useful to avoid deadlock scenarios and when you don't want a thread to block forever waiting for a lock.
    - Returns `true` if the lock was acquired within the timeout, `false` otherwise.

## `unlock()`

- **Description**:
    - Releases the lock held by the current thread.
    - Must be called in a `finally` block to ensure that the lock is always released even if an exception occurs.

## `lockInterruptibly()`

- **Description**:
    - Acquires the lock unless the current thread is interrupted.
    - Useful when you want to handle interruptions while acquiring a lock.


### Condition Objects

`ReentrantLock` provides the ability to create `Condition` objects, which are similar to the `wait`, `notify`, and `notifyAll` mechanisms used with synchronized blocks. These can be used for more sophisticated thread coordination.

### Unlocking

The `unlock()` method is used to release the lock. It should always be called in a `finally` block to ensure that the lock is released even if an exception occurs.


# Example Usage of ReentrantLock

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private final Lock lock = new ReentrantLock();

    public void doSomething() {
        lock.lock(); // Acquire the lock
        try {
            // Critical section: code that needs to be thread-safe
            System.out.println(Thread.currentThread().getName() + " is working");
            // Simulate some work with sleep
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Always release the lock in the finally block
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        // Creating multiple threads to demonstrate lock
        for (int i = 0; i < 5; i++) {
            new Thread(example::doSomething).start();
        }
    }
}
```

## When to Use ReentrantLock

- **More Complex Locking Logic**: Use `ReentrantLock` when you need more advanced locking mechanisms like try-lock with timeout, interruptible locking, or the need for fair queueing.
- **Condition Objects**: When you need to use multiple condition variables (more than one wait/notify style synchronization).
- **Better Performance**: In some cases, `ReentrantLock` can offer better performance than `synchronized`, particularly in highly contended situations.

However, for simple use cases where the functionality provided by `synchronized` is sufficient, it's often better to stick with `synchronized` for its simplicity and ease of use.

# Example Usage of ReentrantLock
```java
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000); // Simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
```


# BankAccount Class with ReentrantLock

The code defines a `BankAccount` class that manages a bank account with a balance and allows for withdrawals using multiple threads. The code is designed to handle concurrency safely, ensuring that only one thread can modify the balance at a time.

## Key Components

- **`balance`**: An integer field that stores the account balance. It's initialized to 100.

- **`Lock lock = new ReentrantLock();`**: A `ReentrantLock` is used to control access to the `withdraw` method. A `ReentrantLock` is a lock with the same basic behavior and semantics as the implicit monitor lock accessed using synchronized methods and statements, but with extended capabilities.

- **`withdraw(int amount)`**: A method that attempts to withdraw a specified amount from the balance.

## How the `withdraw` Method Works

### Attempting to Withdraw

- The method starts by printing which thread is attempting to withdraw the specified amount.
- The `lock.tryLock(1000, TimeUnit.MILLISECONDS)` call attempts to acquire the lock within 1000 milliseconds (1 second). If the lock is acquired, the thread can proceed with the withdrawal. Otherwise, it will print a message that it couldn't acquire the lock and will try again later.

### Lock Acquired

- If the lock is acquired within the specified time, the method checks if the balance is sufficient for the withdrawal.
- If the balance is sufficient, the thread proceeds with the withdrawal:
    - It prints that the thread is proceeding with the withdrawal.
    - The thread sleeps for 3 seconds (`Thread.sleep(3000);`), simulating the time taken to process the withdrawal.
    - After the simulated delay, the balance is reduced by the withdrawal amount.
    - A message is printed indicating the withdrawal is complete and showing the remaining balance.

### Insufficient Balance

- If the balance is not sufficient, it prints a message indicating that the withdrawal cannot proceed due to insufficient funds.

### Releasing the Lock

- In the `finally` block, the lock is released (`lock.unlock();`), ensuring that the lock is always released, even if an exception occurs during the withdrawal process.

### Handling Exceptions

- The `catch` block handles any exceptions that occur during the locking or withdrawal process by interrupting the thread.

## Summary

- **Concurrency Control**: The use of `ReentrantLock` ensures that only one thread can execute the critical section (modifying the balance) at a time, preventing race conditions.
- **Try-Lock with Timeout**: The `tryLock` method with a timeout allows threads to attempt to acquire the lock within a specified time, enabling other threads to retry later if the lock is not available.
- **Thread Safety**: The code ensures thread safety by locking the critical section where the balance is modified, preventing inconsistent states due to concurrent access.
