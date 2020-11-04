package Files;

import java.io.Serializable;

/**
 * 
 * Friendly abstract class for creating a object, which holds the information about the match.
 * @author Group 1
 */

@SuppressWarnings("serial")
public class Friendly extends Match  implements Serializable
{
   private String type;
   /**
    * @author Group 1
    * Friendly constructor gets the data from the Arguments and sets them in the Match class
    * @param date Date of the match
    * @param location Location of the match
    * @param substitutes how many substitutes BOB can do in this match type.
    */
   public Friendly(MyDate date, String location, int substitutes)
   {
      super(date, location, substitutes);
      this.type = "Friendly";
   }
   
   /**
    * Gets the match type
    * @return Returns the match type
    */
   public String getType()
   {
      return type;
   }
   
   /**
    * Overwrites the default toString method to show information about the match.
    * @return Returns the whole information about the Match
    */
   @Override
   public String toString()
   {
      return super.toString()
           +  "Match Type: " + type + "\n";
   }
}
