
public class Illness {

	protected int		id;
	protected String 	name;
	protected int 		recoveryTime;
	protected int		minRecoveryTime;
	protected boolean 	theatreRequired;
	
	


	public Illness(int id, String name, int recoveryTime, int minRecoveryTime,
			boolean theatreRequired) {
		super();
		this.id = id;
		this.name = name;
		this.recoveryTime = recoveryTime;
		this.minRecoveryTime = minRecoveryTime;
		this.theatreRequired = theatreRequired;
	}


	public int getMinRecoveryTime() {
		return minRecoveryTime;
	}


	public void setMinRecoveryTime(int minRecoveryTime) {
		this.minRecoveryTime = minRecoveryTime;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRecoveryTime() {
		return recoveryTime;
	}


	public void setRecoveryTime(int recoveryTime) {
		this.recoveryTime = recoveryTime;
	}


	public boolean isTheatreRequired() {
		return theatreRequired;
	}


	public void setTheatreRequired(boolean theatreRequired) {
		this.theatreRequired = theatreRequired;
	}
	
	
	
}
