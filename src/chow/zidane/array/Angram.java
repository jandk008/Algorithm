package chow.zidane.array;
/*
* issue description : verify two string whether they are anagram string.
* I use marks to identify the checked characters and check the number of marks at last to return the result 
* exmple:
*  input "apple" "alepp"   output: true
*  input "apple" "appls"   output: false
*/
class Anagram{

	public static boolean checkAnagram(String a, String b) {
		//if length are different, return false  
		if (a.length() != b.length())
			return false;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					b = b.replace(b.charAt(j), ' ');  // if charecters exsiting in String A exsits in B too, mark it with ' '
					break;
				}
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) != ' ') //check the mark 
				return false;
		}
		return true;
	}

}
