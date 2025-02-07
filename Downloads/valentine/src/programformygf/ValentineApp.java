import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ValentineApp {

    // Messages to cycle through when "No" is clicked
    private static final String[] messages = {
            "Are you sure?",
            "Really sure??",
            "Are you positive?",
            "Pookie please...",
            "Just think about it!",
            "If you say no, I will be really sad...",
            "I will be very sad...",
            "I will be very very very sad...",
            "Ok fine, I will stop asking...",
            "Just kidding, say yes please! ❤️"
    };

    private static int messageIndex = 0;

    public static void main(String[] args) {
        // Create the frame for the application
        JFrame frame = new JFrame("Will You Be My Valentine?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Set pink background color
        frame.getContentPane().setBackground(new Color(255, 182, 193)); // Light pink color

        // Title label
        JLabel titleLabel = new JLabel("Will you be my Valentine?", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 20, 147)); // Deep pink color
        frame.add(titleLabel, BorderLayout.NORTH);

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 182, 193)); // Pink background for button panel

        // Yes and No buttons with pink theme
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");

        // Set button colors explicitly and make sure they are opaque
        yesButton.setBackground(new Color(255, 105, 180)); // Hot pink color for the button
        yesButton.setForeground(Color.WHITE);
        yesButton.setOpaque(true);
        yesButton.setBorderPainted(false);

        noButton.setBackground(new Color(255, 105, 180)); // Hot pink color for the button
        noButton.setForeground(Color.WHITE);
        noButton.setOpaque(true);
        noButton.setBorderPainted(false);

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Image to display (Cat GIF from provided URL)
        JLabel gifLabel = new JLabel();
        gifLabel.setHorizontalAlignment(JLabel.CENTER);

        // Load GIF from URL
        try {
            URL gifUrl = new URL("https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExbW5lenZyZHI5OXM2eW95b3pmMG40cWVrMDhtNjVuM3A4dGNxa2g2dSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/VM1fcpu2bKs1e2Kdbj/giphy.gif");
            ImageIcon catGif = new ImageIcon(gifUrl);
            gifLabel.setIcon(catGif);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.add(gifLabel, BorderLayout.CENTER);

        // Action listener for the "No" button
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noButton.setText(messages[messageIndex]);
                messageIndex = (messageIndex + 1) % messages.length;  // Cycle through the messages

                // Increase the font size of the Yes button by 1.5x
                Font currentFont = yesButton.getFont();
                float currentSize = currentFont.getSize2D();
                yesButton.setFont(currentFont.deriveFont(currentSize * 1.5f));
            }
        });

        // Action listener for the "Yes" button
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new page (In Java, you can handle this as a different window or functionality)
                JOptionPane.showMessageDialog(frame, "Yay! You said Yes!");
                // You can simulate redirection or other actions here
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
