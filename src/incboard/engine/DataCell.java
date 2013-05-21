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


package incboard.engine;

import incboard.api.DataItemInterface;

/**
 *
 * @author RobertoPinho
 */
public class DataCell extends AbstractCell {
    private DataItemInterface dataItem;

    public DataCell(DataItemInterface item){
        this.dataItem = item;
        
    }
    
    public Double getDistance(CellItemInterface other) {
        return dataItem.getDistance(((DataCell)other).getDataItem());
    }

    public DataItemInterface getDataItem(){
        return dataItem;
    }
}
