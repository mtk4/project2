package com.cs413.walker.actors;

import java.util.ArrayList;

import com.cs413.walker.items.Portable;
import com.cs413.walker.locations.Location;

/***
 * Actor interface. Includes movement of actors
 * 
 * @author michaelkalimuthu
 * 
 */
public interface Actor {
	/**
	 * Moves actor from one cell to another
	 * 
	 * @return
	 */
	public boolean move(Location newLocation);

	/**
	 * returns actor's Location
	 */
	public Location getLocation();

	@Override
	String toString();

	public String getName();

	public int getLives();

	public int getHealth();

	public int getEnergy();

	public int getCoins();

	public int getArmor();

	public int getDamage();

	public int getCapacity();

	public int getCurrentCapacity();

	public void addCoins(int addCoins);

	public void addHealth(int addHealth);

	public void addEnergy(int addEnergy);
	
	public void attacked(int damage);
	
	public void addDamagePoints(int damage);

	public Boolean addItems(ArrayList<Portable> list);

	public void useItem(Portable item);

	public ArrayList<Portable> getItems();

	public void addListeners(ActorListener listener);
	
	public void removeListeners(ActorListener listener);

	public void attack(Actor actor);

	public int getRate();
	
	public boolean isArmed();
	
	public void setArmed(boolean armed);

}
