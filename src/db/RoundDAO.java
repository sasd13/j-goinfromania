package db;

import game.round.ListRounds;
import game.round.Round;

public class RoundDAO {

	public static Round load(String roundId) {
		Round round = null;
		
		//TODO Database query
		
		return round;
	}
	
	public static ListRounds loadAll() {
		ListRounds listRounds = new ListRounds();
		
		//TODO Database query
		
		return listRounds;
	}
	
	public static void save(Round round) {
		//TODO Database query
	}
	
	public static void saveAll(ListRounds listRounds) {
		for (int i=0; i<listRounds.size(); i++) {
			save(listRounds.get(i));
		}
	}
}
