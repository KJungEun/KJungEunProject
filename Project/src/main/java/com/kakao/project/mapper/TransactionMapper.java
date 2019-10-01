package com.kakao.project.mapper;

import java.util.List;

import com.kakao.project.model.TransactionOneModel;
import com.kakao.project.model.TransactionTwoModel;

import net.minidev.json.JSONObject;

import com.kakao.project.model.TransactionThreeModel;
import com.kakao.project.model.TransactionFourModel;

public interface TransactionMapper {
	public List<TransactionOneModel> selectOne() throws Exception;
	public List<TransactionTwoModel> selectTwo() throws Exception;
	public List<TransactionThreeModel> selectThree_1() throws Exception;
	public List<TransactionThreeModel> selectThree_2() throws Exception;
	public List<TransactionFourModel> selectFour(JSONObject jsonObjectInput);
}
