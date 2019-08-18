package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.TeacherDao;
import com.rgzn.entity.Teacher;
import com.rgzn.utils.DBUtil;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public List<Teacher> selectAllTea() {
		String sql = "select * from t_teacher";
		Object[] params = {};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List list = new ArrayList<Teacher>();
		
		try {
			while(rs.next()) {
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				String tpwd = rs.getString("tpwd");
				String tphone = rs.getString("tphone");
				Date hireDate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				
				Teacher teacher = new Teacher(tno, tname, tpwd, tphone, hireDate, remark);
				list.add(teacher);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		return list;
	}

}
