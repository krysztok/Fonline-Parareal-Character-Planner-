import Core.Character;
import GUI.GUI;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IOException, FontFormatException {
        // Create a frame
        JFrame frame = new JFrame("Fonline Parareal Character Planner");

        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/background.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon icon = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/icon.png")));
        try {
            icon = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Character character = new Character();
        GUI gui = new GUI(frame, character);
        frame.setLayout(null);
        //frame.add(gui);


        /****************FOR SMALLER RESOLUTION SCROLL PANE*********************/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        int preferredWidth = 1129, preferredHeight = 851;
        int imageWidth = 1113, imageHeight = 812;

        if(width < preferredWidth || height < preferredHeight) {
            if(width < preferredWidth){
                preferredWidth = width;
                width = width - 20;
            } else {
                width = preferredWidth;
                preferredWidth += 20;
            }

            if(height < preferredHeight){
                height = height - 40;
                preferredHeight = height;
            } else {
                height = preferredHeight;
            }

            JPanel contentPane = new JPanel();
            frame.setContentPane(contentPane);
            contentPane.setLayout(null);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

            scrollPane.setBounds(0, 0, width, height-40);
            scrollPane.setPreferredSize(new Dimension(width, height-40));

            JPanel viewport = new JPanel();
            viewport.setLayout(null);
            viewport.setBounds(0, 0, imageWidth, imageHeight);
            viewport.add(gui);

            JLabel lblNewLabel = new JLabel();
            lblNewLabel.setIcon(new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/background.png"))));
            lblNewLabel.setBounds(0, 0, imageWidth, imageHeight);
            viewport.add(lblNewLabel);

            viewport.setPreferredSize(new Dimension(imageWidth, imageHeight));
            scrollPane.setViewportView(viewport);
            contentPane.add(scrollPane);
        } else {
            frame.add(gui);
        }

        /*************************************/


        // Display the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setBounds(0, 0, preferredWidth, preferredHeight);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }
}
