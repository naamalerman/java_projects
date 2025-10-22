package FindUtils.SearchAlgs;

public class LinearSearch {

	/**
	 * @param arr an array sorted in an arbitrary order
	 * @param x a number to be searched in arr
	 * @return the index of x in arr, or -1 if x is not found
	 * 
	 * @pre "arr is sorted in ascending order"
	 */
	public static int find(int [] arr, int x)
	{
		for (int i=0; i <arr.length; ++i)
		{
			if (arr[i]==x)
				return i; 
		}
		return -1;
	}

}
