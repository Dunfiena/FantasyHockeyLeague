public class Teams {

    //Initializing teams with team name and setter getter
    private String TeamName;
    public Teams(String teamName){
        this.TeamName=teamName;
    }
    public String getTeamName() {
        return TeamName;
    }

    // Formula for assigning team rank based on Player goals and assists
    // Uses total from the Main class to decide the path for the 'if'
    public static void TeamRank(int Total) {
        if (Total == 0) {
            System.out.print(" ");
        } else if (0 < Total && Total < 10) {
            System.out.print("*");
        } else if (10 < Total && Total <= 20) {
            System.out.print("**");
        } else {
            System.out.print("***");
        }


    }
}
