package quantum.core;

import quantum.ui.MainForm;
import quantum.util.FileManager;
import sun.applet.Main;

import java.awt.*;
import java.io.File;

public class Internal {
    public static void make(String bat,String out,String icon){
        if(!new File(bat).exists()){
            MainForm.er.setText("Batch File Does Not Exists!");
            MainForm.er.setForeground(Color.red);
            return;
        }
        if(!new File(new File(out).getParent()).exists()){
            MainForm.er.setText("Output Path Does Not Exists!");
            MainForm.er.setForeground(Color.red);
            return;
        }
        if(icon.length()>0&&!new File(icon).exists()){
            MainForm.er.setText("Either Remove the Icon file path or Write a correct Icon file path");
            MainForm.er.setForeground(Color.red);
            return;
        }
        MainForm.er.setForeground(Color.BLACK);
        MainForm.er.setText("Wrapping...");
        Runnable runnable =() -> {
            String fc = new FileManager().read(bat);
            new Wrapper().wrap(fc,out,icon);
            MainForm.er.setText("Done!");
        };
        new Thread(runnable).start();
    }
    public static void read(){
       MainForm.bat.setText(new FileManager().read("data\\last_bat.data"));
       MainForm.out.setText(new FileManager().read("data\\last_out.data"));
       MainForm.icon.setText(new FileManager().read("data\\last_icon.data"));
    }
    public static void write(){
        FileManager.write("data\\last_bat.data", MainForm.bat.getText());
        FileManager.write("data\\last_out.data", MainForm.out.getText());
        FileManager.write("data\\last_icon.data", MainForm.icon.getText());
    }
}
