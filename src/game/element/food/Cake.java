package game.element.food;

import game.element.Element;
import game.element.character.Pig;
import game.element.draw.CakeDrawing;
import game.round.Score;

public class Cake extends Food {

	public static final String NAME = "Cake";
	public static final int SCORE_VALUE = 50;
	
	public static final int VALUE_EVOLVE_PIG_ENERGY = 20;
	
	public Cake() {
		super();
		
		setName(NAME);
		setDrawing(new CakeDrawing());
		setMovable(true);
		setSpeed(Element.SPEED_LOW);
		setScore(new Score(SCORE_VALUE));
		setEffectValue(VALUE_EVOLVE_PIG_ENERGY);
	}
	
	@Override
	public void act(Pig pig) {
		pig.setEnergy(pig.getEnergy() + getEffectValue());
	}
}
