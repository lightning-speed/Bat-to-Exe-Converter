package quantum.ui;

import javax.swing.*;
import java.awt.*;

public class QButton extends JButton {
    public QButton(String name){
        super(name);
        this.setBorder(BorderFactory.createLineBorder(new Color(50,150,255),0,false));
        this.setBackground(new Color(220,220,220));
    }
}
