package model.service;

import java.util.ArrayList;

import model.dao.Goods;
import model.dao.goodsDAO;

public class goodsService {

	goodsDAO dao;

	public void setDao(goodsDAO dao){
		this.dao = dao;
	}
	
	public ArrayList<Goods> getGoodsItems(){
		ArrayList<Goods> list = dao.getGoodsItems();
		return list;
	}
	
	
}
