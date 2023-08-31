import javax.swing.*; // pour tout les JFrameJbutton ect
import java.awt.*; // import java.awt.Toolkit;
import java.io.*;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/* PANEAUX DES TEXTURES en 16x
	GRASS BASIC 1 : (ligne 30) (colonne 03) = id 3003
*/

public  class MapObject extends Gameobject {
	private String TEXTURES_PATH = "data/uses/texture/all16.png";
	private int O_texture_size = 16;

	protected int id;

	public MapObject(int id_t, int layer_t, int posX_t, int posY_t) {
		this.id = id_t;
		int col = (id % 100) - 1; // Ligne de la texture que vous voulez extraire
            int row = ((id - col) / 100) - 1; // Colonne de la texture que vous voulez extraire
		try {
			BufferedImage spritesheet = ImageIO.read(new File(TEXTURES_PATH));

			BufferedImage texture = spritesheet.getSubimage(
                  	col * O_texture_size, row * O_texture_size,
                  	O_texture_size, O_texture_size
            	);

			Image imageTexture = texture;
			int	sizeNeed = env.getMapSize();
			Image reziseImage = imageTexture.getScaledInstance(sizeNeed, sizeNeed, Image.SCALE_SMOOTH);
			// super(reziseImage, layer_t);
			width = reziseImage.getWidth(null);
			height = reziseImage.getHeight(null);
			posX = posX_t;
			posY = posY_t;
			image = reziseImage;
			layer = layer_t;
			ImageIcon icon = new ImageIcon(image);
			jlabel = new JLabel(icon);
		} catch (IOException e) {
            	e.printStackTrace();
        	}
	}
}