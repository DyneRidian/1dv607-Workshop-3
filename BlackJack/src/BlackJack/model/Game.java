package BlackJack.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {

  private Dealer m_dealer;
  private Player m_player;
  
  private ArrayList<IObserver> m_subscribers;

  public Game()
  {
    m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory());
    m_player = new Player();
    
    m_subscribers = new ArrayList<IObserver>();
  }
    
  
  public void addSubscriber(IObserver a_sub){
	  m_subscribers.add(a_sub);
	  
  }
    
  public boolean IsGameOver()
  {
    return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner()
  {
    return m_dealer.IsDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
	  if(m_dealer.NewGame(m_player)){
			 hasDealtCard(m_player);
			  return true;
		  }
    return false;
  }
  
  //observer
  private void hasDealtCard(Player player){
	  
	  Card card = null;
		  
	  //iterates till the last one
		  Iterator<Card> hand = player.GetHand().iterator();
			 while(hand.hasNext()) {
				card = hand.next();
			 }
		  //sends it
			 for(IObserver obs : m_subscribers ){
			 obs.dealtCard(card.GetValue(), this);
			 }
  }
  
  public boolean Hit()
  {
	  if(m_dealer.Hit(m_player)){
		 hasDealtCard(m_player);
		  return true;
	  }
	  
    return false;
  }
  
  public boolean Stand()
  {  
	  if(m_dealer.Stand()){
			 hasDealtCard(m_dealer);
			  return true;
		  }
		  
	return false;
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
    
  
}