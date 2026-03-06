package org.example;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer input=userInput(sc);
        Integer[] arrOfNums=createArray(input);
        int sumArr=sumOfElements(arrOfNums);
        while(true){
            if(input==null){
                System.out.println("Konec programu.");
                return;
            }
        }

    }

    //Metoda pro vstup od uzivatele.
    public static Integer userInput(Scanner sc){
        Integer result=null;
        while(true){
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("quit")){
                return null;
            }
            try{
                result=Integer.parseInt(input);
                return result;
            }catch (NumberFormatException e){
                System.out.println("Zadavejte pouze cela cisla:");
            }
        }
    }

    //Metoda pro vytvoreni a naplneni pole.
    public static Integer[] createArray(Integer input){
        Integer[] nums;
        while(true){
            System.out.println("Zadejte kolik prvku bude pole obsahovat:");
            if(input<1){ //Osetreni velikosti pole.
                System.out.println("Velikost pole musi byt vetsi nez 0. ");
                break;
            }
           nums=new Integer[input];
            System.out.println("Postupne piste prvky pole. Za kazdym prvkem stisknete enter.");
            for (int i=0; i < nums.length; i++) {
                nums[i] = input;
            }
            return nums;
        }
       return null;
    }

    //Metoda pro hledani minima.
    public static int findMin(Integer[] arrOfNums){
        int min=arrOfNums[0];
        for(int i = 0; i<arrOfNums.length; i++){
            if(arrOfNums[i]<min){
                min=arrOfNums[i];
            }
        }
        return min;
    }

    //Metoda pro hledani maxima.
    public static int findMax(Integer[] arrOfNums){
        int max=arrOfNums[0];
        for(int i = 0; i<arrOfNums.length; i++){
            if(max<arrOfNums[i]){
                max=arrOfNums[i];
            }
        }
        return max;
    }

    //Metoda pro soucet prvku.
    public static int sumOfElements(Integer[] arrOfNums){
        int sum=0;
        for(int i=0;i< arrOfNums.length;i++){
            sum+=arrOfNums[i];
        }
        return sum;
    }

    //Metoda pro vypocet prumeru prvku.
    public static int averageOfElements(int sumArr,Integer[] arrOfNums){
        int average=0;
        return average=sumArr/arrOfNums.length;
    }
}
