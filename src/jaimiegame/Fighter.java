/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaimiegame;

/**
 *
 * @author arias
 */
public class Fighter {
    
    public static final int SHIELD_ON = 1;
    public static final int LIFE_ON = 2;
    public static final int DEAD = 3;
    
    private int shield;
    private int attack;
    private int life;
    private String name;

    public Fighter(String name, int shield, int attack, int life) {
        this.name = name;
        this.shield = shield;
        this.attack = attack;
        this.life = life;
    }

    @Override
    public String toString() {
        return "Fighter{" + "name=" + name + ", shield=" + shield + ", attack=" + attack + ", life=" + life + '}';
    }

    public int getShield() {
        return shield;
    }

    public int getAttack() {
        return attack;
    }

    public int getLife() {
        return life;
    }

    public String getName() {
        return name;
    }
    public int attack(int power){
        if (power > life){
            return 0;
        }
        if (power > 10 || power < 0){
            return -1;
        }
        life -= power;
        return (int)Math.round(power / 10.0 * attack * Math.random());
    }
    public int defend(int attack){
        if (shield > attack){
            shield -= attack;
            return SHIELD_ON;
        }else{
            if (shield > 0){
                attack -= shield;
                shield = 0;
            }
            if (life > attack){
                life -= attack;
                return LIFE_ON;
            }else{
                life = 0;
                return DEAD;
            }
            
        }
    }
    
}
