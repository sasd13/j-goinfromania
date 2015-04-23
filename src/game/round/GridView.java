package game.round;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import game.IViewable;
import game.draw.Drawing;
import game.draw.IDrawable;
import game.element.Element;
import game.element.Pig;

public class GridView extends JPanel implements Observer, IViewable, IDrawable {

	public static final int GRID_WIDTH = 640;
	public static final int GRID_HEIGHT = 480;
	
	public GridView() {
		super();
		
		setPreferredSize(new Dimension(GRID_WIDTH, GRID_HEIGHT));
	}
	
	@Override
	public void update(Observable observable, Object arg) {
		Grid grid = (Grid) observable;
		
		Pig pig = grid.getPig();
		draw(pig.getDrawing());
		
		for(Element element : grid.getListElement()) {
			draw(element.getDrawing());
		}
	}
	
	@Override
	public void draw(Drawing drawing) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void display() {
		setVisible(true);
	}
	
	@Override
	public void mask() {
		setVisible(false);
	}
}
