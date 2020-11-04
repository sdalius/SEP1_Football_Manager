package Files;

import java.util.ArrayList;
import java.io.Serializable;


/**
 * MatchList class for creating ArrayLists that hold objects of the Match class
 * @author Group 1
 */
@SuppressWarnings("serial")
public class MatchList implements Serializable
{
   private ArrayList<Match> matcharr;
   
   /**
    * A no-argument constructor that initializes the ArrayList
    */
   public MatchList()
   {
      matcharr = new ArrayList<Match>();
   }
   
   /**
    * A method that adds a Match object to the ArrayList
    * @param Match An object of the Match class
    */
   public void addMatch(Match Match)
   {
      if (matcharr.size() == 0)
      {
         
         matcharr.add(Match);
      }
      else 
      {
         for (int i = 0; i < matcharr.size(); i++)
         {
           
            if (matcharr.get(i).getDate().equals(Match.getDate()))
            {
               System.out.println("WE ARE BUSY THAT DAY,ABORTING");
               return;
            }
         }
         matcharr.add(Match);
      }
   }
   
   /**
    * Gets the size of the MatchList
    * @return The size of the MatchList
    */
   public int size()
   {
      return matcharr.size();
   }
   
   /**
    * Removes a Match from the ArrayList by the "date" field in the Match class
    * @param date Field in Match class specifying the date of the match as a MyDate object
    */
   public void removeMatch(MyDate date)
   {
      for (int i = 0; i < matcharr.size(); i++)
      {
         if (date == matcharr.get(i).getDate())
         {
            matcharr.remove(i);
         }
      }
   }
   
   /**
    * Gets a Match from the ArrayList by specifying the index
    * @param index The index of the wanted Match in the ArrayList
    * @return Match object located at the index of the ArrayList
    */
   public Match getMatch(int index)
   {
      return matcharr.get(index);
   }
   
   public void EditMatch(int index,Match Match)
   {
      matcharr.set(index, Match);
   }
   
   /**
    * Gets all matches from the ArrayList
    * @return All Match objects in an ArrayList of the Match class
    */
   public ArrayList<Match> returnAllMatches()
   {
      return matcharr;
   }
   
   /**
    * Gets all matches from the ArrayList in an array
    * @return An array of the Match type containing all Match objects
    */
   public Match[] getAllMatches()
   {
	   Match[] matcharray = new Match[matcharr.size()];
	   matcharray = matcharr.toArray(matcharray);
      
      return matcharray;
   }
   
   /**
    * Overrides the system-default toString method to show all the Match objects in the ArrayList
    * @return returns all the information about the all matches
    */
   public String toString() {
      String matchess = "";
      
      for(int i = 0 ; i < matcharr.size(); i++)
      {
        matchess += matcharr.get(i) + "\n";
      }
      return matchess;
   }
}
