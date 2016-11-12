package BlackJack.view;

public class SimpleView implements IView 
{
	
	public void DisplayWelcomeMessage() {
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
		GetInput();
	}

	/*
	 * public int GetInput() { try { int c = System.in.read(); while (c == '\r'
	 * || c =='\n') { c = System.in.read(); } return c; } catch
	 * (java.io.IOException e) { System.out.println("" + e); return 0; } }
	 */

	public String choiceValue = "Quit";

	@Override
	public String getValue() {
		return choiceValue;
	}

	private void setValue(IView.choice value) {

		choiceValue = value.toString();
	}

	public void GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}

			if (c == 'p') {
				setValue(choice.NewGame);
			} else if (c == 'h') {
				setValue(choice.Hit);
			} else if (c == 's') {
				setValue(choice.Stand);
			}else if (c == 'q') {
				setValue(choice.Quit);
			}

		} catch (java.io.IOException e) {
			System.out.println("" + e);
		}
	}

	public void DisplayCard(BlackJack.model.Card a_card) {
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
		GetInput();
	}

	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
    }
