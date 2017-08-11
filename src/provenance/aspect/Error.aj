package provenance.aspect;

import java.time.Instant;

public aspect Error {

    /*before (Throwable t): handler(Exception+) && args(t) {
		Instant now = Instant.now();
    	System.out.println("Exception Error in " + t.toString() + " at " + now);
    }*/
    
    before (Exception e): handler(Exception+) && args(e) {
    	Instant now = Instant.now();
    	System.out.println("Exception Error in " + e.toString() + " at " + now);
    }
	
}
