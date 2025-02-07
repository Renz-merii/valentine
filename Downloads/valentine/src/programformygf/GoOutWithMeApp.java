import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GoOutWithMeApp {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Do You Wanna Go Out With Me?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Set the background color to pink
        frame.getContentPane().setBackground(Color.PINK);

        // Set up header text
        JLabel headerText = new JLabel("Do you wanna go out with me?", JLabel.CENTER);
        headerText.setFont(new Font("Indie Flower", Font.PLAIN, 32));
        frame.add(headerText, BorderLayout.NORTH);

        // Set up GIF (Bug Cat)
        try {
            URL gifURL = new URL("https://media.tenor.com/efbi1EpFlVUAAAAi/bugcat-capoo.gif");
            ImageIcon gifIcon = new ImageIcon(gifURL);
            JLabel gifLabel = new JLabel(gifIcon);
            frame.add(gifLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println("Error loading GIF: " + e.getMessage());
        }

        // Set up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // 'Yes' button
        JButton yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Arial", Font.PLAIN, 20));
        yesButton.setPreferredSize(new Dimension(150, 50));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Yay! I'm so happy! 😍", "Response", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 'No' button
        JButton noButton = new JButton("No");
        noButton.setFont(new Font("Arial", Font.PLAIN, 20));
        noButton.setPreferredSize(new Dimension(150, 50));

        // Ensure the "No" button stays within the frame bounds and moves only on hover
        noButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Get the frame's width and height
                int frameWidth = frame.getWidth();
                int frameHeight = frame.getHeight();

                // Get the button's width and height
                int buttonWidth = noButton.getWidth();
                int buttonHeight = noButton.getHeight();

                // Calculate random positions ensuring the button stays within bounds
                int x = (int) (Math.random() * (frameWidth - buttonWidth));
                int y = (int) (Math.random() * (frameHeight - buttonHeight));

                // Move the button to the new position
                noButton.setLocation(x, y);
            }
        });

        // Add buttons to the panel
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make frame visible
        frame.setVisible(true);
    }
}