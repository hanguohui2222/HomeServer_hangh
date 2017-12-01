package com.hangh.home.mapper;

import java.util.List;

import com.hangh.home.po.Post;
import com.hangh.home.pojo.PostCustom;


public interface PostMapperCustom {
	
	List<Post> selectPostpage(PostCustom custom) throws Exception;

}
