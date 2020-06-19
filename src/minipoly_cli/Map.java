/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipoly_cli;

import Cell.Cell;
import Cell.CellGroup;
import java.util.HashMap;

/**
 *
 * @author Andrei Golovkin
 */
public class Map {
    private Cell start = null;
    
    public Map(){
        predefinedCell[] cells = {
            new predefinedCell("Start", 0, "Z"), // Go
            new predefinedCell("Prop 1", 50, "A"), // A1
            new predefinedCell("Empty 1", 0, "Z"), // empty
            new predefinedCell("Prop 2", 50, "A"), // A2
            new predefinedCell("Prop 3", 70, "A"), // A3
            new predefinedCell("Empty 2", 0, "Z"), // empty
            new predefinedCell("Prop 4", 100, "B"), // B1
            new predefinedCell("Empty 3", 0, "Z"), // empty
            new predefinedCell("Prop 5", 100, "B"), // B2
            new predefinedCell("Prop 6", 120, "B"), // B3
            new predefinedCell("Corner 1", 0, "Z"), // corner
            new predefinedCell("Prop 7", 150, "C"), // C1
            new predefinedCell("Empty 4", 0, "Z"), // empty
            new predefinedCell("Prop 8", 150, "C"), // C2
            new predefinedCell("Prop 9", 170, "C"), // C3
            new predefinedCell("Empty 5", 0, "Z"), // empty
            new predefinedCell("Prop 10", 200, "D"), // D1
            new predefinedCell("Empty 6", 0, "Z"), // empty
            new predefinedCell("Prop 11", 200, "D"), // D2
            new predefinedCell("Prop 12", 220, "D"), // D3
            new predefinedCell("Corner 2", 0, "Z"), // corner
            new predefinedCell("Prop 13", 250, "E"), // E1
            new predefinedCell("Empty 7", 0, "Z"), // empty
            new predefinedCell("Prop 14", 250, "E"), // E2
            new predefinedCell("Prop 15", 270, "E"), // E3
            new predefinedCell("Empty 8", 0, "Z"), // empty
            new predefinedCell("Prop 16", 300, "F"), // F1
            new predefinedCell("Empty 9", 0, "Z"), // empty
            new predefinedCell("Prop 17", 300, "F"), // F2
            new predefinedCell("Prop 18", 320, "F"), // F3
            new predefinedCell("Corner 3", 0, "Z"), // corner
            new predefinedCell("Prop 19", 350, "G"), // G1
            new predefinedCell("Empty 10", 0, "Z"), // empty
            new predefinedCell("Prop 20", 350, "G"), // G2
            new predefinedCell("Prop 21", 370, "G"), // G3
            new predefinedCell("Empty 11", 0, "Z"), // empty
            new predefinedCell("Prop 22", 400, "H"), // H1
            new predefinedCell("Empty 12", 0, "Z"), // empty
            new predefinedCell("Prop 23", 400, "H"), // H2
            new predefinedCell("Prop 24", 420, "H") // H3
        };
        
        initializeMap(cells);
    }
    
    private void initializeMap(predefinedCell[] cells){
        start = new Cell();
        HashMap<String, CellGroup> groups = new HashMap<>();
        
        Cell current_cell = start;
        for(int n = 0; n < cells.length; n++){
            String groupId = cells[n].groupId;
            String name = cells[n].name;
            int price = cells[n].price;
            if(!groups.containsKey(groupId)){
                groups.put(groupId, new CellGroup(groupId));
            }
            
            current_cell.setName(name);
            current_cell.setPrice(price);
            current_cell.setGroup(groups.get(groupId));
            
            if(n >= cells.length - 1){
                current_cell.setNextCell(start);
            }
            else{
                current_cell.setNextCell(new Cell());
            }
            
            current_cell = current_cell.next();
        }
    }
    
    public Cell getStart(){
        return start;
    }
    
    @Override
    public String toString(){
        String map = "";
        
        Cell current_cell = start;
        map += current_cell.toString();
        current_cell = current_cell.next();
        while(current_cell != start){
            map += " - " + current_cell.toString();
            current_cell = current_cell.next();
        }
        
        return map;
    }
    
    private class predefinedCell{
        public int price;
        public String groupId;
        public String name;
        
        public predefinedCell(){}
        
        public predefinedCell(String name, int price, String groupId){
            this.name = name;
            this.price = price;
            this.groupId = groupId;
        }
    }
}
