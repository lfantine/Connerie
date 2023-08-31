import environnement.Env;
import javax.swing.*;
import java.awt.*; // import java.awt.Toolkit;.Color;

public class main {

    // SETTINGS
    private static int size = 0;
    private static int fps = 60;
    private static int width;
    private static int height;
    private static Env env = new Env();

    // GAME value
    private static Game game = new Game();
    private static long nowTime = 0;

    // Window
    private static JFrame window;

    // GAME objects

    public static void main(String[] argv) {
        // FileWriter fw = new FileWriter("data/settings/setup.txt");  ecrire
        // File fichier = new File(env.SETUP_FILE);


        System.out.println("Starting !");
        if (!env.setupOK()) {
            System.out.println("error while launching program");
        }
        size = env.getEnvSize();
        fps = env.getEnvFps();
        System.out.println("program fps are : " + fps);
        width = env.listW[size];
        height = env.listH[size];
        System.out.println("\nwidth : " + width + " heigth : " + height + "\n");

        Game();
    }

    public static boolean okGame() {
        if (!game.gameOn) {
            if (window.isVisible())
                window.dispose();
            return false;
        }
        if (!window.isVisible())
            return false;
        System.out.print("game is : ok \r");
        return true;
    }

    public static void gameInitialisation() {

        // game var
        game.gameOn = true;
        game.startTime = System.currentTimeMillis();
        game.state = 0;

        // window init
        window = new JFrame("Restrike");
        window.setResizable(false);
        window.setSize(400, 400);
        JLayeredPane layeredPane = new JLayeredPane();
        window.setContentPane(layeredPane);
        game.centerWindow(window);
        game.applyBackground(window, "data/uses/hagrid.jpg", false);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);

        // Loading 3 secondes
        long timestart = System.currentTimeMillis();
        long timenow = System.currentTimeMillis();
        boolean ok = true;

        while(ok) {
            if (timestart - nowTime <= -1000) {
                ok = false;
            }
            else {
                nowTime = System.currentTimeMillis();
                System.out.print("time is : " + -(timestart - nowTime) + "\r");
            }
        }
        System.out.println("");

        game.playMusic("data/uses/home.wav");
        window.setSize(width, height);
        game.applyBackground(window, "", true); // avec true pour retirer back actuelle
        game.applyBackground(window, "data/uses/sky1.png", false);
        game.centerWindow(window);

        game.makeMap(env.HOME_FILE, window, env);

        timestart = System.currentTimeMillis();
        timenow = System.currentTimeMillis();
        ok = true;

        while(ok) {
            if (timestart - nowTime <= -1000) {
                ok = false;
            }
            else {
                nowTime = System.currentTimeMillis();
                System.out.print("time is : " + -(timestart - nowTime) + "\r");
            }
        }
        System.out.println("");

        game.clearMap(window);

        timestart = System.currentTimeMillis();
        timenow = System.currentTimeMillis();
        ok = true;

        while(ok) {
            if (timestart - nowTime <= -500) {
                ok = false;
            }
            else {
                nowTime = System.currentTimeMillis();
                System.out.print("time is : " + -(timestart - nowTime) + "\r");
            }
        }
        System.out.println("");

        return ;
    }

    public static void Game() {

        gameInitialisation();
        System.out.println("GAME");

        while(okGame()) {

        }

        gameClosing();
    }

    public static void gameClosing() {

        // game var
        game.state = 0;
        game.stopMusic();

        // bye bye
        System.out.println("\nProgram end !");
        return ;
    }
}
