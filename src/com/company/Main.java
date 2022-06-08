package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int cp=0,pp=0,tie_value=0;

    public static void main(String[] args) {
        String[] value = {"R","P","S"};
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = in.next();
        int round=1;
        System.out.println("Computer's Initial Score : "+cp);
        System.out.println(name+"'s Initial Score : "+pp);
        while(true){
            while(round<=5){
                tie_value=0;
                String ans;
                System.out.println("Round "+round);
                System.out.println("Enter your choice : (R/P/S)");
                while(true){
                    ans = in.next();
                    if(ans.equals("R") || ans.equals("P") || ans.equals("S")){
                        break;
                    }else{
                        System.out.println("Enter a Valid choice : ");
                    }
                }
                int temp = new Random().nextInt(3);
                String comp = value[temp];
                System.out.println();
                System.out.println("Computer's choice was : "+comp);
                switch (ans){
                    case "R" :{
                        if(comp.equals("P")){
                            compwin();
                        }else if(comp.equals("S")){
                            pwin(name);
                        }else{
                            tie();
                        }
                        break;
                    }
                    case "P":{
                        if(comp.equals("S")){
                            compwin();
                        }else if(comp.equals("R")){
                            pwin(name);
                        }else{
                            tie();
                        }
                        break;
                    }
                    case "S":{
                        if(comp.equals("R")){
                            compwin();
                        }else if(comp.equals("P")){
                            pwin(name);
                        }else{
                            tie();
                        }
                        break;
                    }
                }
                if(tie_value==0){
                    round++;
                }
            }
            System.out.println();
            System.out.println("After End of 5 Rounds : ");
            System.out.println("Computer's Score : "+cp);
            System.out.println(name+"'s Score : "+pp);
            if(cp<pp){
                System.out.println(name+" Wins the Game!");
            }else{
                System.out.println("Computer Wins the Game!");
            }
            System.out.println();
            System.out.println("Play Again? y/n");
            String choice = in.next();
            if(!choice.equals("y")){
                break;
            }else{
                round=1;
            }
        }
    }
   static void compwin(){
        System.out.println("The Computer Wins!");
        cp++;
    }
    static void pwin(String name){
        System.out.println(name + " Wins!");
        pp++;
    }
    static void tie(){
        System.out.println("There is a Tie");
        tie_value=1;
    }
}
