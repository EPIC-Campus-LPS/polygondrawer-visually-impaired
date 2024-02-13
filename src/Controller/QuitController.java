import javax.swing.*;

public class QuitController {
    public boolean confrim(Application app){
        return JOptionPane.showConfirmDialog (app, "Do you wish to exit the Application?") == JOptionPane.OK_OPTION;
    }
}
