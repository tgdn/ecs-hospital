
public class Health {

	/*
	 * healthState:
	 * healthy=0
	 * sick=1
	 * recovering=2
	 */
	protected int healthState;
	
	/*
	 * Time in days it takes to recover.
	 * Means something only when healthState=2 (recovering)
	 */
	protected int recoveryTime;
	
	/*
	 * Defines which illness the patient has
	 */
	protected Illness illness;
	
	protected boolean requiresTheatre;

	
	/*
	 * recoveryTime and requiresTheatre are set inside the constructor according to illness
	 */
	public Health(int healthState, Illness illness) throws Exception {
		super();
		this.healthState = healthState;
		this.illness = illness;
		
		// No need for checks for healthState as it is hard coded in the Patient class
		
		// Set recoveryTime
		if (illness != null)
			this.recoveryTime = illness.getRecoveryTime(); // get maximum amount of days and not minimum
		else {
			throw new Exception("illness should not be null!");
		}
		
		// if no exception then jump here
		// set requiresTheatre according to illness
		if (illness.isTheatreRequired())
			this.requiresTheatre = true;
		else
			this.requiresTheatre = false;
	}

	public int getHealthState() {
		return healthState;
	}

	public void setHealthState(int healthState) {
		this.healthState = healthState;
	}

	public int getRecoveryTime() {
		return recoveryTime;
	}

	public void setRecoveryTime(int recoveryTime) {
		this.recoveryTime = recoveryTime;
	}
	
	/*
	 * What a day passes actually calls
	 * if it is recovering and if recoveryTime > 0 then decrement 
	 */
	public void decrementRecoveryTime() {
		// execute only if patient is recovering and if he still needs to recover
		if (this.healthState == 2 && this.recoveryTime > 0)
			this.recoveryTime--; // decrement recovery time
			
		// check if is now healthy
		if (this.recoveryTime == 0)
			this.healthState = 0; // set healthy 

	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}
	
	public boolean getRequiresTheatre() {
		return requiresTheatre;
	}

	public void setRequiresTheatre(boolean requiresTheatre) {
		this.requiresTheatre = requiresTheatre;
	}

	
}
