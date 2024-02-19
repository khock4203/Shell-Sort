/*
* @author Kevin Hock
* CS1131, L01, Week 12
* Shell Sort Program.
* Insert a text file of Doubles in line 21 to sort.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class MyShellSort<E extends Comparable<E>> implements Sortable<E> {


    public static void main(String[] args) {
        //FILE READER
        File file = new File("Test1.txt");
        int length = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                length = length + 1;
                scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        double[] numberList = new double[length];

        try {
            Scanner scanner = new Scanner(file);
            int anotherCount = 0;
            while (scanner.hasNextLine()) {
                numberList[anotherCount] = Double.parseDouble(scanner.nextLine());
                anotherCount++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        MyShellSort<Double> shellSort = new MyShellSort<>();

        List<Double> newArray = (shellSort.sort(shellSort.arrayToList(numberList)));
        System.out.println (newArray);

    }

    //Converts the scanned Array into a list
    public List<Double> arrayToList(double[] array){
        List<Double> result = new ArrayList<>();

        for(double i : array){
            result.add(i);
        }
        return result;
    }

    public double[] listToArray(List<Double> list){
        double [] result = new double[list.size()];

        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    public List<E> sort(List<E> list) {
        long startTime = System.currentTimeMillis();
        //SHELL SORT
        List <E> result = list;
        int gap = (result.size() / 2);
        while (gap > 0) {
            for (int i = gap; i < result.size(); i++) {
                E temp = result.get(i);
                int j = i;
                while ((j >= gap) && result.get(j - gap).compareTo(temp)>0) {
                    result.set(j, result.get(j- gap));
                    j -= gap;
                }
                result.set(j, temp);
            }
            gap = gap / 2;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("The runtime is:");
        System.out.println(endTime - startTime);

        return result;


    }

}