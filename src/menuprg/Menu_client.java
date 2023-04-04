package menuprg;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Menu_client extends JFrame {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private JPanel mainPanel;

    public Menu_client() {
        setTitle("Food Menu");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        // Create the menu item
        createMenuItem("pizza","C:\\Users\\user\\Desktop\\rocket.jpg");
        createMenuItem("pizza","C:\\Users\\user\\Desktop\\rocket.jpg");
        createMenuItem("pizza","C:\\Users\\user\\Desktop\\rocket.jpg");
        createMenuItem("pizza","C:\\Users\\user\\Desktop\\rocket.jpg");
        createMenuItem("pizza","C:\\Users\\user\\Desktop\\rocket.jpg");
        setVisible(true);
    }

    private void createMenuItem(String name, String imageName) {
        // Create the menu item panel
        JPanel menuItemPanel = new JPanel();
        menuItemPanel.setLayout(new BoxLayout(menuItemPanel, BoxLayout.X_AXIS));
        menuItemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuItemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create the food image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imageName));
        } catch (Exception e) {
            e.printStackTrace();
        }
		Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Scale the Image to fit the label
	
        JLabel imageLabel = new JLabel(new ImageIcon(newImg));
        menuItemPanel.add(imageLabel);

        // Create the food name label
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        menuItemPanel.add(nameLabel);

        // Add the menu item panel to the main panel
        mainPanel.add(menuItemPanel);
    }

    public static void main(String[] args) {
    	try {
    		new Menu_client();
    	}
        catch(Exception e) {
        	
        }
    }
}
