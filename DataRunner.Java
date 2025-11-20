import java.util.Scanner;

public class DataRunner {
  public static void main(String[] args) {

    //This is where we instantiate our UserStory object that will then print out the best quaterback. 
  UserStory us = new UserStory("players.txt", "teams.txt", "completionPercentage.txt", "passingYards.txt", "scramblingYards.txt"); 

        // Use toString() method to print out the best quarterback in the 2023 season based on their total passing yards, rushing yards, and completion percentage. 
    System.out.println(us);