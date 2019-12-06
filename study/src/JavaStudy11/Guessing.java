package JavaStudy11;

import java.util.Random;
import javax.swing.JOptionPane;
public class Guessing
{
	public static void main(String[] args)
	{
		String targetStr, result;
		int again;
		int target, guess;
		
		Random generator = new Random();
		target = generator.nextInt(10) + 1;
		do {
			targetStr = JOptionPane.showInputDialog("추측 숫자를 입력하세요: ");
			guess = Integer.parseInt(targetStr);
			if (guess > target)
				result = "당신의 추측 숫자는 크다";
			else if (guess < target)
				result = "당선의 추측 숫자는 작다";
			else {
				result = "맞았다";
				JOptionPane.showMessageDialog(null, result);
				break;
			}

			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "계속하시겠습니까? : ");

		} while (again == JOptionPane.YES_OPTION);

	}

}