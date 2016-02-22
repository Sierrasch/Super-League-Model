import java.util.*;
class AllLeagues{
    public ArrayList<League> leagues;
    public int numLeagues;

    public AllLeagues(){
	numLeagues = 1;
	leagues = new ArrayList<League>();
	League superLeague = new League("Super League", 0);
	leagues.add(0, superLeague);
	superLeague = null;
	
    }

    public String toString(){
	String returnVal = "";
	for(int i = 0; i < numLeagues; i++){
	    returnVal += leagues.get(i).toString() + '\n';
	}
	return returnVal;
    }
    public void addLeague(League newLeague){
	leagues.add(numLeagues, newLeague);
	numLeagues++;
    }
    
    public void sortLeagues(){
	for(int i = 0; i < numLeagues; i++){
	    Collections.sort(leagues.get(i).members);
	}
    }

    public void createSuperLeague(){
	for(int i = 1; i < numLeagues; i++){ //for each league
	     for(int j = 0; j < leagues.get(i).promotedTeamCount; j++){ // the number of promotions that should be made
		
		Team tempTeam = leagues.get(i).promoteTop();
		leagues.get(0).members.add(tempTeam);
		leagues.get(0).numTeams++;
	     }
	}
    }

    public void playSeason(){
	for(int i = 0; i < numLeagues; i++){
	    leagues.get(i).playSeason();
	}
    }
}
