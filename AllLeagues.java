import java.util.*;
class AllLeagues{
    public ArrayList<League> leagues;
    public int numLeagues;

    public AllLeagues(){
	leagues = new ArrayList<League>();
	numLeagues = 0;
    }

    public String toString(){
	String returnVal = "";
	for(int i = 0; i < numLeagues; i++){
	    returnVal += leagues.get(i).toString() + '\n';
	}
	return returnVal;
    }
    public void addLeague(League newLeague){
	leagues.add(newLeague);
	numLeagues++;
    }

}
