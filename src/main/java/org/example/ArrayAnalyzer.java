package org.example;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer input=userInput(sc);
        menu();
        Integer[] arrOfNums=createArray(input);
        int sumArr=sumOfElements(arrOfNums);
        int value=0;
        while(true){
            if(input==null){
                System.out.println("Konec programu.");
                return;
            }
            int option=input;
            switch(option){
                case 1:
                    System.out.println("Nejmenší hodnota v poli je " +
                            +findMin(arrOfNums)+" a největsí hodnota v poli je "+findMax(arrOfNums)+".");
                    break;
                case 2:
                    System.out.println("Součet všsch prvků v poli je "+sumOfElements(arrOfNums)+
                            " a jejich průměr je "+averageOfElements(sumArr,arrOfNums)+".");
                    break;
                case 3:
                    System.out.println("Napište jaké číslo chcete vyhledat:");
                    value=userInput(sc);
                    if(findElement(arrOfNums, value)){
                        System.out.println("Číslo "+value+" je obsaženo v poli.");
                    }else{
                        System.out.println("Číslo "+value+" není obsaženo v poli.");
                    }
                    break;
                case 4:
                    System.out.println("Nejčastěji vyskytujícíse prvek je:"+modus(arrOfNums));
                    break;
            }
        }
    }

    //Metoda pro vstup od uzivatele.
    public static Integer userInput(Scanner sc){
        Integer result=null;
        while(true){
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("5")){
                return null;
            }
            try{
                result=Integer.parseInt(input);
                return result;
            }catch (NumberFormatException e){
                System.out.println("Zadávejte pouze celá čísla:");
            }
        }
    }

    //Metoda pro vytvoreni a naplneni pole.
    public static Integer[] createArray(Integer input){
        Integer[] nums;
        while(true){
            System.out.println("Zadejte kolik prvku bude pole obsahovat:");
            if(input<1){ //Osetreni velikosti pole.
                System.out.println("Velikost pole musí být větší než 0. ");
                break;
            }
           nums=new Integer[input];
            System.out.println("Postupně pište prvky pole. Za každým prvkem stisknete enter.");
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

    //Metoda pro vyhledani prvku.
    public static boolean findElement(Integer[] arrOfNums,int value) {
        for (int element : arrOfNums){
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    //Metoda pro modus.
    public static int modus(Integer[] arrOfNums){
        int count=0;
        int num=0;
        for(int i=0;i<arrOfNums.length;i++){
            num=arrOfNums[i];
            for(int j=0;j<arrOfNums.length;j++){
                if(arrOfNums[j]==num){
                    count++;
                    num=arrOfNums[j];
                }
            }
        }
        return num;
    }

    //Metoda pro vyvolani menu.
    public static void menu(){
        System.out.println("Vyberte jednu možnost zadaním příslušného čísla a potvrďte entrem:\n" +
                "--------------------------------------------------------------------\n" +
                "1 – Min a Max\n" +
                "2 – Součet a Průměr\n" +
                "3 – Vyhledat číslo\n" +
                "4 – Nejčastější prvek\n" +
                "5 – Konec");
    }
}
