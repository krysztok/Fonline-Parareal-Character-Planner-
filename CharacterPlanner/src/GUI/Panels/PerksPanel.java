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

public class PerksPanel extends JPanel {
    private int width, height, xOffset, yOffset, perksMax;
    private Font font;
    Color transparentColor, debug1Color, debug2Color, greenColor, takenColor, notAvailable;
    private JPanel leftPanel, rightPanel, leftButtonsPanel, rightButtonsPanel, paddingPanel0, paddingPanel1;
    private List<JLabel> perksLabels;
    private List<JButton> buttons;
    private List<String> perksNames;
    Icon smallButtonIcon, smallButtonPushedIcon;

    public PerksPanel(Controller controller, Font font, List<String> perksNames, Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug){
        this.font = font;
        setOpaque(false);
        transparentColor = colorsMap.get("Transparent");
        greenColor = colorsMap.get("Green");
        takenColor = colorsMap.get("Taken");
        notAvailable = colorsMap.get("NotAvailable");
        debug1Color = colorsMap.get("Debug1");
        debug2Color = colorsMap.get("Debug2");
        smallButtonIcon = iconsMap.get("smallButton");
        smallButtonPushedIcon = iconsMap.get("smallButtonPushed");
        width = 368;
        height = 400;
        xOffset = 355;
        yOffset = 362;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        perksMax = 50;
        this.perksNames = perksNames;
        perksLabels = new ArrayList<JLabel>();
        buttons = new ArrayList<JButton>();

        leftButtonsPanel = new JPanel();
        leftButtonsPanel.setPreferredSize(new Dimension(20, height));
        leftButtonsPanel.setLayout(null);
        leftButtonsPanel.setBackground(debug? debug1Color:transparentColor);
        add(leftButtonsPanel);

        paddingPanel0 = new JPanel();
        paddingPanel0.setPreferredSize(new Dimension(10, height));
        paddingPanel0.setBackground(debug? debug2Color:transparentColor);
        add(paddingPanel0);

        leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(154, height));
        leftPanel.setLayout( new GridLayout(perksMax/2,1));
        leftPanel.setBackground(debug? debug1Color:transparentColor);
        add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(154, height));
        rightPanel.setLayout( new GridLayout(perksMax/2,1));
        rightPanel.setBackground(debug? debug2Color:transparentColor);
        add(rightPanel);

        paddingPanel1 = new JPanel();
        paddingPanel1.setPreferredSize(new Dimension(10, height));
        paddingPanel1.setBackground(debug? debug1Color:transparentColor);
        add(paddingPanel1);

        rightButtonsPanel = new JPanel();
        rightButtonsPanel.setPreferredSize(new Dimension(20, height));
        rightButtonsPanel.setLayout(null);
        rightButtonsPanel.setBackground(debug? debug2Color:transparentColor);
        add(rightButtonsPanel);

        for(int i = 0; i < perksNames.size() /*&& max amount*/; i++){
            String perkName = perksNames.get(i);
            JButton button = new JButton(smallButtonIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            button.setPressedIcon(smallButtonPushedIcon);
            button.setToolTipText("Take " + perkName + " perk");
            button.setBorder(null);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.takePerkButtonOnClick(perkName);
                }
            });
            int onLeftSide = perksNames.size()%2==0? perksNames.size()/2 : perksNames.size()/2+1;
            int n = i < onLeftSide? i : i - onLeftSide;
            int x = i < onLeftSide? 3 : 2;
            button.setBounds(x, 3 + n * 16,16, 10);
            buttons.add(button);

            JLabel label = new JLabel(perkName){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            label.setForeground(greenColor);
            label.setFont(font);
            perksLabels.add(label);

            if(i < onLeftSide){
                leftButtonsPanel.add(button);
                leftPanel.add(label);
            } else {
                rightButtonsPanel.add(button);
                rightPanel.add(label);
            }

        }

        setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public JLabel getJLabelByPerkName(String name) {
        for(int i = 0; i < perksNames.size(); i++){
            if(perksNames.get(i).equals(name)){
                return perksLabels.get(i);
            }
        }

        return null;
    }

    public void setColors(List<String> takenPerks, List<String> availablePerks, List<String> unavailablePerks){
        for(int i = 0; i < takenPerks.size(); i++){
            getJLabelByPerkName(takenPerks.get(i)).setForeground(takenColor);
        }

        for(int i = 0; i < availablePerks.size(); i++){
            getJLabelByPerkName(availablePerks.get(i)).setForeground(greenColor);
        }

        for(int i = 0; i < unavailablePerks.size(); i++){
            getJLabelByPerkName(unavailablePerks.get(i)).setForeground(notAvailable);
        }
    }

    public void refreshTips(Map<String, String> perksTipsMap) {
        perksTipsMap.forEach((name, tip) -> {
            getJLabelByPerkName(name).setToolTipText(tip);
        });
    }
}
