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
public class Property implements CellType{
    private int price = 0;
    public CellGroup group;
    
    public Property(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
    
    @Override
    public String toString(){
        return "" + price;
    }

    @Override
    public CellType setOwner(Player newOwner){
        newOwner.decMoney(getPrice());
        CellType ans = new OwnedProperty(newOwner, price);
        ans.setGroup(group);
        return ans;
    }

    @Override
    public void setGroup(CellGroup group) {
        this.group = group;
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public CellType update() {
        return this;
    }

    
    @Override
    public void process(Player p) {}
    
    @Override
    public int getMovingPrice() {
        return 0;
    }
    
}
