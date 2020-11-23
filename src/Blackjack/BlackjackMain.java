package Blackjack;
import java.util.Scanner;
import java.util.*;

public class BlackjackMain {
	Deck playerdeck =new Deck();
	Deck Dealercard = new Deck();
	double playeramount;
	
	public void dealer() {
		
	}
	public void player() {
		double playerinitialamount = 100.0;
		System.out.println("Your amount left $" + playerinitialamount);
	}
	public static void main(String[] args) {
		System.out.println("WELCOME TO CASINO GUYS ");
		System.out.println("BLACK JACK GAME");
		System.out.println("Please enter your name :");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		
		System.out.println("Select 1 to see deck before shuffle and 2 for after shuffle");
		Scanner scan1 = new Scanner(System.in);
		String userinput = scan1.nextLine();
		
		System.out.println(username);
		Deck Decktest = new Deck();
		Decktest.createDeck();
		System.out.println(Decktest.deckSize());
		
		int input = Integer.parseInt(userinput);
		
		if(input == 1) {
		
		System.out.println("Before Shuffle:");
		for(int i = 0; i<Decktest.deckSize();i++){
			System.out.println(Decktest.getCard(i).getSuit());
		}
		}
		else if (input == 2) {

		Decktest.shuffle();
		System.out.println(" ");
		System.out.println("After Shuffle:");
		for(int i = 0; i<Decktest.deckSize();i++){
			System.out.println(Decktest.getCard(i).getSuit());
		}
		}
		else {
			System.out.println("You have entered wrong input");
		}
		}
		
		
	}
	
	


