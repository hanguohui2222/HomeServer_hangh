package com.hangh.home.service;


import java.util.List;

import com.hangh.home.po.Post;
import com.hangh.home.utils.ResultData;

public interface PostService {

	 int insert(Post record);
	 
	 int update(Post record);

	 ResultData<List<Post>> selectPosts(Integer page, Integer num, Integer homeid) throws Exception;

	 Post selectByPrimaryKey(Integer id);
	 
	 

	
}
