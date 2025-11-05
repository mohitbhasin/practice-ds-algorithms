class FileSystemMain {
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		System.out.println(fs.ls("/"));
		fs.mkdir("/a/b");
		fs.addContentToFile("/a/b/c","hello world");
		System.out.println(fs.ls("/a/b"));
		System.out.println(fs.readContentFromFile("/a/b/c"));
	}
}