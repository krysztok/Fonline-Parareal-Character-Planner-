package GUI.Panels;

import GUI.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StatsPanel extends JPanel {

    private JPanel labelsPanel, valuesPanel;
    private int width, height, xOffset, yOffset, statsAmount;
    private List<JLabel> statsLabels;
    private List<JLabel> statsValues;
    private List<String> statsNames;
    Font font;
    Color transparentColor, debug1Color, debug2Color, greenColor;

    public StatsPanel(Controller controller, Font font, List<String> statsNames, Map<String, Color> colorsMap, boolean debug){
        this.font = font;
        setOpaque(false);
        transparentColor = colorsMap.get("Transparent");
        greenColor = colorsMap.get("Green");
        debug1Color = colorsMap.get("Debug1");
        debug2Color = colorsMap.get("Debug2");
        width = 150;
        height = 308;
        xOffset = 189;
        yOffset = 15;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        statsLabels = new ArrayList<JLabel>();
        statsValues = new ArrayList<JLabel>();
        statsAmount = 22;
        this.statsNames = statsNames;

        labelsPanel = new JPanel();
        labelsPanel.setPreferredSize(new Dimension(110, height));
        labelsPanel.setLayout( new GridLayout(statsAmount,1));
        labelsPanel.setBackground(debug? debug1Color:transparentColor);
        add(labelsPanel);

        valuesPanel = new JPanel();
        valuesPanel.setPreferredSize(new Dimension(40, height));
        valuesPanel.setLayout( new GridLayout(statsAmount,1));
        valuesPanel.setOpaque(false);
        valuesPanel.setBackground(debug? debug2Color:transparentColor);
        add(valuesPanel);

        for(int i = 0; i < statsAmount; i++){
            JLabel label = new JLabel(this.statsNames.get(i));
            label.setForeground(greenColor);
            label.setFont(font);
            statsLabels.add(label);
            labelsPanel.add(label);

            JLabel value = new JLabel("text");
            //value.setBounds(0, i *14, 40, 14);
            value.setForeground(greenColor);
            value.setFont(font);
            statsValues.add(value);
            valuesPanel.add(value);
        }

        setVisible(true);
    }

    public void showStatsValues(List<String> values) {
        for(int i = 0; i < statsNames.size(); i++){
            statsValues.get(i).setText(values.get(i));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
