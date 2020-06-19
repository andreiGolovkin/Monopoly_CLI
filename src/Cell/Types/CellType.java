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
public interface CellType {
    public int getPrice();
    public int getMovingPrice();
    public Player getOwner();
    public CellType setOwner(Player newOwner);
    public CellType update();
    public void process(Player p);
    public void setGroup(CellGroup group);
    @Override
    public String toString(); 
}
