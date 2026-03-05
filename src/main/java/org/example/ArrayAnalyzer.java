package org.example;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer input=userInput(sc);
        while(true){
            if(input==null){
                System.out.println("Konec programu.");
                return;
            }
        }

    }
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
}
