package dao.impl;

import util.DataBaseUtil;
import dao.IRoundsDao;
import entity.Round;

public class RoundsDaoImpl extends DataBaseUtil implements IRoundsDao {

	@Override
	public boolean addRoundByID(Round round) {
		boolean flag = false;

		// 执行添加的SQL语句
		String sql = "INSERT INTO round(`id`, `time`, `positionN`, `positionE`, `positionS`, `positionW`, `target`, `firstPlayer`, `banker`) VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {round.getId(), round.getTime(), round.getPositionN(), round.getPositionE(), round.getPositionS(), round.getPositionW(), round.getTarget(), round.getFirstPlayer(), round.getBanker()};

		int line = exeUpdate(sql, params);

		// 释放资源
		closeAll(rs, pstmt, conn);

		if(line > 0) flag = true;

		return flag;
	}

	@Override
	public boolean deleteRoundByID(int id) {
		boolean flag = false;

		// 执行添加的SQL语句
		String sql = "DELETE FROM round WHERE id=?";
		Object[] params = {id};

		int line = exeUpdate(sql, params);

		// 释放资源
		closeAll(rs, pstmt, conn);

		if(line > 0) flag = true;

		return flag;
		
	}

	@Override
	public boolean updateRoundByID(int id) {
		boolean flag = false;

		// 执行添加的SQL语句
		String sql = "DELETE FROM round WHERE id=?";
		Object[] params = {id};

		int line = exeUpdate(sql, params);

		// 释放资源
		closeAll(rs, pstmt, conn);

		if(line > 0) flag = true;

		return flag;
	}

	@Override
	public boolean selectRoundByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
