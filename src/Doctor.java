import java.util.Random;


public class Doctor extends Person {

	/*
	 * 1=Doctor, 2=Surgeon, 3=LimbSurgeon, 4=OrganSurgeon
	 */
	protected int specialism;
	
	protected Patient assignedPatient;
	
	// whether is busy or not atm
	protected boolean busy;
	
	// For random recoveryTime
	public static Random rand = new Random();
	
	
	public Doctor(char gender, Integer age) {
		super(gender, age);
		this.specialism = 1;
	}

	
	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	public Patient getAssignedPatient() {
		return assignedPatient;
	}

	public void assignPatient(Patient assignedPatient) {
		if (!assignedPatient.equals(null))
			this.busy = true; // set that it is busy
		this.assignedPatient = assignedPatient;
	}

	public int getSpecialism() {
		return specialism;
	}
	
	// just a method to verify that this doctor can cure the patient in the argument
	public boolean canCurePatient(Patient patient) {
		
		if (patient.getHealth().getIllness().getId() <= 3)
			return true;
		return false;
	}
	
	/*
	 * Here we get a random recovery time 
	 */
	public void setRandomRecovery(Health health) {
		// Thank you: http://stackoverflow.com/a/363692/12327
		int max = health.getIllness().getRecoveryTime();
		int min = health.getIllness().getMinRecoveryTime();
		
		// return if max = min
		if (max == min)
			health.setRecoveryTime(max);

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;
		health.setRecoveryTime(randomNum); // set random recoveryTime
	}
	
	/*
	 * method used in subclasses
	 */
	public boolean doSpecialTreatment() {
		return true;
	}
	
	public boolean treatPatient() {
		// if no patient or if Doctor cant cure it just return false
		if (assignedPatient == null || !this.canCurePatient(assignedPatient))
			return false;
		
		System.out.printf("\nTrying to treat patient");
		
		// used in subclasses
		boolean r = this.doSpecialTreatment();
		if (!r)
			return false; // return false if the treatment fails
		
		// set healthState and recoveryTime
		assignedPatient.getHealth().setHealthState(2); // set recovering
		this.setRandomRecovery(assignedPatient.getHealth());
		
		System.out.printf("\nPatient treated and going on recovery now for %d days\n", assignedPatient.getHealth().getRecoveryTime());
		
		return true;	
	}
	

	@Override
	public boolean aDayPasses() {
		// TODO Auto-generated method stub
		return false;
	}

}
