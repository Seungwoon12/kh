package com.kh.test.fruit.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.kh.test.fruit.model.vo.Fruit;

public class FruitTest {
	public static void main(String[] args) {
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("사과", "달콤"));
		list.add(new Fruit("오렌지", "상큼"));
		list.add(new Fruit("키위", "상큼"));
		
//		System.out.println("값 삽입 : "+list.get(0).getName());
		
		list.remove(0);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getFlavor());
		}
		
		
	}
}
