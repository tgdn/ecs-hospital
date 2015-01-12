import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hospital {

	protected ArrayList<Patient> beds;
	protected ArrayList<Boolean> theatres; // true if empty
	
	protected Integer maxBeds;
	protected Integer maxThr;
	
	
	/*
	 * List of all illnesses  (only a helper)
	 */
	public static final List<Illness> ILLNESSES = Collections.unmodifiableList(
		    new ArrayList<Illness>() {{
		        add( new Illness(1, "Djkstra’s syndrome", 5, 5, false) );
		        add( new Illness(2, "Java Flu", 3, 3, false) );
		        add( new Illness(3, "Deadline Panic Attacks", 1, 1, false) );
		        add( new Illness(4, "Polymorphic Cist", 4, 2, true) );
		        add( new Illness(5, "Semicolon Missing", 8, 5, true) );
		        add( new Illness(6, "Trapped Exception", 8, 6, true) );
		        add( new Illness(7, "Tim Berners Knee", 6, 4, true) );
		        add( new Illness(8, "Coder's Elbow", 3, 2, true) );
		    }});
	
	public Hospital(int nbeds, int ntheatres) throws Exception {
		
		System.out.println("*** HOSPITAL ONLINE MONITOR ***\n");
		
		maxBeds = nbeds;
		maxThr  = ntheatres;
		beds = 		new ArrayList<Patient>(maxBeds);	// initialise ArrayList with initialCapacity = 50
		theatres = 	new ArrayList<Boolean>();
		
		
		// Add 5 theatres
		beds = 		new ArrayList<Patient>(maxBeds);
		theatres = 	new ArrayList<Boolean>();
		
		for (int i = 0; i <= maxThr; i++) {
			theatres.add(new Boolean(true));
		}
	}
	
	public ArrayList<Patient> getBeds() {
		return beds;
	}

	public ArrayList<Boolean> getTheatres() {
		return theatres;
	}

		
	public int admitPatient(Patient patient) {
		
		// check if patient is null and if incorrect gender
		if (patient.equals(null) || !patient.isGenderCorrect())
			return 0;
		
		
		// return -1 if there is no free bed
		if ( this.remaining() <= 0 ) {
			System.err.println("No more spare beds, future patients will not be accepted");
			return -1;
		}
		
		// if there is room, add patient to 
		// ArrayList and return its index
		this.beds.add(patient);
		// print information about admittance
		System.out.println("- A " + patient.getAge() + " years old " + ((patient.getGender() == 'M') ? "male" : "female") + " patient was admitted");
		System.out.printf("  The patient has %s and will stay at least %d days\n", patient.getHealth().getIllness().getName(), patient.getHealth().getIllness().getMinRecoveryTime());
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
	
	
	
	/*
	 * return n° of remaining available beds
	 */
	public int remaining() {
		return maxBeds - this.beds.size();
	}
	
	
	
	/*
	 * patients in hospital
	 */
	public int size() {
		return this.beds.size();
	}

	
	
	public void dischargePatient(int n) {
		// try to remove patient in bed n, otherwise do nothing
		System.out.println("Now discharging a patient");
		try {
			this.beds.remove(n);
		} catch (IndexOutOfBoundsException e) {
			// do nothing
		}
	}

	
	
	public Boolean isTheatreFree(int n) {
		// try to get theatre and check whether it is free
		// otherwise return false if not free or if entry does not exist
		try {
			return this.theatres.get(n); // returns true or false whether free or not
		} catch (IndexOutOfBoundsException e) {
			System.err.println("\nCannot check if free, theatre at index " + n + " does not exist,\n IndexOutOfBounds");
			return false;
		}
	}
	
	
	
	public Integer getFreeTheatre() {
		int i = 0;
		for (Boolean isFree : this.theatres) {
			if (isFree)
				return i;
			i++;
		}
		return null;
	}
	

	
	// remove patients from theatres
	public void emptyTheatres() {
		for (int j = 0; j < this.theatres.size(); j++) {
			this.theatres.set(j, true);
		}
		
		for (Patient patient : this.beds) {
			patient.removeFromTheatre();
		}
	}
	
	
	
	/*
	 * just a function that sends healthy patients back home
	 */
	public void freeBeds() {
		int i = 0;
		ArrayList<Patient> tmp = new ArrayList<>(this.beds);
		for (Patient patient : tmp) {
			if (patient.getHealth().getHealthState() == 0) // if healthy
				this.dischargePatient(i);
			i++;
		}
	}
	
	
	
	public void prepForTheatre(int th, Patient patient) {
		// check if theatre at index th exists  and set current patient,
		// otherwise display error message and return
		try {
			// set OperatingTheatre's current patient to 'patient' 
			this.theatres.set(th, false);
			patient.setTheatre(th);
			System.out.printf("\nPatient is now in prep for theatre %d", th);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Cannot assign patient to given theatre,\n IndexOutOfBounds");
			return;
		}
	}
	
	
	
	public Patient getPatientInTheatreN(int n) {
		for (Patient patient : this.beds) {
			if (patient.getTheatreIn().equals(n))
				return patient;
		}
		return null;
	}
	
	
	
	public void takeForRecovery(int th) {
		Patient patient;
		try {
			this.theatres.set(th, false);
			patient = this.getPatientInTheatreN(th); // get instance of patient in that theatre
			if (patient == null) // if there were no results, return silently
				return;
			
			// otherwise, remove from theatre
			patient.removeFromTheatre();
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Cannot take patient to recovery, the theatre was not found,\n IndexOutOfBounds");
		}
	}
	

	
	public void aDayPasses() {
		// make a day pass for all the patients in the hospital
		for (Patient patient : beds) {
			patient.aDayPasses();
		}
	}
	
}
