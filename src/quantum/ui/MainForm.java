package quantum.ui;

import quantum.core.Internal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JPanel {
    public static JLabel er = new JLabel("Welcome to bat to exe converter!");
    public QButton buildButton = new QButton("Build");
    public JLabel head = new JLabel("  BTE");
    public JPanel top = new JPanel();
    public JLabel batl = new JLabel("Batch file: ");
    public static JTextField bat = new JTextField();
    public JLabel outl = new JLabel("Output file: ");
    public static JTextField out = new JTextField();
    public JLabel iconl = new JLabel("  Icon file: ");
    public static JTextField icon = new JTextField();
    public Font smallFont = FontManger.getFont("fonts\\Roboto\\Roboto-Regular.ttf",13);
    public MainForm(){

    }
    public void draw(){
        buildButton.setBounds(10,195,70,27);
        add(buildButton);
      this.setLayout(null);
      top.setBounds(0,0,500,50);
      top.setLayout(null);
      top.setBackground(new Color(230,230,230));
      top.add(head);
      add(top);
      head.setBounds(0,0,400,50);
      head.setFont(FontManger.getFont("fonts\\Roboto\\Roboto-Regular.ttf",23));
      // Form
      // Bat
      batl.setBounds(10,70,65,27);
      batl.setFont(smallFont);
      add(batl);
      bat.setBounds(75,70,360,27);
      bat.setFont(smallFont);
      add(bat);
      outl.setBounds(10,110,65,27);
      outl.setFont(smallFont);
      add(outl);
      out.setBounds(75,110,360,27);
      out.setFont(smallFont);
      add(out);
      iconl.setBounds(10,150,65,27);
      iconl.setFont(smallFont);
      add(iconl);
      icon.setBounds(75,150,360,27);
      icon.setFont(smallFont);
      add(icon);
      er.setBounds(10,235,500,25);
      add(er);
      this.setBackground(new Color(250,250,255));
      buildButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              Internal.make(bat.getText(),out.getText(),icon.getText());
          }
      });
    }

}
