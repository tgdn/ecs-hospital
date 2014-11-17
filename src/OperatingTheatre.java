
public class OperatingTheatre {

	// an integer to differentiate the operating theatres
	protected Integer id;
	protected boolean free;
	
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
}
