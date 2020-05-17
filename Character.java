import java.util.ArrayList;
import java.util.Random;

public class Character {

	public static void main(String[] args) {
	
	}
	
//private attributes
	private String name;
	private double attackValue;
	private double maxHealth;
	private double currentHealth;
	private int numOfWins;
	private static ArrayList<Spell> spells;
	
//public methods
	
	//constructor
	public Character (String name, double attackValue, double maxHealth, int numOfWins)	{
		this.name = name;
		this.attackValue = attackValue;
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		this.numOfWins = numOfWins;
	}
	
	//getName method
	public String getName()	{
		return name;
	}
	
	//getAttackValue method
	public double getAttackValue()	{
		return attackValue;
	}
	
	//getMaxHealth method
	public double getMaxHealth()	{
		return maxHealth;
	}
	
	//getCurrentHealth
	public double getCurrHealth()	{
		return currentHealth;
	}
	
	//getNumofWins
	public int getNumWins()	{
		return numOfWins;
	}
	
	//toString
	public String toString()	{
		String currentHealthStr = String.format("%1$.2f", currentHealth);
		return name + " current health is " + currentHealthStr + "."; 
	}
	
	//getAttackDamage
	public double getAttackDamage(int input)	{
	Random numberGenerator = new Random(input);
	Double AttackDamage = this.attackValue * (0.7 + 0.3 * numberGenerator.nextDouble());
	
	return AttackDamage;

	}
	
	//takeDamage 
	public double takeDamage(double characterDamage)	{
		currentHealth -= characterDamage;
		return currentHealth;
	}
	
	//increaseWins 
	public void increaseWins()	{
		numOfWins = numOfWins + 1;
	}
	
	//setter method for spells
	public static void setSpells(ArrayList<Spell> l)	{
		//make a copy
		ArrayList<Spell> copySpell = new ArrayList<Spell>();
		
		for (int i = 0; i < l.size(); i++)	{
			copySpell.add(l.get(i));
		}
		//assign new copy to spells attribute
		spells = copySpell;
		
	}
	
	//display spells method
	public static void displaySpells()	{
		for (int i = 0; i < spells.size(); i++) {
			System.out.println((spells.get(i)));
		}
		
	}
	
	//cast spell method
	
	public static double castSpell(String spellName, int i)	{
		//search through list of spell name 
		for (int index = 0; index < spells.size(); index++)	{
			//compare with input
			if(((spells.get(index)).getName()).equalsIgnoreCase(spellName))	{
				
				//return damage caused by spell in double
				double damage = (spells.get(index)).getMagicDamage(i);
				
				return damage;
			}
		}
		return -1;
	}
	
	
	
	
}
