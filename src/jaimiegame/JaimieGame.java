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
        if (type == 'a') {
            player1 = new Fighter(name, PALADIN_SHIELD, PALADIN_ATTACK, PALADIN_LIFE);
        } else if (type == 'b') {
            player1 = new Fighter(name, FIGHTER_SHIELD, FIGHTER_ATTACK, FIGHTER_LIFE);
        } else if (type == 'c') {
            player1 = new Fighter(name, RANGER_SHIELD, RANGER_ATTACK, RANGER_LIFE);
        } else {
            System.err.println("This should never happen!");
            System.exit(1);
        }

        System.out.println("Player 2 = = = = = = = = = =");
        System.out.print("What is your name: ");
        name = input.nextLine();
        type = selectType();
        if (type == 'a') {
            player2 = new Fighter(name, PALADIN_SHIELD, PALADIN_ATTACK, PALADIN_LIFE);
        } else if (type == 'b') {
            player2 = new Fighter(name, FIGHTER_SHIELD, FIGHTER_ATTACK, FIGHTER_LIFE);
        } else if (type == 'c') {
            player2 = new Fighter(name, RANGER_SHIELD, RANGER_ATTACK, RANGER_LIFE);
        } else {
            System.err.println("This should never happen!");
            System.exit(1);
        }

        System.out.println("Selecting First Player!!");
        if (Math.random() > 0.5) {
            Fighter temp = player1;
            player1 = player2;
            player2 = temp;
        }

        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);
        System.out.println("\n\nGame Starts!!\n\n");
        boolean keepOn;
        while (true) {
            keepOn = play(player1, player2);
            if (!keepOn){
                System.out.println("Player 1 Wins: " + player1);
                break;
            }
            keepOn = play(player2, player1);
            if (!keepOn){
                System.out.println("Player 2 Wins: " + player2);
                break;
            }
            
        }
    }

    private static boolean play(Fighter player1, Fighter player2) {
        int power, attack, defenseStatus;
        System.out.println("Atacking Player: " + player1.getName());

        do {
            System.out.print("How much power you want to use: ");
            power = input.nextInt();
            if (power < 0 || power > 10) {
                System.err.println("Incorrect Value, input again [1..10]");
            }
        } while (power < 0 || power > 10);
        attack = player1.attack(power);
        System.out.println("Current atack = " + attack);
        System.out.println("Attacking Player Stats = " + player1);
        System.out.println();

        defenseStatus = player2.defend(attack);
        System.out.println("Defending Player Defended!!");
        System.out.println("Defending Player Stats = " + player2);
        if (defenseStatus == Fighter.SHIELD_ON) {
            System.out.println("Defending Player still has shield");
        } else if (defenseStatus == Fighter.LIFE_ON) {
            System.out.println("Defending Player has no shield, but has life");
        } else {
            System.out.println("Defending Player is dead");
            return false;
        }
        return true;
    }

    private static char selectType() {
        System.out.println("Troop Type:");
        System.out.println("\ta. Paladin");
        System.out.println("\tb. Fighter");
        System.out.println("\tc. Ranger");
        System.out.print("Choice: ");
        String choice;
        do {
            choice = input.nextLine();
            if (choice.length() != 1 || (choice.charAt(0) != 'a' && choice.charAt(0) != 'b' && choice.charAt(0) != 'c')) {
                System.err.println("Incorrect choice, please input again");
                System.out.print("Choice: ");
            } else {
                break;
            }
        } while (true);
        return choice.charAt(0);
    }
}
