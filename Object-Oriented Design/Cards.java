/*
design the data structures for a generic deck of cards. 
Explain how you would subclass the data structures to implement blackjack.
*/

//Who, What, Where, When, How, Why

//Suit: 4 suits, value for each suit
public enum Suit{
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	private Suit(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
	public static Suit getSuitFromValue(int value){
		switch (value){
			case 0:
				return Suit.Club;
			case 1:
				return Suit.Diamond;
			case 2: 
				return Suit.Heart;
			case 3: 
				return Suit Spade;
			default:
				return null;
		}
	}
}

//Card: value, suit, available
public abstract class Card{
	private boolean available = true;

	//a number 2 to 10, 11 for Jack, 12 for Queen, 13 for King, 1 for Ace
	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}

	public abstract int value();

	public Suit suit(){
		return suit;
	}

	//check if the card is available to be given out to someone
	public boolean isAvailable(){
		return available;
	}
	public void markUnavailable(){
		avalable = false;
	}
	public void markAvailable(){
		available = true;
	}
}

//Deck: 
public class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex = 0;

	public Deck(){

	}
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		cards = deckOfCards;
	}

	public void shuffle(){
		for (int i = 0; i < cards.size(); i++){
			int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}

	public int remainingCards(){
		return cards.size() - dealtIndex;
	}

	public T[] dealHand(int number){
		if (remainingCards() < number){
			return null;
		}

		T[] hand = (T[]) new Card[number];
		int count = 0;
		while (count < number){
			T card = dealCard();
			if (card != null){
				hand[count] = card;
				count++;
			}
		}
	}

	public T dealCard(){
		if (remainingCards() == 0)
			return null;

		T card = cards.get(dealtIndex);
		cards.markUnavailable();
		dealtIndex++;

		return card;
	}
}

public class Hand <T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();

	public int score(){
		int score = 0;
		for (T card: cards){
			score += card.value;
		}
		return score;
	}

	public void addCard(T card){
		cards.add(card);
	}
}

public class BlackJackCard extends Card{
	public BlackJackCard(int c, Suit s){
		super(c, s);
	}
	public int value(){
		if (isAce())
			return 1;
		else if (faceValue >= 11 && faceValue <= 13)
			return 10;
		else
			return faceValue;
	}

	public int minValue(){
		if (isAce())
			return 1;
		else
			return value;
	}
	public int maxValue(){
		if (isAce())
			return 11;
		else
			return value();
	}

	public boolean isAce(){
		return faceValue == 1;
	}

	public boolean isFaceCard(){
		return faceValue >= 11 && faceValue <= 13;
	}
}

public class BlackJackHand extends Hand<BlackJackCard>{
	public BlackJackHand(){

	}

	public int score(){
		ArrayList<Integer> scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;

		for (int score : scores){
			if (score > 21 && score < minOver){
				minOver = score;
			}
			else if (score <= 21 && score > maxUnder){
				maxUnder = score;
			}
		}
		return maxUnder = Integer.MIN_VALUE ? minOver : maxUnder;
	}

	private ArrayList<Integer> possibleScores(){
		ArrayList<Integer> scores = new ArrayList<Integer>();
		if (cards.size() == 0)
			return scores;

		for (BlackJackCard card: cards){
			addCardToScoreList(card, scores);
		}
		return scores;
	}

	private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores){
		if (scores.size() == 0)
			scores.add(0);

		int length = scores.size();
		for (int i = 0; i < length; i++){
			int score = scores.get(i);
			scores.set(i, score + card.minValue());
			if (card.minValue() != card.maxValue()){
				scores.add(score + card.maxValue());
			}
		}
	}

	public boolean busted(){
		return score() > 21;
	}
	public boolean is21(){
		return score() == 21;
	}
	public boolean isBlackJack(){
		if (cards.size() != 2)
			return false;
		BlackJackCard first = cards.get(0);
		BlackJackCard second = cards.get(1);
		return (first.isAce() && second.isFaceCard()) || (first.isFaceCard() && second.isAce());
	}
}
