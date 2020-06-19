package minipoly_cli;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Golovkin
 */
public class CommandReader {
    private Scanner input = new Scanner(System.in);
    
    public String read(){
        //System.out.println("Enter the command:");
        
        String command = input.next();
        return command;
    }
}
