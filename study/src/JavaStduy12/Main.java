//String길이가 20이 넘거나 null이면 예외처리

package JavaStduy12;

import java.lang.*;

public class Main {

	public static String len_check(String str) {
		String result = "";
		// 예외가 발생할 수 있는 구간
		try {
			// 단어길이가 20이상이면 More than 20 words 오류작성
			if (str.length() > 20)
				throw new RuntimeException("More than 20 words");
			// 단어길이가 0보다 작으면(null)이면 Null오류
			else if (str.length() < 0)
				throw new RuntimeException("NULL");
			else
				result = str;
		}
		// try문에서 발생한 오류 처리
		catch (RuntimeException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(len_check("abcdefghijklmnopqr"));
		System.out.println(len_check("abcdefghijklmnopqrstu"));
		System.out.println(len_check(null));

	}

}
