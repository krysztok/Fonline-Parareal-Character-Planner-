package GUI.Panels;

import GUI.Controller;
import GUI.CustomToolTip;
import GUI.ToolTipsGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class SkillPointsPanel extends JPanel {
    private int width, height, xOffset, yOffset, defaultValue;
    Color transparentColor, debug1Color;
    private RollingNumbersPanel skillPoints;
    private ImageIcon[] numbers;
    private ImageIcon[] negativeNumbers;
    private JButton plus1Button, plus5Button, readAllButton;
    private Icon plus1Icon, plus1PushedIcon, plus5Icon, plus5PushedIcon, allIcon, allPushedIcon;

    public SkillPointsPanel(Controller controller, ImageIcon[] numbers, ImageIcon[] negativeNumbers, Map<String, Color> colorsMap,
                            Map<String, Icon> iconsMap, boolean debug) {
        transparentColor = colorsMap.get("Transparent");
        debug1Color = colorsMap.get("Debug1");
        plus1Icon = iconsMap.get("plus1");
        plus1PushedIcon = iconsMap.get("plus1Pushed");
        plus5Icon = iconsMap.get("plus5");
        plus5PushedIcon = iconsMap.get("plus5Pushed");
        allIcon = iconsMap.get("all");
        allPushedIcon = iconsMap.get("allPushed");
        defaultValue = 9999;
        width = 180;
        height = 24;
        xOffset = 541;
        yOffset = 304;
        setBounds(xOffset, yOffset, width, height);
        setLayout(null);
        setBackground(debug? debug1Color:transparentColor);

        skillPoints = new RollingNumbersPanel(numbers, negativeNumbers, 4, 0,0);
        add(skillPoints);
        skillPoints.setValue(defaultValue);

        plus1Button = new JButton(plus1PushedIcon){
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };

        plus1Button.setPressedIcon(plus1PushedIcon);
        plus1Button.setToolTipText("1 skill points per click");
        plus1Button.setBorder(null);
        plus1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setSkillPointsPerClickAmount(1);
            }
        });
        plus1Button.setBounds(76, 2,23, 21 );
        add(plus1Button);

        plus5Button = new JButton(plus5Icon){
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };

        plus5Button.setPressedIcon(plus5PushedIcon);
        plus5Button.setToolTipText("5 skill points per click");
        plus5Button.setBorder(null);
        plus5Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setSkillPointsPerClickAmount(5);
            }
        });
        plus5Button.setBounds(102, 2,23, 21 );
        add(plus5Button);

        readAllButton = new JButton(allIcon) {
            @Override
            public JToolTip createToolTip() {
                return (new CustomToolTip(this));
            }
        };

        readAllButton.setPressedIcon(allPushedIcon);
        readAllButton.setBorder(null);
        readAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.readAllBooksButtonOnClick();
            }
        });

        readAllButton.setToolTipText("Read all books");
        readAllButton.setBorder(null);
        readAllButton.setBounds(140, 2,23, 21 );
        add(readAllButton);
    }

    public void changeIcons(int skillPointsPerClick) {
        if(skillPointsPerClick == 1){
            plus1Button.setIcon(plus1PushedIcon);
            plus5Button.setIcon(plus5Icon);
        } else {
            plus1Button.setIcon(plus1Icon);
            plus5Button.setIcon(plus5PushedIcon);
        }
    }

    public void showSkillPoints(int points) {
        skillPoints.setValue(points);
    }
}
