package com.hangh.home.service;

import java.util.List;


import com.hangh.home.po.Comment;
import com.hangh.home.utils.ResultData;

public interface CommentService {


	ResultData<List<Comment>> selectComments(Integer page, Integer num, Integer postid) throws Exception;
	
	void insert(Comment record);  
	 
	Comment selectByPrimaryKey(Integer id);
	 
}
