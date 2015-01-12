import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ConfigFileReader {

	protected String 			filename;
	protected BufferedReader 	bf;
	
	protected Hospital 				hospital = null;
	protected ArrayList<Doctor> 	doctors;
	protected ArrayList<Patient>	patients;
	
	
	public ConfigFileReader(String filename) throws Exception {
		this.filename = filename;
		doctors = 	new ArrayList<Doctor>();
		patients = 	new ArrayList<Patient>();
		
		try {
			bf = new BufferedReader( new FileReader(filename)); // try to create buffered reader
		} catch(FileNotFoundException e) {
			throw new Exception("Config file was not found");
		}
		
	}
	
	public void close() throws IOException {
		this.bf.close();
	}
	
	public void setup() throws Exception {
		String line = null;
		int n = 0; // counts if more than one hospital line
		// for each line do some work
		while ((line = bf.readLine()) != null) {
			
			String[] s1, s2;
			
			try {
				s1 = line.split(":");
				s2 = s1[1].split(",");
			} catch (IndexOutOfBoundsException e) {
				throw new Exception("Config file of incorrect format!");
			}
			
			char gender;
			Integer age;
			Integer condition;
			Integer recovery;
			
			// conditions to see what we do here
			// {action}:{arguments...,..,.,,}
			// and then instantiate according entities (Doctors, Patients, Hospital...)
			// s1[0] is the first part of the parsed line of text
			// s2 contains the elements of the second part
			
			if (s1[0].equals("hospital")) {
				if (n > 0)
					throw new Exception("Two instances of Hospital cannot be created, update your config file");
				Integer a = new Integer(s2[0]);
				Integer b = new Integer(s2[1]);
				this.hospital = new Hospital(a,b);
				n = 1; // change value so we know there exists an instance of hospital already
				
			} else if (s1[0].equals("doctor")) {
				gender 	= s2[0].charAt(0);
				age 	= new Integer(s2[1]);
				this.doctors.add(new Doctor(gender,age));
				
			} else if (s1[0].equals("surgeon")) {
				gender 	= s2[0].charAt(0);
				age 	= new Integer(s2[1]);
				this.doctors.add(new Surgeon(gender,age));
				
			} else if (s1[0].equals("limbSurgeon")) {
				gender 	= s2[0].charAt(0);
				age 	= new Integer(s2[1]);
				this.doctors.add(new LimbSurgeon(gender,age));
				
			} else if (s1[0].equals("organSurgeon")) {
				gender 	= s2[0].charAt(0);
				age 	= new Integer(s2[1]);
				this.doctors.add(new OrganSurgeon(gender,age));
				
			} else if (s1[0].equals("patient")) {
				gender 		= s2[0].charAt(0);
				age 		= new Integer(s2[1]);
				condition	= new Integer(s2[2]);
				recovery 	= new Integer(s2[3]);
				this.patients.add(new Patient(gender, age, condition));
				
			} else  {
				throw new Exception("The config file's format is not recognised");
			}
			
		}
	}
	
	public Hospital getHospital() {
		return this.hospital;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

}
