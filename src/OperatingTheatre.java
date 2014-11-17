
public class OperatingTheatre {

	// an integer to differentiate the operating theatres
	protected Integer id;
	protected boolean free;
	protected Patient current;
	
	public OperatingTheatre(int id, boolean free) {
		this.id = id;
		this.free = free;
	}
	
	public OperatingTheatre(int id) {
		this.id = id;
		this.free = true;
	}

	public Integer getId() {
		return id;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public Patient getCurrent() {
		return current;
	}

	/*
	 * Set current patient to OperatingTheatre
	 * If it is not free return false
	 * otherwise return free
	 * 
	 * can set to null and will then 
	 */
	public boolean setCurrent(Patient patient) {
		if ( !this.isFree() )
			return false;
		
		this.current = patient;
		
		if (patient == null)
			// if current is null then theatre is free
			this.setFree(true);
		else
			// if we assign a current user then it cannot be free
			this.setFree(false);
		
		return true;
	}
	
	public void emptyTheatre() {
		this.setCurrent(null);
	}

}
