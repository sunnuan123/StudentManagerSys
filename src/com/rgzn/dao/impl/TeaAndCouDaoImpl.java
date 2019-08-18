package com.rgzn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.rgzn.dao.TeaAndCouDao;
import com.rgzn.entity.TeaAndCou;
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

}
