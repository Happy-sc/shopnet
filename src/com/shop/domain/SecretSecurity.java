package com.shop.domain;

/**
 * 密保实体
 */
public class SecretSecurity implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String secretId;             //密保编号
	private String secretQuestion;       //密保问题
	private String secretAnswer;         //密保答案
	private Users users;
	
	public SecretSecurity(){	
	}
	
	public SecretSecurity(String secretId){
		this.secretId = secretId;
	}
	
	public SecretSecurity(String secretId,String secretQuestion,
			String secretAnswer,Users users){
		this.secretId = secretId;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.users = users;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
}
