package hu.schonherz.training.registrate;

public class RegData {
	String Title;
	String UserName;
	String FullName;
	String PassWord;
	String DateOfBirth;
	String PlaceOfBirth;
	String Email;
	String PhoneNumber;
	public RegData(String title, String userName, String fullName, String passWord, String dateOfBirth,
			String placeOfBirth, String email, String phoneNumber) {
		super();
		Title = title;
		UserName = userName;
		FullName = fullName;
		PassWord = passWord;
		DateOfBirth = dateOfBirth;
		PlaceOfBirth = placeOfBirth;
		Email = email;
		PhoneNumber = phoneNumber;
	}
	public String getTitle() {
		return Title;
	}
	public String getUserName() {
		return UserName;
	}
	public String getFullName() {
		return FullName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public String getPlaceOfBirth() {
		return PlaceOfBirth;
	}
	public String getEmail() {
		return Email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateOfBirth == null) ? 0 : DateOfBirth.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((FullName == null) ? 0 : FullName.hashCode());
		result = prime * result + ((PassWord == null) ? 0 : PassWord.hashCode());
		result = prime * result + ((PhoneNumber == null) ? 0 : PhoneNumber.hashCode());
		result = prime * result + ((PlaceOfBirth == null) ? 0 : PlaceOfBirth.hashCode());
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegData other = (RegData) obj;
		if (DateOfBirth == null) {
			if (other.DateOfBirth != null)
				return false;
		} else if (!DateOfBirth.equals(other.DateOfBirth))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (FullName == null) {
			if (other.FullName != null)
				return false;
		} else if (!FullName.equals(other.FullName))
			return false;
		if (PassWord == null) {
			if (other.PassWord != null)
				return false;
		} else if (!PassWord.equals(other.PassWord))
			return false;
		if (PhoneNumber == null) {
			if (other.PhoneNumber != null)
				return false;
		} else if (!PhoneNumber.equals(other.PhoneNumber))
			return false;
		if (PlaceOfBirth == null) {
			if (other.PlaceOfBirth != null)
				return false;
		} else if (!PlaceOfBirth.equals(other.PlaceOfBirth))
			return false;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		return true;
	}
	
	
	
}
