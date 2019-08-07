package com.rgzn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.rgzn.dao.AdminDao;
import com.rgzn.entity.Admin;
import com.rgzn.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {
	
	@Override
	public Admin selectOne(String userName, String passWord) {
		String sql = "select ano, name, pwd, phone, email, gender,"
				+ " remark from t_admin where name = ? and pwd = ?";
		Object[] params = {userName, passWord};
		ResultSet result = DBUtil.executeQuery(sql, params);
		Admin admin = null;
		try {
			while(result.next()) {
				String ano = result.getString(1);
				String name = result.getString(2);
				String pwd = result.getString(3);
				String phone = result.getString(4);
				String email = result.getString(5);
				String gender = result.getString(6);
				String remark = result.getString(7);
				admin = new Admin(ano, name, pwd, phone, email, gender, remark);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return admin;
	}

	@Override
	public int insert(Admin admin) {
		String sql = "insert into t_admin(name, pwd, phone, email, gender, remark, employdate, hobby) "
				+ "values( ?, ?, ?, ?, ?, ?, ?, ?)";
		String email = admin.getEmail();
		Date employdate = admin.getEmploydate();
		String gender = admin.getGender();
		String hobby = admin.getHobby();
		String name = admin.getName();
		String phone = admin.getPhone();
		String pwd = admin.getPwd();
		String remark = admin.getRemark();
		Object[] params = {name, pwd, phone, email, gender, remark, employdate, hobby};
		int flag = DBUtil.executeUpdate(sql, params);
		DBUtil.closeAll();
		return flag;
	}

}
