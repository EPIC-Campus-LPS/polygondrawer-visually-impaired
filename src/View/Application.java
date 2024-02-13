// import statements

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.awt.Color.*;

/**
 * Configures the window and elements of the application
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 9, 2024
 */
public class Application extends JFrame {
    /**
     * Contains all the content of the application
     */
    PolygonDrawer contentPane;

    /**
     * Contains all the content of the menu bar
     */
    private JMenuBar coolBar;
    /**
     * Contains all options under the drop-down "Polygon"
     */
    JMenu Polygon;
    /**
     * Creates a drop-down option called "Reset"
     */
    JMenuItem Reset;
    /**
     * Contains all options under the drop-down "Edit"
     */
    JMenu Edit;

    /**
     * Creates a drop-down option called "Undo"
     */
    JMenuItem Undo;

    /**
     * Instantiates a model from the Model class
     */
    Model model;

    /**
     * Defines and sets up all the content in the application window
     *
     * @param m -- An instantiation of the Model class
     */
    public Application(Model m) {
        super();
        this.model = m; // defines model
        setTitle("Polygon Drawing"); // sets the title of the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // defines how the program stops running
        setBounds(100, 100, 450, 300); // sets the size of the window frame

        coolBar = new JMenuBar(); // defines the menu bar
        setJMenuBar(coolBar); // tells the frame which object to look for the menu bar

        Polygon = new JMenu("Polygon"); // defines the polygon menu
        coolBar.add(Polygon); // tells the frame which object to look for the polygon menu

        Reset = new JMenuItem("Reset"); // defines the item as the reset button
        Reset.setAccelerator(KeyStroke.getKeyStroke("control N")); // defines what happens if the option is selected
        Polygon.add(Reset); // tells the frame which object to look for the reset option

        Edit = new JMenu("Edit"); // defines the edit menu
        coolBar.add(Edit); // tells the frame which object to look for the edit menu

        Undo = new JMenuItem("Undo"); // defines the item as the undo button
        Undo.setAccelerator(KeyStroke.getKeyStroke("control Z")); // defines what happens if the option is selected
        Edit.add(Undo); // tells the frame which object to look for the undo option

        contentPane = new PolygonDrawer(model); // defines the content pane as a PolygonDrawer, with "model" as an argument
        contentPane.addMouseListener(new MouseAdapter() { // listens for mouse clicks
            public void mouseClicked(MouseEvent e) { // when the mouse clicks

                new AddPointController(Application.this, model).addPoint(e.getPoint()); // create a point controller and add a point when the mouse is clicked

            }
        });
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Defines the borders of the pane
        contentPane.setLayout(new BorderLayout(0, 0)); // defines the size of the gaps between elements
        contentPane.setBackground(black);

        setContentPane(contentPane); // tells the frame which object to look for the content

    }
    /**
     *
     * No-argument constructor so that Java doesn't get pissy
     *
     */
    Application() {

        this (new Model());

    }

    /**
     *
     * Returns the Undo object
     *
     * @return Undo - undo option object
     *
     */
    public JMenuItem getUndoMenuItem() {

        return Undo;

    }

    /**
     *
     * Returns the Reset object
     *
     * @return Reset - reset option object
     *
     */
    public JMenuItem getResetMenuItem() {

        return Reset;

    }

    /**
     *
     * Returns the contentPane object
     *
     * @return contentPane - where the content of the window is contained
     *
     */
    public JPanel getPolygonDrawer() {

        return contentPane;

    }
}
