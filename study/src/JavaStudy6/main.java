package JavaStudy6;

//은행계좌 입출금 시스템

import java.text.DecimalFormat;
import java.util.Scanner;

//계좌선언
class BankAccount {
	//잔고 선언
	private int balance;
	
	//초기 금액이 0이상일땐 초기금액 설정, 0이하일때 0으로 설정
	public BankAccount(int initial_amount) {
		if (initial_amount >= 0)
			balance = initial_amount;
		else
			balance = 0;
	}

	//잔고 불러오는 함수
	public int getBalance() {
		return balance;
	}

	//입금
	public boolean deposit(int amount) {
		boolean result = false;
		if (amount < 0)
			System.out.println("invalid deposit amount");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}

	//출금
	public boolean withdraw(int amount) {
		boolean result = false;
		if (amount < 0)
			System.out.println("invalid withdraw amount");
		else if (amount > balance)
			System.out.println("not enough balance");
		else {
			balance = balance - amount;
			result = true;
		}
		return result;
	}
}

//사용자의 입력을 받아서 처리하는 시스템
class BankReader {
	private String input_line = "";
	private Scanner scan;

	//입력받기 메소드
	public BankReader() {
		scan = new Scanner(System.in);
	}

	//제일 먼저 나오는 커맨드 읽기
	public char readCommand(String message) {
		System.out.print(message);
		input_line = scan.nextLine().toUpperCase();
		return input_line.charAt(0);
	}

	//뒤에나오는 금액 읽기
	public int readAmount() {
		int answer = 0;
		String s = input_line.substring(1, input_line.length());

		//달러를 센트로 바꾼다
		if (s.length() > 0) {
			double dollars_cents = new Double(s).doubleValue();
			answer = (int) (dollars_cents * 100);
		} else
			System.out.println("invalid command - input amount: 0");
		return answer;
	}
}

//계좌에 쓰기
class BankWriter {
	private BankAccount bank;
	private String last_transaction = "";

	//계좌 쓰는 메소드
	public BankWriter(BankAccount b) {
		bank = b;
	}

	public String unconvert(int i) {
		return new DecimalFormat("0.00").format(i / 100.0);
	}

	//입력상황에 맞는 메시지를 출력하는 메소드
	public void setTransaction(String message, int amount) {
		last_transaction = message + " " + unconvert(amount);
		System.out.println("transaction: " + last_transaction);
	}

	//입력상황에 맞는 메시지를 출력하는 메소드
	public void setTransaction(String message) {
		last_transaction = message;
		System.out.println("transaction: " + last_transaction);
	}

}


//구동에 필요한 계좌관리 시스템
class AccountController {
	private BankReader reader; // input view
	private BankAccount primary_account, secondary_account, account;
	private BankWriter primary_writer, secondary_writer, writer;

	public AccountController(BankReader r, BankAccount a1, BankWriter w1, BankAccount a2, BankWriter w2) {
		reader = r;
		primary_account = a1;
		primary_writer = w1;
		secondary_account = a2;
		secondary_writer = w2;
		account = primary_account;
		writer = primary_writer;
	}

	//선택되있는 계좌를 바꾸는 메소드
	public void resetAccount(BankAccount new_account, BankWriter new_writer) {
		account = new_account;
		writer = new_writer;
	}

	//커맨드에 맞춰서 각자 실행한다
	public void processTransactions() {
		char command = reader.readCommand("Commands (P/S/D/W/T/I/Q): ");

		switch (command) {
		case 'P':
			resetAccount(primary_account, primary_writer);
			break;
		case 'S':
			resetAccount(secondary_account, secondary_writer);
			break;
		case 'Q':
			System.out.println("Quit");
			return;
		case 'D': {
			int amount = reader.readAmount();
			if (account.deposit(amount))
				writer.setTransaction("deposit $", amount);
			else
				writer.setTransaction("deposit error ", amount);
			break;
		}
		case 'W': {
			int amount = reader.readAmount();
			if (account.withdraw(amount))
				writer.setTransaction("withdraw $", amount);
			else
				writer.setTransaction("withdraw error ", amount);
			break;
		}
		case 'T':
		{
			if (account == primary_account) {

				int amount = reader.readAmount();

				if (account.withdraw(amount)) {
					secondary_account.deposit(amount);
					writer.setTransaction("transfer $", amount);
				} else {
					writer.setTransaction("transfer error");
				}
			} else {

				int amount = reader.readAmount();

				if (account.withdraw(amount)) {
					primary_account.deposit(amount);
					writer.setTransaction("transfer $", amount);
				} else {
					writer.setTransaction("transfer error");
				}
			}

			break;
		}
		case 'I':
		{
			int amount = reader.readAmount();
			double interest = amount / 100.00;
			if (interest > 0 && interest < 1) {
				int balance = (int) (account.getBalance() * interest);
				account.deposit(balance);
				writer.setTransaction("interest $", balance);
			} else {
				writer.setTransaction("interest error");
			}

			break;
		}
		//정해진 값이 아닐경우 오류메시지
		default:
			writer.setTransaction("invalid commpand: " + command);
			break;
		}
		//실행후 계좌 출력
		System.out.println("=======================");
		System.out.println("== currently active : " + ((account == primary_account) ? "primary" : "secondary"));
		System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
		System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
		System.out.println("=======================");

		this.processTransactions();
	}
}

public class main {

	public static void main(String[] args) {
		BankReader reader = new BankReader();
		BankAccount primary_account = new BankAccount(0);
		BankWriter primary_writer = new BankWriter(primary_account);
		BankAccount secondary_account = new BankAccount(0);
		BankWriter secondary_writer = new BankWriter(secondary_account);
		AccountController controller = new AccountController(reader, primary_account, primary_writer, secondary_account,
				secondary_writer);
		controller.processTransactions();

	}

}
