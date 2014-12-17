/*public class TestHarness {
	public static void testHospital() {
		Hospital var1 = new Hospital();
		assertEquals("Expecting 0 from var1.size()", var1.size(), 0);
		Patient var2 = new Patient('a', 7);
		assertEquals("Expecting 0 from var1.admitPatient(var2)",
				var1.admitPatient(var2), 0);
		assertEquals("Expecting null from var1.getPatient(7)",
				var1.getPatient(7), null);
		var1.dischargePatient(7);

		assertEquals("Expecting false from var1.isTheatreFree(7)",
				var1.isTheatreFree(7), false);
		Patient var3 = new Patient('a', 7);
		var1.prepForTheatre(2, var3);

		var1.takeForRecovery(7);

		assertEquals("Expecting false from var1.aDayPasses()",
				var1.aDayPasses(), false);
	}

	public static void testPatient() {
		Patient var4 = new Patient('a', 7);
		assertEquals("Expecting false from var4.aDayPasses()",
				var4.aDayPasses(), false);
	}
	
	public static void testHospitalAdvanced() {
		Hospital h = new Hospital();
		
		// Testing beds
		assertEquals("Empty hospital should have zero Patients.", h.size(), 0);
		for(int i=0; i<50; i++) {
			assertEquals("Adding patient #"+i+" should return: "+i, h.admitPatient(new Patient('m', 20)), i);
		}
		assertEquals("Adding patient #50 should return -1, as Hospital is full.", h.admitPatient(new Patient('m', 20)), -1);
		assertEquals("Full hospital should have 50 Patients.", h.size(), 50);
		//System.out.println("Removing patient in bed 17.");
		h.dischargePatient(17);
		assertEquals("After discharging 1 Patient, there should be 49.", h.size(), 49);
		assertEquals("Patient 17 has been discharged, that bed should be null.", h.getPatient(17), null);
		Patient f25 = new Patient('f', 25);
		 // this assumes that new Patients go in the first gap 
		assertEquals("This test harness assumes a new Patient should go in first gap, 17.", h.admitPatient(f25), 17);
		assertEquals("Hospital should be full now.", h.size(), 50);
		assertEquals("Getting patient in bed 17 (should be "+f25+"): ", h.getPatient(17), f25);
		
		
		// Test operating theatres
		assertEquals("There is no theatre 4, assuming zero-indexing.", h.isTheatreFree(4), false);
		assertEquals("Theatre 3 should currently be empty.", h.isTheatreFree(3), true);
		//System.out.println("Putting f25 in theatre 0");
		h.prepForTheatre(0, f25);
		assertEquals("Just put Patient in Theatre 0, so should not be free.", h.isTheatreFree(0), false);
		//System.out.println("Emptying theatre 0");
		h.takeForRecovery(0);
		assertEquals("Patient in Theatre 0 has been taken for recovery.", h.isTheatreFree(0), true);
	}

	static int passed = 0;
	static int failed = 0;

	public static void main(String[] args) {
		testHospital();
		testPatient();
		testHospitalAdvanced();
		if (failed > 0)
			System.out.println("FAILURES!");
		System.out.println("Tests run: " + (passed + failed) + ",  Failures: "
				+ failed);
	}

	private static void assertEquals(String message, Object expected,
			Object actual) {
		if ((expected != null && expected.equals(actual))
				|| (expected == null && actual == null)) {
			System.out.println("[PASS] ");
			passed++;
		} else {
			System.out.println("[FAIL] " + message);
			failed++;
		}
	}

	private static void fail(String message) {
		System.out.println("[FAIL] " + message);
		failed++;
	}
}*/