package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Item;

public interface ItemService {
	
	public List<Item> list() throws Exception;
	
	public void regist(Item item) throws Exception;
	
	public Item read(Integer itemId) throws Exception;
	
	public void modify(Item item) throws Exception;
	
	public void remove(Integer itemId) throws Exception;
	
	public String getPicture(Integer itemId) throws Exception;
	
	public List<String> getAttach(Integer itemId) throws Exception;
	
	public Integer getItemId() throws Exception;
}