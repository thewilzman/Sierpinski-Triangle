import javax.swing.*;
import java.awt.*;

// Define a class named SierpinskiTriangle that extends JFrame
public class SierpinskiTriangle extends JFrame {

    // Constants for the width and height of the JFrame
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    // Constructor for the SierpinskiTriangle class
    public SierpinskiTriangle() {
        // Set the title of the JFrame
        setTitle("Sierpinski Triangle");
        // Set the size of the JFrame
        setSize(WIDTH, HEIGHT);
        // Set the default close operation for the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the background color of the content pane
        getContentPane().setBackground(Color.white);
        // Set the JFrame to be visible
        setVisible(true);
    }

    // Method to draw the Sierpinski Triangle recursively
    public void drawSierpinskiTriangle(Graphics g, int x, int y, int size, int depth) {
        // Base case: If depth is 0, draw a triangle
        if (depth == 0) {
            // Define the coordinates of the triangle
            int[] xPoints = {x, x + size / 2, x - size / 2};
            int[] yPoints = {y, y + size, y + size};
            // Draw the triangle using the polygon method
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            // Recursive case: Divide the triangle into three and call the method on each
            int newSize = size / 2;

            // Recursive call for the top triangle
            drawSierpinskiTriangle(g, x, y, newSize, depth - 1);
            // Recursive call for the bottom left triangle
            drawSierpinskiTriangle(g, x + newSize / 2, y + newSize, newSize, depth - 1);
            // Recursive call for the bottom right triangle
            drawSierpinskiTriangle(g, x - newSize / 2, y + newSize, newSize, depth - 1);
        }
    }

    // Override the paint method to draw the Sierpinski Triangle
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the Sierpinski Triangle starting from the center of the JFrame
        drawSierpinskiTriangle(g, WIDTH / 2, 50, 400, 5);
    }

    // Main method to create an instance of the SierpinskiTriangle class
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new SierpinskiTriangle());
    }
}

