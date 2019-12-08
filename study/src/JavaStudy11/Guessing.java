//랜덤 숫자 (1~10) 맞추기

package JavaStudy11;

//랜덤으로 돌리기
import java.util.Random;
import javax.swing.JOptionPane;
public class Guessing
{
	public static void main(String[] args)
	{
		//변수선언
		String targetStr, result;
		int again;
		int target, guess;
		
		//랜덤 변수 생성
		Random generator = new Random();
		//랜덤 변수 1~10으로 한정
		target = generator.nextInt(10) + 1;
		do {
			//추측 숫자 입력창 띄워서 받는다
			targetStr = JOptionPane.showInputDialog("추측 숫자를 입력하세요: ");
			//Stirng을 Intager로 변환
			guess = Integer.parseInt(targetStr);
			//정답보다 추측이 더 클때
			if (guess > target)
				result = "당신의 추측 숫자는 크다";
			else if (guess < target)
				result = "당선의 추측 숫자는 작다";
			//정답을 입력했을때
			else {
				result = "맞았다";
				JOptionPane.showMessageDialog(null, result);
				break;
			}

			//if문의 값을 창에 띄워줌
			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "계속하시겠습니까? : ");

			
		} while (again == JOptionPane.YES_OPTION); // yes버튼을 누를때 마다 반복

	}

}