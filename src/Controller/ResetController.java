// import statements
import javax.swing.*;

/**
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 13, 2024
 *
 */
public class ResetController {

    /**
     * Instance of model class
     */
    private Model model;

    /**
     * Instance of application class
     */
    private Application app;

    /**
     *
     * Deafult constructor
     *
     * @param app - application object
     * @param model - model object
     *
     */
    public ResetController(Application app, Model model){
        this.app =app;
        this.model = model;
    }

    /**
     *
     * Resets
     *
     */
    public void reset() {
        model.removeAll();

        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
