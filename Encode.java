package zidane.encode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class Encode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Encode encode = new Encode();
		//read the code of character from resource file, instead of writing hard code 
		String filepathString = "C:\\Users\\Zidane_Chow\\Desktop\\開発\\1.txt";
		encode.fileOutputByUnicode(filepathString, null);
		String s;
		// test the old character in Japanse OS 
//		String s = "﨑";
		 s = "髙";
		 s = "漍";
		if (StringUtils.equals(StringEscapeUtils.escapeJava(" "), "\u0000"))
			System.out.println("yes");
			//special character(harf width space), cant recognized and get the character code 
		  System.out.println("String is " + StringEscapeUtils.escapeJava("�")); 
		  System.out.println("String is " + StringEscapeUtils.escapeJava(s));
		  System.out.println("uneascape is "
				+ StringEscapeUtils.unescapeJava("\u00A0"));
		s = "私は"+StringEscapeUtils.unescapeJava("\u200B")+"人です";
//		 s = StringEscapeUtils.unescapeJava("\u0001");
		System.out.println("charAt is below");
		for (int n = 0;n<s.length();n++){
			System.out.print(s.charAt(n)+",");
		}
		/* Use the HTML tool library to display these character correctly, here comment out 
		 * System.out.println("String is "+encode.htmlEncode(CharUtils.
		 * unicodeEscaped('A')));
		 * System.out.println("String is "+StringEscapeUtils.escapeJava("髙"));
		 * System
		 * .out.println("unicode is "+CharUtils.toCharacterObject("\u9EB4"));
		 * System.out.println("String is "+StringEscapeUtils.escapeJava(" "));
		 * System.out.println("String is "
		 * +StringEscapeUtils.unescapeJava("\u200B")=="?"?true:false);
		 * System.out.println("charset is "+Charset.defaultCharset());
		 */
		System.out.println("convert is " + encode.convertUTF8toUTF16(s));
		/*
		 * String userName = "1' or '1'='1"; String password = "123456";
		 * userName = StringEscapeUtils.escapeSql(userName); password =
		 * StringEscapeUtils.escapeSql(password); String sql =
		 * "SELECT COUNT(userId) FROM t_user WHERE userName='"+ userName +
		 * "' AND password ='" + password + "'"; System.out.println(sql);
		 */
	}

	/**
	 * Takes UTF-8 strings and encodes non-ASCII as
	 * ampersand-octothorpe-digits-semicolon HTML-encoded characters
	 *
	 * @param string
	 * @return HTML-encoded String
	 */
	@SuppressWarnings("unused")
	private String htmlEncode(final String string) {
		final StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			final Character character = string.charAt(i);
			if (CharUtils.isAscii(character)) {
				// Encode common HTML equivalent characters
				stringBuffer.append(StringEscapeUtils.escapeHtml(character
						.toString()));
			} else {
				// Why isn't this done in escapeHtml4()?
				stringBuffer.append(String.format("&#x%x;",
						Character.codePointAt(string, i)));
			}
		}
		return stringBuffer.toString();
	}

	// deal with each character for a string to convert it to unicode
	public String convertUTF8toUTF16(String s) {

		try {
			System.out.println("s is "+s);
			byte[] bytes = s.getBytes("UTF16");
			displayHex(s.getBytes());
			String a = new String(bytes, "UTF8");
			System.out.println("a is "+a);
			String b = new String (a.getBytes("UTF8"),"SJIS");
			System.out.println("b is "+b);
			displayHex(b.getBytes());
//			String newStrng = new String(s.getBytes("UTF-16"), "UTF-8");
//			System.out.printf("String hex is %d",a);
			return a;
		} catch (UnsupportedEncodingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
	/*
	*accept the array of byte and show the code in Hex 
	*/
	public  static void displayHex(byte[] s){
		for (int n=0;n<s.length;n++){
			 String h = Integer.toHexString(s[n] & 0xFF);
			 if(h.length() == 1){
				 h='0'+h;
			 }
			 System.out.print(h.toUpperCase()+" ");
		}
		System.out.println("");
	}

	/**
	 * ファイルからUnicodeを読み込み、文字をファイルに書き込むメソッド
	 *read unicode from resource file and output the characters to the target file 
	 *@param sourceFile
	 *@param targetFile
	 */
	public boolean fileOutputByUnicode(String sourceFile, String targetFile) {

		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(sourceFile));
//			out = new BufferedWriter(new FileWriter(targetFile));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println("!"+StringEscapeUtils.unescapeJava(line)+"!      "+line+"<br>");
			}
			in.close();
			return true;
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
	}
}
