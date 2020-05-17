import java.util.Random;

public class Spell {

	public static void main(String[] args) {
		

	}
	
	
//private attributes
	private String name;
	private double minDamage;
	private double maxDamage;
	private double chance;
	
//public methods
	//constructor
	public Spell (String name, double minDamage, double maxDamage, double chance) {
		this.name = name;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.chance = chance;
		
		//throw exception
		if(minDamage < 0 || minDamage > maxDamage || chance < 0 || chance > 1)	{
			throw new IllegalArgumentException();
		}
	}
	
	//getName
	public String getName()	{
		return name;
	}
	
	//getMagicdamage
	public double getMagicDamage(int input)	{
		Random numberGenerator = new Random(input);
		double random = numberGenerator.nextDouble();
		double random2 = numberGenerator.nextDouble();

		
		//return 0 damage if random double between 0 and 1 is greater than chance
		if(random > chance)	{
			return 0;
		}else {
			//return random double between min and max damage otherwise
			double newRandom = minDamage + (maxDamage - minDamage)*random2;
			return newRandom;
		}
	}
	
	//toString
	public String toString()	{
		String spell = ("Name: " + this.name + " Damage: " + this.minDamage + "-" + this.maxDamage + " Chance: " + chance*100 + "%");
		return spell;
	}
}
