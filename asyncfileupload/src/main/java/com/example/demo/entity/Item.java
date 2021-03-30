package com.example.demo.entity;

import java.io.Serializable;
import java.util.Arrays;

// 직렬화를 사용하는 이유 ?
public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer itemId;
	
	private String itemName;
	
	private Integer price;
	
	private String description;
	
	private String[] files;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", description=" + description
				+ ", files=" + Arrays.toString(files) + "]";
	}
}