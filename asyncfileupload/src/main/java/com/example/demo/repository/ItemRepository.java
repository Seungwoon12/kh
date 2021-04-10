package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;

@Repository
public interface ItemRepository {
	
	public List<Item> list() throws Exception;
	
	public void create(Item item) throws Exception;
	
	public void addAttach(String fullName, Integer itemJoinId) throws Exception;
	
	public void update(Item item) throws Exception;
	
	public Item read(Integer itemId) throws Exception;
	
	public List<String> getAttach(Integer itemId) throws Exception;
	
	public Integer getItemId() throws Exception;

	public void delete(Integer itemId) throws Exception;
}