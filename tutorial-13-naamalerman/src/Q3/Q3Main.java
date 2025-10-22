package Q3;

import java.util.*;

public class Q3Main {

	public static void main(String[] args) {
		
		
		class PrimeCollection implements Iterable<Integer>{
			public int k;
			public PrimeCollection(int k) {
				this.k = k;
				
			}
			
			public Iterator<Integer> iterator(){
				return new PrimeCollectionIterator();
			}
			
			class PrimeCollectionIterator implements Iterator<Integer>{
				public int counter = 0;
				public int prePrime = 0;

				@Override
				public boolean hasNext() {
					return counter<k;
				}

				@Override
				public Integer next() {
					boolean flag = true;
					while (flag){
						flag = isNotPrime(++prePrime);
					}
					counter++; 
					return prePrime;
				}
				
				public boolean isNotPrime(int i) {
					for (int j=0; j<Math.sqrt(i); j++) {
						if (i%j == 0) {
							return true;
						}
					}
					return false;
				}
				
			}
		}
	}

}

