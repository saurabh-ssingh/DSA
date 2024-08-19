package org.example.multiThreading;

/**
 * The {@code DaemonThread} class demonstrates the usage of a daemon thread in Java.
 * It extends the {@code Thread} class and overrides the {@code run} method to continuously print a message.
 */
public class DaemonThread extends Thread {

  /**
   * The {@code run} method is executed when the thread is started.
   * It continuously prints "Inside run method" to the console in an infinite loop.
   */
  @Override
  public void run() {
    while (true) {
      System.out.println("Inside run method"); // Prints message continuously
    }
  }

  /**
   * The main method demonstrates the behavior of a daemon thread.
   * It sets the thread as a daemon, starts it, and then prints a message from the main thread.
   *
   * @param args command-line arguments (not used)
   * @throws InterruptedException if the thread is interrupted while waiting
   */
  public static void main(String[] args) throws InterruptedException {
    DaemonThread daemonThread = new DaemonThread();

    // Set the thread as a daemon thread
    daemonThread.setDaemon(true);

    // Start the daemon thread
    daemonThread.start();

    // Print message from the main thread
    System.out.println("Inside main method");
  }
}
