// import statements


import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 * Class that extends JPanel, used for drawing the shapes
 */
public class PolygonDrawer extends JPanel {
    public static final int RADIUS = 2;

    /**
     * Instantiates an instance of the Model class
     */
    Model model;

    /**
     * Constructor acts as a JPanel, but passes model
     *
     * @param m - Model object
     */
    public PolygonDrawer(Model m) {
        this.model = m;
    }

    /**
     *
     * Actually puts the things on the visual application
     *
     * @param g the <code>Graphics</code> object to protect
     *
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator<Polygon> it = model.iterator();
        while (it.hasNext()) {
            Polygon poly = it.next();

            g.setColor(Color.black);
            if(model.isSelected(poly)){
                g.setColor(Color.white);
            }

            //draw line if close
            if (poly.npoints >= 3) {
                for (int i = 0; i < poly.npoints - 1; i++) {
                    g.drawLine(poly.xpoints[i], poly.ypoints[i], poly.xpoints[i + 1], poly.ypoints[i + 1]);
                }
                g.drawLine(poly.xpoints[poly.npoints - 1], poly.ypoints[poly.npoints - 1], poly.xpoints[0], poly.ypoints[0]);
            } else {
                for (int i = 0; i < poly.npoints; i++) {
                    g.drawOval(poly.xpoints[i] - RADIUS, poly.ypoints[i] - RADIUS, 2 * RADIUS, 2 * RADIUS);
                }
            }
        }
    }
}
