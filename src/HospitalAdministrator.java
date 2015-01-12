import java.util.ArrayList;


public class HospitalAdministrator {

	protected Hospital hospital;
	protected ArrayList<Doctor> doctors;
	
	public HospitalAdministrator(Hospital hospital, ArrayList<Doctor> doctors, ArrayList<Patient> patients) throws Exception {
		this.hospital = hospital;
		this.doctors = doctors;
		 // admit patients
		for (Patient patient : patients) {
			this.hospital.admitPatient(patient);
		}
		
		boolean doct, surg, lsurg, osurg;
		doct = surg = lsurg = osurg = false;
		
		
		/*
		 * Verify that at least all types of doctors exist, if not, just warn the user
		 */
		for (Doctor doc : this.doctors) {
			switch (doc.getSpecialism()) {
				case 1:
					doct = true;
				break;
				case 2:
					surg = true;
				break;
				case 3:
					lsurg = true;
				break;
				case 4:
					osurg = true;
				break;
			}
		}
		if ( !(doct && surg && lsurg && osurg) )
			System.out.println("\n* Not all types of doctors are in this hospital, you might wait a while *");
	}
	
	
	/*
	 * method name is quite self explanatory
	 * use this method either every new day or twice a day or more
	 * if doctors can treat different patients in a  day
	 */
	public void makeAllDocsAvailable() {
		for (Doctor doc : this.doctors) {
			doc.setBusy(false);
		}
	}
	
	public void go() {
		
		int days = 1;
		
		while(true) {
			System.out.println("\n* DAY " + days + " *");
			this.aDayPasses();
			days++;
			
			// exit if no more patients to be treated
			if (this.hospital.size() == 0) {
				System.out.printf("No more ill people here, exiting...");
				break;
			} else if (days > 500) {
				System.out.printf("Way too many days, shutting down");
				break;
			}
		}
		System.out.println("\ndays: "+ days);
	}
	
	public void aDayPasses() {
		
		// EXTENSION: doctors can treat twice a day (morning and afternoon)
		for (int n = 0; n < 2; n++) {
		
			if (n== 0)
				System.out.println("___Morning___");
			else if(n == 1)
				System.out.println("___Afternoon___");
			
			// main loop to treat patients
			for (Patient patient : this.hospital.getBeds()) {
				
				// next patient if this one is already recovering
				if (patient.getHealth().getHealthState() != 1)
					continue;
				
				// next patient if there is no available theatre and if the patient needs one
				if (patient.getHealth().getRequiresTheatre() && this.hospital.getFreeTheatre() == null)
					continue;
				
				for (Doctor doc : doctors) {
					
					// next doc if it is already taking care of someone
					if (doc.isBusy())
						continue;
					
					// next doc if this doc cannot cure him
					if (!doc.canCurePatient(patient))
						continue;
					
					// if needs operating theatre then prepForTheatre
					if (patient.getHealth().getRequiresTheatre()) {
						int operatingTheatreNumber = this.hospital.getFreeTheatre(); // request a theatre number from hospital
						this.hospital.prepForTheatre(operatingTheatreNumber, patient); // then prep
					}
					
					// assign patient to doctor and try to cure it
					doc.assignPatient(patient);
					doc.treatPatient();
	
					break; // break the for because we want next Patient	
				}	
			}
			
			// empty all theatres
			this.hospital.emptyTheatres();
			// make all doctors available when they have treated the first row of patients
			this.makeAllDocsAvailable();
		}

		this.hospital.freeBeds();
		
		// one day passes
		// make a day pass for all the entities in the hospital
		for (Doctor doctor : doctors) {
			doctor.aDayPasses();
		}
		this.hospital.aDayPasses();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
		System.out.println("\nPatients left: "+hospital.size());
		
	}
	
	public static void main(String[] args) throws Exception {
		
		// check for config file in args
		if (args.length < 1)
			throw new Exception("A configuration file is needed!\nusage: java HospitalAdministrator config.txt");
		
		// Instantiate ConfigFile reader to retrieve elements from config file
		ConfigFileReader configReader = new ConfigFileReader(args[0]);
		configReader.setup();

		// Get elements from config file into variables
		Hospital h = configReader.getHospital();
		ArrayList<Doctor> d = configReader.getDoctors();
		ArrayList<Patient> p = configReader.getPatients();
		
		HospitalAdministrator admin = new HospitalAdministrator(h,d,p);
		admin.go(); // start !
		
		configReader.close();
	}

}
