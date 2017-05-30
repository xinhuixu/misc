/** SleepSort.
 * Sorts a list of integers and prints them to stdout.
 * This implementation uses n space, and at least O(n) time.
 * Requires less than n threads by using a DelayQueue as a priority heap.
 * Constant space and constant time could be achieved, at the loss of accuracy.
 */

import java.util.concurrent.DelayQueue;

public final class SleepSort {
  private static final long STARTTIME = System.currentTimeMillis();
  private static final DelayQueue<Thing> dq = new DelayQueue<>();

  public static void main(String[] args) {
    for ( int i = 0; i < args.length; i++ ) {
      try {
        dq.add(new Thing(STARTTIME, Long.parseLong(args[i])));
      } catch ( NumberFormatException e ) {
        System.out.printf("\nExpected an integer, got %s.\n", args[i]);
      }
    }

    while ( ! dq.isEmpty() ) {
      try {
        System.out.print(dq.take());
      } catch ( InterruptedException e ) { }
    }
  }
}

