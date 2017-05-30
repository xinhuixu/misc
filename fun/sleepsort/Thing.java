import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Thing implements Delayed {
  private final long VALUE;
  private final long EXPIRETIME;

  Thing(long startTime, long value) {
    EXPIRETIME = startTime + value;
    VALUE = value;
  }

  @Override
  public long getDelay(TimeUnit timeUnit) {
    return timeUnit.convert(EXPIRETIME - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed o) {
    if ( this.EXPIRETIME < ((Thing) o).EXPIRETIME ) { return -1; }
    if ( this.EXPIRETIME > ((Thing) o).EXPIRETIME ) { return 1; }
    return 0;
  }

  @Override
  public String toString() {
    return VALUE + " ";
  }
}

