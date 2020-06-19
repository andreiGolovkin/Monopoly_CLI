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
public class Game {
    private boolean cheatMode = true;
    private boolean gameOver = false;
    
    private CommandReader commandLine = new CommandReader();
        
    private Map map = new Map();
    private Dice dice = new Dice();
        
    private Player p1 = new Player();
    private Player p2 = new Player();
    
    private Player currentPlayer = p1;
    
    public Game(){
        System.out.print("Enter the name of player 1: ");
        String name1 = commandLine.read();
        p1.setName(name1);
        p1.setLocation(map.getStart());
        
        System.out.print("Enter the name of player 2: ");
        String name2 = commandLine.read();
        p2.setName(name2);
        p2.setLocation(map.getStart());
        
        System.out.println(map);
        System.out.println();
        System.out.println(p1);
        System.out.println();
        System.out.println(p2);
        System.out.println();
    }
    
    public void iterate(){
        System.out.println(map);
        System.out.println();

        int steps = getSteps();

        currentPlayer.move(steps);
        
        if(currentPlayer.getLocation().getName().equals("Corner 2")){
            currentPlayer.setLocation(map.getStart());
        }
        
        System.out.println(currentPlayer);
        System.out.println();
        
        if(!currentPlayer.bankrupt()) processCommand();
        else{
            if(currentPlayer == p1) System.out.println(p2.getName() + " won");
            else System.out.println(p1.getName() + " won");
        }

        if(currentPlayer == p1) currentPlayer = p2;
        else currentPlayer = p1;

        gameOver = p1.bankrupt() || p2.bankrupt() || gameOver;
    }
    
    private void showAvailableCommands(){
        System.out.println("Available Commands");
        
        if(currentPlayer.canBuy()) System.out.println("buy - to buy the property for " + currentPlayer.getLocation().getPrice() + "$");
        if(currentPlayer.canUpdate()) System.out.println("update - to update the property for " + currentPlayer.getLocation().getPrice() + "$");
        System.out.println("info - to show information about map and players");
        System.out.println("next - to end your turn");
        System.out.println("quit - to end the game");
    }
    
    private void processCommand(){
        boolean over = false;
        while(!over){
            
            showAvailableCommands();
            System.out.println();
            System.out.print("Enter your command: ");
            String command = commandLine.read();
            if(command.equals("quit")){
                gameOver = true;
                over = true;
            }
            else if(command.equals("buy")){
                if(currentPlayer.canBuy()){
                    currentPlayer.buy();
                }
                
                /*
                if(isBought) System.out.println("You sucessfully bought the property.");
                else System.out.println("You can't buy the property.");
                */
            }
            else if(command.equals("update")){
                if(currentPlayer.canUpdate()){
                    currentPlayer.update();
                }
            }
            else if(command.equals("info")){
                over = false;
                
                info();
            }
            else if(command.equals("next")){
                over = true;
            }
            else{
                over = false;
                System.out.println("Invalid command");
            }
        }
    }
    
    
    
    private int getSteps(){
        int steps;
        if(cheatMode){
            System.out.print("Enter number of steps: ");
            try{
                steps = Integer.parseInt(commandLine.read());
            }
            catch(java.lang.NumberFormatException e){
                System.out.println("Not a number");
                steps = rollDices();
            }
        }
        else{
            steps = rollDices();
        }
        
        return steps;
    }
    
    private int rollDices(){
        int dice1 = dice.roll();
        int dice2 = dice.roll();
        
        System.out.println("Dice 1: " + dice1 + " Dice 2: " + dice2);
        
        return dice1 + dice2;
    }
    
    public boolean isOver(){
        return gameOver;
    }
    
    
    
    
    // commands
    
    public void info(){
        System.out.println(map);
        System.out.println();
        System.out.println("Player 1");
        System.out.println(p1);
        System.out.println();
        System.out.println("Player 2");
        System.out.println(p2);
        System.out.println();
    }
}
