import java.awt.*;
import java.util.Optional;

public class AddPointController {

    private Model model;

    private Application app;

    public AddPointController(Application a, Model m) {

        this.app = a;
        this.model = m;

    }

    public void addPoint(Point p) {

        Optional<Polygon> selected = model.getSelected();
        if (!selected.isPresent()) {

            Polygon poly = new Polygon();
            poly.addPoint(p.x,p.y);

            model.addPolygon(poly);
            model.makeCurrent(poly);

        } else {

            selected.get().addPoint(p.x,p.y);

        }

        app.repaint();

    }

}
