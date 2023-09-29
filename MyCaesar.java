
public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n; 
	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}
	public char encryptChar(char c) {
		int index = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return c;
		}
		int newIndex = (index + n) % ALPHABET.length;
		return ALPHABET[newIndex];
	}
	public String encrypt(String input) {
		input = input.toUpperCase();
		StringBuilder output = new StringBuilder();
		for (char c : input.toCharArray()) {
			output.append(encryptChar(c));
		}
		return output.toString();
	}
	public char decryptChar(char c) {
		int index = -1;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return c;
		}
		int newIndex = (index - n + ALPHABET.length) % ALPHABET.length;
		return ALPHABET[newIndex];
	}
	public String decrypt(String input) {
		input = input.toUpperCase();
		StringBuilder output = new StringBuilder();
		for (char c : input.toCharArray()) {
			output.append(decryptChar(c));
		}
		return output.toString();
	}
	public static void main(String[] args) {
		MyCaesar myCaesar = new MyCaesar(3);
		System.out.println(myCaesar.encryptChar('A')); 
		System.out.println(myCaesar.decryptChar('X')); 
		System.out.println(myCaesar.encryptChar('K')); 
		System.out.println(myCaesar.decryptChar('J')); 
		System.out.println(myCaesar.encryptChar(' ')); 
		System.out.println(myCaesar.decryptChar(' ')); 
		System.out.println(myCaesar.encryptChar('C')); 
		System.out.println(myCaesar.decryptChar('c')); 

		System.out.println(myCaesar.encrypt("HELLO WORLD"));
		System.out.println(myCaesar.decrypt("KHOOR ZRUOG")); 
		System.out.println(myCaesar.encrypt("THIS IS A TEST")); 
		System.out.println(myCaesar.decrypt("WKLV LV D WHVW")); 
	}
}
