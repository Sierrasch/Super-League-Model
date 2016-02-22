import java.io.*;

public class LeagueModel {
    public static void main(String [] args) {

	String fileName = "input.txt";       
        String leagueName = null;

        try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

	    AllLeagues myLeagues = new AllLeagues(); //creates new set of leagues

            while((leagueName = bufferedReader.readLine()) != null) {
		String leagueInfo = bufferedReader.readLine();
		int promotedTeamNum = Integer.parseInt("" + leagueInfo.split(" ")[0]);
		int teamCount = Integer.parseInt("" + leagueInfo.split(" ")[1]);
		League tempLeague = new League(leagueName, promotedTeamNum);
		for(int i = 0; i < teamCount; i++){
		    String team = bufferedReader.readLine();
		    int points = Integer.parseInt("" + team.split(" ")[0]);
		    String name = team.split(" ")[1];
		    Team tempTeam = new Team(name, tempLeague, tempLeague, points);
		    tempLeague.addTeam(tempTeam);
		}
		String relegatedTeam = null;
		for(int i = 0; i < 5; i++){
		    relegatedTeam = bufferedReader.readLine();
		    Team tempTeam = new Team(relegatedTeam, tempLeague, tempLeague, -1);
		    tempLeague.addRelegatedTeam(tempTeam);
		}
		String breakString = bufferedReader.readLine();
		myLeagues.addLeague(tempLeague);
	    }  

	    System.out.println("" + myLeagues);

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
                    }
    }
}
