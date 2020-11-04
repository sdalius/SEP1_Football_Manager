package Files;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * PlayerList class for creating ArrayLists that hold objects of the Player class
 * @author Group 1
 */
@SuppressWarnings("serial")
public class PlayerList implements Serializable
{
   private ArrayList<Player> playerarr;
   
   /**
    * A no-argument constructor that initializes the ArrayList
    */
   public PlayerList()
   {
      playerarr = new ArrayList<Player>();
   }
   
   /**
    * A method that adds a Player object to the ArrayList
    * @param Player An object of the Player class
    */
   public void addPlayer(Player Player)
   {
      playerarr.add(Player);
   }
   
   /**
    * Removes a player from the ArrayList by the "number" field in the Player class
    * @param number Field in Player class specifying the players number on the field
    */
   public void removePlayer(int number)
   {
      for (int i = 0; i < playerarr.size(); i++)
      {
         if (number == playerarr.get(i).getNumber())
         {
            playerarr.remove(i);
         }
      }
   }
   
   /**
    * Gets a player from the ArrayList by specifying the index
    * @param index The index of the wanted Player in the ArrayList
    * @return Player object located at the index of the ArrayList
    */
   public Player getPlayer(int index)
   {
      return playerarr.get(index);
   }
   
   /**
    * Gets all players from the ArrayList in an array
    * @return An array of the Player type containing all player objects
    */
   public Player[] getAllPlayers()
   {
      Player[] playerarray = new Player[playerarr.size()];
      playerarray = playerarr.toArray(playerarray);
      
      return playerarray;
   }
   
   /**
    * Sets the player status to injured
    * @param index The index of the wanted Player object in the ArrayList
    */
   public void setPlayerInjured(int index)
   {
      playerarr.get(index).setStatus("Injured");
   }
   
   /**
    * Sets the player status to suspended
    * @param index The index of the wanted Player object in the ArrayList
    */
   public void setPlayerSuspended(int index)
   {
      playerarr.get(index).setStatus("Suspended");
   }
   
   /**
    * Sets the player status to transfered
    * @param index The index of the wanted Player object in the ArrayList
    */
   public void setPlayerTransfered(int index)
   {
      playerarr.get(index).setStatus("Transfered");
   }
   
   /**
    * Increases the amount of red cards by 1
    * @param index The index of the wanted Player object in the ArrayList
    */
   public void increaseRedCardAmount(int index)
   {
      int currRedCards = playerarr.get(index).getRedcards();
      playerarr.get(index).setRedcards(currRedCards+1);
   }
   
   /**
    * Increases the amount of yellow cards by the amount of red cards + the argument
    * @param index The index of the wanted Player object in the ArrayList
    * @param yellowcards The argument for how many cards to add onto the current amount of red cards
    */
   public void increaseYellowCardAmount(int index, int yellowcards)
   {
      int currRedCards = playerarr.get(index).getYellowcards();
      playerarr.get(index).setYellowcards(currRedCards+yellowcards);
   }
   
   /**
    * Decreases the number of suspended games by 1 unless it's already 0 and also sets the player status to available
    * @param index The index of the wanted Player object in the ArrayList
    */
   public void decreaseNumberOfSuspension(int index)
   {
      if (playerarr.get(index).getGamessuspended() >= 1)
      {
         playerarr.get(index).setGamessuspended(playerarr.get(index).getGamessuspended() - 1);
         playerarr.get(index).setStatus("Suspended");
      }
      playerarr.get(index).setStatus("Available");
   }

   /**
    * Overrides the system-default toString method to show all the Player objects in the ArrayList
    * @return Return all the players, with their information.
    */
   @Override
   public String toString()
   {
      String playerlist = "";
      for (int i = 0; i < playerarr.size(); i++)
      {
         playerlist += playerarr.get(i) + "\n";
      }
      return playerlist;
   }
}
