package org.example;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer input = null;
        int value = 0;

        // Ošetření opakovaného zadání velikosti pole
        while (true) {
            System.out.println("Zadejte kolik prvku bude pole obsahovat:");
            input = userInput(sc);
            if (input == null) { // uživatel zadal *
                System.out.println("Konec programu.");
                return;
            }
            if (input < 1) {
                System.out.println("Velikost pole musí být větší než 0.");
            } else {
                break; // platná velikost
            }
        }

        // Vytvoření a naplnění pole
        Integer[] arrOfNums = createArray(input, sc);
        if (arrOfNums == null) { // uživatel zadal * při plnění
            System.out.println("Konec programu.");
            return;
        }
        double sumArr=sumOfElements(arrOfNums);
        while(true){
            menu();
            Integer option=userInput(sc);
            if(option==null){
                System.out.println("Konec programu.");
                return;
            }
            switch(option) {
                case 1:
                    System.out.println("Nejmenší hodnota v poli je " +
                            +findMin(arrOfNums) + " a největsí hodnota v poli je " + findMax(arrOfNums) + ".");
                    break;
                case 2:
                    System.out.println("Součet všsch prvků v poli je " + sumOfElements(arrOfNums) +
                            " a jejich průměr je " + averageOfElements(sumArr, arrOfNums) + ".");
                    break;
                case 3:
                    System.out.println("Napište jaké číslo chcete vyhledat:");
                    value = userInput(sc);
                    if (findElement(arrOfNums, value)) {
                        System.out.println("Číslo " + value + " je obsaženo v poli.");
                    } else {
                        System.out.println("Číslo " + value + " není obsaženo v poli.");
                    }
                    break;
                case 4:
                    System.out.println("Nejčastěji vyskytujícíse prvek je:" + modus(arrOfNums));
                    break;

            }
        }
    }

    //Metoda pro vstup od uzivatele.
    public static Integer userInput(Scanner sc){
        Integer result=null;
        while(true){
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("*")){
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
    public static Integer[] createArray(Integer size, Scanner sc) {
        Integer[] nums = new Integer[size];
        System.out.println("Postupně pište prvky pole. Za každým prvkem stisknete enter. Pro ukončení zadejte *.");
        for (int i = 0; i < size; i++) {
            Integer value = userInput(sc);
            if (value == null) {
                return null;
            }
            nums[i] = value;
        }
        return nums;
    }

    //Metoda pro hledani minima.
    public static int findMin(Integer[] arrOfNums){
        int min=arrOfNums[0];
        for(int i = 1; i<arrOfNums.length; i++){
            if(arrOfNums[i]<min){
                min=arrOfNums[i];
            }
        }
        return min;
    }

    //Metoda pro hledani maxima.
    public static int findMax(Integer[] arrOfNums){
        int max=arrOfNums[0];
        for(int i = 1; i<arrOfNums.length; i++){
            if(max<arrOfNums[i]){
                max=arrOfNums[i];
            }
        }
        return max;
    }

    //Metoda pro soucet prvku.
    public static double sumOfElements(Integer[] arrOfNums){
        double sum=0;
        for(int i=0;i< arrOfNums.length;i++){
            sum+=arrOfNums[i];
        }
        return sum;
    }

    //Metoda pro vypocet prumeru prvku.
    public static double averageOfElements(double sumArr,Integer[] arrOfNums){
        return sumArr/arrOfNums.length;
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
        int maxCount = 0;
        int mode = arrOfNums[0];
        for (int i = 0; i < arrOfNums.length; i++) {
            int count = 0;
            for (int j = 0; j < arrOfNums.length; j++) {
                if (arrOfNums[j] == arrOfNums[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mode = arrOfNums[i];
            }
        }
        return mode;
    }

    //Metoda pro vyvolani menu.
    public static void menu(){
        System.out.println("Vyberte jednu možnost zadaním příslušného čísla a potvrďte entrem:\n" +
                "--------------------------------------------------------------------\n" +
                "1 – Min a Max\n" +
                "2 – Součet a Průměr\n" +
                "3 – Vyhledat číslo\n" +
                "4 – Nejčastější prvek\n" +
                "* – Konec");
    }
}
