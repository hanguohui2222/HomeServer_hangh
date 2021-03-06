package com.hangh.home.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hangh.home.mapper.AdMapper;
import com.hangh.home.po.Ad;
import com.hangh.home.po.AdExample;
import com.hangh.home.utils.ResultData;

/**
 * 轮播广告
 * @author luqinmao
 *
 */
@Controller
@RequestMapping(value="ad",produces="text/plain;charset=UTF-8")
public class AdCtrl {

	@Resource
	private AdMapper adMapper;

	/***
	 * 获取广告列表
	 */
	@RequestMapping(value = "getAds", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.GET)
	@ResponseBody
	public ResultData<List<Ad>> getAds() throws Exception {
		List<Ad> ads = adMapper.selectByExample(new AdExample());
		ResultData<List<Ad>> resultData = new ResultData<>();
		resultData.setData(ads);
		resultData.setCode(200);
		resultData.setMsg("请求成功");
		return resultData;
	}
	
}
