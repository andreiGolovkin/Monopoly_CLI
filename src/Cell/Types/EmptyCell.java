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
public class EmptyCell implements CellType{
    CellGroup group;

    @Override
    public int getPrice() {
        return 0;
    }
    
    @Override
    public String toString(){
        return "Not for sale";
    }

    @Override
    public CellType setOwner(Player newOwner) {
        return this;
    }

    @Override
    public void process(Player p) {}

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
    public int getMovingPrice() {
        return 0;
    }
}
