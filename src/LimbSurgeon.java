
public class LimbSurgeon extends Surgeon {

	public LimbSurgeon(char gender, Integer age) {
		super(gender, age);
		this.specialism = 3;
	}


	// just a method to verify that this doctor can cure the patient in the argument
	@Override
	public boolean canCurePatient(Patient patient) {

		if (patient.getHealth().getIllness().getId() <= 6)
			return true;
		return false;
	}
}
