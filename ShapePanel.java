package shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShapePanel extends JPanel {
    private final int DELAY = 10;
    /**
     * creates the panel and mechanisms for the GUI. A button with a listener to add a new circle, a counter for
     * presses and the panel for the graphics.
     */

    private final ArrayList<Shape> shapes = new ArrayList<Shape>();
    private int count = -1;
    private final JPanel controlPanel;
    private final JTextField showNum;
    private final JLabel countLabel;
    private final DrawingPanel drawPanel;
    private final Timer timer;
    private final JButton[] buttons = {new JButton("Circle"), new JButton("Square"), new JButton("Oval"),
            new JButton("Smiley"), new JButton("Swirl"), new JButton("Start"),
            new JButton("Stop"), new JButton("Remove")};


    /**
     * The panel for the GUI
     */
    public ShapePanel() {
        ButtonListener listener = new ButtonListener();
        showNum = new JTextField(2);
        countLabel = new JLabel("Remove which?");
        controlPanel = new JPanel();
        drawPanel = new DrawingPanel();
        timer = new Timer(DELAY, listener);

        for (JButton item : buttons) {
            item.addActionListener(listener);
            controlPanel.add(item);
        }

        controlPanel.setPreferredSize(new Dimension(100, 400));
        controlPanel.add(countLabel);
        controlPanel.add(showNum);
        add(controlPanel);
        add(drawPanel);
    }

    /**
     * The background for the shapes
     */
    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.cyan);
        }

        /**
         * the for-loop will display every instance of the shapes array that is not null
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < shapes.size(); i++) {
                if (!shapes.isEmpty()) {
                    shapes.get(i).display(g);
                    shapes.get(i).showIndex(g, shapes.indexOf(shapes.get(i)));

                }
            }
        }
    }

    /**
     * Listener for addShape. When Add Shape button is pressed it will add a Shape object to the shapes array and
     * continue doing so with every successive button press until a limit of 20. Start and stop is used to set the
     * timer.
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == timer) {
                for (int i = 0; i < shapes.size(); i++)
                    if (!shapes.isEmpty())
                        shapes.get(i).move();
            } else {
                JButton button = (JButton) event.getSource();
                if (button.getText().equals("Circle") && count < 20) {
                    shapes.add(new Circle());
                    showNum.setText(Integer.toString(count + 1));
                    count++;
                }
                if (button.getText().equals("Square") && count < 20) {
                    shapes.add(new Square());
                    showNum.setText(Integer.toString(count + 1));
                    count++;
                }
                if (button.getText().equals("Oval") && count < 20) {
                    shapes.add(new Oval());
                    showNum.setText(Integer.toString(count + 1));
                    count++;
                }
                if (button.getText().equals("Smiley") && count < 20) {
                    shapes.add(new Smiley());
                    showNum.setText(Integer.toString(count + 1));
                    count++;
                }
                if (button.getText().equals("Swirl") && count < 20) {
                    shapes.add(new Swirl());
                    showNum.setText(Integer.toString(count + 1));
                    count++;
                }
                if (button.getText().equals("Remove")) {
                    try {
                        int removeIndex = Integer.parseInt(showNum.getText());
                        shapes.remove(removeIndex);
                        showNum.setText(Integer.toString(count - 1));
                        count--;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input - please enter a number within range");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("the number you entered is out of bounds");
                    }

                }
                if (button.getText().equals("Start"))
                    timer.start();
                if (button.getText().equals("Stop"))
                    timer.stop();
                if (shapes.isEmpty())
                    showNum.setText(" ");
            }
            repaint();
        }
    }
}

