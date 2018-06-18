package dao;

import entity.Round;

public interface IRoundsDao {
	
	// 添加叫牌游戏回合
	public boolean addRoundByID(Round round);
	
	// 通过编号删除叫牌游戏回合
	public boolean deleteRoundByID(int id);
	
	// 通过编号修改叫牌游戏回合
	public boolean updateRoundByID(int id);
	
	// 通过编号查询叫牌游戏回合
	public boolean selectRoundByID(int id);

}
