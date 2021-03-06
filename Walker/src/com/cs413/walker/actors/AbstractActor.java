package com.cs413.walker.actors;

import java.util.ArrayList;

import com.cs413.walker.items.Coin;
import com.cs413.walker.items.Portable;
import com.cs413.walker.locations.Location;

public abstract class AbstractActor implements Actor {

	protected Location location;

	protected boolean armed;
	protected String name;

	protected int health, energy, coins, lives, armor, damage, capacity, rate, additionalCapacity;
	protected ArrayList<Portable> items;

	public AbstractActor(String name, Location location, int health,
			int energy, int lives, int capacity, int rate) {
		this.name = name;
		this.location = location;
		this.health = health;
		this.energy = energy;
		this.lives = lives;
		this.capacity = capacity;
		this.rate = rate;
		armor = 1;
		damage = 1;
		coins = 0;
		additionalCapacity = 0;
		items = new ArrayList<Portable>();
	}

	@Override
	public Boolean addItems(ArrayList<Portable> list) {
		for (Portable item : list){
			if (item instanceof Coin) {
				addCoins(item.getValue());
			}else if (getCurrentCapacity() + item.getVolume() < getCapacity()) {
				items.add(item);
				item.setActor(this);
			}
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Portable> getItems() {
		return items;
	}

	@Override
	public int getCoins() {
		return coins;
	}

	@Override
	public void addCoins(int addCoins) {
		coins += addCoins;
	}

	@Override
	public void addHealth(int addHealth) {
		health += addHealth;
	}

	@Override
	public void addEnergy(int addEnergy) {
		energy += addEnergy;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public int getLives() {
		return lives;
	}

	@Override
	public void useItem(Portable item) {
		if (getItems().contains(item)) {
			item.useItem();
			getItems().remove(item);
		}
	}

	@Override
	public int getArmor() {
		return armor;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	public void addArmor(int addArmor) {
		armor += addArmor;
	}

	public void addDamage(int addDamage) {
		damage += addDamage;
	}

	@Override
	public void attack(Actor actor) {
		actor.attacked(getDamage());
	}

	@Override
	public int getCurrentCapacity() {
		int sum = 0;
		for (Portable p : items) {
			sum += p.getVolume();
		}
		return sum + additionalCapacity;
	}

	@Override
	public int getRate() {
		return rate;
	}

	@Override
	public boolean isArmed() {
		return armed;
	}
	@Override
	public void attacked(int damage){
		this.health -= damage;
	}

	@Override
	public void setArmed(boolean armed) {
		this.armed = armed;

	}
	@Override
	public void addDamagePoints(int damage){
		this.damage += damage;
	}

}
