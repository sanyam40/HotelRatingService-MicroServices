package com.api.gateway.entity;

import java.util.Collection;

public class AuthResponse {
	
	private String userId;
	private String accessToken;
	private String refreshToken;
	private long expireAt;
	private Collection<String> authorises;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public long getExpireAt() {
		return expireAt;
	}
	public void setExpireAt(long expireAt) {
		this.expireAt = expireAt;
	}
	public Collection<String> getAuthorises() {
		return authorises;
	}
	public void setAuthorises(Collection<String> authorises) {
		this.authorises = authorises;
	}
	public AuthResponse(String userId, String accessToken, String refreshToken, long expireAt,
			Collection<String> authorises) {
		super();
		this.userId = userId;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expireAt = expireAt;
		this.authorises = authorises;
	}
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
