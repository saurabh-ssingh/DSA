package org.example.multiThreading;

/**
 * The {@code ThreadState} class demonstrates the different states of a thread.
 * It extends the {@code Thread} class and overrides the {@code run} method.
 */
public class ThreadState extends Thread {

  /**
   * The {@code run} method is executed when the thread is started.
   * It prints "RUNNING" to the console and then puts the thread to sleep for 1 second.
   */
  @Override
  public void run() {
    System.out.println("RUNNING"); // Thread is running
    try {
      Thread.sleep(1000); // Puts the thread to sleep for 1 second
    } catch (InterruptedException e) {
      throw new RuntimeException(e); // Handles the InterruptedException
    }
  }

  /**
   * The main method demonstrates the different states of a thread.
   * It creates a {@code ThreadState} object, starts the thread, and prints its state at various points.
   *
   * @param args command-line arguments (not used)
   * @throws InterruptedException if the thread is interrupted while waiting
   */
  public static void main(String[] args) throws InterruptedException {
    ThreadState threadState = new ThreadState();

    // Initial state of the thread (NEW)
    System.out.println(threadState.getState()); // New

    // Start the thread, transitioning to the RUNNABLE state
    threadState.start();
    System.out.println(threadState.getState()); // RUNNABLE

    // Main thread sleeps for 1 second, allowing threadState to enter TIMED_WAITING
    Thread.sleep(1000);

    // After sleep, threadState is in TIMED_WAITING state
    System.out.println(threadState.getState()); // TIMED WAITING

    // Wait for the thread to finish execution, transitioning to TERMINATED state
    threadState.join();
    System.out.println(threadState.getState()); // TERMINATED
  }
}
