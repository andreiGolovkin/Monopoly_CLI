/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipoly_cli;


/**
 *
 * @author Andrei Golovkin
 */
public class Minipoly_CLI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        
        while(!game.isOver()){
            game.iterate();
        }
        
    }
    
}
