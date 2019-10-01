package com.kakao.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.project.mapper.TransactionMapper;
import com.kakao.project.model.TransactionOneModel;
import com.kakao.project.model.TransactionTwoModel;

import net.minidev.json.JSONObject;

import com.kakao.project.model.TransactionThreeModel;
import com.kakao.project.model.TransactionFourModel;

@Service("transactionDaoService")
public class TransactionDaoService implements TransactionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TransactionOneModel> selectOne() throws Exception{
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectOne();
    }
	
	public List<TransactionTwoModel> selectTwo() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectTwo();
    }
	
	@Override
	public List<TransactionThreeModel> selectThree_1() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectThree_1();
    }
	@Override
	public List<TransactionThreeModel> selectThree_2() throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
        return mapper.selectThree_2();
    }

	@Override
	public List<TransactionFourModel> selectFour(JSONObject jsonObjectInput) throws Exception {
		TransactionMapper mapper = sqlSession.getMapper(TransactionMapper.class);
		return mapper.selectFour(jsonObjectInput);
	}
	
}
