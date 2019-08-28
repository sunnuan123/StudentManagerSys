package com.rgzn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgzn.dao.TeaAndCouDao;
import com.rgzn.entity.Course;
import com.rgzn.entity.TeaAndCou;
import com.rgzn.entity.Teacher;
import com.rgzn.utils.DBUtil;

public class TeaAndCouDaoImpl implements TeaAndCouDao{

	@Override
	public int insertTeaAndCou(TeaAndCou tac) {
		int cno = tac.getCno();
		int tno = tac.getTno();
		Object[] params = {cno, tno};
		
		
		String sql = "select * from t_tc where cno=? and tno=?";
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql2 = "insert into t_tc(cno, tno) values(?, ?)";
		
		
		int flag = DBUtil.executeUpdate(sql2, params);
		
		DBUtil.closeAll();
		
		return flag;
	}

	@Override
	public int delOneTc(int tno, int cno) {
		String sql = "delete from t_tc where tno=? and cno=?";
		Object[] params = {tno, cno};
		
		int flag = DBUtil.executeUpdate(sql, params);
		DBUtil.closeAll();
		return flag;
	}

	@Override
	public List<Course> selectTeaAndCou(int sno) {
		String sql = "select * from t_course cou left join t_tc tc on tc.cno=cou.cno left join t_teacher tea on tea.tno=tc.tno"+ 
				" where cou.cno not in(SELECT cno from t_sc WHERE sno=?)";
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

}
