package entity;

import java.util.Arrays;

/**
 * 桥牌叫牌玩家类
 * @author Time
 *
 */
public class Player {
	
	
	private int id;		// 桥牌叫牌玩家编号
	private String name;	// 桥牌叫牌玩家的用户名
	private int round_id;	// 桥牌叫牌回合的编号
	private Card[] cards = new Card[13]; 	// 玩家的手牌
	private String role;	// 玩家扮演的角色
	
	public Player() {
		super();
	}

	public Player(int id, String name, int round_id, Card[] cards, String role) {
		super();
		this.id = id;
		this.name = name;
		this.round_id = round_id;
		this.cards = cards;
		this.role = role;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRound_id() {
		return round_id;
	}

	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", round_id=" + round_id
				+ ", cards=" + Arrays.toString(cards) + ", role=" + role + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
