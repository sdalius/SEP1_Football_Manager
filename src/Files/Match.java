package Files;

import java.io.Serializable;

/**
 * Abstract class for creating objects that hold information about football matches
 * @author Group 1
 */
@SuppressWarnings("serial")
public abstract class Match implements Serializable
{
   private MyDate date;
   private String location;
   private int substitutes;
   private String type;
   
   /**
    * A 3-argument constructor that initializes the 3 match fields.
    * @param date The date of the match as a MyDate object
    * @param location The location of the match
    * @param substitutes The number of substitutes in the match
    */
   public Match (MyDate date, String location, int substitutes)
   {
      this.date = date;
      this.location = location;
      this.substitutes = substitutes;
   }
   
   /**
    * Gets the match date
    * @return date The date of the match as a MyDate object
    */
   public MyDate getDate()
   {
      return date;
   }
   
   /**
    * Sets the match date
    * @param date The date of the match as a MyDate object
    */
   public void setDate(MyDate date)
   {
      this.date = date;
   }
   
   /**
    * Gets the match location
    * @return location The location of the match
    */
   public String getLocation()
   {
      return location;
   }
   
   /**
    * Sets the match location
    * @param location The location of the match
    */
   public void setLocation(String location)
   {
      this.location = location;
   }
   
   /**
    * Gets the number of substitutes
    * @return substitutes The number of substitutes in the match
    */
   public int getSubstitutes()
   {
      return substitutes;
   }
   
   /**
    * Sets the number of substitutes
    * @param substitutes The number of substitutes in the match
    */
   public void setSubstitutes(int substitutes)
   {
      this.substitutes = substitutes;
   }
   
   /**
    * Gets the match type
    * @return type The type of the match
    */
   public String getType()
   {
      return type;
   }

   /**
    * Overrides the system-default toString method to show information about the match
    * @return returns all the information about the match
    */
   @Override
   public String toString()
   {
      return "Date: " + date + "\n" + 
              "Location: " + location + "\n" 
              + "Substitutes: " + substitutes + "\n";
   }
}
