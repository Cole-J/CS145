// DeckOfCardsTest.java
// Card shuffling and dealing

public  class DeckOfCardsTest {
    // execute application
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards(); 
        myDeckOfCards.shuffle(); // place Cards to random order 
        
        // print all 52 Cards in the order in which they are dealt
        for (int i = 1; i <= 52; i++) {
            // deal and display a Card
            //System.out.printf("%-19s", myDeckOfCards.dealCard().toString()); 
            
            if ( i % 4 == 0) { // output a new line after every fourth Card
                System.out.println(); 
            } // end of if 
        } // end of for loop 
        
        Card s = myDeckOfCards.dealCard();
        
        String c = s.toString();
        System.out.println(c + " a dd");
        
        int v = s.getValue();
        System.out.println(v);
    } // end of main method 
} // end of DeckOfCardsTest class 