import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Application extends JFrame{

    private JPanel contentPane;

    private JMenuBar coolBar;
    private JMenu Polygon;
    private JMenuItem Reset;
    private JMenu Edit;
    private JMenuItem Undo;

    public Application() {

        setTitle("Polygon Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        coolBar = new JMenuBar();
        setJMenuBar(coolBar);

        Polygon = new JMenu("Polygon");
        coolBar.add(Polygon);

        Reset = new JMenuItem("Reset");
        Reset.setAccelerator(KeyStroke.getKeyStroke("control N"));
        Polygon.add(Reset);

        Edit = new JMenu("Edit");
        coolBar.add(Edit);

        Undo = new JMenuItem("Undo");
        Undo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        Edit.add(Undo);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        setContentPane(contentPane);

    }

}
