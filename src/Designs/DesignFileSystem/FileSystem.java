import java.util.*;

class FileSystem {
    Map<String, Integer> map;
    Set<String> set;
    
    public FileSystem() {
        map = new HashMap<>();
        set = new HashSet<>();
    }
    
    public boolean createPath(String path, int value) {
        if(map.containsKey(path)) return false;
        String[] dirs = path.split("/");
        int i=1;
        while(i<dirs.length-1) {
            if(!set.contains(dirs[i])) {
                return false;
            }
            i++;
        }
        set.add(dirs[i]);
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        if(map.containsKey(path)) {
            return map.get(path);
        }
        return -1;
    }
}