//GUI를 사용한 환전프로그램

package JavaStudy10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MoneyExchange extends JFrame
{
	private JTextField money;
	private JLabel inputLabel, outputLabel, resultLabel;
	//환전 메소드
	public MoneyExchange()

	{
		//컨테이너 생성
		Container contentPane = getContentPane();
		//컨테이너 이름 설정
		setTitle("환전기");
		//컨테이너 크기 설정
		setSize(400, 100);
		
		//입력창 설정
		contentPane.setLayout(new FlowLayout());
		inputLabel = new JLabel("환전금액(원화)을 입력하세요:");
		outputLabel = new JLabel("환전받는 금액(달러화): $");
		resultLabel = new JLabel("---");
		//금액 입력창
		money = new JTextField(10);
		
		//컨테이너에 추가
		contentPane.add(inputLabel);
		contentPane.add(money);
		contentPane.add(outputLabel);
		contentPane.add(resultLabel);
		
		//이벤트 처리기 메소드
		MoneyListener listener = new MoneyListener();
		money.addActionListener(listener);
		//컨테이너 색상 설정
		contentPane.setBackground(Color.green);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//이벤트 처리기
	private class MoneyListener implements ActionListener
	{
		//이벤트 생성시 처리해주는 메소드
		public void actionPerformed(ActionEvent event)
		{
			int won, dollar;
			
			//입력 금액 받기
			String text = money.getText();
			//String타입을 Integer타입으로 변환
			won = Integer.parseInt(text);
			dollar = won / 1200;
			//resultLabel 변경
			resultLabel.setText(Integer.toString(dollar));
		}
	}

	public static void main(String[] args)
	{
		MoneyExchange frame = new MoneyExchange();
		//프레임 보이기
		frame.setVisible(true);
	}
}