package com.kakao.project.mapper;

import java.util.LinkedHashMap;
import java.util.List;

import com.kakao.project.model.TransactionModel;

import net.minidev.json.JSONObject;

public interface TransactionMapper {
	public List<LinkedHashMap<String, TransactionModel>> selectOne() throws Exception;
	public List<LinkedHashMap<String, TransactionModel>> selectTwo() throws Exception;
	public List<LinkedHashMap<String, TransactionModel>> selectThree_1() throws Exception;
	public List<LinkedHashMap<String, TransactionModel>> selectThree_2() throws Exception;
	public LinkedHashMap<String, TransactionModel> selectFour(JSONObject jsonObjectInput) throws Exception;
}
