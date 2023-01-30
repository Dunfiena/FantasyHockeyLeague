public class Players {

    //Initializing Players with variables & constructor method
    private String PlayerName;
    private int NumGoals;
    private int NumAssist;
    public Players(String playerName, int numAssist, int numGoals){
        this.PlayerName=playerName;
        this.NumAssist=numAssist;
        this.NumGoals=numGoals;
    }

    //Setters and getters for three variables
    public void setPlayerName(String playerName) {
        PlayerName = playerName;}
    public void setNumAssist(int numAssist) {
        NumAssist = numAssist;}
    public void setNumGoals(int numGoals) {
        NumGoals = numGoals;}
    public String getPlayerName() {
        return PlayerName;}
    public int getNumAssist() {
        return NumAssist;}
    public int getNumGoals() {
        return NumGoals;}
}
