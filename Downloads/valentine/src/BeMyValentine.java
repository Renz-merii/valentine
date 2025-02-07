import java.util.Scanner;

public class BeMyValentine {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Print out a romantic message
        System.out.println("Hey beautiful! 💖");
        System.out.println("I have something very important to ask...");

        // Pause for effect
        try {
            Thread.sleep(1500); // Sleep for 1.5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Ask the question
        System.out.println("Will you be my Valentine? 💌");

        // Wait for a response
        System.out.print("Type 'yes' if your answer is yes: ");
        String response = scanner.nextLine();

        // Check if the response is positive
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Yay! 😍 I'm so happy! I can't wait to spend this special day with you! 💕");
        } else {
            System.out.println("Oh, that's okay! You will always be my Valentine no matter what! 😘");
        }

        // Close the scanner object
        scanner.close();
    }
}
