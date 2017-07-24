package juego;

import javax.swing.ImageIcon;

public class Jugador extends Entidad{

	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image.put(Entidad.still_key, new ImageIcon(this.getClass().getResource("/sprites/still.png")));
		this.image.put(Entidad.forward_key, new ImageIcon(this.getClass().getResource("/sprites/step1.png")));
		this.image.put(Entidad.backward_key, new ImageIcon(this.getClass().getResource("/sprites/back1.png")));
		this.image.put(Entidad.jump_key, new ImageIcon(this.getClass().getResource("/sprites/jump.png")));
	}
}
