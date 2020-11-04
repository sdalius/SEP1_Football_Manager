package Files;

import java.io.Serializable;

/**
 * Player class for creating objects that hold information about the football players
 * @author Group 1
 */
@SuppressWarnings("serial")
public class Player implements Serializable
{
   private String name,position,status;
   private int number,redcards,yellowcards;
   private MyDate dateofsuspension;
   private int gamessuspended;
   
   /**
    * Gets the number of games the player has been suspended
    * @return gamessuspended The number of games the player has been suspended
    */
   public int getGamessuspended()
   {
      return gamessuspended;
   }

   /**
    * Sets the number of games the player has been suspended
    * @param gamessuspended The number of games the player has been suspended
    */
   public void setGamessuspended(int gamessuspended)
   {
      this.gamessuspended = gamessuspended;
   }

   /**
    * Gets the date a player has been suspended
    * @return dateofsuspension The date a player has been suspended as a MyDate object
    */
   public MyDate getDateofsuspension()
   {
      return dateofsuspension;
   }

   /**
    * Sets the date a player has been suspended
    * @param dateofsuspension The date a player has been suspended as a MyDate object
    */
   public void setDateofsuspension(MyDate dateofsuspension)
   {
      this.dateofsuspension = dateofsuspension;
   }

   /**
    * A 4-argument constructor that initializes the Player object with the 4 parameters and 2 fields
    * @param name The players full name
    * @param number The players number in the field
    * @param position The players position on the field
    * @param status The status of a player, whether he is available to play a match
    */
   public Player(String name,int number, String position,String status)
   {
      this.name = name;
      this.number = number;
      this.position = position;
      this.status = status;
      redcards = 0;
      yellowcards = 0;
   }

   /**
    * Gets the players full name
    * @return name The players full name
    */
   public String getName()
   {
      return name;
   }

   /**
    * Sets the player name
    * @param name The players name
    */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Gets the player position
    * @return position The player position on the field
    */
   public String getPosition()
   {
      return position;
   }

   /**
    * Sets the player position
    * @param position The player position on the field
    */
   public void setPosition(String position)
   {
      this.position = position;
   }

   /**
    * Gets the player status
    * @return status The players availability status
    */
   public String getStatus()
   {
      return status;
   }

   /**
    * Sets the player status
    * @param status The players availability status
    */
   public void setStatus(String status)
   {
      this.status = status;
   }

   /**
    * Gets the player number
    * @return number The players number on the field
    */
   public int getNumber()
   {
      return number;
   }

   /**
    * Sets the player number
    * @param number The players number on the field
    */
   public void setNumber(int number)
   {
      this.number = number;
   }

   /**
    * Gets amount of red cards
    * @return redcards The number of red cards a player has
    */
   public int getRedcards()
   {
      return redcards;
   }

   /**
    * Sets amount of red cards
    * @param redcards The number of red cards a player has
    */
   public void setRedcards(int redcards)
   {
      this.redcards = redcards;
   }

   /**
    * Gets amount of yellow cards
    * @return yellowcards The number of yellow cards a player has
    */
   public int getYellowcards()
   {
      return yellowcards;
   }

   /**
    * Sets amount of yellow cards
    * @param yellowcards The number of yellow cards a player has
    */
   public void setYellowcards(int yellowcards)
   {
      this.yellowcards = yellowcards;
   }

   /**
    * Overrides the system-default toString method to show information about the player
    * @return returns the information about the player
    */
   @Override
   public String toString()
   {
      return "Player name: " + name + "\n"
            + "Position: " + position + "\n"
            + "Status: " + status + "\n"
             + "Number: " + number + "\n"
             + "RedCards: " + redcards + "\n"
            + "Yellow Cards: " + yellowcards + "\n"
            + "Date when player was suspended: " + dateofsuspension + "\n"
            + "Games Suspended: " + gamessuspended + "\n";
   }
   
}
