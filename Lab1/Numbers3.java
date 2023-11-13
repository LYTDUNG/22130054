
public class Numbers3 {
	public static int getS3(int n) {
		//S(n)=1^2+2^2+3^2+....+n^2 , n >0 
				
		if (n == 1) {
			return 1;
		}
		return n * n + getS3(n - 1);
	}
	public static void main(String[] args) {
		// Khai báo và gán giá trị cho n
		int n = 3; 
		if (n > 0) {
			int s = getS3(n);
			System.out.println("S(" + n + ") = " + s);
		} else {
			System.out.println("Vui lòng nhập n > 0");
		}
	}
}
