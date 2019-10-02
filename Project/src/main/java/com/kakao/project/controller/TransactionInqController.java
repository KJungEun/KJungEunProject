package com.kakao.project.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.kakao.project.model.TransactionModel;
import com.kakao.project.service.TransactionService;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionInqController {
	
	@Autowired
	private TransactionService transactionServiceImpl;
	
	/********
	 * 1번 *
	 *******/
	@RequestMapping(value = "/selectOne")
	public ModelAndView selectOne (HttpServletRequest request) throws Exception{
		
		JSONArray jsonArray = new JSONArray();
		
		List<LinkedHashMap<String, TransactionModel>> list = transactionServiceImpl.selectOne();

		//jsonArray.add(list)는 []가 중복됨
		jsonArray.add(list.get(0));
		jsonArray.add(list.get(1));

		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArray);
		System.out.println("view ; "+view);
		return view;

	}

	/********
	 * 2번 *
	 *******/
	@RequestMapping(value = "/selectTwo")
	public ModelAndView selectTwo (HttpServletRequest request) throws Exception{
		
		JSONArray jsonArray = new JSONArray();
        
		List<LinkedHashMap<String, TransactionModel>> list = transactionServiceImpl.selectTwo();

		//jsonArray.add(list)는 []가 중복됨
		for(int i=0 ; i<list.size() ; i++) {
			jsonArray.add(list.get(i));
		}
		
		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArray);
		
		return view;
	}

	/********
	 * 3번 *
	 *******/
	@RequestMapping(value = "/selectThree")
	public ModelAndView selectThree (HttpServletRequest request) throws Exception{
		
		JSONObject jsonObjectOut1 = new JSONObject();
		JSONObject jsonObjectOut2 = new JSONObject();
		
		JSONArray jsonArrayOut = new JSONArray();
		
		List<LinkedHashMap<String, TransactionModel>> dataList_1 = transactionServiceImpl.selectThree_1();
		List<LinkedHashMap<String, TransactionModel>> dataList_2 = transactionServiceImpl.selectThree_2();

		jsonObjectOut1.put("year", 2018);
		jsonObjectOut1.put("dataList", dataList_1);
		jsonObjectOut2.put("year", 2019);
		jsonObjectOut2.put("dataList", dataList_2);
		
		jsonArrayOut.add(jsonObjectOut1);
		jsonArrayOut.add(jsonObjectOut2);
		
		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArrayOut);
		
		return view;
	}
	
	/********
	 * 4번 *
	 *******/
	@RequestMapping(value = "/selectFour/{brName}")
	public ModelAndView selectFour (@ModelAttribute("transactionFourModel") JSONObject jsonObjectInput, @PathVariable String brName,
									HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		jsonObjectInput.put("brName", brName);
		LinkedHashMap<String, TransactionModel> outList = new LinkedHashMap<String, TransactionModel>();
		try {
			outList = transactionServiceImpl.selectFour(jsonObjectInput);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		if (outList.get("brCode")==null) {
			throw new NullPointerException();
		}
		//JSONArray 변환
		JSONArray jsonArrayOut = new JSONArray();
		jsonArrayOut.add(outList);

		ModelAndView view = new  ModelAndView("selectAll", "selectData", jsonArrayOut);
		
		return view;
	}
	

	@ExceptionHandler(NullPointerException.class)
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
