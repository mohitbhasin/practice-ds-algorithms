import java.util.*;

class FindDuplicateFileInSystem {
	public static void main(String args[]) {
		String[] paths = {"data/files 1.csv(data1)","data/files/processed 2.csv(data2)","data/files/backup 3.csv(data1)","data/archives 4.csv(data3)","data/archives/old 5.csv(data2)"};
		System.out.println(findDuplicate(paths));
	}

	public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths) {
            String[] dirFiles = path.split(" ");
            String dir = dirFiles[0];
            for(int i=1; i<dirFiles.length; i++) {
            	String file = dirFiles[i];
            	int bracketIndex = file.indexOf("(");
                String fileName = file.substring(0,bracketIndex);
                String content = file.substring(bracketIndex+1, file.length()-1);
                
                if(!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(dir+"/"+fileName);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> value:  map.values()) {
            if(value.size()>1) {
                result.add(value);
            }
        }
        return result;
    }
}