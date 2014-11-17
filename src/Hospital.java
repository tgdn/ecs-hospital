import java.util.ArrayList;
import java.util.Random;


public class Hospital {

	protected ArrayList<Patient> beds;
	protected ArrayList<OperatingTheatre> theatres;
	
	public Hospital() {
		beds = new ArrayList<Patient>(50);	// initialise ArrayList with initialCapacity = 50
		
		// add 4 theatres
		theatres = new ArrayList<OperatingTheatre>();
		theatres.add(new OperatingTheatre(1));
		theatres.add(new OperatingTheatre(2));
		theatres.add(new OperatingTheatre(3));
		theatres.add(new OperatingTheatre(4));
		
	}
	
	public int admitPatient(Patient patient) {
		
		// return -1 if there is no free bed
		if ( this.size() >= 50 )
			return -1;
		
		// if there is room, add patient to 
		// ArrayList and return its index
		this.beds.add(patient);
		// print information about admittance
		System.out.println("- A " + patient.getAge() + " years old " + ((patient.getGender() == 'M') ? "male" : "female") + " patient was admitted");
		System.out.println("  Patient ID: " + (this.size() - 1));
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
	
	public boolean isTheaterFree(int n) {
		// try to get theatre and check whether it is free
		// otherwise return false if not free or if entry does not exist
		try {
			return this.theatres.get(n).isFree();
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Cannot check if free, theatre at index " + n + " does not exist,\n IndexOutOfBounds");
			return false;
		}
	}
	
	public void prepForTheatre(int th, Patient patient) {
		// check if theatre at index th exists  and set current patient,
		// otherwise display error message and return
		try {
			// set OperatingTheatre's current patient to 'patient' 
			this.theatres.get(th).setCurrent(patient);
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Cannot assign patient to given theatre,\n IndexOutOfBounds");
			return;
		}
	}
	
	public void takeForRecovery(int th) {
		try {
			this.theatres.get(th).emptyTheatre();
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Cannot take patient to recovery, the theatre was not found,\n IndexOutOfBounds");
		}
	}
	
	public void aDayPasses() {
		// make a day pass for all the patients in the hospital
		for (Person person : beds) {
			person.aDayPasses();
		}
		
		// TODO: Same but for doctors
	}
	
	public static void main(String[] args) {
		System.out.println("Just creating a hospital");
		Hospital hospital = new Hospital();

		Patient p1 = new Patient('M', 33);
		Patient p2 = new Patient('F', 12);
		Patient p3 = new Patient('F', 26);
		Patient p4 = new Patient('F', 17);

		hospital.admitPatient(p1);
		hospital.admitPatient(p2);
		hospital.admitPatient(p3);
		hospital.admitPatient(p4);
		
		
		// Size harness
		// Here we check that the Hospital doesnt take more than 50 patients
		/*
		Random rand = new Random();
		int rage;
		for (int i = 0; i < 52; i++) {
			// get random age
			// http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
			rage = rand.nextInt( (120 - 6) + 1 ) + 6;
			// let them all be males
			hospital.admitPatient(new Patient('M', rage));
		}
		*/
		
	}
	
	
}
