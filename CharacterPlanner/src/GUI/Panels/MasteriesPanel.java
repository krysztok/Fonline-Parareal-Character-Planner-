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


public class MasteriesPanel extends JPanel {
    private int width, height, xOffset, yOffset, masteriesMax;
    private Font font;
    Color transparentColor, debug1Color, debug2Color, greenColor, takenColor, notAvailable;
    private JPanel leftPanel, rightPanel, leftButtonsPanel, rightButtonsPanel, paddingPanel0, paddingPanel1;
    private List<JLabel> masteriesLabels;
    private List<JButton> buttons;
    private List<String> masteriesNames;
    Icon smallButtonIcon, smallButtonPushedIcon;

    public MasteriesPanel(Controller controller, Font font, List<String> masteriesNames, Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug){
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
        masteriesMax = 10;
        this.masteriesNames = masteriesNames;
        width = 368;
        height = 16 * masteriesMax/2;
        xOffset = 739;
        yOffset = 27;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        masteriesLabels = new ArrayList<JLabel>();
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
        leftPanel.setLayout(new GridLayout(masteriesMax/2,1));
        leftPanel.setBackground(debug? debug1Color:transparentColor);
        add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(154, height));
        rightPanel.setLayout(new GridLayout(masteriesMax/2,1));
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

        for(int i = 0; i < masteriesNames.size() /*&& masteriesMax*/; i++){
            String masteryName = masteriesNames.get(i);
            JButton button = new JButton(smallButtonIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            button.setPressedIcon(smallButtonPushedIcon);
            button.setToolTipText("Take " + masteryName + " mastery");
            button.setBorder(null);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.takeMasteryButtonOnClick(masteryName);
                }
            });
            int onLeftSide = masteriesNames.size()%2==0? masteriesNames.size()/2 : masteriesNames.size()/2+1;
            int n = i < onLeftSide? i : i - onLeftSide;
            int x = i < onLeftSide? 3 : 2;
            button.setBounds(x, 3 + n * 16,16, 10);
            buttons.add(button);

            JLabel label = new JLabel(masteryName){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            label.setForeground(greenColor);
            label.setFont(font);
            masteriesLabels.add(label);

            if(i < onLeftSide){
                leftButtonsPanel.add(button);
                leftPanel.add(label);
            } else {
                rightPanel.add(label);
                rightButtonsPanel.add(button);
            }
        }

        setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public JLabel getJLabelByPerkName(String name) {
        for(int i = 0; i < masteriesNames.size(); i++){
            if(masteriesNames.get(i).equals(name)){
                return masteriesLabels.get(i);
            }
        }

        return null;
    }

    public void setColors(List<String> takenMasteries, List<String> availableMasteries, List<String> unavailableMasteries){
        for(int i = 0; i < takenMasteries.size(); i++){
            getJLabelByPerkName(takenMasteries.get(i)).setForeground(takenColor);
        }

        for(int i = 0; i < availableMasteries.size(); i++){
            getJLabelByPerkName(availableMasteries.get(i)).setForeground(greenColor);
        }

        for(int i = 0; i < unavailableMasteries.size(); i++){
            getJLabelByPerkName(unavailableMasteries.get(i)).setForeground(notAvailable);
        }
    }

    public void refreshTips(Map<String, String> masteriesTipsMap) {
        masteriesTipsMap.forEach((name, tip) -> {
            getJLabelByPerkName(name).setToolTipText(tip);
        });
    }
}
