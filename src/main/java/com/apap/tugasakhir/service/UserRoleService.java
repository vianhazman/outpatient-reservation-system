package com.apap.tugasakhir.service;

import com.apap.tugasakhir.model.UserRoleModel;

public interface UserRoleService {
	UserRoleModel addUser(UserRoleModel user);
	public String encrypt(String password);
}
