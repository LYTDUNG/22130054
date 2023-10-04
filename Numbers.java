
public class Numbers {
	public static int getS(int n) {
		//s(n)=1-2+3-4+...+((-1)^(n+1).n,n>0
		if (n == 1) {
			return 1;
		}
		return n * (int) Math.pow(-1, n + 1) + getS(n - 1);
	}
	public static void main(String[] args) {
		// Khai báo và gán giá trị cho n
		int n = 5; //Có thể thay đổi giá trị này để kiểm tra các trường hợp khác nhau
		if (n > 0) {
			int s = getS(n);
			System.out.println("S(" + n + ") = " + s);
		} else {
			System.out.println("Vui lòng nhập n > 0");
		}
	}
}

