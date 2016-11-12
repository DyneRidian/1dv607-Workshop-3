package BlackJack.model;

import BlackJack.model.Card.Value;

public interface IObserver {

	void dealtCard(Value value,BlackJack.model.Game a_game);
	
}
