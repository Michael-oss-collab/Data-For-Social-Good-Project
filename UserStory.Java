import java.util.Scanner; // This imports our scanner to read and iterate through our 1D arrays.

public class UserStory {


  // This is where we initialie our variables based on the data from our dataset. 
  private String[] players;
  private String[] teams;
  private double[] completionPercentage;
  private int[] passingYards;
  private int[] scramblingYards;


  //This is our argument based constructor method for our UserStory class. 
  //This also uses our Scanner to iterate through each array.
  public UserStory (String playersFile, String teamsFile, String completionPercentageFile, String passingYardsFile, String scramblingYardsFile){
    this.players = FileReader.toStringArray(playersFile);
    this.teams = FileReader.toStringArray(teamsFile);
    this.completionPercentage = FileReader.toDoubleArray(completionPercentageFile);
    this.passingYards = FileReader.toIntArray(passingYardsFile);
    this.scramblingYards = FileReader.toIntArray(scramblingYardsFile);
  }

//This find max method finds the highest completion percentage in the completionPercentage array. 
  public double findMaxCompletionPercentage() {
    double max = completionPercentage[0];
    for(int i =0; i<completionPercentage.length; i++){
      if(completionPercentage[i]>max){
        max = completionPercentage[i];
      }
    }
return max;
  }

  //This find max method finds the highest total amount of passing yards in the passingYards array. 
    public int findMaxPassingYards() {
    int max = passingYards[0];
    for(int i =0; i<passingYards.length; i++){
      if(passingYards[i]>max){
        max = passingYards[i];
      }
    }
return max;
  }

  //This find max method finds the highest total amount of scrambling yards in the scramblingYards array. 
    public int findMaxScramblingYards() {
    int max = scramblingYards[0];
    for(int i =0; i<scramblingYards.length; i++){
      if(scramblingYards[i]>max){
        max = scramblingYards[i];
      }
    }
return max;
  }
//This findPlayerByScrambleyards finds the player index by taking the index for the max scrambling yards. This finds which player eqyuals the value. 
    public String findPlayerByScrambleyards(int yard) {
    for(int i =0; i<scramblingYards.length; i++){
      if(scramblingYards[i] == yard){
        return players[i];
      }
    }
    return "No Player";
  }

  //This is our toString method to print out our information from the data into the Console to tell the user
  //the best quarterback from the 2023 NFL season.
  //The for and if loops take the index that is the max from completionPercentage, passingYards, and scramblingYards
  //and equals it to the index in the players file to get the player. 
 public String toString() {
int bestPasser = findMaxPassingYards();
  String bestPasserName = players[0];
   for (int i = 0; i < players.length; i++) {
    if (passingYards[i] == bestPasser) {
      bestPasserName = players[i];
    }  
   }
   int bestScrambler = findMaxScramblingYards();
   String bestScramblerName = findPlayerByScrambleyards(bestScrambler);
   
   double bestCompletionPercentage = findMaxCompletionPercentage();
   String bestCompletionPercentageName = players[0];
   for (int i = 0; i < players.length; i++) {
     if (completionPercentage[i] == bestCompletionPercentage) {
       bestCompletionPercentageName = players[i];
     }
   }
   //This is the final return value which returns the information for the user.
   String result = "The best passer in the 2023 NFL Season was: " + bestPasserName + " with " + findMaxPassingYards() + " passing yards. " + "The best scrambling quarterback in the 2023 NFL season was: " + bestScramblerName + " with " + findMaxScramblingYards() + " scrambling yards. " +  "The quarterback in the 2023 NFL Season with the highest completion percentage was: " + bestCompletionPercentageName + " with " + findMaxCompletionPercentage() + "%";
   return result;
 }

}