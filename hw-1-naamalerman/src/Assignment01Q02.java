

public class Assignment01Q02 {

	public static void main(String[] args) {
		// do not change this part below
		double piEstimation = 0.0;
		
		// *** your code goes here below ***
		int loops =  Integer.parseInt(args[0]);
		double step = 1.0;
		while (loops > 0) {
			if ((step+1)%4==0) {
				piEstimation -= (1/step);
			}
			else {
				piEstimation += (1/step);
			}
			step+=2.0;
			loops--;
		}
		// do not change this part below
		System.out.println(piEstimation*4 + " " + Math.PI);

	}

}
