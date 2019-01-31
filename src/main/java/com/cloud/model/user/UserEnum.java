package com.cloud.model.user;

/**
 * 用户状态
 */
public enum UserEnum {
	ACTIVE("正常", "1"),
	ACCOUNTNONEXPIRED("过期", "2"),
	ACCOUNTNONLOCKED("锁定", "3"),
	CREDENTIALSNONEXPIRED("凭证(密码)过期", "4"),
	ENABLED("禁用", "5"),
	;
	
	private String name;
	
    private String value;
    
	private UserEnum(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public static UserEnum getUserEnum(String value) {
		for (UserEnum userEnum : UserEnum.values()) {
            if (userEnum.getValue().endsWith(value)) {
                return userEnum;
            }
        }
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
}
