package memento;

 

import java.util.*;


// Value object.
//
public class TableMemento implements java.io.Serializable {

    private ArrayList columnIdentifiers;
    private ArrayList dataList;

    // Package visibility to only allow access for
    // the Originator.
    // We receive from the TableModel:
    // - a List of column identifiers
    // - a List of Lists of Object values (assumption: Strings)

    TableMemento(ArrayList columnIdentifiers, ArrayList dataList)
    {
	this.columnIdentifiers = columnIdentifiers;
    this.dataList = dataList;

    }

    // Package visibility to only allow access for
    // the Originator.
    ArrayList getColumnIdentifiers()
    {
	return this.columnIdentifiers;
        //throw new UnsupportedOperationException();


    }

    ArrayList getDataVector()
    {
        return this.dataList;
        //throw new UnsupportedOperationException();



    }

    @Override
    public String toString() {
	return "[ci=" + columnIdentifiers.toString() + "\n" +
	    "dl=" + dataList.toString() + "]";
    }

    // Other private (static) helper methods.
    // COMPLETE if necessary.

}
