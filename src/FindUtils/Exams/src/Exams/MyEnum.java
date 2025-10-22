package Exams;

import java.util.Arrays;
import java.util.List;

public enum MyEnum{
	PLUS, MINUS, TIMES;
	
	
	
	public double calc(double x1, double x2) {
		double ens = 0;
		switch(this) {
		case PLUS:
			ens = x1+x2;
			break;
		case MINUS:
			ens = x1-x2;
		case TIMES:
			ens = x1*x2;
		default: throw new RuntimeException("no such Oper: "+ this);
		}
		return ens;
	}
	
}
