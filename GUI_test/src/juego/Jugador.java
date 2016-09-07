package juego;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Jugador extends Entidad{

	public Jugador(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right.png"));
	}
}
