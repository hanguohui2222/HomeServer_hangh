package com.hangh.home.mapper;

import java.util.List;

import com.hangh.home.po.Comment;
import com.hangh.home.pojo.CommentCustom;


public interface CommentMapperCustom {
	
	List<Comment> selectCommentsPageByPostId(CommentCustom custom) throws Exception;
	
	void insertCommentGetCommentId(Comment record);  //返回评论id


}
