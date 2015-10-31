package hu.dupetya.web.register.validation;

import java.util.ArrayList;
import java.util.List;

public class RegistrationResult {
	private Result result = Result.SUCCESS;
	private String message = "Successfully registered user";
	private List<String> causes = new ArrayList<>();

	public List<String> getCauses() {
		return causes;
	}

	public void setCauses(List<String> causes) {
		this.causes = causes;
	}

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
