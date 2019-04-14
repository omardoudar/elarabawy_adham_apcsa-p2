//Name: Adham Elarabawy

public class WordSearchRunner {
	
	public static void main(String[] args) throws Exception {
		
		WordSearch temp = new WordSearch(8, "APPLEXYPXLHJKEEDEGGLLXXCGFPDGOGNMYNTAHUUPUQDGBTSBTHIGHMSILKXLTHIS");
		String[] words = "APPLE AXE APEX CAT HEX EGG HAT COMPUTER GUM THIS TUG THIGH".split(" ");

		System.out.println(temp);
		for (String s : words) {
			
			if (temp.isFound(s)) {
				
				System.out.println(s + " was found in the matrix.");
			} else {

				System.out.println(s + " was not found in the matrix.");
			}
		}
	}
}
