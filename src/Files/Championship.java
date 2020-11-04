package Files;

import java.io.Serializable;

/**
 * Championship abstract class for creating a object, which holds the information about the match.
 * @author Group 1
 */

@SuppressWarnings("serial")
public class Championship extends Match  implements Serializable
{
   private String type;
   
   /**
    * @author Group 1
    * Championship constructor gets the data from the Arguments and sets them in the Match class
    * @param date Date of the match
    * @param location Location of the match
    * @param substitutes how many substitutes BOB can do in this match type.
    */
   public Championship(MyDate date, String location, int substitutes)
   {
      super(date, location, substitutes);
      this.type = "Championship";
   }
   
   /**
    * Returns the match type
    * @return Match Type
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
