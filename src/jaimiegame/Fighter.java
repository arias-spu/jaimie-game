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
        return "Fighter{" + "shield=" + shield + ", attack=" + attack + ", life=" + life + '}';
    }
    
    
}
