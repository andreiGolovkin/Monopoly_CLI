/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cell;

import Cell.Types.CellType;
import Cell.Types.EmptyCell;
import Cell.Types.OwnedProperty;
import Cell.Types.Property;
import minipoly_cli.Player;

/**
 *
 * @author Andrei Golovkin
 */
public class Cell {
    private String name = "";
    private Cell nextCell = null;
    private CellType type = null;
    private CellGroup group = null;
    private int price = 0;
    
    public void setPrice(int price){
        if(price > 0){
            type = new Property(price);
        }
        else{
            type = new EmptyCell();
        }
    }
    
    public void setGroup(CellGroup group){
        assert type == null;
        
        this.group = group;
        type.setGroup(group);
        group.add(this);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean possibleToBuy(Player p){
        return forSale() && p.isAffordable(getPrice());
    }
    
    public boolean possibleToUpdate(Player p){
        return updateble() && p == getOwner() && group.fullyOwned() && p.isAffordable(getPrice());
    }
    
    public void setOwner(Player newOwner){
        assert possibleToBuy(newOwner);
        
        type = type.setOwner(newOwner);
    }
    
    public void update(){
        assert possibleToUpdate(getOwner());
        
        type.update();
    }
    
    public void process(Player p){
        type.process(p);
    }
    
    public int getPrice(){
        return type.getPrice();
    }
    
    public Player getOwner(){
        return type.getOwner();
    }
    
    public void setNextCell(Cell next){
        nextCell = next;
    }
    
    public Cell next(){
        return nextCell;
    }
    
    public boolean forSale(){
        return type.getClass() == Property.class;
    }
    
    public boolean updateble(){
        return type.getClass() == OwnedProperty.class;
    }
    
    @Override
    public String toString(){
        return group.getIndicator(this) + " " + name + " (" + type.toString() + ")";
    }
}
