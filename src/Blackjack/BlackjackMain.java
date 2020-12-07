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
				System.out.println("your cards in hand:"+ Player.toString().toString());
				System.out.println("Current value of your cards:"+Player.cardsValue());
				
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
				
				if(userresponse == 2){
					break;
					
				}
				
				}
			System.out.println("Uhide dealer cards:" + Dealer.toString());
			
			if((Dealer.cardsValue() > Player.cardsValue())&&endofround == false) {
				System.out.println("Dealer Wins!!! He beats you  " + Dealer.cardsValue() + " to " + Player.cardsValue());
				playeramount -= Bet;
				endofround = true;
			}
			
			while((Dealer.cardsValue() < 17) && endofround == false){
				Dealer.draw(play);
				System.out.println("Dealer draws following cards " + Dealer.getCard(Dealer.deckSize()-1).toString());
			}
			
			System.out.println("Value of Dealer cards: " + Dealer.cardsValue());
			
			if((Dealer.cardsValue()>21)&& endofround == false){
				System.out.println("Dealer Busts. You win!");
				playeramount += Bet;
				endofround = true;
			}
			
			if((Dealer.cardsValue() == Player.cardsValue()) && endofround == false){
				System.out.println("Push.");
				endofround = true;
			}
			
			if((Player.cardsValue() > Dealer.cardsValue()) && endofround == false){
				System.out.println("ou have won the hand");
				playeramount += Bet;
				endofround = true;
			}
			else if(endofround == false) //dealer wins
			{
				System.out.println("Dealer wins.");
				playeramount -= Bet;
			}
			
			Player.moveAllToDeck(play);
			Dealer.moveAllToDeck(play);
			System.out.println("Its end of hand");
		}
		System.out.println(" You have lost your money: Game over!");
		Input.close();
		scan.close();
		}		
		}
		
		
		
		
	
	
	


