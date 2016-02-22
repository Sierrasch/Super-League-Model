import java.util.*;
class Team implements Comparable<Team>{
    public String name;
    public League homeLeague;
    public League currentLeague;
    public int points;
    public int probabilityNumber;
    public Team(String myName, League myHomeLeague, League myCurrentLeague, int myPoints) {
	probabilityNumber = myPoints;
	name = myName;
	homeLeague = myHomeLeague;
	currentLeague = myCurrentLeague;
	points = myPoints;
    }

    public String toString(){
	return ("" + points + " " + name);
    }

    public boolean equals(Object o) {
	if (!(o instanceof Team))
	    return false;
	Team t = (Team) o;
	Integer myPoints = points;
	Integer tPoints = t.points;
	return (tPoints.equals(myPoints));
    }

    public int hashCode(){
	Integer myPoints = points;
	return 31 * myPoints.hashCode();
    }

    public int compareTo(Team t){
	Integer myPoints = points;
	Integer tPoints = t.points;
	int ptsComp = tPoints.compareTo(myPoints);
	return (ptsComp !=0 ? ptsComp : name.compareTo(t.name));
    }

}
