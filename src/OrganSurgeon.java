
public class OrganSurgeon extends Surgeon {

	public OrganSurgeon(char gender, Integer age) {
		super(gender, age);
		this.specialism = 4;
	}


	// just a method to verify that this doctor can cure the patient in the argument
	@Override
	public boolean canCurePatient(Patient patient) {

		if (patient.getHealth().getIllness().getId() == 5 || patient.getHealth().getIllness().getId() == 6)
			return false;
		return true;
	}
}
