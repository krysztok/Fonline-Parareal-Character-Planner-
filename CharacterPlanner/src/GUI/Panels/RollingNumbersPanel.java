package GUI.Panels;


import javax.swing.*;
import java.awt.*;

import static java.lang.Math.abs;

public class RollingNumbersPanel extends JPanel {
    private ImageIcon[] numbers;
    private ImageIcon[] negativeNumbers;
    private JLabel numbersLabels[];
    private int width, height, xOffset, yOffset;
    private Color transparentColor;
    private int nNumbers;


    public RollingNumbersPanel(ImageIcon[] numbers, ImageIcon[] negativeNumbers, int nNumbers, int xOffset, int yOffset) {
        transparentColor = new Color(0,0,0,0);
        width = 14 * nNumbers;
        height = 24;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        setBounds(xOffset, yOffset, width, height);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setBackground(transparentColor);

        this.numbers = numbers;
        this.negativeNumbers = negativeNumbers;
        this.nNumbers = nNumbers;
        numbersLabels = new JLabel[nNumbers];

        for(int i = 0; i < nNumbers; i++){
            numbersLabels[i] = new JLabel(numbers[0]);
            add(numbersLabels[i]);
        }
    }

    public void setValue(int value) {
        boolean negative = value < 0? true : false;
        ImageIcon icons[] = negative? negativeNumbers : numbers;
        value = abs(value);

        for(int i = 1; i < nNumbers+1; i++){
            numbersLabels[nNumbers-i].setIcon(icons[value%10]);
            value /= 10;
        }
    }
}
