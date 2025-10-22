package il.ac.tau.cs.sw1.polynomial;

public class Polynomial {
	double[] polynomial;
	/*
	 * Creates the zero-polynomial with p(x) = 0 for all x.
	 */
	public Polynomial()
	{
		this.polynomial = new double[] {0.0};
	} 
	
	public int cutZeros(double[] coefficients) {
		int i = coefficients.length;
		while (i>1 && coefficients[i-1]==0) {
			i--;
		}
		return i;
	}
	
	/*
	 * Creates a new polynomial with the given coefficients.
	 */
	public Polynomial(double[] coefficients) 
	{
		int i = this.cutZeros(coefficients);
		this.polynomial = new double[i];
		System.arraycopy(coefficients, 0, this.polynomial, 0, i);
	}
	
	/*
	 * Addes this polynomial to the given one
	 *  and retruns the sum as a new polynomial.
	 */
	public static void addsArray(double[] arr1, double[] arr2, double[] addArray) {
		int i = 0;
		for (;i<arr1.length;i++) {
			addArray[i]=arr1[i]+arr2[i];
		}
		for (;i<arr2.length;i++) {
			addArray[i] = arr2[i];
		}
	}
	
	public Polynomial adds(Polynomial polynomial)
	{
		double[] polynomialDouble = polynomial.polynomialToDouble();
		
		double[] add_polynomial = new double[Math.max(this.polynomial.length, polynomialDouble.length)];
		
		if (this.polynomial.length>=polynomialDouble.length) {
			addsArray(polynomialDouble, this.polynomial, add_polynomial);
		}
		else {addsArray(this.polynomial, polynomialDouble, add_polynomial);}
		
		return new Polynomial(add_polynomial);
		
	}
	/*
	 * Multiplies a to this polynomial and returns 
	 * the result as a new polynomial.
	 */
	public Polynomial multiply(double a)
	{
		double[] multi_polynomial = new double[this.polynomial.length];
		for (int i=0;i<this.polynomial.length;i++) {
			multi_polynomial[i] = this.polynomial[i]*a;
		}
		return new Polynomial(multi_polynomial);
		
	}
	/*
	 * Returns the degree (the largest exponent) of this polynomial.
	 */
	public int getDegree()
	{
		return this.polynomial.length-1;
	}
	/*
	 * Returns the coefficient of the variable x 
	 * with degree n in this polynomial.
	 */
	public double getCoefficient(int n)
	{
		if (this.polynomial.length>n && n>=0) {
			return this.polynomial[n];
		}
		return 0.0f;
	}
	
	/*
	 * set the coefficient of the variable x 
	 * with degree n to c in this polynomial.
	 * If the degree of this polynomial < n, it means that that the coefficient of the variable x 
	 * with degree n was 0, and now it will change to c. 
	 */
	public void setCoefficient(int n, double c)
	{
		if (this.polynomial.length<n) {
			double[] newPolynomial = new double[n+1];
			newPolynomial[n] = c;
			addsArray(this.polynomial, newPolynomial, newPolynomial);
			this.polynomial = newPolynomial;
		}
		else {this.polynomial[n] = c;}
		
		int i = this.cutZeros(this.polynomial);
		double[] copyArray = new double[i];
		System.arraycopy(this.polynomial, 0, copyArray, 0, i);
		this.polynomial = copyArray;
		
		
	}
	
	/*
	 * Returns the first derivation of this polynomial.
	 *  The first derivation of a polynomal a0x0 + ...  + anxn is defined as 1 * a1x0 + ... + n anxn-1.
	
	 */
	public Polynomial getFirstDerivation()
	{
		double[] polynomialDerivation = new double[this.getDegree()];
		for (int i=1; i<this.polynomial.length;i++) {
			double t =this.getCoefficient(i)*i;
			polynomialDerivation[i-1] = t;
		}
		int i = this.cutZeros(polynomialDerivation);
		if (i==0) {
			return new Polynomial();
		}
		return new Polynomial(polynomialDerivation);
	}
	
	/*
	 * given an assignment for the variable x,
	 * compute the polynomial value
	 */
	public double computePolynomial(double x)
	{
		double value = 0.0;
		for (int i=0;i<this.polynomial.length;i++) {
			value+=(this.getCoefficient(i)*Math.pow(x, i));
		}
		return value;
	}
	
	/*
	 * given an assignment for the variable x,
	 * return true iff x is an extrema point (local minimum or local maximum of this polynomial)
	 * x is an extrema point if and only if The value of first derivation of a polynomal at x is 0
	 * and the second derivation of a polynomal value at x is not 0.
	 */
	public boolean isExtrema(double x)
	{
		Polynomial polynomialDerivation = this.getFirstDerivation();
		Polynomial secoundDerivation = polynomialDerivation.getFirstDerivation();
		if (polynomialDerivation.computePolynomial(x)==0.0 && secoundDerivation.computePolynomial(x)!=0.0) {
			return true;
		}
		return false;
	}
	/*
	 * return the double[] represent of Polynomial object.
	 */
	
	public double[] polynomialToDouble() {
		return this.polynomial;
	}
	
	
	
	

    
    

}
