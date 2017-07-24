package juego;

import javax.swing.ImageIcon;

public class Malo extends Entidad{
	
	public Malo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image.put(Entidad.still_key, new ImageIcon(this.getClass().getResource("/sprites/goomba1.png")));
		this.image.put(Entidad.forward_key, new ImageIcon(this.getClass().getResource("/sprites/goomba1.png")));
		this.image.put(Entidad.backward_key, new ImageIcon(this.getClass().getResource("/sprites/goomba1.png")));
	}
	public void mover(String dir){
		if(!dir.equals(Entidad.jump_key)){
			super.mover(dir);
		}
	}
}
