
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

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}

	
}
