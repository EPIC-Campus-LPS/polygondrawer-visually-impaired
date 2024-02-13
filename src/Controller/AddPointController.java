// import statements
import java.awt.*;
import java.util.Optional;

/**
 *
 * Allows points to be added in the application
 *
 */
public class AddPointController {

    /**
     *
     * Instance of Model
     *
     */
    private Model model;

    /**
     *
     * Instance of Application
     *
     */
    private Application app;

    /**
     *
     * Assigns objects to the instances of model and application, respectively
     *
     * @param a - Appplication object
     * @param m - Model object
     *
     */
    public AddPointController(Application a, Model m) {

        this.app = a;
        this.model = m;

    }

    /**
     *
     * Adds a point at the specified location
     *
     * @param p - Point object
     *
     */
    public void addPoint(Point p) {

        Optional<Polygon> selected = model.getSelected(); // selected point
        if (!selected.isPresent()) { // if the point isn't there

            Polygon poly = new Polygon();
            poly.addPoint(p.x,p.y); // add a point at the given location

            model.addPolygon(poly); // add the polygon to the model
            model.makeCurrent(poly); // select it

        } else { // if the point is there

            selected.get().addPoint(p.x,p.y); // add a point at the given location

        }

        app.repaint(); // effectively refreshes the page

    }

}
