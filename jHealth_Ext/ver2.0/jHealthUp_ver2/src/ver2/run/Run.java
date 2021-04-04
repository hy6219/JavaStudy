package ver2.run;

import java.io.IOException;

import ver2.controller.HealthController;

public class Run {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HealthController hc = new HealthController();
		hc.init();
		hc.execute();
	}

}
