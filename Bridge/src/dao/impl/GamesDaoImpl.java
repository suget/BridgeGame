package dao.impl;

import java.sql.SQLException;
import java.util.List;

import util.DataBaseUtil;
import dao.IGamesDao;
import entity.Contract;
import entity.Player;
import entity.Round;

public class GamesDaoImpl extends DataBaseUtil implements IGamesDao {

	@Override
	public boolean saveGame(Player[] player, Round round,
			List<Contract> contracts) {
		boolean flag = false;
		
		// 执行的SQL语句
		String sql_player = "INSERT INTO players(`name`, `round_id`, `cards`, `role`) VALUE(?, ?, ?, ?)";
		String sql_round = "INSERT INTO round(`time`, `positionN`, `positionE`, `positionS`, `positionW`, `target`, `firstPlayer`, `banker`) VALUE(?, ?, ?, ?, ?, ?, ?, ?)";
		String sql_contract = "INSERT INTO contract(`round_id`, `row`, `callN`, `callE`, `callS`, `callW`) VALUE(?, ?, ?, ?, ?, ?)";
		
		// 执行成功标识位
		boolean flag_player = true, flag_round = true, flag_contract = true;
		
		conn = getConn();	// 获取数据库连接
		try {
			// 插入本局游戏回合
			pstmt = conn.prepareStatement(sql_round);
			Object[] params = {round.getTime(), round.getPositionN(), round.getPositionE(), round.getPositionS(), round.getPositionW(), round.getTarget(), round.getFirstPlayer(), round.getBanker()};
			for(int j = 0; j < params.length; j++) pstmt.setObject(j + 1, params[j]);
			if(pstmt.executeUpdate() > 0) flag_round = true;
			
			// 插入四位玩家
			for(int i = 0; i < player.length; i++) {
				pstmt = conn.prepareStatement(sql_player);
				Object[] param = {player[i].getName(), player[i].getRound_id(), player[i].getCards(), player[i].getRole()};
				for(int j = 0; j < param.length; j++) pstmt.setObject(j + 1, param[j]);
				if(!(pstmt.executeUpdate() > 0)) {flag_player = false; break;}
			}
			
			// 插入叫牌回合记录
			for(int i = 0; i < contracts.size(); i++) {
				pstmt = conn.prepareStatement(sql_contract);
				Contract c = contracts.get(i);
				Object[] param = {c.getRound_id(), c.getRow(), c.getCallN(), c.getCallE(), c.getCallS(), c.getCallW()};
				for(int j = 0; j < param.length; j++) pstmt.setObject(j + 1, param[j]);
				if(!(pstmt.executeUpdate() > 0)) {flag_contract = false; break;}
			}
			conn.commit(); 		// 提交事务
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		flag = flag_player && flag_round && flag_contract;
		
		return flag;
	}

	public static void main(String[] args) {

	}

}
