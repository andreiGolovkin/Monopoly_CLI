package minipoly_cli;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Golovkin
 */
public class Dice {
    private Random rand = new Random();
    
    public int roll(){
        return rand.nextInt(6) + 1;
    }
}
