package shapes;

import java.awt.*;
import java.util.Random;

public abstract class Shape {
    protected int x, y, width, height, moveX = 1, moveY = 1;
    protected Color colour;

    /**
     * the constructor randomises the width between 10-30 and sets the height to that number as well. X and Y is also
     * randomised to fit inside the drawing panel. Colour is also randomised.
     */
    public Shape() {
        width = randomRange(10, 30);
        height = width;
        x = randomRange(0, 400 - width);
        y = randomRange(0, 400 - height);
        colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
    }

    public void showIndex(Graphics g, int i) {
        g.setColor(Color.black);
        g.drawString(Integer.toString(i), x, y);
    }

    /**
     * Method to produce a random number between two numbers
     */
    public int randomRange(int lo, int hi) {
        Random generator = new Random();
        int result = generator.nextInt(hi - lo + 1) + lo;
        return result;
    }

    /**
     * This method gets called by the timer. When the circles are moving and touch the boundary of the drawing panel,
     * they change to a random colour and move at a random speed.
     */
    public void move() {

        if (x >= 400 - width) {
            moveX = randomRange(-2, 0);
            colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
        } else if (x <= 0) {
            moveX = randomRange(0, 2);
            colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
        }

        if (y >= 400 - height) {
            moveY = randomRange(-2, 0);
            colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
        } else if (y <= 0) {
            moveY = randomRange(0, 2);
            colour = new Color(randomRange(0, 255), randomRange(0, 255), randomRange(0, 255));
        }
        x += moveX;
        y += moveY;
    }

    /**
     * creates the circle and sets the colour
     */
    public abstract void display(Graphics g);
}
