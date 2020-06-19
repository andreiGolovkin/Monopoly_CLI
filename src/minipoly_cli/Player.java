package minipoly_cli;

import Cell.Cell;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Golovkin
 */
public class Player {
    private String name;
    private int money;
    private Cell currentPos = null;
    
    public Player(){
        name = "";
        money = 2000;
    }
    
    public void decMoney(int price){
        money -= price;
    }
    
    public void incMoney(int amount){
        money += amount;
    }
    
    public boolean bankrupt(){
        return money < 0;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setLocation(Cell location){
        currentPos = location;
    }
    
    public Cell getLocation(){
        return currentPos;
    }
    
    public boolean canBuy(){
        return currentPos.possibleToBuy(this);
    }
    
    public boolean canUpdate(){
        return currentPos.possibleToUpdate(this);
    }
    
    public void buy(){
        currentPos.setOwner(this);
    }
    
    public void update(){
        currentPos.update();
    }
    
    @Override
    public String toString(){
        String desc = "";
        
        desc += name + "\n";
        desc += "money: " + money + "\n";
        if(currentPos != null){
            desc += "Location: " + currentPos.toString();
        }
        
        return desc;
    }
    
    public void move(int steps){
        if(currentPos != null){
            for(int n = 0; n < steps; n++){
                currentPos = currentPos.next();
            }
            
            currentPos.process(this);
        }
    }
    
    public boolean isAffordable(int price){
        return money >= price;
    }
}
