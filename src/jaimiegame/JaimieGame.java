/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaimiegame;

import java.util.Scanner;

/**
 *
 * @author arias
 */
public class JaimieGame {
    private static Scanner input;
 
    private static final int PALADIN_ATTACK = 70;
    private static final int PALADIN_LIFE = 100;
    private static final int PALADIN_SHIELD = 100;

    private static final int FIGHTER_ATTACK = 20;
    private static final int FIGHTER_LIFE = 100;
    private static final int FIGHTER_SHIELD = 70;
    
    private static final int RANGER_ATTACK = 20;
    private static final int RANGER_LIFE = 100;
    private static final int RANGER_SHIELD = 70;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);
        String name;
        char type;
        Fighter player1 = null, player2 = null;
        
        System.out.println("Welcome to the Battle!\n");
        System.out.println("Player 1 = = = = = = = = = =");
        System.out.print("What is your name: ");
        name = input.nextLine();
        type = selectType();
        if (type == 'a'){
            player1 = new Fighter(name, PALADIN_SHIELD, PALADIN_ATTACK, PALADIN_LIFE);
        }else if (type == 'b'){
            player1 = new Fighter(name, FIGHTER_SHIELD, FIGHTER_ATTACK, FIGHTER_LIFE);
        }else if (type == 'c'){
            player1 = new Fighter(name, RANGER_SHIELD, RANGER_ATTACK, RANGER_LIFE);
        }else{
            System.err.println("This should never happen!");
            System.exit(1);
        }

        System.out.println("Player 2 = = = = = = = = = =");
        System.out.print("What is your name: ");
        name = input.nextLine();
        type = selectType();
        if (type == 'a'){
            player2 = new Fighter(name, PALADIN_SHIELD, PALADIN_ATTACK, PALADIN_LIFE);
        }else if (type == 'b'){
            player2 = new Fighter(name, FIGHTER_SHIELD, FIGHTER_ATTACK, FIGHTER_LIFE);
        }else if (type == 'c'){
            player2 = new Fighter(name, RANGER_SHIELD, RANGER_ATTACK, RANGER_LIFE);
        }else{
            System.err.println("This should never happen!");
            System.exit(1);
        }
        
        System.out.println(player1);
        System.out.println(player2);

        
    }
    private static char selectType(){
        System.out.println("Troop Type:");
        System.out.println("\ta. Paladin");
        System.out.println("\tb. Fighter");
        System.out.println("\tc. Ranger");
        System.out.print("Choice: ");
        String choice;
        do{
            choice = input.nextLine();
            if (choice.length() != 1 || (choice.charAt(0) != 'a' && choice.charAt(0) != 'b' && choice.charAt(0) != 'c')){
                System.err.println("Incorrect choice, please input again");
                System.out.print("Choice: ");
            }else
                break;
        }while (true);
        return choice.charAt(0);
    }
}
