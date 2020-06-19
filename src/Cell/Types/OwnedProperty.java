/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cell.Types;

import Cell.CellGroup;
import minipoly_cli.Player;

/**
 *
 * @author Andrei Golovkin
 */
public class OwnedProperty implements CellType{
    private Player owner;
    private int price;
    private int level = 0;
    CellGroup group;

    public OwnedProperty(Player newOwner, int newPrice){
        owner = newOwner;
        price = newPrice;
    }
    
    
    
    

    @Override
    public CellType setOwner(Player newOwner){
        return this;
    }
    
    @Override
    public String toString(){
        return owner.getName() + "(" + getMovingPrice() + ")";
    }

    @Override
    public void process(Player p) {
        if(p != owner){
            System.out.println("Player " + p.getName() + " paid " + getMovingPrice() + "$ to player " + owner.getName());
            p.decMoney(getMovingPrice());
            owner.incMoney(getMovingPrice());
        }
    }

    @Override
    public void setGroup(CellGroup group) {
        this.group = group;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public CellType update() {
        if(level < 4){
            owner.decMoney(getPrice());
            level++;
            
            return this;
        }
        else{
            owner.decMoney(getPrice());
            
            CellType newType = new Hotel(owner, price);
            newType.setGroup(group);
            
            return newType;
        }
    }
    
    @Override
    public int getPrice() {
        if(level < 4) return (int)((double)price * 0.5);
        else return (int)((double)price * 0.8);
    }

    @Override
    public int getMovingPrice() {
         return (int)((double)price * (group.fullyOwned() ? 0.2 : 0.1)) + (int)((double)price * 0.1) * level;
    }
}
