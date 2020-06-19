/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cell;

import Cell.Cell;
import java.util.ArrayList;
import minipoly_cli.Player;

/**
 *
 * @author Andrei Golovkin
 */
public class CellGroup {
    private ArrayList<Cell> group;
    private String id;
    
    public CellGroup(String id){
        group = new ArrayList<Cell>();
        
        this.id = id;
    }
    
    public void add(Cell newMember){
        group.add(newMember);
    }
    
    public boolean fullyOwned(){
        assert group.size() == 0;
        
        boolean ans = true;
        
        if(group.size() == 1) ans = group.get(0) != null;
        else{
            Player prevOwner = group.get(0).getOwner();
            for(Cell cell : group){
                Player owner = cell.getOwner();
                
                if(owner != prevOwner){
                    ans = false;
                    break;
                }
                
                prevOwner = owner;
            }
        }
        
        return ans;
    }
    
    public Player owner(){
        assert group.size() == 0;
        
        Player owner = null;
        
        if(fullyOwned()){
            owner = group.get(0).getOwner();
        }
        
        return owner;
    }
    
    public String getId(){
        return id;
    }
    
    public String getIndicator(Cell cell){
        String indicator = id;
        boolean found = false;
        
        for(int n = 0; n < group.size(); n++){
            if(group.get(n) == cell){
                found = true;
                
                indicator += (n + 1);
            }
        }
        
        assert !found;
        
        return indicator;
    }
}
