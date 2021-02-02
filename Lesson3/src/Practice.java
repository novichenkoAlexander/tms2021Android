import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {

        boolean isPrime = true;
        for (int i = 2; i < 1000; i++){
            for (int j = 2; j < i; j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }if (isPrime){
                System.out.println(i);
            }
        }

/*      Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] mass = new int[length];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++){
            mass[i] = random.nextInt(100);
        }
        //System.out.println(Arrays.toString(mass));

        System.out.println(countOdd(new int[]{1,2,3,4,5}));
    }

    /**
     * Метод должен вернуть кол-во нечетных элементов в массиве array
     * <p>
     * Example1:
     * array = {1,2,3,4,5}
     * Должен вернуть 3
     * Example1:
     * array = {0,2,3,4}
     * Должен вернуть 1
     *
     */
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Input number of columns:");
        int[][] twoArray = new int[rows][rows];
        Random random = new Random();
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                twoArray[i][j] = random.nextInt(100);
            }
            System.out.println(Arrays.toString(twoArray[i]));
        }
        int sum = 0;
        for (int i = 0; i < twoArray.length; i++) {
                sum += twoArray[i][i];
            System.out.println(sum);
        }
*/
/*        countDevs(105);
        int monthIndex = 0;
        switch(monthIndex){
            case 0:
                System.out.println("Jan");
                break;
            case 1:
                System.out.println("Feb");
                break;
            default:
                System.out.println("");

        }*/
    }

    /**
     * На вход приходит число. Вывести в консоль фразу из разряда "_COUNT_ программистов", заменить _COUNT_ на count которое пришло, и заменить окончание "программистов"
     * на уместное с точки русского языка (1 программист, 10 программистов) и тд
     */
    public static void countDevs(int count) {
        int last = count % 10;
        if (last == 1) {
            System.out.println(count + " программист");
        } else if (last > 1 && last < 5) {
            System.out.println(count + " программиста");
        } else {
            System.out.println(count + " программистов");
        }

    }


}
