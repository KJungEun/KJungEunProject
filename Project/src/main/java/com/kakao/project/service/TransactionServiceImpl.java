package com.kakao.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kakao.project.dao.TransactionDaoService;
import com.kakao.project.model.TransactionOneModel;
import com.kakao.project.model.TransactionTwoModel;

import net.minidev.json.JSONObject;

import com.kakao.project.model.TransactionThreeModel;
import com.kakao.project.model.TransactionFourModel;

@Service
@Repository
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDaoService transactionDaoService;
	
	@Override
	public List<TransactionOneModel> selectOne() throws Exception {
		
		List<TransactionOneModel> list = null;
		list = transactionDaoService.selectOne();
		return list;
	}
	
	@Override
	public List<TransactionTwoModel> selectTwo() throws Exception {
		
		List<TransactionTwoModel> list = null;
		list = transactionDaoService.selectTwo();
		return list;
	}
	
	@Override
	public List<TransactionThreeModel> selectThree_1() throws Exception {
		
		List<TransactionThreeModel> list = null;
		list = transactionDaoService.selectThree_1();
		return list;
	}
	@Override
	public List<TransactionThreeModel> selectThree_2() throws Exception {
		
		List<TransactionThreeModel> list = null;
		list = transactionDaoService.selectThree_2();
		return list;
	}

	@Override
	public List<TransactionFourModel> selectFour(JSONObject jsonObjectInput) throws Exception {
		
		List<TransactionFourModel> list = null;
		list = transactionDaoService.selectFour(jsonObjectInput);
		return list;
	}
	

}
