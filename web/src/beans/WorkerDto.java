package beans;

public class WorkerDto {
	private int worker_no;
	private String worker_name;
	private String hire_date;
	private int salary;
	private String position;
	//기본생성자 + setter/getter
	public WorkerDto() {
		super();
	}
	public int getWorker_no() {
		return worker_no;
	}
	public void setWorker_no(int worker_no) {
		this.worker_no = worker_no;
	}
	public String getWorker_name() {
		return worker_name;
	}
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}