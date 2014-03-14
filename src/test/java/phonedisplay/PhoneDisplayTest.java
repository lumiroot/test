package phonedisplay;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneDisplayTest {
	
	@Test
	public void testGEtOriginalPhoneNumber() throws Exception {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("01011112222");
		
		// Then
		assertEquals("01011112222", phoneDisplay.getPhoneNumber());
	}
	
	@Test
	public void testOnlyKeypadCharacter() throws Exception {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("012#34a5b*678");
		
		// Then
		assertEquals("012#345*678", phoneDisplay.removeNonKeypadCharacters());
	}
	
	@Test
	public void testLocalNumber() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("021112222");
		
		// Then
		assertEquals("(02)1112222", phoneDisplay.output());
	}
	
	@Test
	public void testLocalNumberInMiddle() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("020312222");
		
		// Then
		assertEquals("(02)0312222", phoneDisplay.output());
	}

	@Test
	public void testTelecomNumber3DigitInMiddle() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("0103332222");
		
		// Then
		assertEquals("010-333-2222", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumber4DigitInMiddle() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("01044442222");
		
		// Then
		assertEquals("010-4444-2222", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumber5Digit() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("01022");
		
		// Then
		assertEquals("010-22", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumber7Digit() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("0102223");
		
		// Then
		assertEquals("010-222-3", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumber10Digit() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("0102223333");
		
		// Then
		assertEquals("010-222-3333", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumber11Digit() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("01022233334");
		
		// Then
		assertEquals("010-2223-3334", phoneDisplay.output());
	}
	
	@Test
	public void testTelecomNumberOver11Digit() {
		// Given
		PhoneDisplay phoneDisplay = new PhoneDisplay();
		
		// When
		phoneDisplay.input("010222333345555");
		
		// Then
		assertEquals("010-2223-33345555", phoneDisplay.output());
	}
}
