
import Games.Number;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import Games.*;
import static org.junit.Assert.*;


public class CardActionsTest {
    @Test
    public void isThreeOfAKind() throws Exception {
        CardActions c = new CardActions();
        Card one = new Card(Color.black, Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.spades);
        Card three = new Card(Color.black,Number.two,Suit.diamonds);
        Card four = new Card(Color.black,Number.two,Suit.clubs);
        Card five = new Card(Color.black,Number.seven,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isFourOfAKind(cards)==true);
    }

    @Test
    public void isFourOfAKind() throws Exception {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.spades);
        Card three = new Card(Color.black,Number.two,Suit.diamonds);
        Card four = new Card(Color.black,Number.two,Suit.clubs);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isFourOfAKind(cards)==true);
    }

    @Test
    public void isStraightFlush() throws Exception {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.three,Suit.hearts);
        Card three = new Card(Color.black,Number.six,Suit.hearts);
        Card four = new Card(Color.black,Number.four,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isStraightFlush(cards)==true);
    }
    @Test
    public void isNotStraightFlush() throws Exception {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.three,Suit.hearts);
        Card three = new Card(Color.black,Number.six,Suit.spades);
        Card four = new Card(Color.black,Number.four,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertFalse(c.isStraightFlush(cards)==true);
    }

    @Test
    public void checkIfPair()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.hearts);
        Card three = new Card(Color.black,Number.three,Suit.hearts);
        Card four = new Card(Color.black,Number.four,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.NumOfPairs(cards)==1);
    }

    @Test
    public void checkIfFlush()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.hearts);
        Card three = new Card(Color.black,Number.three,Suit.hearts);
        Card four = new Card(Color.black,Number.six,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isFlush(cards)==true);
    }
    @Test
    public void checkIfMaxValue()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.hearts);
        Card three = new Card(Color.black,Number.three,Suit.hearts);
        Card four = new Card(Color.black,Number.seven,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.getMaxValue(cards)==7);
    }
    @Test
    public void checkIfFullHouse()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.two,Suit.hearts);
        Card three = new Card(Color.black,Number.three,Suit.hearts);
        Card four = new Card(Color.black,Number.seven,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isFullHouse(cards) == false);
    }
    @Test
    public void checkIfStraight()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.three,Suit.hearts);
        Card three = new Card(Color.black,Number.four,Suit.hearts);
        Card four = new Card(Color.black,Number.six,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isStraight(cards) == true);
    }
    @Test
    public void checkIfNotStraight()
    {
        CardActions c = new CardActions();
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.three,Suit.hearts);
        Card three = new Card(Color.black,Number.four,Suit.hearts);
        Card four = new Card(Color.black,Number.seven,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);
        Card six = new Card(Color.black,Number.eight,Suit.hearts);
        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five,six));
        assertTrue(c.isStraight(cards) == false);
    }
    @Test
    public void checkIfStraight2()
    {
        CardActions c = new CardActions();
        Card seven = new Card(Color.black,Number.six,Suit.hearts);
        Card one = new Card(Color.black,Number.two,Suit.hearts);
        Card two = new Card(Color.black,Number.three,Suit.hearts);
        Card three = new Card(Color.black,Number.four,Suit.hearts);
        Card four = new Card(Color.black,Number.seven,Suit.hearts);
        Card five = new Card(Color.black,Number.five,Suit.hearts);
        Card six = new Card(Color.black,Number.eight,Suit.hearts);
        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five,six,seven));
        assertTrue(c.isStraight(cards) == true);
    }

    @Test
    public void checkIfRoyalFlush()
    {
        CardActions c = new CardActions();

        Card one = new Card(Color.black,Number.ten,Suit.hearts);
        Card two = new Card(Color.black,Number.jack,Suit.hearts);
        Card three = new Card(Color.black,Number.queen,Suit.hearts);
        Card four = new Card(Color.black,Number.king,Suit.hearts);
        Card five = new Card(Color.black,Number.ace,Suit.hearts);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isRoyalFlush(cards) == true);
    }

    @Test
    public void checkIfNotRoyalFlush()
    {
        CardActions c = new CardActions();

        Card one = new Card(Color.black,Number.ten,Suit.hearts);
        Card two = new Card(Color.black,Number.jack,Suit.hearts);
        Card three = new Card(Color.black,Number.queen,Suit.hearts);
        Card four = new Card(Color.black,Number.king,Suit.hearts);
        Card five = new Card(Color.black,Number.ace,Suit.spades);
        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(one,two,three,four,five));
        assertTrue(c.isRoyalFlush(cards) == false);
    }
//'Card(com.company.Color, com.company.Number, com.company.Suit)' in 'com.company.Card' cannot be applied to '()'
}