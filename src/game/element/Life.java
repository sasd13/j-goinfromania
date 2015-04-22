package game.element;

import game.Model;

public class Life extends Model {
	
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 100;
	
	public static final int LIFE_LOW = 20;
	public static final int LIFE_MEDIUM = 50;
	
	private int value;
	
	public Life() {
		super();
		
		setTitle("Life");
		
		this.value = MAX_VALUE;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		if (value >= MAX_VALUE) {
			this.value = MAX_VALUE;
		} else if (value <= MIN_VALUE ) {
			this.value = MIN_VALUE;
		} else {
			this.value = value;
		}
		
		setChanged();
		notifyObservers();
	}
}
