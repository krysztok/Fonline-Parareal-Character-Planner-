package GUI.Panels;

import GUI.Controller;
import GUI.CustomToolTip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

public class MainButtonsPanel extends JPanel {
    private int width, height, xOffset, yOffset;
    private Color transparentColor, debug1Color;
    private JButton resetButton, printButton, levelUpButton;
    Icon bigButtonIcon, bigButtonPushedIcon;

    public MainButtonsPanel(Controller controller, Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug) {
        transparentColor = colorsMap.get("Transparent");
        debug1Color = colorsMap.get("Debug1");
        width = 254;
        height = 17;
        xOffset = 12;
        yOffset = 757;
        setBounds(xOffset, yOffset, width, height);
        setLayout(null);
        setBackground(debug? debug1Color:transparentColor);

        bigButtonIcon = iconsMap.get("bigButton");
        bigButtonPushedIcon = iconsMap.get("bigButtonPushed");

        resetButton = new JButton(bigButtonIcon){
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        resetButton.setPressedIcon(bigButtonPushedIcon);
        resetButton.setToolTipText("Reset");
        resetButton.setBorder(null);
        resetButton.setBounds(0, 0,17, 17 );
        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.resetButtonOnClick();
            }
        });
        add(resetButton);

        printButton = new JButton(bigButtonIcon){
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        printButton.setPressedIcon(bigButtonPushedIcon);
        printButton.setToolTipText("Save build as PNG");
        printButton.setBorder(null);
        printButton.setBounds(114, 0,17, 17 );
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.printScreen();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(printButton);

        levelUpButton = new JButton(bigButtonIcon){
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };
        levelUpButton.setPressedIcon(bigButtonPushedIcon);
        levelUpButton.setToolTipText("Create character / Level up");
        levelUpButton.setBorder(null);
        levelUpButton.setBounds(231, 0,17, 17 );
        levelUpButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.levelUpButtonOnClick();
            }
        });
        add(levelUpButton);
    }
}
