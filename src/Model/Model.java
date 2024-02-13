import java.awt.Polygon;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 9, 2024
 */
public class Model {
    //used to keep track of polygons
    LinkedList<Polygon> list = new LinkedList<>();
    //used to keep track of current polygon
    Polygon current = null;

    /**
     * Returns polygons in the model
     *
     * @return
     */
    public Iterator<Polygon> iterator() {
        return list.iterator();
    }

    /**
     * Returns the total number of polygons
     * @return
     */
    public int size() {
        //returns the number of polygons
        return list.size();
    }

    /**
     * Removes all polygons from the list
     */
    public void removeAll() {
        //removes all the polygons from the list
        list.clear();
        //removes current
        current = null;
    }

    /**
     * Adds a polygon to the list
     * @param poly
     */
    public void addPolygon(Polygon poly) {
        //adds a Polygon
        list.add(poly);
    }

    public void makeCurrent(Polygon poly) {
        if(list.contains(poly)){
            current = poly;
        } else {
            throw new NoSuchElementException("No Such Vertex");
        }
    }

    public void unselectPolygon(){
        current = null;
    }

    public Optional<Polygon> getSelected() {
        return Optional.ofNullable(current);
    }

    public boolean isSelected(Polygon poly) {
        return (poly != null && poly.equals(current));
    }
}
