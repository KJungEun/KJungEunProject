package com.kakao.project.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.kakao.project.model.TransactionFourModel;
import com.kakao.project.model.TransactionOneModel;
import com.kakao.project.model.TransactionThreeModel;
import com.kakao.project.model.TransactionTwoModel;
import com.kakao.project.service.TransactionService;

import javassist.NotFoundException;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionInqController {
	
	@Autowired
	private TransactionService transactionServiceImpl;
	
	@RequestMapping(value = "/selectOne")
	public ModelAndView selectOne (HttpServletRequest request) throws Exception{
		
		JSONArray jsonArray = new JSONArray();
		
		List<TransactionOneModel> list = transactionServiceImpl.selectOne();

		//jsonArray.add(list)는 []가 중복됨
		jsonArray.add(list.get(0));
		jsonArray.add(list.get(1));

		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArray);
		System.out.println("view ; "+view);
		return view;

		
	}

	@RequestMapping(value = "/selectTwo")
	public ModelAndView selectTwo (HttpServletRequest request) throws Exception{
		
		JSONArray jsonArray = new JSONArray();
        
		List<TransactionTwoModel> list = transactionServiceImpl.selectTwo();

		//jsonArray.add(list)는 []가 중복됨
		for(int i=0 ; i<list.size() ; i++) {
			jsonArray.add(list.get(i));
		}
		
		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArray);
		
		return view;
	}

	@RequestMapping(value = "/selectThree")
	public ModelAndView selectThree (HttpServletRequest request) throws Exception{
		
		JSONObject jsonObjectOut1 = new JSONObject();
		JSONObject jsonObjectOut2 = new JSONObject();
		
		JSONArray jsonArrayOut = new JSONArray();
		
		List<TransactionThreeModel> dataList_1 = transactionServiceImpl.selectThree_1();
		List<TransactionThreeModel> dataList_2 = transactionServiceImpl.selectThree_2();

		jsonObjectOut1.put("year", 2018);
		jsonObjectOut1.put("dataList", dataList_1);
		jsonObjectOut2.put("year", 2019);
		jsonObjectOut2.put("dataList", dataList_2);
		
		jsonArrayOut.add(jsonObjectOut1);
		jsonArrayOut.add(jsonObjectOut2);
		
		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArrayOut);
		
		return view;
	}

	
	@RequestMapping(value = "/selectFour/{brName}")
	public ModelAndView selectFour (@ModelAttribute("transactionFourModel") JSONObject jsonObjectInput, @PathVariable String brName,
									HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		JSONObject jsonObjectInOut = new JSONObject();
        
		jsonObjectInput.put("brName", brName);
		
		List<TransactionFourModel> outList = transactionServiceImpl.selectFour(jsonObjectInput);

		//결과 null이면 exception 처리
		if (outList.get(0) == null) {
			throw new NotFoundException(brName);
		}
		
		jsonObjectInOut.put("outList", outList);
		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonObjectInOut);
		
		return view;
	}
	

	@ExceptionHandler(NotFoundException.class)
	public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response){
		
		JSONObject errorData = new JSONObject();
		String code = "404";
		String message = "br code not found error";

		errorData.put("code", code);
		errorData.put("메시지", message);
		
		ModelAndView view = new  ModelAndView("error", "errorData", errorData);
		
		return view;

	}
	
}
