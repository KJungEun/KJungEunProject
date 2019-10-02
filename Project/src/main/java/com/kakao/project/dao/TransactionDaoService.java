package com.kakao.project.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.project.mapper.TransactionMapper;
import com.kakao.project.model.TransactionModel;

import net.minidev.json.JSONObject;


@Service("transactionDaoService")
public class TransactionDaoService implements TransactionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectOne() throws Exception{
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectOne();
    }
	
	public List<LinkedHashMap<String, TransactionModel>> selectTwo() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectTwo();
    }
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectThree_1() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectThree_1();
    }
	@Override
	public List<LinkedHashMap<String, TransactionModel>> selectThree_2() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectThree_2();
    }
	@Override
	public LinkedHashMap<String, TransactionModel> selectFour(JSONObject jsonObjectInput) throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
		return mapper.selectFour(jsonObjectInput);
	}
	
}
