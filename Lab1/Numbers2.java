public class Numbers2 {
	public static int getS2(int n) {
		//s(n)=1+1.2+1.2.3-1.2.3.4+...+1.2.3...n,n>0
		if (n == 1) {
			return 1;
		}
		return n*getS2(n-1);
	}
	public static void main(String[] args) {
		// Khai báo và gán giá trị cho n
		int n = 4; // Có thể thay đổi giá trị này để kiểm tra các trường hợp khác nhau
		if (n > 0) {
			int s = getS2(n);
			System.out.println("S(" + n + ") = " + s);
		} else {
			System.out.println("Vui lòng nhập n > 0");
		}
	}
}

