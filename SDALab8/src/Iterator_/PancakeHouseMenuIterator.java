package Iterator_;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {
    ArrayList al = new ArrayList();
    Iterator ia = al.iterator();

    PancakeHouseMenuIterator(ArrayList al){
        this.al = al;
    }

    @Override
    public boolean hasNext() {
        while(ia.hasNext())
            return ia.hasNext();
        return false;
    }

    @Override
    public Object next() {
        return ia.next();
    }
}
