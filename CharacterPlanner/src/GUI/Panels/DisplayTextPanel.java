package GUI.Panels;

import GUI.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DisplayTextPanel extends JPanel {
    private int width, height, xOffset, yOffset;
    private Font font;
    private Color transparentColor, greenColor, redColor, takenColor, debug1Color;
    private JLabel firstLine, secondLine;

    public DisplayTextPanel(Controller controller, Font font, Map<String, Color> colorsMap, boolean debug){
        this.font = font;
        setOpaque(false);
        transparentColor = colorsMap.get("Transparent");
        greenColor = colorsMap.get("Green");
        redColor = colorsMap.get("Red");
        takenColor = colorsMap.get("Taken");
        debug1Color = colorsMap.get("Debug1");
        width = 254;
        height = 32;
        xOffset = 50;
        yOffset = 748;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new  GridLayout(2,1));
        setBackground(debug? debug1Color:transparentColor);

        firstLine = new JLabel("LEVEL: 1");
        firstLine.setForeground(greenColor);
        firstLine.setFont(font);
        add(firstLine);

        secondLine = new JLabel("EXP: 1000");
        secondLine.setForeground(greenColor);
        secondLine.setFont(font);
        add(secondLine);
    }

    public void setCharBuildingMessage(int specials, int traits, int tags) {
        if(specials < 0){
            setFirstLineRed(true);
        } else {
            setFirstLineRed(false);
        }

        firstLine.setText("SPECIAL points left: " + specials + ", skill tags left: " + tags);
        secondLine.setText("Traits points: " + traits);
    }

    public void showLevelAndExpValues(int level, int exp, boolean newPerk) {
        firstLine.setForeground(greenColor);

        String firstLineText = "LEVEL: " + level;
        if(newPerk){
            firstLineText += "     NEW PERK!";
        }

        firstLine.setText(firstLineText);
        secondLine.setText("EXP: " + exp);
    }

    public void setFirstLineRed(boolean bool) {
        if(bool){
            firstLine.setForeground(redColor);
        } else {
            firstLine.setForeground(greenColor);
        }
    }
}
