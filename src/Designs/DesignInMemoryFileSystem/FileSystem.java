import java.util.*;
public class FileSystem {
    Node root;

    public FileSystem() {
        root = new Node();
    }
    public List <String> ls(String path) {
        String[] locs = path.split("/");
        Node curr = root;
        for(int i=1; i<locs.length; i++) {
            if(curr.map.containsKey(locs[i])) {
                curr = curr.map.get(locs[i]);
            } else {
                return new ArrayList<>();
            }
        }
        Collections.sort(curr.objectList);
        return curr.objectList;
    }

    public void mkdir(String path) {
        Node curr = root;
        String[] locs = path.split("/");
        for(int i=1; i<locs.length; i++) {
            if(!curr.map.containsKey(locs[i])) {
                curr.map.put(locs[i], new Node());
                curr.objectList.add(locs[i]);
            }
            curr = curr.map.get(locs[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Node curr = root;
        String[] locs = filePath.split("/");
        for(int i=1; i<locs.length-1; i++) {
            if(!curr.map.containsKey(locs[i])) {
                curr.map.put(locs[i], new Node());
            }
            curr = curr.map.get(locs[i]);
        }
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
        if(curr.filesContentMap.containsKey(fileName)) {
            String fileContent = curr.filesContentMap.get(fileName);
            curr.filesContentMap.put(fileName, fileContent + content);
        } else {
            curr.filesContentMap.put(fileName, content);
            curr.objectList.add(fileName); 
        }
    }

    public String readContentFromFile(String filePath) {
        Node curr = root;
        String[] locs = filePath.split("/");
        for(int i=1; i<locs.length-1; i++) {
            if(!curr.map.containsKey(locs[i])) {
                return "";
            }
            curr = curr.map.get(locs[i]);
        }
        String file = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
        return curr.filesContentMap.get(file);
    }
}

class Node {
    Map<String, Node> map;
    List<String> objectList;
    Map<String, String> filesContentMap;

    public Node() {
        map = new HashMap<>();
        objectList = new ArrayList<>();
        filesContentMap = new HashMap<>();
    }
}