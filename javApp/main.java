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

public class main {

	public static void sound(String cheminSon, boolean repeat ) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(cheminSon).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            if (repeat)
            {
                clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        // Redémarrez la lecture quand elle est terminée
                        clip.setFramePosition(0); // Remet le curseur au début
                        clip.start();
                    }
                }
            });
            }
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void open() {
        // Créer une instance de JFrame (la fenêtre)
        JFrame fenetre = new JFrame("Narty game launcher");

        // Définir l'icône de la fenêtre
        Image icone = Toolkit.getDefaultToolkit().getImage("icone.jpg");
        fenetre.setIconImage(icone);

	  // Créer un composant ImageIcon (une image)
        ImageIcon image = new ImageIcon("./image.png");

        // Créer un composant JLabel (un label)
        JLabel imageLabel = new JLabel(image);

        // Ajouter le label à la fenêtre
        fenetre.add(imageLabel);

        // Définir la taille de la fenêtre
        fenetre.setSize(800, 400);

	    // Empêcher la redimensionnement de la fenêtre
        fenetre.setResizable(false);
        // fenetre.pack(); pour que la taille de la fenetre s'adapte a son contenu

        // Creer un bouton
        JButton bouton = new JButton("Cliquez ici !");
        fenetre.add(bouton, BorderLayout.SOUTH);

	    // Obtenir la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();

        // Attacher une action au bouton
        bouton.addActionListener(e -> {
            //jouer le son
	        sound("./song2.wav", true);
        });

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
        for (int i = 0; i < argv.length; i++) {
            System.out.println(argv[i]);
        }
        
		open();
    }
}
