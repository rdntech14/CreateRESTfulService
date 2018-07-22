package package1;

public class ResultOK {
	
	String message;



	public ResultOK(String result) {
		this.message=result;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ResultOK [result=" + message + "]";
	}
	

}
