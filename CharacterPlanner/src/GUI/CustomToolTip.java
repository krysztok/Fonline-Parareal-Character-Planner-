package GUI;

import javax.swing.*;
import java.awt.*;

public class CustomToolTip extends JToolTip {

    public CustomToolTip(JComponent component){
        super();
        setComponent(component);
        setBackground(Color.black);
        setForeground(Color.GREEN);
    }
}
