/**
 * The State class contains a toString() method, in addition to getter
 * and setter methods to allow the Project1 class to access private
 * state name, capital, abbreviation, region, population, and seats fields
 * @author 
 */
public class State {

	// Declare fields
	private String name, capital, abbreviation, region;
	private int population, seats;
	
	/**
     * Constructor for State.
     * @param state_name : string
     * @param state_capital : string
     * @param state_abv : string
     * @param state_population : integer
     * @param state_region : string
     * @param state_seats : integer
     * @return nothing
     */
	public State(String state_name, String state_capital, String state_abv, int state_population, 
			String state_region,  int state_seats) {
		
		name = state_name;
		capital = state_capital;
		abbreviation = state_abv;
		region = state_region;
		population = state_population;
		seats = state_seats;
		
	}// End State
	
	 /**
     * Method to retrieve the value of a states name.
     * @param none
     * @return a string
     */
	public String getStateName() {
		return name;
	}
	
	 /**
     * Method to set the value of a states name.
     * @param state_name : string
     * @return nothing
     */
	public void setStateName(String state_name) {
		state_name = name;
	}
	
	 /**
     * Method to retrieve the value of a states capital.
     * @param none
     * @return a string
     */
	public String getStateCapital() {
		return capital;
	}
	
	 /**
     * Method to set the value of a states capital.
     * @param state_capital : string
     * @return nothing
     */
	public void setStateCapital(String state_capital) {
		state_capital = capital;
	}
	
	 /**
     * Method to retrieve the value of a states abbreviation.
     * @param none
     * @return a string
     */
	public String getStateAbrv() {
		return abbreviation; 
	}
	
	 /**
     * Method to set the value of a states abbreviation.
     * @param state_abv : string 
     * @return nothing
     */
	public void setStateAbrv(String state_abv) {
		state_abv = abbreviation;
	}
	
	
	 /**
     * Method to retrieve the value of a states region.
     * @param none
     * @return a string
     */
	public String getStateRegion() {
		return region;
	}
	
	 /**
     * Method to set the value of a states region.
     * @param state_region : int 
     * @return nothing
     */
	public void setStateRegion(String state_region) {
		state_region = region;
	}
	
	 /**
     * Method to retrieve the value of a states population.
     * @param none
     * @return an integer
     */
	public int getStatePopulation() {
		return  population;
	}
	
	 /**
     * Method to set the value of a states population.
     * @param state_population : int 
     * @return nothing
     */
	public void setStatePopulation(int state_population) {
		state_population = population;
	}
	
	 /**
     * Method to retrieve the value of a states seats.
     * @param none
     * @return an integer
     */
	public int getStateSeats() {
		return seats;
	}
	
	 /**
     * Method to set the value of a states seats.
     * @param state_seats : int 
     * @return nothing
     */
	public void setStateSeats(int state_seats) {
		state_seats = seats;
	}
	
	 /**
     * Method to compare the name of states.
     * @param State states
     * @return a string
     */
	public int compareTo(State states) {
		
		return this.getStateName().compareTo(states.getStateName());
		
	}
	
	/**
     * Method to print out a states name, capital, abbreviation, region, population, and seats.
     * @param none
     * @return a formatted string
     */
	public String toString() {
		
		return name + " " + capital + " " + abbreviation + " " + region + " " + population + " " + seats;
		
	}
	
}//End State Class
