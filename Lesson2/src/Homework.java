import java.util.Scanner;

public class Homework {

    public static final long integerMaxValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        System.out.println(sum(2147483647, 20));
//        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
//        System.out.println(max(50, 49));
//        System.out.println(average(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(max(new int[]{1, 2, 3, 4, 5, 100, 99}));
//        System.out.println(calculateHypotenuse());
    }

    /**
     * 1. Method should return sum of "a" and "b"
     * 2. (optional) if sum of a and b is more then int can store -- return -1;
     **/
    public static int sum(int a, int b) {
        return ((long) a + (long) b) > integerMaxValue ? (-1) : (a + b);
    }

    /**
     * Method should return larger of two numbers ("a" and "b")
     * <p>
     * Example1:
     * a = 4,
     * b = 5
     * <p>
     * Method should return 5
     * Example2:
     * a = 10,
     * b = 10
     * <p>
     * Method should return 10
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Method should return avg. value of given array (sum of all elements of array divided by array length).
     * <p>
     * Example:
     * array = {1,2,3,4,5}
     * Method should return 3
     */
    public static double average(int[] array) {
        double arrayElementsSum = 0;
        for (int element : array) {
            arrayElementsSum += element;
        }
        return arrayElementsSum / array.length;
    }

    /**
     * (optional)
     * Method should return max element of array. For example if array = {1,2,10,3} then method should return 10;
     **/
    public static int max(int[] array) {
        int maxArrayElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxArrayElement) {
                maxArrayElement = array[i];
            }
        }
        return maxArrayElement;
    }

    /**
     * (optional)
     * 1. Read two ints from console
     * 2. Using the Pythagorean theorem calculate value of hypotenuse if value of two given ints -- value of triangle legs
     * Example1:
     * Console input:
     * 3
     * 4
     * Method should return 5
     * <p>
     * Example2:
     * Console input:
     * 12
     * 16
     * Method should return 20
     */
    public static double calculateHypotenuse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a: ");
        int a = scanner.nextInt();
        System.out.println("Input b: ");
        int b = scanner.nextInt();
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
