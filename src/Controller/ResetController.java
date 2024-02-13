import javax.swing.*;

public class ResetController {
    private Model model;

    private Application app;

    public ResetController(Application app, Model model){
        this.app =app;
        this.model = model;
    }
    public void reset() {
        model.removeAll();

        UpdateMenu.updateMenu(app, model);
        app.repaint();
    }
}
