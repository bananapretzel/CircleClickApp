package shapes;

import javax.swing.*;

public class CircleClickApp {
    /**
     * An app that displays a GUI that will let you click a button up to 20 times to see a circle randomly sized and
     * placed within the box.
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Click");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ShapePanel());
        frame.pack();
        frame.setVisible(true);
    }
}

