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
    private Model model;
    private Application app;

    public UndoController(Application app, Model m) {
        this.app = app;
        this.model = m;
    }

    public void removeLastPoint() {
        Optional<Polygon> selected = model.getSelected();
        if (selected.isPresent()) {
            Polygon poly = selected.get();
            if (poly.npoints > 0) {
                poly.npoints--;
            }
        } else {
            Iterator<Polygon> it = model.iterator();
            while (it.hasNext()) {
                it.next();
                if (!it.hasNext()) {
                    it.remove();
                    break;
                }
            }
        }
        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
