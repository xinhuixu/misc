/** SleepSort.
 * Sorts a list of integers and prints them to stdout.
 * This implementation uses n space, n threads, and at least O(n) time.
 * Constant space and constant time could be achieved, at the loss of accuracy.
 */

public class SleepSort extends Thread {
  private final int VALUE;

  private SleepSort(int value) {
    VALUE = value;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(VALUE);
    } catch ( InterruptedException e ) { }

    System.out.printf("%s ", VALUE);
  }

  public static void main(String[] args) {
    Thread[] threads = new Thread[args.length];

    for ( int i = 0; i < args.length; i++ ) {
      try {
        threads[i] = new SleepSort(Integer.parseInt(args[i]));
      } catch ( NumberFormatException e ) {
        System.out.printf("Expected an integer, got %s.", args[i]);
      }
    }

    for ( Thread t : threads ) {
      t.start();
    }
  }
}

