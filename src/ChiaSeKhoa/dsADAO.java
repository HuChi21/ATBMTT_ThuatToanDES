/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChiaSeKhoa;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ADMIN
 */
public class dsADAO extends AbstractTableModel{
    public String Name[] = {"i","ai"};
    public Class classess[] = {long.class,long.class};
    
    ArrayList<Long> ds = new ArrayList<>();
    public dsADAO(ArrayList<Long> cn){
          ds = cn;
    } 
    public dsADAO(){
          
    } 
    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
       return Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 :
                return (rowIndex+1);
            case 1 :
                return  ds.get(rowIndex);
            
             default: return null;
        }
    }
    @Override
    public Class getColumnClass(int ColumnIndex){
           return classess[ColumnIndex];
       }
    @Override
     public String getColumnName(int Column){
           return Name[Column];
       }

}
