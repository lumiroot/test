package phonedisplay;

public class PhoneDisplay {

	private String phoneNumber;
	private String formattedPhoneNumber;

	public void input(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.formattedPhoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String output() {
		formattedPhoneNumber = removeNonKeypadCharacters();
		formattedPhoneNumber = parenthesesLocalNumber();
		formattedPhoneNumber = dashTelecomNumber();
		formattedPhoneNumber = dashTelecomMiddleNumber();
		
		return formattedPhoneNumber;
	}

	protected String parenthesesLocalNumber() {
		return formattedPhoneNumber.replaceAll("^(02|031|032|033|041|042|043|044|051|052|053|054|055|061|062|063|064)", "($0)");
	}

	protected String removeNonKeypadCharacters() {
		return formattedPhoneNumber.replaceAll("[^\\d#*]", "");
	}
	
	protected String dashTelecomNumber() {
		return formattedPhoneNumber.replaceAll("^(010|011|012|013|014|015|016|017|018|019)", "$0-");
	}

	private String dashTelecomMiddleNumber() {
		return formattedPhoneNumber.replaceAll("-((\\d{3})(..?.?.?$)|(\\d{4})(.*))", "-$2$4-$3$5");
	}	

}
