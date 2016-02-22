class Team{
    public String name;
    public League homeLeague;
    public League currentLeague;
    public int points;
    
    public Team(String myName, League myHomeLeague, League myCurrentLeague, int myPoints) {

	name = myName;
	homeLeague = myHomeLeague;
	currentLeague = myCurrentLeague;
	points = myPoints;
    }

    public String toString(){
	return name;
	
    }
}
