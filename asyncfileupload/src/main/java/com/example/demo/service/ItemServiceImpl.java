package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	private static final Logger log =
			LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemRepository repository; 
	
	@Override
	public List<Item> list() throws Exception {
		// TODO Auto-generated method stub
		return repository.list();
	}

	@Override
	public void regist(Item item) throws Exception {
		// TODO Auto-generated method stub
		repository.create(item);
		
		String[] files = item.getFiles();
		Integer itemJoinId = repository.getItemId();
		
		log.info("join id: " + item.getItemId());
		log.info("ready to join: " + itemJoinId);
		
		if (files == null) {
			return;
		}
		
		for (String fileName : files) {
			repository.addAttach(fileName, itemJoinId);
		}
	}

	@Override
	public Item read(Integer itemId) throws Exception {
		// TODO Auto-generated method stub
		return repository.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		// TODO Auto-generated method stub
		repository.update(item);
	}

	@Override
	public void remove(Integer itemId) throws Exception {
		// TODO Auto-generated method stub
		repository.delete(itemId);
	}

	@Override
	public String getPicture(Integer itemId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAttach(Integer itemId) throws Exception {
		// TODO Auto-generated method stub
		return repository.getAttach(itemId);
	}

	@Override
	public Integer getItemId() throws Exception {
		// TODO Auto-generated method stub
		return repository.getItemId();
	}
}