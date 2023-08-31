import environnement.Env;
import javax.swing.*; // pour tout les JFrameJbutton ect
import java.awt.*; // import java.awt.Toolkit;
import java.io.*;
import javax.sound.sampled.*;
import java.util.ArrayList;


public class Game {

	public static int state = 0;
	/*
		0 = lobby
		1 = level 1
		2 = level 2
		ect 
	*/
	public static boolean gameOn = false;
	public static long startTime = 0;

	// use for temp
	public static JLabel backtemp;
	public static Clip backSoundTemp = null;

	// MAP
	public static ArrayList<MapObject>	map = new ArrayList<MapObject>();


	public static void centerWindow(JFrame window) {
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		// Calculer les positions pour centrer la fenêtre
		int posX = (tailleEcran.width - window.getWidth()) / 2;
		int posY = (tailleEcran.height - window.getHeight()) / 2;

		// Définir la position de la fenêtre au centre de l'écran
		window.setLocation(posX, posY);
	}

	public static void applyBackground(JFrame window, String imgPath, boolean white) {
		if (white) {
			window.remove(backtemp);
			return ;
		}
		ImageIcon imageIcon = new ImageIcon(imgPath);
		Image image = imageIcon.getImage();
		int width = window.getWidth();
		int height = window.getHeight();
		Image reziseImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon ReziseImageIcon = new ImageIcon(reziseImage);
		JLabel imageLabel = new JLabel(ReziseImageIcon);
		imageLabel.setBounds(0, 0, width, height); // Ajustez les dimensions selon l'image
		backtemp = imageLabel;
		window.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
	}

	public static Clip playSound(String cheminSon, boolean repeat) {
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

	public static void playMusic(String cheminSon) {
		if (backSoundTemp != null)
			stopMusic();
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(cheminSon).getAbsoluteFile());
			backSoundTemp = AudioSystem.getClip();
			backSoundTemp.open(audioInputStream);
			FloatControl gainControl = (FloatControl) backSoundTemp.getControl(FloatControl.Type.MASTER_GAIN);
			// Réduire le volume (en dB)
			float volumeReductionInDecibels = -30.0f; // Par exemple, réduction de 10 dB
			gainControl.setValue(volumeReductionInDecibels);
			backSoundTemp.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						// Redémarrez la lecture quand elle est terminée
						backSoundTemp.setFramePosition(0); // Remet le curseur au début
						backSoundTemp.start();
					}
				}
			});
			backSoundTemp.start();
		} catch (Exception e) {
			System.out.println("Error starting music !");
			e.printStackTrace();
		}
	}

	public static void stopMusic() {
		if (backSoundTemp == null)
			return ;
		backSoundTemp.setFramePosition(0);
		backSoundTemp.stop();
		backSoundTemp = null;
	}

	public static int takeId(char c) {
		if (c == ' ')
			return -1;
		if (c == 'G')
			return 3003;
		if (c == 'g')
			return 3004;
		if (c == 'D')
			return 3103;
		if (c == 'd')
			return 3104;
		
		return 1001;
	}

	public static void makeMap(String mapPath, JFrame window, Env env) {
		int	winHeight = window.getHeight();
		int	winWidth = window.getWidth();
		int nbL = 0;
		int imgSize = env.getMapSize();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapPath));
			String line = br.readLine();
			while (line != null) {
				nbL++;
				line = br.readLine();
			}
			BufferedReader br2 = new BufferedReader(new FileReader(mapPath));
			String line2;
			int	actualheight = winHeight - (nbL * imgSize);
			System.out.println("actual " + actualheight + " tall");
			for (int i = 0; i < nbL; i++) {
				line2 = br2.readLine();
				int	actualWidth = 0;
				for (int j = 0; j < line2.length(); j++) {
					int id = takeId(line2.charAt(j));
					if (id != -1) {
						MapObject obj = new MapObject(id, 1, actualWidth, actualheight);
						obj.jlabel.setBounds(actualWidth, actualheight, imgSize, imgSize);
						window.add(obj.jlabel, JLayeredPane.PALETTE_LAYER);
						map.add(obj);
					}
					actualWidth += imgSize;
				}
				actualheight += imgSize;
			}
			return ;
		} catch (IOException e) {
			return ;
		}
	}

	public static void clearMap(JFrame window) {
		while (!map.isEmpty()) {
			window.remove(map.get(0));
			map.remove(0);
		}
	}
}