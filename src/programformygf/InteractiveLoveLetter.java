import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveLoveLetter extends JPanel {

    // Full love letter message in one paragraph
    private String message = "Hello lovee, I know nakakastress always and super hirap palagi, especially when you're practicing for the festival and doing other schoolworks at the same time, pero kahit na super hirap, nakaya mo. And now, tapos na! I just want to say congratulations, my love. I'm always proud of you no matter what the result may be because I'm your number one fan. I always believe in you and that you can do it. I'm always here cheering for you, and I will always be proud of your accomplishments, no matter how big or small. And good luck for your upcoming exam! Don't worry, after the exam, babawi tayoo, pramis to you! I love youuuuuu always, my love.";

    // Index to track whether the letter is fully revealed or not
    private boolean letterRevealed = false;

    // Font and color settings
    private Font titleFont = new Font("Serif", Font.BOLD, 36);
    private Font messageFont = new Font("Serif", Font.PLAIN, 20); // Slightly smaller font size
    private Font footerFont = new Font("Serif", Font.ITALIC, 24); // Font for "With all my love, Renz"
    private Color textColor = new Color(255, 105, 180); // Soft pink color for text
    private Color backgroundColor = new Color(255, 240, 245); // Soft pink background color
    private Color borderColor = new Color(255, 182, 193); // Light rosy pink for the border

    // Constructor
    public InteractiveLoveLetter() {
        // Timer for redrawing the screen every 50ms
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(); // Repaint the screen to keep it responsive
            }
        });
        timer.start();

        // Mouse listener to detect click events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // If the letter hasn't been revealed, reveal it
                if (!letterRevealed) {
                    letterRevealed = true;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set the background color for the panel
        setBackground(backgroundColor);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the decorative border around the letter
        drawLetterBorder(g2d);

        // Draw the title of the letter (e.g., "My Dearest, Mary")
        g2d.setFont(titleFont);
        g2d.setColor(textColor);
        g2d.drawString("My Dearest, Mary", 50, 100); // Title text

        // If the letter is revealed, draw the rest of the message
        if (letterRevealed) {
            g2d.setFont(messageFont);
            g2d.setColor(textColor);

            // Set up the text area where the letter will be drawn
            int lineHeight = 30; // Increased spacing between lines for readability
            int x = 50; // X position of the message
            int y = 150; // Starting Y position for the message

            // Create a FontMetrics object to measure text width
            FontMetrics metrics = g2d.getFontMetrics(messageFont);
            int maxWidth = 740; // Width of the message box (inside the border)

            // Split the message into multiple lines based on the width constraint
            String[] lines = wrapText(g2d, message, maxWidth);

            // Draw each line of the wrapped message
            for (String line : lines) {
                g2d.drawString(line, x, y);
                y += lineHeight; // Move down for the next line
            }

            // Leave space between the message and the footer
            y += 40; // Adjust this value to control the space between the paragraph and footer

            // Draw the footer (with all my love, Renz) outside of the main paragraph
            g2d.setFont(footerFont);
            g2d.setColor(textColor);
            g2d.drawString("With all my love,", x, y);
            g2d.drawString("Renz", x, y + lineHeight);
        } else {
            // Draw a cute "reveal" message or design element before the letter is revealed
            g2d.setFont(new Font("Serif", Font.PLAIN, 18));
            g2d.setColor(new Color(255, 105, 180)); // Soft pink for this text
            g2d.drawString("Tap to reveal the letter!", 50, 400);
        }
    }

    // Method to draw the decorative border around the letter
    private void drawLetterBorder(Graphics2D g2d) {
        // Set the border color
        g2d.setColor(borderColor);
        // Draw the rectangle with rounded corners (border of the letter)
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRoundRect(30, 50, 740, 500, 30, 30); // x, y, width, height, arcWidth, arcHeight
    }

    // Method to wrap text based on the width of the box (maxWidth)
    private String[] wrapText(Graphics g, String text, int maxWidth) {
        FontMetrics metrics = g.getFontMetrics();
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();
        StringBuilder wrappedText = new StringBuilder();

        // Iterate over the words and wrap them
        for (String word : words) {
            // Check if the current line width is too long
            if (metrics.stringWidth(currentLine + word) <= maxWidth) {
                currentLine.append(word).append(" ");
            } else {
                // Move the current line to the wrapped text and start a new line
                wrappedText.append(currentLine).append("\n");
                currentLine = new StringBuilder(word + " ");
            }
        }

        // Append the last line
        wrappedText.append(currentLine);

        // Return the wrapped lines as an array of strings
        return wrappedText.toString().split("\n");
    }

    public static void main(String[] args) {
        // Create the main JFrame window
        JFrame frame = new JFrame("Interactive Love Letter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window

        // Add the InteractiveLoveLetter panel to the frame
        frame.add(new InteractiveLoveLetter());

        // Make the window visible
        frame.setVisible(true);
    }
}
