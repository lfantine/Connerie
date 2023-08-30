import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.sound.sampled.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import java.io.File;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLayeredPane;
import java.util.ArrayList;
import java.awt.Font;

public class main {

    private static boolean isPlaying = false;
    private static Clip clip = null;
    private static int size = 2;
    private static int[] listW  = {720, 1280, 1920};
    private static int[] listH  = {480, 720, 1080};
    private static int width;
    private static int height;
    

	public static Clip sound(String cheminSon, boolean repeat ) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(cheminSon).getAbsoluteFile());
            Clip temp = AudioSystem.getClip();
            temp.open(audioInputStream);
            if (repeat)
            {
                temp.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Redémarrez la lecture quand elle est terminée
                        temp.setFramePosition(0); // Remet le curseur au début
                        temp.start();
                    }
                }
            });
            }
            temp.start();
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void open() {
        // Créer une instance de JFrame (la fenêtre)
        JFrame fenetre = new JFrame("Narty game launcher");

        // Utilisation d'un JLayeredPane pour superposer les composants
        JLayeredPane layeredPane = new JLayeredPane();
        fenetre.setContentPane(layeredPane);

        // Définir la taille de la fenêtre
        fenetre.setSize(width, height);
        // fenetre.pack(); pour que la taille de la fenetre s'adapte a son contenu

	    // Empêcher la redimensionnement de la fenêtre
        fenetre.setResizable(false);

        // Définir l'icône de la fenêtre
        Image icone = Toolkit.getDefaultToolkit().getImage("icone.jpg");
        fenetre.setIconImage(icone);

        // Créer un objet Font avec une taille personnalisée
        Font customFont = new Font("Arial", Font.PLAIN, 20);

	    // Créer un composant ImageIcon (une image)
        ImageIcon imageIcon = new ImageIcon("./image.png");
        Image image = imageIcon.getImage();
        Image reziseImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon ReziseImageIcon = new ImageIcon(reziseImage);

        // Créer un composant JLabel (un label pour l'image)
        JLabel imageLabel = new JLabel(ReziseImageIcon);
        imageLabel.setBounds(0, 0, width, height); // Ajustez les dimensions selon l'image

        // Ajouter le label à la fenêtre
        fenetre.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        
        // Creer un bouton
        JButton play = new JButton("PLAY");
        play.setBounds(width - 150, 10, 100, 30); // Ajustez les dimensions et la position
        play.setFont(customFont);
        fenetre.add(play, JLayeredPane.PALETTE_LAYER);

	    // Obtenir la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();

        // Attacher une action au bouton
        play.addActionListener(e -> {
            if (isPlaying) {
                if (clip != null && clip.isRunning()) {
                    clip.setFramePosition(0);
                    clip.stop(); // Arrête le Clip en cours de lecture
                }
                System.out.println("passage Off");
                play.setText("PLAY");
                isPlaying = false;
            } else {
                // Charger et jouer le son uniquement lorsque le bouton PLAY est cliqué
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./song.wav").getAbsoluteFile());
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                    System.out.println("passage On");
                    play.setText("Stop");
                    isPlaying = true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Creer un bouton pour le jeu
        JButton game = new JButton("GAME");
        game.setBounds(10, height - 75, width - 40, 30); // Ajustez les dimensions et la position
        game.setFont(customFont);
        fenetre.add(game, JLayeredPane.PALETTE_LAYER);

        // Calculer les positions pour centrer la fenêtre
        int posX = (tailleEcran.width - fenetre.getWidth()) / 2;
        int posY = (tailleEcran.height - fenetre.getHeight()) / 2;

        // Définir la position de la fenêtre au centre de l'écran
        fenetre.setLocation(posX, posY);

        // Spécifier comment la fenêtre doit se comporter lors de la fermeture
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }


    public static void main(String[] argv) {
        
        System.out.println("Starting : \n\nsize : " + size);
        width = listW[size];
        height = listH[size];
        System.out.println("\nwidth : " + width + " heigth : " + height + "\n");

		open();
    }
}
