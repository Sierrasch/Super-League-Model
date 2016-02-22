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

    public Team promoteTop(){
	Team returnTeam = members.get(0);
	
	//sanity check
	int relegatedTeamCount = relegatedMembers.size();
	if(relegatedTeamCount == 0){
	    System.out.println("ERROR: ran out of relegated teams");
	}

	members.remove(0);
	members.add(numTeams - 1, relegatedMembers.get(0));
	members.get(numTeams - 1).probabilityNumber = members.get(numTeams - 2).probabilityNumber - 1;
	members.get(numTeams - 1).points = members.get(numTeams - 2).probabilityNumber - 1;
	
	relegatedMembers.remove(0);
	return returnTeam;
    }

    public void relegateHome(Team relegatedHere){
	relegatedHere.points = members.get(0).points;
	relegatedHere.probabilityNumber = members.get(0).probabilityNumber;

	Team relegatedFrom = members.get(numTeams - 1);
	members.remove(numTeams - 1);
	relegatedMembers.add(0, relegatedFrom);
	members.add(0, relegatedHere);
    }
    public void playSeason(){
	for(int i = 0; i < numTeams; i++){
	    members.get(i).probabilityNumber = (members.get(i).probabilityNumber*2 + members.get(i).points) / 3;
	    members.get(i).points = 0;	
	}
	
	for(int i = 0; i < numTeams; i++){
	    for(int j = 0; j < numTeams; j++){
		//note: this will generate two matches for each pair of teams
		if(i!=j){ //team is not against itself
		    int randomRange = members.get(i).probabilityNumber + members.get(j).probabilityNumber + 20;
		    int rand = (int)(Math.random()*randomRange);
		    if(rand < members.get(i).probabilityNumber){
			members.get(i).points += 3;
		    }else if( rand < members.get(i).probabilityNumber + 20){
			members.get(i).points += 1;
			members.get(j).points += 1;
		    }else{
			members.get(j).points += 3;
		    }
		}
	    }
	}
	
	Collections.sort(members);

    }
}
