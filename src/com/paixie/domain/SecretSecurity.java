package com.paixie.domain;

/**
 * �ܱ�ʵ��
 */
public class SecretSecurity implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String secretId;             //�ܱ����
	private String secretQuestion;       //�ܱ�����
	private String secretAnswer;         //�ܱ���
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
