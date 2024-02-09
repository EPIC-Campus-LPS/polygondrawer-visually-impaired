import java.awt.EventQueue;

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

    }
}