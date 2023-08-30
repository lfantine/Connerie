import environnement.Env;
import javax.swing.*; // pour tout les JFrameJbutton ect
import java.awt.*; // import java.awt.Toolkit;
import java.io.*;
import javax.sound.sampled.*;

public abstract class Gameobject {
	protected int	width;
	protected int	height;
	protected int	layer;
	protected Image	image;
	public JLabel	jlabel;
	protected Env 	env = new Env();


	// public	Gameobject(Image image_t, int layer_t) {
		
	// }
}