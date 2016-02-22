import java.util.*;

class League{
    public int numTeams;
    public String name;
    public int promotedTeamCount;
    public ArrayList<Team> members;
    public ArrayList<Team> relegatedMembers;
    
    public League(String myName, int myPromotedTeamCount){
	promotedTeamCount = myPromotedTeamCount;
	numTeams = 0;
	name = myName;
	members = new ArrayList<Team>();
	relegatedMembers = new ArrayList<Team>();
    }	

    public String toString(){
	String returnVal = "";
	returnVal += name + '\n';
	for(int i = 0; i < numTeams; i++){
	    returnVal += members.get(i).toString() + '\n';
	}
	return returnVal;
    }

    public void addTeam(Team newTeam){
	members.add(newTeam);
	numTeams++;
    }

    public void addRelegatedTeam(Team newTeam){
	relegatedMembers.add(newTeam);
    }
    public void playSeason(){

	//runs all the games according to value given to each team. 
	//sorts the teams by most points
    }
}
