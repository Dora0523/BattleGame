import java.io.*;
import java.util.ArrayList;


public class FileIO {

	public static void main(String[] args) {
		System.out.println(readSpells("spells.txt"));
	
}
	
	
//public static method
	//readCharacter
	public static Character readCharacter(String fileName) {

		String name = "";
		   double attackValue = 0.0;
		   double MaxHealth = 0.0;
		   int numOfWins = 0;
		   

	//try block
		try {
		//set fileReader and bufferedReader
			FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		//read first line
		String currentLine = br.readLine();
		//update name 
		name += currentLine;
		
		//loop to read all lines until the end

		for(int i = 0; currentLine != null; i++)	{
		
			currentLine = br.readLine();


		if(i == 0)	{
			//update attack value
			attackValue += Double.parseDouble(currentLine);
		}
		if(i == 1)	{
			//update maximum health
			MaxHealth += Double.parseDouble(currentLine);
			
		}
		if(i == 2)	{
			//update number of wins so far in the battle game
			numOfWins += Integer.parseInt(currentLine);
		}
		
		
		}
		br.close();
		fr.close();
		}
		
	//catch block
		//catch fileNotFoundException & return null
		catch (FileNotFoundException a) {
		System.out.println("the file was not there");
		return null;
		
	} 		
		//catch IOException & return null
		catch(IOException b) {
		System.out.println("Something went wrong");
		return null;
	}
	
		
		//create a new character with info from the reader
		Character newCharacter = new Character (name, attackValue, MaxHealth, numOfWins);
		//return new character
		return newCharacter ;
		

	}
	
	
	
	
	
	//readSpells
	public static ArrayList<Spell> readSpells(String fileName)	{
		//create arraylist
		ArrayList<Spell> spell = new ArrayList<Spell>() ;

		
		try {
				
			
		//set fileReader and bufferedReader
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
		//read first line
		String currentLine = br.readLine();
			
			
	
			//loop through rest of the lines	
			for(int i = 0; currentLine != null; i++)	{

				//split line
			String[] str = currentLine.split("\t");
			
			String name = str[0];
			double minDamage = Double.parseDouble(str[1]);
			double maxDamage = Double.parseDouble(str[2]);
			double chance = Double.parseDouble(str[3]);
			//create new Spell
			Spell a = new Spell (name, minDamage,maxDamage,chance);
			//put new Spell into arrayList
			spell.add(i,a);
			currentLine = br.readLine();


			
		}
			br.close();
			fr.close();
		
		}//catch block
		//catch fileNotFoundException & return null
		catch (FileNotFoundException a) {
		System.out.println("the file was not there");
		return null;
		} 		
		//catch IOException & return null
		catch(IOException b) {
		System.out.println("Something went wrong");
		return null;
		}
			
		return spell;
		}
	
	
	//write Character
	public static void writeCharacter(Character character, String writeFileName ) {
		
		try {
		FileWriter fw = new FileWriter(writeFileName);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(character.getName() + '\n');
		bw.write("" + character.getAttackValue() + '\n');
		bw.write("" + character.getMaxHealth() + '\n');
		bw.write("" + character.getNumWins() + '\n');


		
		bw.close();
		fw.close();
		}
		
		catch(FileNotFoundException a) {
			System.out.println("the file was not there");
			} 		
			//catch IOException & return null
			catch(IOException b) {
			System.out.println("Something went wrong");
	}
	
}
}
