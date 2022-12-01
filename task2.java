import java.util.Scanner;
import java.io.*;

//2. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

public class task2 {
    public static int[] sortArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }                
            }
            writeLog(array);
        }
        return array;

    }

    public static void writeLog(int[] array) {
        try (FileWriter writer = new FileWriter("logHWTask2.txt", true)) {
            for (int i = 0; i < array.length; i++) {
                writer.write(array[i] + " ");
            }
            writer.write("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int[] createArray() {
        System.out.println("Long array = ");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        iScanner.close();
        return array;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        sortArray(arr);
    }

}