import java.util.ArrayList;


public class Hospital {

	protected ArrayList<Patient> beds;
	protected ArrayList<OperatingTheatre> theatres;
	
	public Hospital() {
		beds = new ArrayList<Patient>(50);	// initialise ArrayList with initialCapacity = 50
		
		// add 4 theatres
		theatres = new ArrayList<OperatingTheatre>(4);
		
	}
	
	public int admitPatient(Patient patient) {
		
		// return -1 if there is no free bed
		if ( this.size() >= 50 )
			return -1;
		
		// if there is room, add patient to 
		// ArrayList and return its index
		this.beds.add(patient);
		return (this.size() - 1);
	}
	
	public Patient getPatient(int n) {
		// return patient at index n, if doesnt exist return null
		try {
			return this.beds.get(n);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public int size() {
		return this.beds.size();
	}
	
	public void dischargePatient(int n) {
		// try to remove patient in bed n, otherwise do nothing
		try {
			this.beds.remove(n);
		} catch (IndexOutOfBoundsException e) {
			// do nothing
		}
	}
	
	
}
