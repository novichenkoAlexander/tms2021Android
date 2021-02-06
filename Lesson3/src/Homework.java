import java.util.*;

public class Homework {

    public static final int MAX_INT = Integer.MAX_VALUE;
    public static final int MIN_INT = Integer.MIN_VALUE;

    public static void main(String[] args) {
//        System.out.println(operation(1));
//        System.out.println(operation(MIN_INT));
//        foobar(6);
//        foobar(10);
//        foobar(4);
//        printMatrix();
        printPrimeNumbers();
    }

    /**
     * Method should perform some operation with int "number" based on some conditions:
     * - if number is positive - increase it by 1
     * - if number is negative - decrease it by 2
     * - if number is equal to zero - replace it with 10
     * return number value after operation
     */
    public static int operation(int number) {
        if (number > 0 && number != MAX_INT) {
            return number + 1;
        } else if (number < 0 && number != MIN_INT) {
            return number - 2;
        } else if (number == MAX_INT) {
            return MAX_INT;
        } else if (number == MIN_INT) {
            return MIN_INT;
        } else {
            return 10;
        }

    }

    /**
     * Method should print different strings in console based on some conditions:
     * - if remainder of the division number by 3 is zero - print "foo" (example of number - 6)
     * - if remainder of the division number by 5 is zero - print "bar" (example of number - 10)
     * - if remainder of the division number by both 3 and 5 is zero 0  and - print "foobar" (example of number - 15)
     */
    public static void foobar(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("foobar");
        } else if (number % 5 == 0) {
            System.out.println("bar");
        } else if (number % 3 == 0) {
            System.out.println("foo");
        } else {
            System.out.println("The number is out of conditions!");
        }
    }

    /**
     * Steps to implement:
     * - Read two ints from console
     * - Create a two-dimensional int array (use ints that you read from console height and width)
     * - Fill array with random values (under 100)
     * - Print in console matrix with given size, but:
     * - If remainder of the division array element by 3 is zero - print "+" sign instead of array element value
     * - If remainder of the division array element by 7 is zero - print "-" sign instead of array element value
     * - Print "*" otherwise
     * <p>
     * Example:
     * - Values from console -  2 and 3
     * - Array will look like this (values be different because it's a random)
     * 6 11 123
     * 1 14 21
     * - For this values output in console should be:
     * <p>
     * + * *
     * * - +
     * <p>
     * Note that 21 % 3 == 0 and 21 % 7 = 0, but output is not +-, but +
     */
    public static void printMatrix() {

        System.out.println("Input integer height: ");
        int height = readNumber("height");
        System.out.println("Input integer width: ");
        int width = readNumber("width");
        int[][] array = new int[height][width];
        Random random = new Random();
        for (int[] rows : array) {
            for (int i = 0; i < rows.length; i++) {
                rows[i] = random.nextInt(100);
            }
            System.out.println(Arrays.toString(rows));
        }

        String[][] stringArray = new String[height][width];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 3 == 0) {
                    stringArray[i][j] = " + ";
                } else if (array[i][j] % 7 == 0) {
                    stringArray[i][j] = " - ";
                } else {
                    stringArray[i][j] = " * ";
                }

            }

        }
        for (String[] rows : stringArray) {
            System.out.println(Arrays.toString(rows));
        }

    }

    private static int readNumber(String parameter) {
        int number;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Incorrect input!");
                System.out.println("Input " + parameter + " again:");
            }
        }
        return number;
    }

    /**
     * (optional)
     * Method should print all prime numbers < 1000
     */
//    public static void printPrimeNumbers() {
//        int[] array = new int[1000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
//        boolean isPrime = true;
//        for (int i = 2; i < array.length; i++) {
//            for (int j = 2; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime) {
//                array[i] = i;
//            }
//
//        }
//        System.out.println(Arrays.toString(array));
//
//    }

    /**
     * The sieve of Eratosthenes
     */
    public static void printPrimeNumbers() {
        int n = 100;
        Boolean[] array = new Boolean[n + 1];
        Arrays.fill(array, true);
        for (int i = 2; Math.pow(i, 2) <= n; i++) {
            if (!array[i]) {
                continue;
            }
            for (int j = (int) Math.pow(i, 2); j <= n; j += i) {
                array[j] = false;
            }
        }
        for (int i = 2; i < array.length; i++) {
            if (array[i]) {
                System.out.print(i+ " ");
            }
        }

    }

}



