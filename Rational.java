/**
 * @author Shashi Kumar Kadari Mallikarjuna
 */
package Assignment1;
import java.util.Scanner;
/** Class description of Rational*/
public class Rational {	
	private int numerator;
	private int denominator;
	/**Constructor description of Rational and initializing the variables*/
	public Rational() {
		numerator=0;
		denominator=1;
	}
	/** It is a constructor which assigns two parameters to the numerator and the denominator
	 * @param num The parameter with which the numerator is replaced with
	 * @param den The parameter with which the denominator is replaced with
	 */
	public Rational(int num, int den) {
		numerator=num;
		denominator=den;
	}
	/**This method is used to get the numerator
	 * @return numerator It returns the numerator
	 */
	public int getNumerator() {
		return numerator;
	}
	/**This method is used to get the denominator
	 * @return denominator It returns the denominator
	 */
	public int getDenominator() {
		return denominator;
	}
	/**This method updates the numerator with a new value
	 * @param value It is the new number that the numerator should be updated with
	 */
	public void setNumerator(int value) {
		numerator=value;
	}
	/**This method updates the denominator with a new value
	 * @param value It is the new number that the denominator should be updated with
	 */
	public void setDenominator(int value) {
		denominator=value;
	}
	/**This method is used get the numerator and the denominator from the user */
	public void inputRational() {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter the numerator: ");
		numerator=in.nextInt();
		System.out.print("Enter the denominator: ");
		denominator=in.nextInt();
	}
	/**This method is used to convert the numerator and the denominator into string and return the string in the form of numerator/denominator
	 * @return the numerator/denominator in string
	 */
	public String toString() {
		String num=Integer.toString(numerator);
		String den=Integer.toString(denominator);
		if(num.equals("0")|| den.equals("1"))
			return num;
		else
			return num+"/"+den;
	}
	/**This method is used return the greatest common divisor
	 * @param m It is the numerator
	 * @param n It is the denominator
	 * @return The greatest common divisor
	 */
	private int gcd(int m, int n) {
		int r;
		while(n!=0) {
			r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	/**This method is used to perform the addition of two rational numbers
	 * @param r1 It is the first rational number
	 * @param r2 It is the second rational number
	 */
	public void add(Rational r1, Rational r2) {
		numerator= r1.numerator*r2.denominator+r2.numerator*r1.denominator;
		denominator=r1.denominator*r2.denominator;
		int GCD= gcd(numerator,denominator);
		numerator=numerator/GCD;
		denominator=denominator/GCD;
	}
	/**This method is used to perform subtraction of two rational number
	 * @param r It is the number which needs to be subtracted from
	 * @return The result of the subtraction is returned
	 */
	public Rational sub(Rational r) {
		int tempnum=numerator*r.denominator-denominator*r.numerator;
		int tempden=denominator*r.denominator;
		int GCD= gcd(tempnum,tempden);
		tempnum=tempnum/GCD;
		tempden=tempden/GCD;
		return new Rational(tempnum,tempden);
	}
	/**This method is used to perform multiplication of two rational numbers
	 * @param r1 It is the first rational number
	 * @param r2 It is the second rational number
	 */
	public void mul(Rational r1,Rational r2) {
		numerator=r1.numerator*r2.numerator;
		denominator=r1.denominator*r2.denominator;
		int GCD= gcd(numerator,denominator);
		numerator=numerator/GCD;
		denominator=denominator/GCD;
	}
	/**This method is used to perform division of two rational number
	 * @param R It is the number which needs to be divided from
	 * @return The result of the subtraction is returned
	 */
	public Rational div(Rational R) {
		int tempnum=numerator*R.denominator;
		int tempden=denominator*R.numerator;
		int GCD= gcd(tempnum,tempden);
		tempnum=tempnum/GCD;
		tempden=tempden/GCD;
		return new Rational(tempnum, tempden);
	}
	/**This method is used to perform real division of two rational numbers
	 * @param r1 It is the first rational number
	 * @param r2 It is the second rational number
	 * @return The result is returned in the form of double
	 */
	public static double divToDouble(Rational r1, Rational r2) {
		Rational r3=r1.div(r2);
		double n=r3.numerator;
		return n/r3.denominator;
	}
	/**This is the main method which calls all the above method
	 * @param args Empty Array of string data type
	 */
	public static void main(String [] args) {
		Rational r1=new Rational();
		Rational r2=new Rational();
		Rational r3=new Rational();
		System.out.println("For the first Rational number,");
		r1.inputRational();
		System.out.println("\nFor the second Rational number,");
		r2.inputRational();
		r3.add(r1, r2);
		System.out.println("\n Addition\n"+ r1.toString()+" + "+r2.toString()+" = "+r3.toString());
		r3=new Rational();
		r3=r1.sub(r2);
		System.out.println("\n Subtraction\n"+r1.toString()+" - "+r2.toString()+" = "+r3.toString());
		r3=new Rational();
		r3.mul(r1, r2);
		System.out.println("\nMultplication\n"+r1.toString()+" * "+r2.toString()+" = "+r3.toString());
		r3=new Rational();
		r3=r1.div(r2);
		System.out.println("\n Division\n"+r1.toString()+" / "+r2.toString()+" = "+r3.toString());
		Double r=divToDouble(r1, r2);
		System.out.println("\n Real Division \n"+r1.toString()+" / "+r2.toString()+" = "+r);
		r1.setNumerator(2);
		r2.setDenominator(5);
		System.out.println("\nNumerator of r1: "+r1.getNumerator());
		System.out.println("\nDenominator of r2: "+r2.getDenominator());
	}
}
