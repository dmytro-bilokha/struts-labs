package net.thinksquared.lilldep.database;
/**
  * Autogenerated by Lisptorq 0.1.4 
  * from default-scroller.template
*/
import java.util.Iterator;
public interface Scroller extends Iterator{ 

    /* (optional) Number of items on this Scroller. */
    public int size();

    /* (optional) Moves cursor to this position. */
    public void absolute(int position);

    /* Returns "true" if there is a previous item */
    public boolean hasPrevious();

    /* Returns the "previous" object or null if there is no such item */
    public Object previous();
    
}
