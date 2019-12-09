//String을 받아서 그 안에있는 정수의 합 구하기

package JavaStudy13;

public class Main {

	public static int string_sum(String str)
	{
		String num1 = "";
		int sum = 0;
		int term = 0;
		//예외발생 가능 
		try {
			for(int i=0; i<str.length();i++)
			{
				//str의 한글자씩 꺼내온다
				char ch = str.charAt(i);
				//ASCII코드의 0=48 9=57이므로 숫자일때 num1에 추가
				if(48<=ch && 57>=ch)
					num1 += ch;
				//공백이거나 끝까지 왔을 때
				if(ch==' ' || i==str.length()-1)
				{
					//String형태의 숫자를 Int로 변환
					sum += Integer.parseInt(num1);
					//num1 초기화
					num1 = "";
				}
			}
		}
		//Integer.parseInt시 숫자가 아닌 문자가 들어있을 때 예외처리
		catch (NumberFormatException e)
		{
			sum = 0;
		}
		return sum;
	}
	

	public static void main(String[] args) {
		System.out.println(string_sum("100 400"));
		System.out.println(string_sum("100 p 400"));
		
		
	}

}
