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

public class SkillsPanel extends JPanel {

    private JPanel tagPanel, labelsPanel, valuesPanel, skillPointsPanel, minusPanel, plusPanel, booksPanel, booksButtonsPanel, paddingPanel0, paddingPanel1, paddingPanel2;
    private int width, height, xOffset, yOffset, skillsAmount;
    Font font;
    Color transparentColor, debug1Color, debug2Color, greenColor, takenColor;
    private List<String> skillsNames;
    private List<JLabel> skillsLabels, valuesLabels, skillPointsLabels, booksAmountLabels;
    private List<JButton> tagButtons, minusSkillButtons, plusSkillButtons, plusBooksButtons;
    Icon smallButtonIcon, smallButtonPushedIcon, minusIcon, minusPushedIcon, plusIcon, plusPushedIcon;

    public SkillsPanel(Controller controller, Font font, List<String> skillsNames, Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug){
        this.font = font;
        setOpaque(false);
        transparentColor = colorsMap.get("Transparent");
        greenColor = colorsMap.get("Green");
        takenColor = colorsMap.get("Taken");
        debug1Color = colorsMap.get("Debug1");
        debug2Color = colorsMap.get("Debug2");
        smallButtonIcon = iconsMap.get("smallButton");
        smallButtonPushedIcon = iconsMap.get("smallButtonPushed");
        minusIcon = iconsMap.get("minus");
        minusPushedIcon = iconsMap.get("minusPushed");
        plusIcon = iconsMap.get("plus");
        plusPushedIcon = iconsMap.get("plusPushed");
        skillsAmount = 18;
        this.skillsNames = skillsNames;
        width = 340;
        height = 15 * skillsAmount;
        xOffset = 365;
        yOffset = 28;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        tagPanel = new JPanel();
        tagPanel.setPreferredSize(new Dimension(20, height));
        tagPanel.setLayout(null);
        tagPanel.setBackground(debug? debug1Color:transparentColor);
        add(tagPanel);

        paddingPanel0 = new JPanel();
        paddingPanel0.setPreferredSize(new Dimension(10, height));
        paddingPanel0.setBackground(debug? debug2Color:transparentColor);
        add(paddingPanel0);

        labelsPanel = new JPanel();
        labelsPanel.setOpaque(false);
        labelsPanel.setPreferredSize(new Dimension(100, height));
        labelsPanel.setLayout( new GridLayout(skillsAmount,1));
        labelsPanel.setBackground(debug? debug1Color:transparentColor);
        add(labelsPanel);

        valuesPanel = new JPanel();
        valuesPanel.setOpaque(false);
        valuesPanel.setPreferredSize(new Dimension(25, height));
        valuesPanel.setOpaque(false);
        valuesPanel.setLayout( new GridLayout(skillsAmount,1));
        valuesPanel.setBackground(debug? debug2Color:transparentColor);
        add(valuesPanel);

        skillPointsPanel = new JPanel();
        skillPointsPanel.setOpaque(false);
        skillPointsPanel.setPreferredSize(new Dimension(50, height));
        skillPointsPanel.setOpaque(false);
        skillPointsPanel.setLayout( new GridLayout(skillsAmount,1));
        skillPointsPanel.setBackground(debug? debug1Color:transparentColor);
        add(skillPointsPanel);

        booksPanel = new JPanel();
        booksPanel.setOpaque(false);
        booksPanel.setPreferredSize(new Dimension(25, height));
        booksPanel.setOpaque(false);
        booksPanel.setLayout( new GridLayout(skillsAmount,1));
        booksPanel.setBackground(debug? debug2Color:transparentColor);
        add(booksPanel);

        paddingPanel1 = new JPanel();
        paddingPanel1.setPreferredSize(new Dimension(25, height));
        paddingPanel1.setBackground(debug? debug1Color:transparentColor);
        add(paddingPanel1);

        minusPanel = new JPanel();
        minusPanel.setPreferredSize(new Dimension(20, height));
        minusPanel.setLayout(null);
        minusPanel.setBackground(debug? debug2Color:transparentColor);
        add(minusPanel);

        plusPanel = new JPanel();
        plusPanel.setPreferredSize(new Dimension(20, height));
        plusPanel.setLayout(null);
        plusPanel.setBackground(debug? debug1Color:transparentColor);
        add(plusPanel);

        paddingPanel2 = new JPanel();
        paddingPanel2.setPreferredSize(new Dimension(22, height));
        paddingPanel2.setBackground(debug? debug2Color:transparentColor);
        add(paddingPanel2);

        booksButtonsPanel = new JPanel();
        booksButtonsPanel.setPreferredSize(new Dimension(20, height));
        booksButtonsPanel.setLayout(null);
        booksButtonsPanel.setBackground(debug? debug1Color:transparentColor);
        add(booksButtonsPanel);

        skillsLabels = new ArrayList<JLabel>();
        valuesLabels = new ArrayList<JLabel>();
        skillPointsLabels = new ArrayList<JLabel>();
        booksAmountLabels = new ArrayList<JLabel>();
        tagButtons = new ArrayList<JButton>();
        minusSkillButtons = new ArrayList<JButton>();
        plusSkillButtons = new ArrayList<JButton>();
        plusBooksButtons = new ArrayList<JButton>();

        for(int i = 0; i < skillsAmount; i++){
            String skillName = skillsNames.get(i);
            JButton tag = new JButton(smallButtonIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            tag.setPressedIcon(smallButtonPushedIcon);
            tag.setToolTipText("Tag " + skillName + " skill");
            tag.setBorder(null);
            tag.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.setTagSkillButtonOnClick(skillName);
                }
            });
            tag.setBounds(1, 3 + i * 15,16, 10);
            tagButtons.add(tag);
            tagPanel.add(tag);

            JLabel label = new JLabel(skillName);
            label.setForeground(greenColor);
            label.setFont(font);
            skillsLabels.add(label);
            labelsPanel.add(label);

            JLabel value = new JLabel("300");
            value.setForeground(greenColor);
            value.setFont(font);
            valuesLabels.add(value);
            valuesPanel.add(value);

            JLabel skillPoints = new JLabel("(+9999)");
            skillPoints.setForeground(greenColor);
            skillPoints.setFont(font);
            skillPointsLabels.add(skillPoints);
            skillPointsPanel.add(skillPoints);

            JButton minus = new JButton(minusIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            minus.setPressedIcon(minusPushedIcon);
            minus.setToolTipText("-" + skillName + " skill point");
            minus.setBorder(null);
            minus.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.minusSkillPointButtonOnClick(skillName);
                }
            });
            minus.setBounds(2, 1 + i * 15,16, 12);
            minusSkillButtons.add(minus);
            minusPanel.add(minus);

            JButton plus = new JButton(plusIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            plus.setToolTipText("+" + skillName + " skill point");
            plus.setBorder(null);
            plus.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.plusSkillPointButtonOnClick(skillName);
                }
            });
            plus.setPressedIcon(plusPushedIcon);
            plus.setBounds(2, 1 + i * 15,16, 12);
            plusSkillButtons.add(plus);
            plusPanel.add(plus);

            JLabel booksAmount = new JLabel("[10]");
            booksAmount.setForeground(greenColor);
            booksAmount.setFont(font);
            booksAmountLabels.add(booksAmount);
            booksPanel.add(booksAmount);

            JButton plusBook = new JButton(plusIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            plusBook.setPressedIcon(plusPushedIcon);
            plusBook.setToolTipText("Read " + skillName + " book");
            plusBook.setBorder(null);
            plusBook.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.readBookButtonOnClick(skillName);
                }
            });
            plusBook.setBounds(2, 1 + i * 15,16, 12);
            plusBooksButtons.add(plusBook);
            booksButtonsPanel.add(plusBook);
        }

        /*Scavenging and Gambling*/
        tagButtons.get(4).setVisible(false);
        plusSkillButtons.get(4).setVisible(false);
        minusSkillButtons.get(4).setVisible(false);
        plusBooksButtons.get(4).setVisible(false);
        plusBooksButtons.get(16).setVisible(false);
        booksAmountLabels.get(4).setVisible(false);
        booksAmountLabels.get(16).setVisible(false);

        setVisible(true);
    }

    public void showSkillsValues(List<Integer> values, List<Integer> skillPoints, List<Integer> books) {
        for(int i = 0; i < skillsNames.size(); i++){
            valuesLabels.get(i).setText(values.get(i).toString());
            skillPointsLabels.get(i).setText("(+" + skillPoints.get(i) + ")");
            booksAmountLabels.get(i).setText("[" + books.get(i) + "]");
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public int getSkillIndex(String skillName){
        int index = -1;
        for(int i = 0; i < skillsNames.size(); i++){
            if(skillsNames.get(i).equals(skillName)){
                return i;
            }
        }

        return index;
    }

    public void setColors(List<String> taggedSkills) {
        for(int i = 0; i < skillsNames.size(); i++){
            skillsLabels.get(i).setForeground(greenColor);
            valuesLabels.get(i).setForeground(greenColor);
            skillPointsLabels.get(i).setForeground(greenColor);
            booksAmountLabels.get(i).setForeground(greenColor);
        }

        for(int i = 0; i < taggedSkills.size(); i++){
            int index = getSkillIndex(taggedSkills.get(i));
            if(index != -1){
                skillsLabels.get(index).setForeground(takenColor);
                valuesLabels.get(index).setForeground(takenColor);
                skillPointsLabels.get(index).setForeground(takenColor);
                booksAmountLabels.get(index).setForeground(takenColor);
            }
        }
    }
}
