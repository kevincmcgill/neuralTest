package neuralTest;

public class connect {

	public static void main(String[] args) {


	}


	public static int MLCal (double[] input) {	
		
		//parameters
		double [][] fc1Weight = {{0.071791708,-0.273520201,0.209405884,0.195195079, 			-1.121803045	, 			-0.996459961	, 			0.594318748	, 			-0.309516639	, 			-1.338285089	, 			-1.883283019	, 			-1.113033533	, 			-0.1713797	, 			-0.01577769	, 			-0.014156765	, 			-0.002883073	, 			-0.001924099	, 			0.000884003	, 			-0.002898041	, 			0.010487561	, 			0.001051584	, 			0.000437031	, 			0.00332519	, 			-0.005168776	, 			0.001920618	, 			0.014992776	, 			0.001920314	, 			-0.012455763	, 			-0.015181897	, 			-0.015036445	, 			0.003294797	, 			-0.000655362	, 			-0.007562938	, 			-0.000557545	, 			-0.003645791	, 			-0.002838991	, 			-0.002225966	},
				{0.322245032	, 				0.542218029	, 				-1.475345016	, 				-0.884903848	, 				0.882239282	, 				-1.088714719	, 				-0.16587843	, 				-0.512780726	, 				-0.632877171	, 				-0.725718021	, 				-0.158854783	, 				-0.056672558	, 				-0.027033886	, 				-0.008661306	, 				-0.017975984	, 				0.003737505	, 				-0.00704545	, 				0.007667117	, 				0.006916017	, 				0.006850094	, 				-0.011783908	, 				0.004049529	, 				-0.001875732	, 				0.003250984	, 				0.014310873	, 				-0.001892314	, 				-0.001696224	, 				-0.002976529	, 				-0.01085856	, 				-0.000336136	, 				-0.001807211	, 				-0.009280751	, 				0.004591503	, 				0.004324209	, 				0.006530917	, 				-0.002072874	},
				{-0.119724207	, 					0.975386143	, 					-0.145098701	, 					-0.605136037	, 					0.493678272	, 					-0.637068391	, 					-0.739637494	, 					0.209786251	, 					-0.51344043	, 					-0.846280217	, 					-0.132942826	, 					-0.009992044	, 					-0.01234982	, 					-0.007055669	, 					-0.002471291	, 					0.003669044	, 					0.011077397	, 					-0.008513085	, 					-0.00282329	, 					0.006509914	, 					-0.00314883	, 					-0.007842547	, 					-0.007368789	, 					0.000508582	, 					-0.00902913	, 					-0.008432669	, 					0.003158953	, 					0.008495963	, 					-0.006984553	, 					0.008239323	, 					-0.003509283	, 					-0.004746191	, 					-0.000543773	, 					0.001631273	, 					-0.008747756	, 					0.001240238	}};

		
		double[][] fc2Weight = {{1.558101892	,	1.135969877	,	1.699363351	},
				{-1.556752801,-1.135006785,-1.704803467}};
		
		double [] fc1Bias = {0.007558372	,-0.065355577	,	-0.024339819	};
		double [] fc2Bias = {-1.071723938,1.071723938};
		//declare first layer output
		double[] fc1Output = {0,0,0};
		//first layer calculation
		for(int j = 0; j < 3; j ++) {
			for(int i = 0 ; i <input.length;i++) {
				fc1Output[j] = fc1Output[j] + fc1Weight[j][i]*input[i];
			}	
			fc1Output[j] = fc1Output[j] +fc1Bias[j] ;
		}
		//declare second layer output
		double fc2Output [] = {0,0};
		//second layer calculation
		for(int j = 0; j < 2; j ++) {
			for(int i = 0 ; i <input.length;i++) {
				fc2Output[j] = fc2Output[j] + fc2Weight[j][i]*input[i];
			}	
			fc2Output[j] = fc2Output[j] +fc2Bias[j] ;
		}
		
		//throw in second layer output and get softmax output
		double [] output  = softmax(fc2Output);
		
		//if the first one has larger probability return 0, else return 1
		if(output[0]>output[1]) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	
	
	public static double[] softmax (double [] input) {
		//declare output
		double [] output = new double [input.length];
		double sum = 0;
		//find the sum of the exponential of all numbers in input
		for(int i = 0 ;  i < input.length; i++) {
			sum = sum + Math.exp(input[i]);
		}
		//divide the input number by the sum
		for(int i = 0 ; i< output.length; i++) {
			output[i] = input[i]/sum; 
		}
		//return output
		return output;
	}


}
