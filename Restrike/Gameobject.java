import environnement.Env;
import javax.swing.*; // pour tout les JFrameJbutton ect
import java.awt.*; // import java.awt.Toolkit;
import java.io.*;
import javax.sound.sampled.*;

public abstract class Gameobject {
	protected int	width;
	protected int	height;
	public int		posX;
	public int		posY;
	protected int	layer;
	protected Image	image;
	public JLabel	jlabel;
	protected Env 	env = new Env();

}