package org.example;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer input = null;

        // Ošetření opakovaného zadání velikosti pole
        while (true) {
            System.out.println("Zadejte kolik prvků bude pole obsahovat:");
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
        int[] arrOfNums = createArray(input, sc);
        if (arrOfNums == null) { // uživatel zadal * při plnění
            System.out.println("Konec programu.");
            return;
        }
        int sumArr=sumOfElements(arrOfNums);
        while(true){
            menu();
            Integer option=userInput(sc);
            if(option==null){
                System.out.println("Konec programu.");
                return;
            }
            if(option<1||option>4){
                System.out.println("Zadejte možnost 1-4.\n" +
                        "--------------------------------------");
                continue;
            }
            switch(option) {
                case 1:
                    System.out.println("Nejmenší hodnota v poli je " +
                            findMin(arrOfNums) + " a největší hodnota v poli je " + findMax(arrOfNums) + ".\n" +
                            "----------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Součet všech prvků v poli je " + sumArr +
                            " a jejich průměr je " + averageOfElements(sumArr, arrOfNums) + ".\n" +
                            "----------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("Napište jaké číslo chcete vyhledat:");
                    Integer valueInput = userInput(sc);
                    if (valueInput == null) {
                        System.out.println("Konec programu.");
                        return;
                    }
                    int value = valueInput;
                    if (containsElement(arrOfNums, value)) {
                        System.out.println("Číslo " + value + " je obsaženo v poli.\n" +
                                "-------------------------------------------------------------");
                    } else {
                        System.out.println("Číslo " + value + " není obsaženo v poli.\n" +
                                "---------------------------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Nejčastěji vyskytující se prvek je:" + modus(arrOfNums)+"\n" +
                            "--------------------------------------------------------------------");
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
    public static int[] createArray(Integer size, Scanner sc) {
        int[] nums = new int[size];
        System.out.println("Postupně pište prvky pole. Za každým prvkem stiskněte enter. Pro ukončení zadejte *.");
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
    public static int findMin(int[] arrOfNums){
        int min=arrOfNums[0];
        for(int i = 1; i<arrOfNums.length; i++){
            if(arrOfNums[i]<min){
                min=arrOfNums[i];
            }
        }
        return min;
    }

    //Metoda pro hledani maxima.
    public static int findMax(int[] arrOfNums){
        int max=arrOfNums[0];
        for(int i = 1; i<arrOfNums.length; i++){
            if(max<arrOfNums[i]){
                max=arrOfNums[i];
            }
        }
        return max;
    }

    //Metoda pro soucet prvku.
    public static int sumOfElements(int[] arrOfNums){
        int sum=0;
        for(int i=0;i< arrOfNums.length;i++){
            sum+=arrOfNums[i];
        }
        return sum;
    }

    //Metoda pro vypocet prumeru prvku.
    public static double averageOfElements(int sumArr,int[] arrOfNums){
        return sumArr/arrOfNums.length;
    }

    //Metoda pro vyhledani prvku.
    public static boolean containsElement(int[] arrOfNums,int value) {
        for (int element : arrOfNums){
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    //Metoda pro modus.
    public static int modus(int[] arrOfNums){
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
        System.out.println("Vyberte jednu možnost zadáním příslušného čísla a potvrďte entrem:\n" +
                "--------------------------------------------------------------------\n" +
                "1 – Min a Max\n" +
                "2 – Součet a Průměr\n" +
                "3 – Vyhledat číslo\n" +
                "4 – Nejčastější prvek\n" +
                "* – Konec");
    }
}
