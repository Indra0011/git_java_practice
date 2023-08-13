package Practice;
import java.util.Scanner;
public class GuessingNumberGame {

	public static void main(String[] args) {
		Umpire ump = new Umpire();
		System.out.println(ump.correctlyGuessedPlayer());

	}

}

class Guessor
{
	private int guessedNumber;
	public int guessNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Guess a number");
		guessedNumber = sc.nextInt();			// take input and return the number
		return guessedNumber;
	}
}
class Player
{
	private int playerGuess;
	private String name;
	public int guessNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Player guess a number");
		playerGuess = sc.nextInt();
		return playerGuess;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}
class Umpire
{
	public String correctlyGuessedPlayer()
	{
		Guessor guessor = new Guessor();
		int guesserNum = guessor.guessNumber();
		Player p1 = new Player();
		Player p2 = new Player();
		p1.setName("Indra");
		p2.setName("Sena");
		int p1Guess = p1.guessNumber();
		int p2Guess = p2.guessNumber();
		if( p1Guess == guesserNum)
		{
			return p1.getName();
		}
		else
		{
			return p2.getName();
		}
		
	}
}