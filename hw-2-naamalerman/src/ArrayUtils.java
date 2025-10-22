public class ArrayUtils {
	public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
		if (direction=='L') move*=(-1);
		else if (direction!='R') move = 0;
		
		int leng  = array.length;
		int[] dup = new int[leng];
		for (int i=0; i<leng; i++) {
			dup[i] = array[i];
		}
		
		for (int i=0; i<leng; i++) {
			int iNext = i+move;
			while (iNext<0) {
				iNext += leng;
			}
			System.out.print(iNext);
			array[iNext%leng] = dup[i];
		}
		return array; //Replace this with the correct returned value
	}
	
	public static int findShortestPath_rec(int[][] m, int i, int j, String path, int[][] pathMatrix) {
		if (i==j) return 0;
		
		for (int k = 0; k<m.length; k++) {
			if (! path.contains(String.valueOf(k))) {
				if (pathMatrix[i][k]==0) {
					if (m[i][k] == 1) {
						path+=k;
						int pathLeng = 1+findShortestPath_rec(m, k, j, path, pathMatrix);
						pathMatrix[i][k] = pathLeng;
						path = path.substring(0,path.length()-1);
					}
				}
			}
		}
		int minK = m.length+1;
		for (int k = 0; k<m.length; k++) {
			if (pathMatrix[i][k] < minK && pathMatrix[i][k]!=0) {
				minK=pathMatrix[i][k];
			}
		}
		if (minK==m.length+1) return -1;
		return minK;
	}

	public static int findShortestPath(int[][] m, int i, int j) {
		int[][] pathMatrix = new int[m.length][m.length];
		
		String path = i + "";
		
		return findShortestPath_rec(m, i, j, path, pathMatrix); //Replace this with the correct returned value

	}
	
}
