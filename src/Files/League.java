package Files;

import java.io.Serializable;

/**
 * 
 * League abstract class for creating a object, which holds the information about the match.
 * @author Group 1
 */

@SuppressWarnings("serial")
public class League extends Match  implements Serializable
{
   private String type;
   
   /**
    * @author Group 1
    * League constructor gets the data from the Arguments and sets them in the Match class
    * @param date Date of the match
    * @param location Location of the match
    * @param substitutes how many substitutes BOB can do in this match type.
    */
   
   public League(MyDate date, String location, int substitutes)
   {
      super(date, location, substitutes);
      this.type = "League";
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
