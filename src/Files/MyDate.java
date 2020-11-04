package Files;

import java.io.Serializable;
import java.util.GregorianCalendar;


/**
 * MyDate class for creating date objects that hold information about a date
 * @author Group 1
 */
@SuppressWarnings("serial")
public class MyDate implements Serializable
{
   private int day,month,year;

   /**
    * A 3-argument constructor that initializes the fields
    * @param day An integer value representing the day in a date
    * @param month An integer value representing the month in a date
    * @param year An integer value representing the year in a date
    */
   public MyDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   /**
    * A no-argument constructor that initializes the field to the current day
    */
   public MyDate()
   {
      day = today().day;
      month = today().month;
      year = today().year;
   }
   
   /**
    * This method uses the java.util.GregorianCalendar class to get the current date
    * @return The current date as a MyDate object
    */
   public static MyDate today ()
   {
      GregorianCalendar currentDate = new GregorianCalendar();
      int currentDay = currentDate.get(GregorianCalendar.DATE);
      int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
      int currentYear = currentDate.get(GregorianCalendar.YEAR);
      return new MyDate(currentDay,currentMonth,currentYear);
   }
   
   /**
    * Gets the day of a date
    * @return day An integer value representing the day in a date
    */
   public int getDay()
   {
      return day;
   }

   /**
    * Sets the day of a date
    * @param day An integer value representing the day in a date
    */
   public void setDay(int day)
   {
      this.day = day;
   }

   /**
    * Gets the month of a date
    * @return month An integer value representing the month in a date
    */
   public int getMonth()
   {
      return month;
   }

   /**
    * Sets the month of a date
    * @param month An integer value representing the month in a date
    */
   public void setMonth(int month)
   {
      this.month = month;
   }

   /**
    * Gets the year of a date
    * @return year An integer value representing the year in a date
    */
   public int getYear()
   {
      return year;
   }

   /**
    * Sets the year of a date
    * @param year An integer value representing the year in a date
    */
   public void setYear(int year)
   {
      this.year = year;
   }
   
   /**
    * Sets all the date fields of a MyDate object
    * @param day An integer value representing the day in a date
    * @param month An integer value representing the month in a date
    * @param year An integer value representing the year in a date
    */
   public void setDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   /**
    * A method to compare two MyDate objects to see if they are equal. If the specified object is not a MyDate object, it automaticly fails the check.
    * @param Obj Any object
    * @return A boolean value. True if both objects are MyDate objects and equal. False if they are not both MyDate objects or they are not equal.
    */
   public boolean equals(Object Obj)
   {
      if (!( Obj instanceof MyDate))
      {
         return false;
      }
      
      MyDate newobj = (MyDate)Obj;
      return newobj.day == day && newobj.month == month && newobj.year == year;
   }

   /**
    * Overrides the system-default toString method to show the information about a date
    * @return returns the date
    */
   @Override
   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
}
