package Files;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An adapter to the matches and players file, making it easy to retrieve and store information.
 * @author Group1
 * @version 1.0
 */
public class CoachingToolAdapter
{
   private MyFileIO mfio;
   private String fileName;

   /**
    * 1-argument constructor setting the file name.
    * @param fileName the name and path of the file where all matches or players will be saved and retrieved
    */
   public CoachingToolAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
 
   /**
    * Uses the CoachingToolAdapter class to retrieve a MatchList object with all Matches.
    * @return a Match object with all stored students
    */
   public MatchList getAllMatches()
   {
      MatchList matches = new MatchList();
     
      try
      {
         matches = (MatchList)mfio.readObjectFromFile(fileName);
               
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return matches;
   }

   /**
    * Use the CoachingToolAdapter class to save matches.
    * @param matches the list of Matches that will be saved
    */
   public void saveMatches(MatchList matches)
   {
     
      try
      {
         mfio.writeToFile(fileName, matches);
     
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
   
   
   /**
    * Uses the CoachingToolAdapter class to retrieve a PlayerList object with all Players.
    * @return a PlayerList object with all stored students
    */
   public PlayerList getAllPlayers()
   {
      PlayerList players = new PlayerList();
     
      try
      {
         players = (PlayerList)mfio.readObjectFromFile(fileName);
               
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
      }
      return players;
   }
   
   /**
    * Use the CoachingToolAdapter class to save matches.
    * @param players the list of Players that will be saved
    */
   public void savePlayers(PlayerList players)
   {
      try
      {
         mfio.writeToFile(fileName, players);
     
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
}
