
public class Patient extends Person {

	protected Health health;
	protected Integer theatre; // if patient is in a theatre, this is the id of the theatre in the ArrayList, otherwise it is null
	
	public Patient(char gender, Integer age, int illness) throws Exception {
		super(gender, age);
		
		// if illness does not exist just ignore it and set patient to not ill
		if (illness > 8 || illness < 1) {
			System.out.println("Impossible to have this type of illness ");
			this.health = new Health(0, null); // set to not ill
			return;
		}
		
		// set health accordingly
		this.health = new Health(1, Hospital.ILLNESSES.get(illness - 1));
			
	}
	
	/* 
	 * How to fit the Test Harness? lol
	 */
	public Patient(char gender, int illness) throws Exception {
		this(gender, 20,  illness);
	}

	public void setTheatre(int n) {
		this.theatre = n;
	}
	
	public void removeFromTheatre() {
		this.theatre = null;
	}
	
	public boolean isInTheatre() {
		return ((this.theatre == null) ? false : true);
	}
	
	public Integer getTheatreIn() {
		return this.theatre;
	}
	
	public Health getHealth() {
		return health;
	}
	
	@Override
	public boolean aDayPasses() {
		// TODO Auto-generated method stub
		
		this.getHealth().decrementRecoveryTime();
		
		return false;
	}

}
