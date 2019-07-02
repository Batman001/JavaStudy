package com.test.gui;

import com.test.jdbc.HeroDAO;
import com.test.jdbc.JDBCHero;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Batman on 2018/11/13.
 * @author Batman
 * 提供一个table显示需要的所有信息
 * TableModel，就用于存放要显示的数据
 * 将数据与展示进行分开存放
 */
public class HeroTableModel extends AbstractTableModel {

    String[] columnNames = new String[] { "id", "name", "hp", "damage" };

    /**
     * 使用HeroDAO返回的list作为TableModel的数据
     */
    public List<JDBCHero> heros = new HeroDAO().listAllData();



    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     * 返回一共有多少行
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        return heros.size();
    }


    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     * 返回一共有多少列
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    /**
     * Returns a default name for the column using spreadsheet conventions:
     * A, B, C, ... Z, AA, AB, etc.  If <code>column</code> cannot be found,
     * returns an empty string.
     *
     * 返回每一列的名称
     * @param column the column being queried
     * @return a string containing the default name of <code>column</code>
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    /**
     * Returns false.  This is the default implementation for all cells.
     *
     * 返回单元格是否可以修改
     * @param rowIndex    the row being queried
     * @param columnIndex the column being queried
     * @return false
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     * 返回每一个单元格的值
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        JDBCHero h = heros.get(rowIndex);
        if(0==columnIndex){
            return h.getId();
        }
        if(1 == columnIndex){
            return h.getName();
        }
        if(2==columnIndex){
            return h.getHp();
        }
        if(3==columnIndex){
            return h.getDamage();
        }
        return null;
    }
}