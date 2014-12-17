
public class Surgeon extends Doctor {

	public Surgeon(char gender, Integer age) {
		super(gender, age);
		this.specialism = 2;
	}


	// just a method to verify that this doctor can cure the patient in the argument
	@Override
	public boolean canCurePatient(Patient patient) {

		if (patient.getHealth().getIllness().getId() <= 4)
			return true;
		return false;
	}
	
	// Surgeons need something more to the treating process
	// this method implements these very easily
	@Override
	public boolean doSpecialTreatment() {
		Health patientHealth = assignedPatient.getHealth();
		// if needs theatre -> check if already in it and cure otherwise nothing
		if (patientHealth.getRequiresTheatre()) {
			if (assignedPatient.isInTheatre()) {
				this.operate(patientHealth);
			} else {
				System.err.printf("\nTrying to operate patient but we could not find him in any operating theatre. Where is heeee??\n");
				return false;
			}	
		}
		return true;
	}
	
	
	public void operate(Health health) {
		System.out.printf("\nNow operating patient...");
	}
}
