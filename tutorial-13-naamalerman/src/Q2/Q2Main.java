package Q2;

import java.util.*;

record MyFile(String name, long size, long created) {
 public String toString() {
	return "'" + name + "' | " + size + " | " + created;
 }
}


public class Q2Main {

	public static SortedMap<String, List<MyFile>> createReport(List<MyFile> files, Comparator<MyFile> comp) {
		SortedMap<String, List<MyFile>> report = new TreeMap<>();
		
//		Collections.sort(files, comp);
        
		for (MyFile mFile: files) {
			String name = mFile.toString().split("[|]")[0];
			String suffix = name.split("[.]")[1];
			List<MyFile> updateMFileList = report.get(suffix);
			if (updateMFileList==null) {
				updateMFileList = new ArrayList<>();
			}
			updateMFileList.add(mFile);
			report.put(suffix, updateMFileList);
		}
		
		for (String suffix: report.keySet()) {
			
			List<MyFile> suffixList = report.get(suffix);
			Collections.sort(suffixList, comp);
			
		}
		
		return report;
    }
	
	public static void main(String[] args) {
		String [] filenames = {"b.java","hello.java", "a.java", "a.class","b.class", "emma.txt", "hello.jar"};
		int idx1 = 1273;
		int idx2 = 2466;
		List<MyFile> files = new ArrayList<>();
		for (String f: filenames) {
			files.add(new MyFile(f, idx1, idx2));
			idx1 += 17;
			idx2 += 191;
		}
		
		SortedMap<String, List<MyFile>> report = createReport(files, (x, y) -> Long.compare(x.created(), y.created()));
		for (String type : report.keySet()) { // Returns a set, but sorted
			System.out.println("*." + type);
			for (MyFile f : report.get(type)) {
				System.out.println("\t" + f.toString());
			}
		}
	}

}



