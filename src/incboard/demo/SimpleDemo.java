/*
 * 
    Copyright 2008 RobertoPinho. All rights reserved.

    This file is part of incboard.api.

    incboard.api is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    incboard.api is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with incboard.api.  If not, see <http://www.gnu.org/licenses/>.

    For academic use, please cite:
    
    Roberto Pinho, Maria Cristina F. de Oliveira, and Alneu de A. Lopes. 2009. Incremental board: a grid-based space for visualizing dynamic data sets. In Proceedings of the 2009 ACM symposium on Applied Computing (SAC '09). ACM, New York, NY, USA, 1757-1764. DOI=10.1145/1529282.1529679 http://doi.acm.org/10.1145/1529282.1529679
 */

package incboard.demo;

import incboard.api.DataItemInterface;
import incboard.api.DataModelInterface;
import incboard.api.DefaultDataItem;
import incboard.api.IncBoard;
import incboard.api.MoveEvent;
import incboard.engine.DataCell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RobertoPinho
 */
public class SimpleDemo implements DataModelInterface {
    
    public static void main(String[] args) {
        SimpleDemo sDemo = new SimpleDemo();
        sDemo.run();
    }

    List<DefaultDataItem> items = new ArrayList<DefaultDataItem>();
    int minRow = Integer.MAX_VALUE;
    int maxRow = Integer.MIN_VALUE;
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    int count = 0;
    int STEP = 10;
    
    
    public void moveReceived(MoveEvent event) {
        count++;
        if(count%STEP!=0) return;
        DataItemInterface moved = event.movedItem();
        if(moved.getRow()<minRow) minRow = moved.getRow();
        if(moved.getRow()>maxRow) maxRow = moved.getRow();       
        if(moved.getCol()<minCol) minCol = moved.getCol();
        if(moved.getCol()>maxCol) maxCol = moved.getCol();
        for(int r = minRow;r<=maxRow;r++) {
            for (int c = minCol; c <= maxCol; c++) {
                System.out.print("|");
                for(DefaultDataItem d:items){
                    if(d.getRow()==r && d.getCol()==c){
                        System.out.print(d.getURI()+" ");
                    }
                }
                System.out.print("\t");
            }
            System.out.println("");
        }
        System.out.println("============================================");
    }

    private void run() {
        IncBoard engine = new IncBoard(this);
        String rndStr;
        DefaultDataItem dCell;
        for(int i = 0;i<150;i++){
            rndStr = Integer.toString((int)(Math.random()*20));
            dCell = new DefaultDataItem(rndStr);
            engine.add(dCell);
            items.add(dCell);
        }
    }
}
