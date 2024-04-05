import javax.swing.*;
import java.awt.*;

public class ImageIconExample {
    public static void main(String[] args) {
        // Create a JFrame to display the JLabel
        JFrame frame = new JFrame("Image Icon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a JLabel
        JLabel imageLabel = new JLabel();

        // Load the image using getResource() (assuming the image is in the classpath)
        ImageIcon icon = new ImageIcon(ImageIconExample.class.getResource("/image.jpg"));
        imageLabel.setIcon(icon);

        // Add the JLabel to the frame
        frame.add(imageLabel);

        // Show the frame
        frame.setVisible(true);
    }
}
