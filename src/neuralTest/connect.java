package neuralTest;

public class connect {

	public static void main(String[] args) {
		

	}

	
	public static int MLCal (double[] input) {	
		if() {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	public static double[] softmax (double [] input) {
		double [] output = new double [input.length];
		double sum = 0;
		for(int i = 0 ;  i < input.length; i++) {
			sum = sum + Math.exp(input[i]);
		}
		for(int i = 0 ; i< output.length; i++) {
			output[i] = input[i]/sum; 
		}
		return output;
	}
}
