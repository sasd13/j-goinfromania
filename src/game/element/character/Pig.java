package game.element.character;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import game.element.ImageLoader;
import game.element.power.ListPowers;
import game.element.power.Missile;
import game.element.power.Paralyze;
import game.element.power.Power;
import game.element.power.Run;
import game.element.power.SuperMissile;

public class Pig extends Character {

	public static final String NAME = "Pig";
	public static final String IMAGE_PATH = IMAGE_DIR + "pig.png";
	
	public static final int ENERGY_MIN = 0;
	public static final int ENERGY_MAX = 100;
	
	public static final int ENERGY_LOW = 20;
	public static final int ENERGY_MEDIUM = 50;
	public static final int ENERGY_HIGH = 80;
	
	private boolean greedy;
	private int energy;
	private int countEatenCake;
	
	public Pig() {
		super();
		
		setName(NAME);
		setDimension(new Dimension(100, 100));
		setPowerful(true);
		
		BufferedImage image = ImageLoader.loadFromPath(IMAGE_PATH);
		setImage(image);
		System.out.println(getDimension());
		
		ListPowers listPowers = new ListPowers();
		listPowers.add(new Run());
		listPowers.add(new Paralyze());
		listPowers.add(new Missile());
		listPowers.add(new SuperMissile());
		setListPowers(listPowers);
		
		this.greedy = true;
		this.energy = ENERGY_MIN;
		this.countEatenCake = 0;
	}
	
	public boolean isGreedy() {
		return this.greedy;
	}
	
	public void setGreedy(boolean greedy) {
		this.greedy = greedy;
		
		setChanged();
		notifyObservers();
	}
	
	public int getEnergy() {
		return this.energy;
	}
	
	public void setEnergy(int energy) {
		if (energy < ENERGY_MIN) {
			this.energy = ENERGY_MIN;
		} else if (energy > ENERGY_MAX) {
			this.energy = ENERGY_MAX;
		} else {
			this.energy = energy;
		}
		
		setChanged();
		notifyObservers();
	}
	
	public int getCountEatenCake() {
		return this.countEatenCake;
	}
	
	public void cakeEaten() {
		this.countEatenCake++;
		
		setChanged();
		notifyObservers();
	}
	
	public Power getPowerWithEnergy() {
		Power power = null;
		
		if (this.energy == ENERGY_MAX) {
			power = getListPowers().get(SuperMissile.NAME);
		} else if (this.energy < ENERGY_MAX && this.energy >= ENERGY_MEDIUM) {
			power = getListPowers().get(Missile.NAME);
		} else if (this.energy == ENERGY_MIN) {
			power = getListPowers().get(Run.NAME);
		} else {
			power = getListPowers().get(Paralyze.NAME);
		}
		
		return power;
	}
}
