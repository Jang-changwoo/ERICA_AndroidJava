package JavaStudy3;
//다른 클래스에서 변수의 값들을 바꾸고 불러온다.
public class study3 {

	public static void main(String[] args) {
		Employee emp1 = new Employee(); // 함수 Employee 설정
		emp1.setName("lee");
		emp1.setNumber(100);
		emp1.setAge(25);
		System.out.println(emp1);

	}

}
