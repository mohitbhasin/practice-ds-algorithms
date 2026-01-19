class RandomPickIndexMain {
	public static void main(String[] args) {
		RandomPickIndex obj = new RandomPickIndex(new int[] {1,2,3,3,3});
		int[] picks = {3,1,3};
		for(int num: picks) {
			System.out.println(obj.pick(num));
		}
		System.out.println("-----------------");
		obj = new RandomPickIndex(new int[] {3,3,3,3,3});
		picks = new int[]{3,3,3,3,3};
		for(int num: picks) {
			System.out.println(obj.pick(num));
		}
	}
}