package JavaStudy3;

public class Employee {
	private String name;		//사람 이름
	private int number;			//사람 번호
	private int age;			//사람 나이

	//함수를 부를 수 있게 하는 함수
	public Employee() {			
	}
	// 이름을 받아오는 함수
	public String getName() {	
		return name;
	}

	//최종적인 String을 출력하는 함수
	public String toString() {	
		return "Employee [name=" + name + ", number=" + number + ", age=" + age + "]";
	}

	//이름을 바꾸는 함수
	public void setName(String name) {
		this.name = name;
	}

	//번호를 받아오는 함수
	public int getNumber() {
		return number;
	}

	//번호를 바꾸는 함수
	public void setNumber(int number) {
		this.number = number;
	}

	//나이를 받아오는 함수
	public int getAge() {
		return age;
	}

	//나이를 설정하는 함수
	public void setAge(int age) {
		this.age = age;
	}

}
