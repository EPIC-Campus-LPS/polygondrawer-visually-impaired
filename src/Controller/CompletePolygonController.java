/**
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 13, 2024
 *
 */
public class CompletePolygonController {

    /**
     *
     * Instance of the Model class
     *
     */
    private Model model;

    /**
     *
     * Instance of Application class
     *
     */
    private Application app;

    /**
     *
     * Constructor that passes application and model
     *
     * @param app - application object
     * @param m - model object
     *
     */
    public CompletePolygonController(Application app, Model m){
        this.app = app;
        this.model = m;
    }

    /**
     *
     * refreshes
     *
     */
    public void complete(){
        model.unselectPolygon();

        UpdateMenu.updateMenu(app,model);
        app.repaint();
    }
}
