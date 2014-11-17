import java.util.ArrayList;


public class Hospital {

	protected ArrayList<Patient> beds;
	protected ArrayList<Integer> theatres;
	
	public Hospital() {
		beds = new ArrayList<Patient>(50);	// initialise ArrayList with initialCapacity = 50
		
		// add 4 theatres
		theatres = new ArrayList<Integer>(4);
		theatres.add(1);
		theatres.add(2);
		theatres.add(3);
		theatres.add(4);
	}
	
	public int admitPatient(Patient patient) {
		
		// return -1 if there is no free bed
		if ( this.beds.size() >= 50 )
			return -1;
		
		// if there is room, add patient to 
		// ArrayList and return its index
		this.beds.add(patient);
		return (this.beds.size() - 1);
	}
	
	public Patient getPatient(int n) {
		// return patient at index n, if doesnt exist return null
		try {
			return this.beds.get(n);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	
}
