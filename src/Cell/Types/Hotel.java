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
public class Hotel implements CellType{
    private Player owner;
    private int price;
    CellGroup group;
    
    public Hotel(Player newOwner, int newPrice){
        owner = newOwner;
        price = newPrice;
    }
    
    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getMovingPrice() {
        return (int)((double)price * 0.28) + (int)((double)price * 0.1);
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public CellType setOwner(Player newOwner) {
        return this;
    }

    @Override
    public CellType update() {
        return this;
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
    
}
