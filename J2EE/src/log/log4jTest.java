package log;

import org.apache.log4j.Logger;

public class log4jTest {
	public static void main(String[] args){
		Logger log = Logger.getLogger(log4jTest.class );
		log.debug("this debug");
		log.error("error-message");
		log.info("this's info");
	}
}
