import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BasicJava2TestForEclipse {
	String filename = "src/BasicJava2.java";

	private boolean containsImportStatement() {
		boolean containsImport = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !containsImport) {
				if (line.matches("import+\\s.*")) {
					containsImport = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return containsImport;
	}
	
	/**
	Checks if the specified library is used anywhere in the code tested.  It checks
	for the word exactly.  If there is a variable name that contains the library name,
	this will result in a false positive.
	*/
	private boolean usesLibrary(String libraryName) {
		boolean usesLibrary = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesLibrary) {
				if (line.contains(libraryName)) {
					usesLibrary = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesLibrary;	
	}
	
	/**
		Checks if the coding construct is used in the class we're testing.  It expects the 
		construct to be preceded and followed by white space or parenthesis.
	*/
	private boolean usesConstruct(String constructName) {
		boolean usesConstruct = false;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			while (line != null && !usesConstruct) {
				if (line.matches(".*\\s+if+[\\s+,(].*")) {
					usesConstruct = true;
				} 
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return usesConstruct;	
	}
		
	@Test
	public void test_match_a_A() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = BasicJava2.match('a','A');
		
		assertEquals("Checking if a and A match", expected, actual);
	}

	@Test
	public void test_match_z_Z() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = true;
		boolean actual = BasicJava2.match('z', 'Z');
		
		assertEquals("Checking if z and Z match", expected, actual);
	}

	@Test
	public void test_match_f_f() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = false;
		boolean actual = BasicJava2.match('f','f');
		
		assertEquals("Checking if f and f match", expected, actual);
	}

	@Test
	public void test_match_Y_9() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = false;
		boolean actual = BasicJava2.match('9','Y');
		
		assertEquals("Checking if 9 and Y match", expected, actual);
	}

	@Test
	public void test_match_A_a() {
		assertFalse("Don't use the Character class in your code.",usesLibrary("Character"));
		
		boolean expected = false;
		boolean actual = BasicJava2.match('B','b');
		
		assertEquals("Checking if B and b match (in wrong order!)", expected, actual);
	}

	
	@Test
	public void test_ceiling_3_99() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = 4;
		long actual = BasicJava2.ceiling(3.99);
		
		assertEquals("Ceiling of 3.4", expected, actual);
	}
	
	@Test
	public void test_ceiling_0_01() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = 1;
		long actual = BasicJava2.ceiling(0.01);
		
		assertEquals("Ceiling of 0.01", expected, actual);
	}
	
	@Test
	public void test_ceiling_23() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = 23;
		long actual = BasicJava2.ceiling(23.0);
		
		assertEquals("Ceiling of 23.0", expected, actual);
	}
	
	@Test
	public void test_ceiling_negativeNum() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		
		long expected = -17;
		long actual = BasicJava2.ceiling(-17.45);
		
		assertEquals("Ceiling of 0.01", expected, actual);
	}

	@Test
	public void test_addHexDigits_12345() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use the StringBuilder library or the word StringBuilder in your code.",usesLibrary("StringBuilder"));
		
		
		int expected = 15;
		int actual = BasicJava2.addHexDigits(0x12345);
		
		assertEquals("testing hexadecimal 12345", expected, actual);
	}
	
	@Test
	public void test_addHexDigits_0() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use the StringBuilder library or the word StringBuilder in your code.",usesLibrary("StringBuilder"));
		
		int expected = 0;
		int actual = BasicJava2.addHexDigits(0);
		
		assertEquals("testing hexadecimal 0", expected, actual);
	}

	@Test
	public void test_addHexDigits_9ABCDEF() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use the StringBuilder library or the word StringBuilder in your code.",usesLibrary("StringBuilder"));
		
		int expected = 84;
		int actual = BasicJava2.addHexDigits(0x9ABCDEF);
		
		assertEquals("testing hexadecimal 9ABCDEF", expected, actual);
	}
	
	@Test
	public void test_addHexDigits_A00() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use the StringBuilder library or the word StringBuilder in your code.",usesLibrary("StringBuilder"));
		
		
		int expected = 10;
		int actual = BasicJava2.addHexDigits(0xA00);
		
		assertEquals("testing hexademical A00", expected, actual);
	}

	@Test
	public void test_addHexDigits_F11111() {
		assertFalse("Don't use the Math library or the word Math in your code.",usesLibrary("Math"));
		assertFalse("Don't use the Integer library or the word Integer in your code.",usesLibrary("Math"));
		assertFalse("Don't use the StringBuilder library or the word StringBuilder in your code.",usesLibrary("StringBuilder"));
		
		int expected = 20;
		int actual = BasicJava2.addHexDigits(0xF11111);
		
		assertEquals("testing hexadecimal F11111", expected, actual);
	}

	@Test
	public void test_count_bothEmptyString() {
		int expected = 0;
		int actual = BasicJava2.count("", "");
		
		assertEquals("Testing count - both empty string", expected, actual);
	}

	@Test
	public void test_count_firstEmptyString() {
		int expected = 0;
		int actual = BasicJava2.count("", "abcdefghijklmnopqrstuvwxyz");
		
		assertEquals("Testing count - first is empty string", expected, actual);
	}

	@Test
	public void test_count_secondEmptyString() {
		int expected = 0;
		int actual = BasicJava2.count("This is a test", "");
		
		assertEquals("Testing count - second is empty string", expected, actual);
	}

	@Test
	public void test_count_one() {
		int expected = 1;
		int actual = BasicJava2.count("This is a test", "ATbc");
		
		assertEquals("Testing count - 'This is a test', 'ATbc'", expected, actual);
	}

	@Test
	public void test_count_many() {
		int expected = 6;
		int actual = BasicJava2.count("This is a test", "sTpqi");
		
		assertEquals("Testing count - 'This is a test', 'sTpqi'", expected, actual);
	}

	@Test
	public void test_count_upperAndLowerCase() {
		int expected = 6;
		int actual = BasicJava2.count("This is another test", "stpq");
		
		assertEquals("Testing count - 'This is another test', 'stpq'", expected, actual);
	}

}
