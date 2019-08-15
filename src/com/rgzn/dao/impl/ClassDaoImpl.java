package com.rgzn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.ClassDao;
import com.rgzn.entity.Class;
import com.rgzn.utils.DBUtil;

public class ClassDaoImpl implements ClassDao{

	@Override
	public List<Class> selectAllClass() {
		String sql = "select * from t_class";
		Object[] params = {};
		List list = new ArrayList<Class>();
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		try {
			while(rs.next()) {
				
				int classno = rs.getInt(1);
				String cname = rs.getString(2);
				String cteacher = rs.getString(3);
				String classroom = rs.getString(4);
				Class clazz = new com.rgzn.entity.Class(classno, cname, cteacher, classroom);
				list.add(clazz);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		return list;
	}

}
