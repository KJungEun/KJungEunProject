package com.kakao.project.dao;

import java.util.List;

import com.kakao.project.model.TransactionOneModel;
import com.kakao.project.model.TransactionTwoModel;

import net.minidev.json.JSONObject;

import com.kakao.project.model.TransactionThreeModel;
import com.kakao.project.model.TransactionFourModel;

public interface TransactionDao {

	/*1번*/
	List<TransactionOneModel> selectOne() throws Exception;
	/*2번*/
	List<TransactionTwoModel> selectTwo() throws Exception;
	/*3번*/
	List<TransactionThreeModel> selectThree_1() throws Exception;
	List<TransactionThreeModel> selectThree_2() throws Exception;
	/*4번*/
	List<TransactionFourModel> selectFour(JSONObject jsonObjectInput) throws Exception;

}

