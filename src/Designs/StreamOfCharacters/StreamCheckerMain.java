class StreamCheckerMain {
	public static void main(String[] args) {
		StreamChecker obj = new StreamChecker(new String[] {"a","abcdefg","mnopqr"});
		System.out.println(obj.query('a'));
		System.out.println(obj.query('b'));
		System.out.println(obj.query('c'));
		System.out.println(obj.query('d'));
		System.out.println(obj.query('e'));
		System.out.println(obj.query('f'));
		System.out.println(obj.query('g'));
		System.out.println(obj.query('m'));
		System.out.println(obj.query('n'));
		System.out.println(obj.query('o'));
		System.out.println(obj.query('p'));
		System.out.println(obj.query('q'));
		System.out.println(obj.query('r'));
	}
}