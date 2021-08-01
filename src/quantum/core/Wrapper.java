package quantum.core;

import quantum.util.FileManager;

import java.io.*;

public class Wrapper {
    String a="";
    String OUTPUT_PATH;
    String ICON_PATH;
    public void wrap(String text,String OP,String ico)  {
        new File("win32\\icon.ico").delete();
        new File("win32\\icon.o").delete();
        if(new File(ico).exists()&&new File(ico).isFile())
        copyFile(new File(ico),new File("win32\\icon.ico"));
        if(new File(ico).exists()&&new File(ico).isFile())
        createIcon();
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.OUTPUT_PATH = OP;
        this.ICON_PATH = ico;
        a+='"';
        String in = text.replace(a,"'");
        String finalText = pack(in);
        System.out.println(finalText);
        FileManager.write("win32\\run.c",finalText);
        compile();
    }
    public String pack(String in){
        String all = "char ip[10000] = ";
        all+='"';
        all+=in;
        all+='"';
        all+=';';
        all = all.replace("\\","\\\\");
        all = all.replace("\n","&");
        return  all;
    }
    public void compile(){
        try {
            if(new File(ICON_PATH).exists()&&new File(ICON_PATH).isFile())
             Runtime.getRuntime().exec("win32\\tcc\\tcc.exe win32\\run.c win32\\main.o win32\\icon.o -o "+a+OUTPUT_PATH+a);
            else
                Runtime.getRuntime().exec("win32\\tcc\\tcc.exe win32\\run.c win32\\main.o  -o "+a+OUTPUT_PATH+a);
            Thread.sleep(1400);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new File("win32\\icon.ico").delete();
        new File("win32\\icon.o").delete();
    }
    void createIcon(){
        try {
            Runtime.getRuntime().exec("win32\\windres.exe win32\\icon.rc -O coff -o win32\\icon.o");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void copyFile(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
