import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Illness {

	protected int id;
	protected String name;
	protected int recoveryTime;
	protected boolean theatreRequired;
	
	
	public static final List<Illness> ILLNESSES = Collections.unmodifiableList(
		    new ArrayList<Illness>() {{
		        add( new Illness(1, "Djkstra’s syndrome", 5, false) );
		        add( new Illness(2, "Java Flu", 3, false) );
		        add( new Illness(3, "Deadline Panic Attacks", 5, false) );
		        add( new Illness(4, "Polymorphic Cist", 5, true) );
		        add( new Illness(5, "Semicolon Missing", 5, true) );
		        add( new Illness(6, "Trapped Exception", 5, true) );
		        add( new Illness(7, "Tim Berners Knee", 5, true) );
		        add( new Illness(8, "Coder's Elbow", 5, true) );
		    }});
	
	
	public Illness(int id, String name, int recoveryTime,
			boolean theatreRequired) {
		super();
		this.id = id;
		this.name = name;
		this.recoveryTime = recoveryTime;
		this.theatreRequired = theatreRequired;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRecoveryTime() {
		return recoveryTime;
	}


	public void setRecoveryTime(int recoveryTime) {
		this.recoveryTime = recoveryTime;
	}


	public boolean isTheatreRequired() {
		return theatreRequired;
	}


	public void setTheatreRequired(boolean theatreRequired) {
		this.theatreRequired = theatreRequired;
	}
	
	
	
}
