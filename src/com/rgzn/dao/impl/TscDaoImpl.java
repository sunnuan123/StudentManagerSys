package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.TscDao;
import com.rgzn.entity.Course;
import com.rgzn.entity.Teacher;
import com.rgzn.utils.DBUtil;

public class TscDaoImpl implements TscDao{

	@Override
	public int insertTsc(int sno, int tno, int cno) {
		Object[] params = {sno, cno, tno};
		String sql1 = "select * from t_sc where sno=? and cno=? and tno=?";
		ResultSet rs = DBUtil.executeQuery(sql1, params);
		try {
			if(rs.next()) {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "insert into t_sc(sno, cno, tno) values(?, ?, ?)";
		int flag = DBUtil.executeUpdate(sql, params);
		
		return flag;
	}

	@Override
	public List<Course> selectAllBySno(int sno) {
		String sql = "select * from t_course cou left join t_sc sc on sc.cno = cou.cno "
				+ "left join t_teacher tea on tea.tno = sc.tno where sc.sno = ?";
		Object[] params = {sno};
		
		
		ResultSet rs = DBUtil.executeQuery(sql, params);
		
		List list = new ArrayList<Course>();
		try {
			while(rs.next()) {
				int cno = Integer.parseInt(rs.getString(1));
				String cname = rs.getString(2);
				int credit = Integer.parseInt(rs.getString(3));
				Date startDate = rs.getDate(4);
				Date endDate = rs.getDate(5);
				
				
				int tno = rs.getInt("tno");
				String tname = rs.getString("tname");
				String tpwd = rs.getString("tpwd");
				String tphone = rs.getString("tphone");
				Date hireDate = rs.getDate("hiredate");
				String remark = rs.getString("remark");
				
				Teacher teacher = new Teacher(tno, tname, tpwd, tphone, hireDate, remark);
				
				Course cou = new Course(cno, cname, credit, startDate, endDate, teacher);
				
				list.add(cou);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll();
		}
		
		
		return list;
	}

	@Override
	public int delOne(int sno, int tno, int cno) {
		String sql = "delete from t_sc where sno=? and tno=? and cno=?";
		Object[] params = {sno, tno, cno};
		int flag = DBUtil.executeUpdate(sql, params);
		
		return flag;
	}

}
