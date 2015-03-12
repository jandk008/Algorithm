/*
* Here using three different way to remove the duplicate character in a sring without any extra memory 
* 1. check each character and replace the duplicate character with ' ', then call the string.trim()
* 2. select the different character to create the new string in the input string without any new storage
* 3. check the duplicate character and rewrite the character by coping the next one for each character after it.
*/

class RemoveDuplicateChar{
//implementation 1 
public static boolean checkUniqueCharater(String s) {
		boolean result = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					result = false;
			}
		}
		return result;
	}
	
//implementation 1 
	public static boolean checkUniqueCharater(String s, int i) {
		char c = s.charAt(i);
		for (int j = i + 1; j < s.length(); j++) {
			if (c == s.charAt(j))
				return true;
		}
		return false;
	}
	
//implementation 1 
	public static String removeDuplicateWord(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (checkUniqueCharater(s, i)) {
				s = s.replace(s.charAt(i), ' ');
			}
		}
		return s.trim();
	}
	
	//implementation 2 
	public static void removeDuplicates(char[] str) {
		if (str == null)
			return;
		int len = str.length;
		if (len < 2)
			return;

		int tail = 1; // new tail for new string

		for (int i = 1; i < len; ++i) { // check each node wither same to each
										// node before tail
			int j;
			for (j = 0; j < tail; ++j) { // make suer each node in array before
											// tail is different
				if (str[i] == str[j]) // break the loop when encounter the
										// duplicated character
					break;
			}
			if (j == tail) { // if there are not same characters before tail the
								// j will equal to jail
				str[tail] = str[i]; // remove the duplicated character
				++tail;
			}
		}
		str[tail] = 0;
	}

		// remove duplicated words in the third way 
	public static void removeDup(char[] c) {
		if (c.length == 1)
			return ;
		int pos = 0;
		while (pos < c.length - 1) {
			int iter = pos;
			while (c[iter + 1] != '0' && c[iter + 1] == c[iter]) {
				for (int current =iter ; current < c.length-1;current++){
					c[current] = c[current+1];
				}
				c[c.length-1]=0;
			}
			pos++;
		}
	}
	
	
	
	
	
	}
