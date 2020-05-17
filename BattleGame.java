import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;


public class BattleGame {

	public static void main(String[] args)	{
		playGame("player.txt","monster.txt","spell.txt");
	}

//private Attributes
	private static Random numberGenerator = new Random(123);
	
//public method
	public static void playGame(String playerFileName, String monsterFileName, String spellsFileName)	{
		//create player and monster 
				Character player = FileIO.readCharacter(playerFileName);
				Character monster = FileIO.readCharacter(monsterFileName);

		//create spell file
				String spellFile = spellsFileName;
				
		//call readSpells
		if (FileIO.readSpells(spellFile) == null)	{
			System.out.println("The game will be played without spells");
		}
		
		
	
		//initialize arraylist
			ArrayList<Spell> arr = FileIO.readSpells(spellsFileName);
			 Character.setSpells(arr);
		
		
		
		//check if new character is null
		 if(player == null || monster == null)	{
			System.out.println("The game cannot be played");
			return;

		}else {
			//display info
			System.out.println("Name: " + player.getName());
			System.out.println("Health: " + player.getCurrHealth());
			System.out.println("Attack: " + player.getAttackValue());
			System.out.println("Number of Wins: " + player.getNumWins());
			System.out.println();
			System.out.println("Name: " + monster.getName());
			System.out.println("Health: " + monster.getCurrHealth());
			System.out.println("Attack: " + monster.getAttackValue());
			System.out.println("Number of Wins: " + monster.getNumWins());
			System.out.println();
			System.out.println("Here are the available spells:");
			Character.displaySpells();;
			
			
			
			
		}
		 
		 
		 
//import scanner object to take input from the user
			Scanner read = new Scanner(System.in);
			
		//loop through attacks
			for (int i = 1; i != 0; i++) {
			
			//check if both player and monster have health above zero
			if(player.getCurrHealth() > 0 && monster.getCurrHealth() > 0) {
				System.out.println(" ");
				System.out.println("Enter a command: ");
				//read nextline
				String command = read.nextLine();
		

	//attack command
	  //***player attack
				 if(command.equals("attack"))	{
					double attackDamage = (player.getAttackDamage(numberGenerator.nextInt()));
					String attackStr = String.format("%1$.2f", attackDamage);
					
					//take damage
					monster.takeDamage(attackDamage);
					
					//print attack damage
					System.out.println(player.getName() + " attacks for " + attackStr + " damage!");

			//check monster health
				//exit loop if monster health <= 0
				 	if(monster.getCurrHealth() <= 0)	{
					 System.out.println(monster.getName() + " was knocked out!");
					 player.increaseWins();
					 //update character
					 Character updateCharacter = new Character (player.getName(), player.getAttackValue(), player.getMaxHealth(), player.getNumWins() );
					  //write on file
						FileIO.writeCharacter(updateCharacter,("player.txt"));
					
						//display 
					 	System.out.println();
						System.out.println("Fantastic! You killed the monster!");
						System.out.println("Successfully wrote to file: " + playerFileName);
						System.out.println(player.getName() + " has won: " + player.getNumWins() + " times");


					 i = 0;
					 break;
				 	}
				//continue of monster health > 0
				 	else	{
					//print monster currentHealth if >0
					System.out.println(monster);
					System.out.println();

					
				 }
				 
				 
	//***monster attack 
				 double attackDamage2 = (monster.getAttackDamage(numberGenerator.nextInt()));
				 	String attackStr2 = String.format("%1$.2f", attackDamage2);

				 	player.takeDamage(Double.parseDouble(attackStr2));
				 	//print attack damage
				 	System.out.println(monster.getName() + " attacks for " + attackStr2 + " damage!");

				 	
			//check player health
				//exit loop if player health <= 0
				 	if(player.getCurrHealth() <= 0)	{
					 System.out.println(player.getName() + " was knocked out!");
					 //monster wins +1
					 monster.increaseWins();
					 
					 //update character
					 Character updateCharacter = new Character (monster.getName(), monster.getAttackValue(), monster.getMaxHealth(), monster.getNumWins() );
					  
					 //write on file
						FileIO.writeCharacter(updateCharacter,("monster.txt"));
					 i = 0;
					 
					//display 
					 	System.out.println();
						System.out.println("Oh no! You lost!");
						System.out.println("Successfully wrote to file: " + monsterFileName);
						System.out.println(monster.getName() + " has won: " + monster.getNumWins() + " times");
					 break;
				 	}
				//continue of player health > 0
				 	else	{
					//print player currentHealth if >0
			
					System.out.println(player);
					System.out.println();

				}
	//Quit	command
				 }else if(command.equals("quit"))	{
				System.out.println("goodbye!");
				break;
	//cast spell
				
				 }else {
	  //***player cast spell
				int randomNum = numberGenerator.nextInt();
				//get damage
				double damage = Character.castSpell(command, randomNum);
				
				if(damage <= 0)	{
					System.out.println( player.getName() + " tried to cast a spell, but they failed.");
				}else {
					monster.takeDamage(damage);
					String attackDamage = String.format("%1$.2f", damage);
					System.out.println(player.getName() + " casts " + command + " dealing " + attackDamage + " damage!");
				}
		//check monster health
				
			//exit loop if health <= 0
			 	if(monster.getCurrHealth() <= 0)	{
				 System.out.println(monster.getName() + " was knocked out!");
				 player.increaseWins();
				 //update character
				 Character updateCharacter = new Character (player.getName(), player.getAttackValue(), player.getMaxHealth(), player.getNumWins() );
				   //write on file
					FileIO.writeCharacter(updateCharacter,("player.txt"));
					
					//display 
				 	System.out.println();
					System.out.println("Fantastic! You killed the monster!");
					System.out.println("Successfully wrote to file: " + playerFileName);
					System.out.println(player.getName() + " has won: " + player.getNumWins() + " times");
					
				 i = 0;
				 break;
			 	}
		  //continue if monster health > 0
			 	else	{
				//print monster currentHealth if >0
		
				System.out.println(monster);
				System.out.println();
			 	}
			 
			 
	 //***monster attack 
			 double attackDamage = (monster.getAttackDamage(numberGenerator.nextInt()));
			 	String damage2 = String.format("%1$.2f", attackDamage);
			 	player.takeDamage(attackDamage);
			    //print attack damage
			 	System.out.println(monster.getName() + " attacks for " + damage2 + " damage!");
			 	
			 	
			 	
		//check player health
			//exit loop if player health <= 0
			 	if(player.getCurrHealth() <= 0)	{
				 System.out.println(player.getName() + " was knocked out!");
				 monster.increaseWins();
				 //update character
				 Character updateCharacter = new Character (monster.getName(), monster.getAttackValue(), monster.getMaxHealth(), monster.getNumWins() );
				   //write on file
					FileIO.writeCharacter(updateCharacter,("monster.txt"));
				 i = 0;
				 
				  //display 
				 	System.out.println();
					System.out.println("Oh no! You lost!");
					System.out.println("Successfully wrote to file: " + monsterFileName);
					System.out.println(monster.getName() + " has won: " + monster.getNumWins() + " times");
				 break;
			 	}
				
		 //continue of player health > 0
			 	else	{
				//print player currentHealth if >0
				System.out.println(player);
				System.out.println();

			}
			
	}
}
					
			}
	}
}


	



		
	


