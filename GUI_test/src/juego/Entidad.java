package juego;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class Entidad {
	
	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 32;
	protected final int height = 32;
	
	protected int velocidad;
	
	protected Point pos;
	
	protected Entidad(int velocidad, int x, int y) {
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
		
		this.image = new Icon[4];
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	protected void mover(int dir){
		if(this.grafico != null){
			this.grafico.setIcon(this.image[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}

}
