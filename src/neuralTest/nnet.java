//package neuralTest;
//
//
//import java.util.Random;
//
//
//public class nnet {
//	
//	static int size = 50;
//	static double[] x1 = new double [size];
//	static double[] x2 = new double [size];
//	static double[] lr1 = new double[size];
//	static boolean[] y = new boolean[size];
//
//	
//	public static void main(String args[]) {
//		for(int i = 0; i < size; i++) {
//			x1[i] = Math.random();
//			x2[i] = Math.random();
//			lr1[i] = Math.sqrt(x1[i]) + Math.sqrt(x2[i]) - 1.5;
//			y[i] = lr1[i] > 0;
//			System.out.print(y[i] + " ");
//		}
//	}
//	
//	
//	static double[] s = new double[size]; 
//	
//	public static double[] Sfun(double[] x ) {
//		
//		double eps = Math.pow(10, -5);
//		
//		for(int i = 0 ; i < size; i++ ) {
//			s[i] = 1/(1+Math.exp(-x[i]));
//			if(s[i]<eps) {
//				s[i] = eps;
//			}
//			else {
//				s[i] = 1 - eps;
//			}	
//		}
//		return(s);
//	}
//		
//
//		
//	public static double[] h1fun(double[] w10,double[] w11,double[] w12) {
//		double[] L1 = new double[size];
//		for(int i = 0 ; i < size; i++) {
//			L1[i] = w10[i] + w11[i] * x1[i] + w12[i] * x2[i];
//		}
//		return(Sfun(L1));
//		
//	}
//	
//	public static double[] h2fun(double[] w20,double[] w21,double[] w22) {
//		double[] L2 = new double[size];
//		for(int i = 0 ; i < size; i++) {
//			L2[i] = w20[i] + w21[i] * x1[i] + w22[i] * x2[i];
//		}
//		return(Sfun(L2));
//		
//	}
//	public static double[] ofun(double[] w30,double[] w31,double[] w32, double[] h1, double h2[]) {
//		double[] L3 = new double[size];
//		for(int i = 0 ; i < size; i++) {
//			L3[i] =  w30[i] + w31[i] * h1[i] + w32[i] * h2[i];
//		}
//		return(Sfun(L3));
//		
//	}
//	
//	public static double lossfun(double[] o) {
//		int j;
//		double loss = 0;
//		for(int i = 0 ; i < size; i++) {
//			if(y[i] == true) {
//				j = 1;
//			}
//			else {
//				j = 0;
//			}
//			 loss = loss - 1/y.length * (j * Math.log(o[i]) + (1 - j) * Math.log(1 - o[i]));
//		}
//		return loss;
//	}
//
//	
//	public static differentialFunw30
//	
//
//	differential.fun.w30 = function(o, y = y) {
//		return(-1/length(y)*sum(y-o))
//	}
//
//	differential.fun.w31 = function(o, h1, y = y) {
//		return(-1/length(y)*sum((y-o)*h1))
//	}
//
//	differential.fun.w32 = function(o, h2, y = y) {
//		return(-1/length(y)*sum((y-o)*h2))
//	}
//
//	differential.fun.w20 = function(o, h2, w32, y = y) {
//		return(-1/length(y)*sum((y-o)*w32*h2*(1-h2)))
//	}
//
//	differential.fun.w21 = function(o, h2, w32, y = y, x1 = x1) {
//		return(-1/length(y)*sum((y-o)*w32*h2*(1-h2)*x1))
//	}
//
//	differential.fun.w22 = function(o, h2, w32, y = y, x2 = x2) {
//		return(-1/length(y)*sum((y-o)*w32*h2*(1-h2)*x2))
//	}
//
//	differential.fun.w10 = function(o, h1, w31, y = y) {
//		return(-1/length(y)*sum((y-o)*w31*h1*(1-h1)))
//	}
//
//	differential.fun.w11 = function(o, h1, w31, y = y, x1 = x1) {
//		return(-1/length(y)*sum((y-o)*w31*h1*(1-h1)*x1))
//	}
//
//	differential.fun.w12 = function(o, h1, w31, y = y, x2 = x2) {
//		return(-1/length(y)*sum((y-o)*w31*h1*(1-h1)*x2))
//	}
//
//
//}
