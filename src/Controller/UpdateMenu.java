/**
 *
 * @author Nathan Hoehndorf and Connor Bonn
 * @since February 13, 2024
 *
 */
public class UpdateMenu {

    /**
     *
     * Determines what the Menu looks like during certain situations
     *
     * @param app - application object
     * @param model - model object
     *
     */
    public static void updateMenu(Application app, Model model) {

        if (model.size() == 0) { // if there are no points

            app.getResetMenuItem().setEnabled(false); // can't use reset if nothing's there
            app.getUndoMenuItem().setEnabled(false); // can't use undo if nothing's there
            app.getUndoMenuItem().setText("Remove"); // renames Undo button to appropriate title

        } else { // if there is at least one point

            app.getResetMenuItem().setEnabled(true); // allow reset to be used
            app.getUndoMenuItem().setEnabled(true); // allow undo to be used

            if (model.getSelected().isPresent()) { // if the selected point exists

                app.getUndoMenuItem().setText("Remove last point"); // remove the point

            } else {

                app.getUndoMenuItem().setText("Remove last Polygon"); // remove the shape

            }
        }
    }
}