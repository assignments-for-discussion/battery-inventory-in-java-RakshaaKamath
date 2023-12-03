package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for (int i = 0; i < presentCapacities.length; i++) {
      double soh = 100.0 * presentCapacities[i] / 120.0;
      if (soh > 80.0) {
        counts.healthy++;
      } else if (soh > 62.0) {
        counts.exchange++;
      } else {
        counts.failed++;
      }
    }
    System.out.println("Healthy batteries: " + counts.healthy + "\nExchange batteries: " + counts.exchange + "\nFailed batteries: " + counts.failed);
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
