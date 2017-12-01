package com.hangh.home.service;

import java.util.List;

import com.hangh.home.po.Village;
import com.hangh.home.utils.ResultData;

public interface VillageService {



	Village selectVillageInfo(Integer homeid);

	List<Village> getVillageListByDistrict(String district);

	Village searchByName(String villageName);

	boolean isAlreadyCreated(String villageName);

	ResultData<Village> insert(String villageIcon, String villageName, String villageDesc, int attentionNum, int postNum,
			String province, String city, String district);
	
}
