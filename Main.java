import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] arg) {
        //region Setup text
        //Scanner Words = Strings -----  Scanner in = integers
        Scanner words = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        //This section is for budget - see teams stats
        // rn is random number generation, decimal format is to limit to 2 digits
        //High & low are the boundaries for the random number
        Random rn = new Random();
        DecimalFormat df = new DecimalFormat(".##");
        int high = 10000;
        int low = 0;

        //Start of program
        System.out.println("\n    * Fantasy Hockey League *");
        System.out.println("        Draft Application");
        System.out.println("---------------------------------\n");
        //endregion

        // region Team Entry
        System.out.println("           Team Entry");
        System.out.println("=================================");

        //Seting up array to take team objects
        ArrayList<Teams> TeamNames = new ArrayList<>();
        int NumberofTeams=3;

        //Naming teams before adding them to the array.  user validation for name>3 characters
        //Uses try catch block and if to ensure program can deny any input under 3 characters
        //Empty print line exists to clear the buffer in the scanner
        for (int i = 1; i <= NumberofTeams; i++) {
            boolean validinput = false;
            while (!validinput) {
                System.out.println("Enter name from team #" + i + ": ");
                try {
                    String name = words.nextLine();
                    if (name.length() < 3) {
                        System.out.println("That's not a valid entry");
                        System.out.println(" ");
                    } else {
                        Teams team = new Teams(name);
                        TeamNames.add(team);
                        validinput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please input a team name");
                }
            }
        }
//endregion
//team validation for names is done

        // region Player Entry
        System.out.println("\n          Player Entry");
        System.out.println("=================================");

        //Creating 3 arrays for teams, and int for 'for loop'
        int NumberofPlayers = 9;
        ArrayList<Players> Team1 = new ArrayList<>();
        ArrayList<Players> Team2 = new ArrayList<>();
        ArrayList<Players> Team3 = new ArrayList<>();

        //Creates new player and assigns values to the three variables in the constructor after creation
        //Uses try catch block and if to ensure program can deny any input under 3 characters for name
        //Uses try catch and if blocks to deny any strings or number<1
        //empty print lines and in.next() are used to empty the buffer for the scanner
        for (int i = 1; i <= NumberofPlayers; i++) {
            boolean validinput = false;
            Players Player = new Players(null,0,0);
            while (!validinput) {
                System.out.println("Enter name from Player #" + i + ": ");
                try {
                    String name = words.nextLine();
                    if (name.length() < 3) {
                        System.out.println("That's not a valid entry");
                        System.out.println(" ");
                    } else {
                        Player.setPlayerName(name);
                        validinput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an acceptable value");
                }
            }
            validinput = false;
            while (!validinput) {
                try {
                    System.out.println("Enter number of goals for " + Player.getPlayerName() + ": ");
                    int goal = in.nextInt();
                    if (goal < 1) {
                        System.out.println("That's not a valid entry");
                    } else {
                        Player.setNumGoals(goal);
                        validinput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an acceptable value");
                    in.next();
                }
            }
            validinput = false;
            while (!validinput) {
                try {
                    System.out.println("Enter number of Assists for " + Player.getPlayerName() + ": ");
                    int assist = in.nextInt();
                    if (assist < 1) {
                        System.out.println("That's not a valid entry");
                    } else {
                        Player.setNumAssist(assist);
                        validinput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter an acceptable value");
                    in.next();
                }
            }
            //Assigns players to proper teams
            if (i == 1 || i == 2 || i == 3) {
                Team1.add(Player);
            } else if (i == 4 || i == 5 || i == 6) {
                Team2.add(Player);
            } else {
                Team3.add(Player);
            }
        }


//endregion

        //region Team Report
        System.out.println("\nReport: Stats per team");
        System.out.println("=================================");

        //Loops based on team size, with is statement to print the three different teams arrays
        //It also adds up the goals and assists for the entire team and then runs the TeamRank method from teams
        //To print out the teams star ranks (ie Rank: **)
        for (int k = 0; k < TeamNames.size(); k++) {
            if (k == 0) {
                int Goals = Team1.get(0).getNumGoals() + Team1.get(1).getNumGoals() + Team1.get(2).getNumGoals();
                int Assists = Team1.get(0).getNumAssist() + Team1.get(1).getNumAssist() + Team1.get(2).getNumAssist();
                int Total = Goals + Assists;
                double Budget = rn.nextDouble(low, high);
                System.out.print("\n" +TeamNames.get(k).getTeamName() + ":    G: " + Goals + "     A: " + Assists +
                        " Total: " + Total + "\nBudget: $" + df.format(Budget) + "\nRank: ");
                Teams.TeamRank(Total);
            } else if (k == 1) {
                int Goals = Team2.get(0).getNumGoals() + Team2.get(1).getNumGoals() + Team2.get(2).getNumGoals();
                int Assists = Team2.get(0).getNumAssist() + Team2.get(1).getNumAssist() + Team2.get(2).getNumAssist();
                int Total = Goals + Assists;
                double Budget = rn.nextDouble(low, high);
                System.out.print("\n" +TeamNames.get(k).getTeamName() + ":    G: " + Goals + "     A: " + Assists +
                        " Total: " + Total + "\nBudget: $" + df.format(Budget) + "\nRank: ");
                Teams.TeamRank(Total);
            } else {
                int Goals = Team3.get(0).getNumGoals() + Team3.get(1).getNumGoals() + Team3.get(2).getNumGoals();
                int Assists = Team3.get(0).getNumAssist() + Team3.get(1).getNumAssist() + Team3.get(2).getNumAssist();
                int Total = Goals + Assists;
                double Budget = rn.nextDouble(low, high);
                System.out.print("\n" +TeamNames.get(k).getTeamName() + ":    G: " + Goals + "     A: " + Assists +
                        " Total: " + Total + "\nBudget: $" + df.format(Budget) + "\nRank: ");
                Teams.TeamRank(Total);
            }
        }
        //endregion

        //region Player Report
        System.out.println("\n \n Report: Stats for Players: ");
        System.out.println("=================================");

        //Prints out the states for each player, same as the setup for teams
        //Nested for loops takes the number of teams, and the checks an if statement to run the next loop to print
        //   thr tree different teams one at a time
        for (int f = 0; f < TeamNames.size(); f++) {
            if (f == 0) {
                for (int j = 0; j < Team1.size(); j++) {
                    System.out.println(TeamNames.get(f).getTeamName());
                    System.out.println(Team1.get(j).getPlayerName() + ":     G - " + Team1.get(j).getNumGoals() +
                            ":     A - " + Team1.get(j).getNumAssist() + ":     Total - " +
                            (Team1.get(j).getNumAssist() + Team1.get(j).getNumGoals()));
                }
            } else if (f == 1) {
                for (int j = 0; j < Team1.size(); j++) {
                    System.out.println(TeamNames.get(f).getTeamName());
                    System.out.println(Team2.get(j).getPlayerName() + ":     G - " + Team2.get(j).getNumGoals() +
                            ":     A - " + Team2.get(j).getNumAssist() + ":     Total - " +
                            (Team2.get(j).getNumAssist() + Team2.get(j).getNumGoals()));
                }
            } else {
                for (int j = 0; j < Team1.size(); j++) {
                    System.out.println(TeamNames.get(f).getTeamName());
                    System.out.println(Team3.get(j).getPlayerName() + ":     G - " + Team3.get(j).getNumGoals() +
                            ":     A - " + Team3.get(j).getNumAssist() + ":     Total - " +
                            (Team3.get(j).getNumAssist() + Team3.get(j).getNumGoals()));
                }
            }
        }
        //endregion
    }
}
