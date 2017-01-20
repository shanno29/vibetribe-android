package matthew.shannon.vibetribe;

public final class UsefulUtils {

    private UsefulUtils() {}

    public static int sum(int... nums) {
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }
}