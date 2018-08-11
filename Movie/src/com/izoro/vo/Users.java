package com.izoro.vo;

public class Users {
     public Users(int userId, String userName, String userPassword, String userDire, String userIntriduce,
			String userFace, String eMail, String usePhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userDire = userDire;
		this.userIntriduce = userIntriduce;
		this.userFace = userFace;
		this.eMail = eMail;
		this.usePhone = usePhone;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((usePhone == null) ? 0 : usePhone.hashCode());
		result = prime * result + ((userDire == null) ? 0 : userDire.hashCode());
		result = prime * result + ((userFace == null) ? 0 : userFace.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userIntriduce == null) ? 0 : userIntriduce.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		Users other = (Users) obj;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (usePhone == null) {
			if (other.usePhone != null)
				return false;
		} else if (!usePhone.equals(other.usePhone))
			return false;
		if (userDire == null) {
			if (other.userDire != null)
				return false;
		} else if (!userDire.equals(other.userDire))
			return false;
		if (userFace == null) {
			if (other.userFace != null)
				return false;
		} else if (!userFace.equals(other.userFace))
			return false;
		if (userId != other.userId)
			return false;
		if (userIntriduce == null) {
			if (other.userIntriduce != null)
				return false;
		} else if (!userIntriduce.equals(other.userIntriduce))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserDire() {
		return userDire;
	}
	public void setUserDire(String userDire) {
		this.userDire = userDire;
	}
	public String getUserIntriduce() {
		return userIntriduce;
	}
	public void setUserIntriduce(String userIntriduce) {
		this.userIntriduce = userIntriduce;
	}
	public String getUserFace() {
		return userFace;
	}
	public void setUserFace(String userFace) {
		this.userFace = userFace;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getUsePhone() {
		return usePhone;
	}
	public void setUsePhone(String usePhone) {
		this.usePhone = usePhone;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userDire="
				+ userDire + ", userIntriduce=" + userIntriduce + ", userFace=" + userFace + ", eMail=" + eMail
				+ ", usePhone=" + usePhone + "]";
	}
	
	 int userId;
	 String userName;
	 String userPassword;
	 String userDire;
	 String userIntriduce;
	 String userFace;
	 String eMail;
	 String usePhone;
}
