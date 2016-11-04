package BlackJack.controller;

import BlackJack.model.Card.Value;
import BlackJack.model.IObserver;

public class PlayGame implements IObserver{
	
	public PlayGame(BlackJack.model.Game a_game){
		
		a_game.addSubscriber(this);
	}

	public boolean Play(BlackJack.model.Game a_game, BlackJack.view.IView a_view) {
		
		a_view.DisplayWelcomeMessage();
	
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

		if (a_game.IsGameOver()) {
			a_view.DisplayGameOver(a_game.IsDealerWinner());
		}

		int input = GetInput();

		if (input == 'p') {
			a_game.NewGame();
		} else if (input == 'h') {
			a_game.Hit();
		} else if (input == 's') {
			a_game.Stand();
		}

		return input != 'q';
	}

	public int GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}

	@Override
	public void dealtCard(Value value) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}