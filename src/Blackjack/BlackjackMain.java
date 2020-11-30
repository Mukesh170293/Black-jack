package Blackjack;
import java.util.Scanner;
import java.util.*;

public class BlackjackMain {
	
	public static void main(String[] args) {
		System.out.println("WELCOME TO CASINO GUYS ");
		System.out.println("BLACK JACK GAME");
		System.out.println("Please enter your name :");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		System.out.println(username);
		
		Deck play = new Deck();
		play.createDeck();
		play.shuffle();
		
		Deck Player = new Deck();
		double playeramount = 100.0;
		
		Deck Dealer = new Deck();
		
		Scanner Input = new Scanner(System.in);
		
		
		while(playeramount>0) {
			System.out.println("Currently you have $" + playeramount + ", How much amount would you like to bet "+username+"?");
			double Bet = Input.nextDouble();
			boolean endofround = false;
			if(Bet>playeramount) {
				System.out.println("Sorry! You don't have enought amount to bet");
				break;
			}
			System.out.println("Dealing");
			Player.draw(play);
			Player.draw(play);
			
			Dealer.draw(play);
			Dealer.draw(play);
			
			while(true) {
				System.out.println("your cards in hand:"+ Player.toString());
				System.out.println("Current value of your cards:"+play.cardsValue());
				
				System.out.println("Cards in Dealer Hand: " + Dealer.getCard(0).getValue() + " and Hidden cards");
				System.out.println("Do you like to 1.Hit or 2.Stand");
				int userresponse = Input.nextInt();	
				if(userresponse == 1){
					Player.draw(play);
					System.out.println("You drawed a card:" + Player.getCard(Player.deckSize()-1).getValue());
					if(Player.cardsValue() > 21){
						System.out.println("Bust..You are currently valued at : " + Player.cardsValue());
						playeramount -= Bet;
						endofround = true;
						break;
					}
				}
			}
		}
		
		}
		
		
	}
	
	


