
public abstract class Person {

	protected char gender; // gender can either be 'M' or 'F'
	protected Integer age;
	protected String health = "healthy"; // string for now but will be changed be changed with a Health class
	

	public Person(char gender, Integer age, String health) {
		super();
		this.gender = gender;
		this.age = age;
		this.health = health;
	}
	
	public Person(char gender, Integer age) {
		super();
		this.gender = gender;
		this.age = age;
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
	
	public String getHealth() {
		return health;
	}
	
	public abstract boolean aDayPasses();
	
	
	
}
