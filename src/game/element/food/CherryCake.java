package game.element.food;

import java.awt.image.BufferedImage;

import util.ImageLoader;

public class CherryCake extends Cake {

	public static final String NAME = "CherryCake";
	public static final String IMAGE_NAME = "cake_cherry.png";
	public static final int VALUE_INCREASE_PIG_ENERGY = 2*Cake.VALUE_INCREASE_PIG_ENERGY;
	public static final int SCORE_POINT = 2*Cake.SCORE_POINT;
	
	public CherryCake() {
		super();
		
		setName(NAME);
		setImageName(IMAGE_NAME);
		setEffectValue(VALUE_INCREASE_PIG_ENERGY);
		setScorePoint(SCORE_POINT);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_NAME);
		setImageWithDimension(image);
	}
}
