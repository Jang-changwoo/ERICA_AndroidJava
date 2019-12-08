//입력 문자열에서 모음의 개수 찾기

package JavaStudy7;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		System.out.print("Please enter a sentence:");
		//모음 변수 선언 및 초기화
		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;
		int consonant = 0;
		int num = 0;
		Scanner scan = new Scanner(System.in);
		//문자열 입력받기
		String sentence = scan.nextLine();
		//문자열에서 공백문자 없애기
		sentence = sentence.replaceAll(" ", "");
		//문자열에서 모두 소문자로 바꾸기
		sentence = sentence.toLowerCase();

		//문자열의 길이만큼 실행
		while (num < sentence.length()) {
			switch (sentence.charAt(num)) {
			case 'a':
				a = a + 1;
				break;
			case 'e':
				e = e + 1;
				break;
			case 'i':
				i = i + 1;
				break;
			case 'o':
				o = o + 1;
				break;
			case 'u':
				u = u + 1;
				break;
			default:
				consonant = consonant + 1;
				break;

			}
			num = num + 1;
		}

		System.out.println("a:" + a);
		System.out.println("e:" + e);
		System.out.println("i:" + i);
		System.out.println("o:" + o);
		System.out.println("u:" + u);
		System.out.println("consonant:" + consonant);
		
	}

}
