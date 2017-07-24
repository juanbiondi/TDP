package juego;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class GameObject {
	public static final String jump_key = "Jump";
	public static final String forward_key = "Froward";
	public static  final String backward_key = "Backward";
	public static  final String still_key = "Still";
	
	protected JLabel grafico;
	protected Map<String, Icon> image;
	protected final int width = 17;
	protected final int height = 17;
	
	protected String last_dir = "";
	
	protected Point pos;
	
	protected GameObject(int x, int y) {
		this.pos = new Point(x, y);

		this.image = new HashMap<String, Icon>();
		
		this.last_dir = still_key;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.last_dir = still_key;
			this.grafico = new JLabel(this.image.get(this.last_dir));
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
}
