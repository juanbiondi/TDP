package juego;

import java.awt.Point;

public abstract class Entidad extends GameObject{		
	protected int jump_strenght = 10;
	protected int velocidad;
	
	protected Entidad(int velocidad, int x, int y) {
		super(x,y);
		this.velocidad = velocidad;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	protected void cambiarGrafico(String dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.image.get(dir));
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	public void mover(String dir){	
		switch (dir) {
			case jump_key : //Jump
				pos.setLocation(pos.x, pos.y - jump_strenght);
				break;
			case forward_key : //Avanzar
				pos.setLocation(pos.x + velocidad, pos.y);
				break;
			case backward_key : //Retroceder
				pos.setLocation(pos.x - velocidad, pos.y);
				break;
			default : //Cualquier otra cosa - Quieto
				dir = still_key;
				break;
		}
		this.last_dir = dir;
		cambiarGrafico(dir);
	}
	
	public void fall(int gravity){
		pos.setLocation(pos.x, pos.y + gravity);
		this.cambiarGrafico(this.last_dir);
	}
}
