public class Program {
	static int a = 10;
	static int f(int x) {
		return x +a;

	}
	public static void main(String[] args) {
		a = 3;
		System.out.println(f(1));
	}
}