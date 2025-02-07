import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class TulipPattern extends JPanel {

    // Method to draw the tulips
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set up anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw tulips on the panel
        drawTulip(g2d, 150, 200);  // First tulip at (150, 200)
        drawTulip(g2d, 300, 200);  // Second tulip at (300, 200)
    }

    // Method to draw a single tulip
    private void drawTulip(Graphics2D g2d, int x, int y) {
        // Draw the stem of the tulip (green line)
        g2d.setColor(new Color(34, 139, 34)); // Green for the stem
        g2d.setStroke(new BasicStroke(6)); // Make the stem thicker
        g2d.drawLine(x, y, x, y + 100); // Stem starting from (x, y) to (x, y+100)

        // Draw the leaves (optional but gives a more natural look)
        g2d.setColor(new Color(0, 128, 0)); // Green for leaves
        Path2D.Double leaf1 = new Path2D.Double();
        leaf1.moveTo(x - 50, y + 30);
        leaf1.curveTo(x - 70, y + 50, x - 50, y + 100, x, y + 100);
        g2d.fill(leaf1);

        Path2D.Double leaf2 = new Path2D.Double();
        leaf2.moveTo(x + 50, y + 30);
        leaf2.curveTo(x + 70, y + 50, x + 50, y + 100, x, y + 100);
        g2d.fill(leaf2);

        // Draw the petals of the tulip (Pink)
        GradientPaint petalGradient = new GradientPaint(
                x, y - 60, new Color(255, 105, 180), // Start color (light pink)
                x, y - 100, new Color(255, 20, 147), // End color (darker pink)
                true // Use cyclic gradient
        );
        g2d.setPaint(petalGradient);

        // Left petal using a cubic curve (more control over the petal shape)
        QuadCurve2D leftPetal = new QuadCurve2D.Float(x - 30, y - 30, x - 60, y - 90, x, y - 60);
        g2d.fill(leftPetal);

        // Right petal using a cubic curve
        QuadCurve2D rightPetal = new QuadCurve2D.Float(x + 30, y - 30, x + 60, y - 90, x, y - 60);
        g2d.fill(rightPetal);

        // Bottom-left petal to close the tulip shape
        QuadCurve2D bottomLeftPetal = new QuadCurve2D.Float(x - 60, y - 30, x - 90, y - 10, x - 30, y);
        g2d.fill(bottomLeftPetal);

        // Bottom-right petal to complete the tulip
        QuadCurve2D bottomRightPetal = new QuadCurve2D.Float(x + 60, y - 30, x + 90, y - 10, x + 30, y);
        g2d.fill(bottomRightPetal);
    }

    public static void main(String[] args) {
        // Set up the frame
        JFrame frame = new JFrame("Closed Tulips");
        TulipPattern tulipPattern = new TulipPattern();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Set the size of the window
        frame.add(tulipPattern);
        frame.setVisible(true);
    }
}
