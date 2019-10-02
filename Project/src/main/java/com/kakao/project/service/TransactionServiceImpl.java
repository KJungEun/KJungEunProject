package com.kakao.project.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kakao.project.dao.TransactionDaoService;
import com.kakao.project.model.TransactionModel;

import net.minidev.json.JSONObject;

@Service
@Repository
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDaoService transactionDaoService;
	
	@Override
	public List<LinkedHashMap<String, TransactionModel>>selectOne() throws Exception {
		
		List<LinkedHashMap<String, TransactionModel>> list = null;
		list = transactionDaoService.selectOne();
		return list;
	}
	
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectTwo() throws Exception {
		
		List<LinkedHashMap<String, TransactionModel>> list = transactionDaoService.selectTwo();
		return list;
	}
	
	
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectThree_1() throws Exception {
		
		List<LinkedHashMap<String,TransactionModel>> map = new ArrayList<LinkedHashMap<String, TransactionModel>>();
		map = transactionDaoService.selectThree_1();
		return map;
	}
	
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectThree_2() throws Exception {
		
		List<LinkedHashMap<String,TransactionModel>> map = new ArrayList<LinkedHashMap<String, TransactionModel>>();
		map = transactionDaoService.selectThree_2();
		return map;
	}
	
	@Override
	public LinkedHashMap<String, TransactionModel> selectFour(JSONObject jsonObjectInput) throws Exception {
		
		LinkedHashMap<String, TransactionModel> list = null;
		list = transactionDaoService.selectFour(jsonObjectInput);
		return list;
	}
	

}
