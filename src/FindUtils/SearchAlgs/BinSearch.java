package FindUtils.SearchAlgs;

public class BinSearch {

	/**
	 * @param arr an array sorted in an ascending order
	 * @param x a number to be searched in arr
	 * @return the index of x in arr, or -1 if x is not found
	 * 
	 * @pre "arr is sorted in ascending order"
	 */
	public static int find(int [] arr, int x)
	{
		int left =0;
		int right = arr.length;
		while (left <right)
		{
			int mid = (left + right)/2;
			if (arr[mid] == x)
				return mid;
			if (arr[mid] > x)
			{
				right = mid-1;
			}
			else 
			{
				left = mid+1;
			}
		}
		return -1;
	}
}
