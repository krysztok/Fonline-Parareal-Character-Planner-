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

public class DrugsPanel extends JPanel {
    private int width, height, xOffset, yOffset, drugsMax;
    private Font font;
    private JPanel leftPanel, rightPanel, leftButtonsPanel, rightButtonsPanel, paddingPanel0, paddingPanel1;
    private List<JLabel> drugsLabels;
    private List<JButton> buttons;
    private List<String> drugsNames;
    Color transparentColor, debug1Color, debug2Color, greenColor, takenColor, notAvailable;
    Icon smallButtonIcon, smallButtonPushedIcon;

    public DrugsPanel(Controller controller, Font font, List<String> drugsNames, Map<String, Icon> iconsMap, Map<String, Color> colorsMap, boolean debug) {
        transparentColor = colorsMap.get("Transparent");
        greenColor = colorsMap.get("Green");
        takenColor = colorsMap.get("Taken");
        notAvailable = colorsMap.get("NotAvailable");
        debug1Color = colorsMap.get("Debug1");
        debug2Color = colorsMap.get("Debug2");
        smallButtonIcon = iconsMap.get("smallButton");
        smallButtonPushedIcon = iconsMap.get("smallButtonPushed");
        setOpaque(false);
        this.font = font;
        drugsMax = 16;
        this.drugsNames = drugsNames;
        transparentColor = new Color(0,0,0,0);
        width = 314;
        height = 16 * drugsMax/2;
        xOffset = 20;
        yOffset = 538;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        drugsLabels = new ArrayList<JLabel>();
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
        leftPanel.setPreferredSize(new Dimension(127, height));
        leftPanel.setLayout( new GridLayout(drugsMax/2,1));
        leftPanel.setBackground(debug? debug1Color:transparentColor);
        add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setPreferredSize(new Dimension(127, height));
        rightPanel.setLayout( new GridLayout(drugsMax/2,1));
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

        for(int i = 0; i < drugsNames.size() /*&& drugsMax*/; i++){
            String drugName = drugsNames.get(i);
            JButton button = new JButton(smallButtonIcon){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            button.setPressedIcon(smallButtonPushedIcon);
            button.setToolTipText("Take " + drugName);
            button.setBorder(null);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.takeDrugButtonOnClick(drugName);
                }
            });
            int onLeftSide = drugsNames.size()%2==0? drugsNames.size()/2 : drugsNames.size()/2+1;
            int n = i < onLeftSide? i : i - onLeftSide;
            int x = i < onLeftSide? 3 : 2;
            button.setBounds(x, 3 + n * 16,16, 10);
            buttons.add(button);

            JLabel label = new JLabel(drugName){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomToolTip(this));
                }
            };
            label.setForeground(greenColor);
            label.setFont(font);
            drugsLabels.add(label);

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

    public JLabel getJLabelByDrugName(String name) {
        for(int i = 0; i < drugsNames.size(); i++){
            if(drugsNames.get(i).equals(name)){
                return drugsLabels.get(i);
            }
        }

        return null;
    }

    public void setColors(boolean isCreated, List<String> takenDrugs){
        Color color = isCreated? greenColor : notAvailable;
        drugsLabels.forEach((label) -> label.setForeground(color));

        for(int i = 0; i < takenDrugs.size(); i++){
            getJLabelByDrugName(takenDrugs.get(i)).setForeground(takenColor);
        }
    }

    public void refreshTips(Map<String, String> drugsTipsMap) {
        drugsTipsMap.forEach((name, tip) -> {
            getJLabelByDrugName(name).setToolTipText(tip);
        });
    }
}

