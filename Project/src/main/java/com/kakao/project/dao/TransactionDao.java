package com.kakao.project.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.kakao.project.model.TransactionModel;

import net.minidev.json.JSONObject;


public interface TransactionDao {

	/*1번*/
	List<LinkedHashMap<String, TransactionModel>> selectOne() throws Exception;
	/*2번*/
	List<LinkedHashMap<String, TransactionModel>> selectTwo() throws Exception;
	/*3번*/
	List<LinkedHashMap<String, TransactionModel>> selectThree_1() throws Exception;
	List<LinkedHashMap<String, TransactionModel>> selectThree_2() throws Exception;
	/*4번*/
	LinkedHashMap<String, TransactionModel> selectFour(JSONObject jsonObjectInput) throws Exception;

}

