import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * Runs the PolygonDrawer application.
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since Version 1.2 -- February 9, 2024
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        // instantiates the Model
        Model m = new Model();
        Application frame = new Application(m); // creates the window
        frame.setVisible(true); //  makes the window visible

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if(new QuitController().confrim(frame)){
                    frame.dispose();
                }
            }
        });

    }
}