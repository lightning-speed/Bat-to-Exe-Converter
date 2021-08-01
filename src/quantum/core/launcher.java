package quantum.core;

import quantum.ui.Window;

import javax.swing.*;

public class launcher {
    public static Window window;
    public void launch(){
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        window = new Window();
        window.setVisible(true);
    }
}
