package hu.dupetya.register.validation;

public class ProgressResult {
	private Result result = Result.SUCCESS;
	private String message;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
