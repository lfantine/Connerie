package environnement;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.lang.*;

public class Env {
    public static final String SETUP_FILE = "data/settings/setup.txt";
    public static int[] listW  = {720, 1280, 1920};
    public static int[] listH  = {480, 720, 1080};

    public boolean setupOK() {
        try {
            File fichier = new File(SETUP_FILE);

            if (!fichier.exists()) {
                if (fichier.createNewFile()) {
                    System.out.println("Fichier de setup créé avec succès.");
                    try {
                        FileWriter fw = new FileWriter(SETUP_FILE);
                        fw.write("size = 0\nfps  = 60");
                        fw.close();
                        System.out.println("Contenu écrit avec succès.");
                    } catch (IOException e) {
                        System.out.println("Impossible d'ecrire dans le fichier.");
                    }
                } else {
                    System.out.println("Impossible de créer le fichier de setup.");
                }
            } else {
                System.out.println("Le fichier de setup existe.");
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String getFileLine(int line_nb, String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            for (int i = 1; i < line_nb; i++) {
                line = br.readLine();
            }
            return line;
        } catch (IOException e) {
            return "";
        }
    }

    public int getEnvSize() {
        String line = getFileLine(1, SETUP_FILE);
        int res = line.charAt(7) - '0';
        return res;
    }

    public int getEnvFps() {
        String line = getFileLine(2, SETUP_FILE);
        String res_s = "";
        for (int i = 7; i < line.length(); i++) {
            res_s += line.charAt(i);
        }
        int res = Integer.parseInt(res_s);
        return res;
    }

    public int getMapSize() {
        String line = getFileLine(3, SETUP_FILE);
        String res_s = "";
        for (int i = 10; i < line.length(); i++) {
            res_s += line.charAt(i);
        }
        int res = Integer.parseInt(res_s);
        return res;
    }
}
