package hu.schonherz.common;

public interface Encryption {
	public String encrypt(String toEncrypt);
	public boolean check(String input, String actualPwd);
}
