package quantum.ui;

import quantum.core.Internal;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Window extends JFrame {
    public static MainForm form;
    public Window(){
        super("BTE");
        this.setIconImage(new ImageIcon("icons\\icon.png").getImage());
        this.setSize(500,305);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        form = new MainForm();
        this.setContentPane(form);
        form.draw();
        new Internal().read();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                  Internal.write();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                Internal.write();

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
