
public class Patient extends Person {

	public Patient(char gender, Integer age, String health) {
		super(gender, age, health);
	}
	
	public Patient(char gender, Integer age) {
		super(gender, age);
	}

	@Override
	public boolean aDayPasses() {
		// TODO Auto-generated method stub
		return false;
	}

}
