package GUI.Panels;

import GUI.Controller;
import GUI.CustomToolTip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpecialsPanel extends JPanel {
    private int width, height, xOffset, yOffset, defaultValue;
    Color transparentColor, debug1Color;
    private RollingNumbersPanel charPoints;
    private List<RollingNumbersPanel> specialsBase, specialsFinal;
    private ImageIcon[] numbers;
    private ImageIcon[] negativeNumbers;
    private List<String> specialsNames;
    private List<JButton> plusSpecialButtons, minusSpecialButtons;
    Icon minusIcon, minusPushedIcon, plusIcon, plusPushedIcon;

    public SpecialsPanel(Controller controller, ImageIcon[] numbers, ImageIcon[] negativeNumbers, List<String> specialsNames,
                         Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug){
        transparentColor = colorsMap.get("Transparent");
        debug1Color = colorsMap.get("Debug1");
        minusIcon = iconsMap.get("minus");
        minusPushedIcon = iconsMap.get("minusPushed");
        plusIcon = iconsMap.get("plus");
        plusPushedIcon = iconsMap.get("plusPushed");
        defaultValue = 11;
        width = 118;
        height = 290;
        xOffset = 52;
        yOffset = 32;
        setBounds(xOffset, yOffset, width, height);
        setLayout(null);
        setBackground(debug? debug1Color:transparentColor);

        this.numbers = numbers;
        this.negativeNumbers = negativeNumbers;
        this.specialsNames = specialsNames;

        specialsBase = new ArrayList<>();
        specialsFinal = new ArrayList<>();
        plusSpecialButtons = new ArrayList<>();
        minusSpecialButtons = new ArrayList<>();

        for(int i = 0; i < specialsNames.size(); i++){
            String specialName = specialsNames.get(i);
            RollingNumbersPanel baseSpecial = new RollingNumbersPanel(numbers, negativeNumbers, 2, 4,4 + i * 33);
            RollingNumbersPanel finalSpecial = new RollingNumbersPanel(numbers, negativeNumbers, 2, 50,4 + i * 33);
            add(baseSpecial);
            add(finalSpecial);
            baseSpecial.setValue(defaultValue);
            finalSpecial.setValue(defaultValue);
            specialsBase.add(baseSpecial);
            specialsFinal.add(finalSpecial);

            JButton plus = new JButton(plusIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            plus.setPressedIcon(plusPushedIcon);
            plus.setToolTipText("+" + specialName);
            plus.setBorder(null);
            plus.setBounds(96, 5 + i * 33,16, 12 );
            plus.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.plusSpecialButtonOnClick(specialName);
                }
            });
            add(plus);
            plusSpecialButtons.add(plus);

            JButton minus = new JButton(minusIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            minus.setPressedIcon(minusPushedIcon);
            minus.setToolTipText("-" + specialName);
            minus.setBorder(null);
            minus.setBounds(96, 17 + i * 33,16, 12 );
            minus.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.minusSpecialButtonOnClick(specialName);
                }
            });
            add(minus);
            minusSpecialButtons.add(minus);
        }

        charPoints = new RollingNumbersPanel(numbers, negativeNumbers, 2, 73,249);
        add(charPoints);
        charPoints.setValue(defaultValue);
    }

    public void showSpecialsValues(List<Integer> baseValues, List<Integer> finalValues) {
        for(int i = 0; i < specialsNames.size(); i++){
            specialsBase.get(i).setValue(baseValues.get(i));
            specialsFinal.get(i).setValue(finalValues.get(i));
        }
    }

    public void showCharPoints(int points) {
        charPoints.setValue(points);
    }
}
