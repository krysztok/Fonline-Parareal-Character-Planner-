import Core.Character;
import GUI.GUI;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static void main(String[] args) throws IOException, FontFormatException {
        JFrame frame = new JFrame("Fonline Parareal Character Planner");

        ImageIcon icon = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/icon.png")));
        try {
            icon = new ImageIcon(ImageIO.read(Main.class.getResource("/resources/graphics/icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Character character = new Character();
        GUI gui = new GUI(frame, character);

        /****************FOR SMALLER RESOLUTION SCROLL PANE*********************/
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        int backgroundWidth = gui.getBgImage().getWidth();
        int backgroundHeight = gui.getBgImage().getHeight();

        if(screenWidth < backgroundWidth || screenHeight < backgroundHeight){
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setViewportView(gui);

            int scrollbarHeight = scrollPane.getHorizontalScrollBar().getHeight();
            int scrollbarWidth = scrollPane.getVerticalScrollBar().getWidth();

            int frameWidth = screenWidth < backgroundWidth? screenWidth - scrollbarWidth : backgroundWidth;
            int frameHeight = screenHeight < backgroundHeight? screenHeight - scrollbarHeight : backgroundHeight;
            frame.setPreferredSize(new Dimension(frameWidth, frameHeight));

            frame.add(scrollPane);
        /**********************************************************************/
        } else {
            frame.add(gui);
        }

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        //frame.setBounds(0, 0, preferredWidth, preferredHeight);
        frame.setVisible(true);
       // frame.setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }
}
