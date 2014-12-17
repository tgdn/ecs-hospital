
public abstract class Person {

	protected char gender; // gender can either be 'M' or 'F'
	protected Integer age;
	

	public Person(char gender, Integer age) {
		super();
		
		this.gender = gender;
		this.age = age;
	}
	
	public Person(char gender) {
		super();
		this.gender = gender;
		this.age = 20; // default age 
	}
	
	public boolean isGenderCorrect() {
		if (String.valueOf(gender).toUpperCase().equals("M") || String.valueOf(gender).toUpperCase().equals("F")) {
			return true;
		}
		return false;
	}
	
	public char getGender() {
		return gender;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract boolean aDayPasses();
	
	
	
}
