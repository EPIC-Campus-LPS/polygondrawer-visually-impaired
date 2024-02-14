// import statements
import java.awt.*;
import java.util.Iterator;
import java.util.Optional;

/**
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 13, 2024
 *
 */
public class UndoController {
    /**
     * Instance of model class
     */
    private Model model;
    /**
     * Instance of application class
     */
    private Application app;

    /**
     * Default constructor
     * @param app
     * @param m
     *
     */
    public UndoController(Application app, Model m) {
        this.app = app;
        this.model = m;
    }

    /**
     * Removes most recent point in polygon
     */
    public void removeLastPoint() {
        Optional<Polygon> selected = model.getSelected(); // gets the selected (and therefore most recent) point
        if (selected.isPresent()) { // if a point is selected
            Polygon poly = selected.get(); // save the point
            if (poly.npoints > 0) { // if there is at least one point
                poly.npoints--; // decrement the number of points
            }
        } else { // a point is not selected
            Iterator<Polygon> it = model.iterator(); // holds all the points
            while (it.hasNext()) { // not at end
                it.next();
                if (!it.hasNext()) {
                    it.remove(); // remove the last one
                    break;
                }
            }
        }
        UpdateMenu.updateMenu(app, model); // updates the menu bar
        app.repaint(); // refreshes the screen
    }
}
