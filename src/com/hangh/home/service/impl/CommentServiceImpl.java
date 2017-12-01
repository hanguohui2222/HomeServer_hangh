package com.hangh.home.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hangh.home.mapper.CommentMapper;
import com.hangh.home.mapper.CommentMapperCustom;
import com.hangh.home.po.Comment;
import com.hangh.home.po.CommentExample;
import com.hangh.home.pojo.CommentCustom;
import com.hangh.home.pojo.Page;
import com.hangh.home.service.CommentService;
import com.hangh.home.utils.PageUtils;
import com.hangh.home.utils.ResultData;

@Transactional
@Service
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentMapper commentMapper;
	@Resource
	private CommentMapperCustom commentMapperCustom;
	
	
	public List<Comment> selectCommentsPageByPostId(CommentCustom custom) throws Exception {
		return commentMapperCustom.selectCommentsPageByPostId(custom);
	}


	@Override
	public ResultData<List<Comment>> selectComments(Integer currentPage, Integer pageCount, Integer postid) throws Exception {
		CommentCustom custom=new CommentCustom();
		custom.setPostid(postid);
		Page page;
		ResultData<List<Comment>> resultData = new ResultData<>();
		if(currentPage>=2){
			/* @param everyPage 每一页记录数
			 * @param totalCount 总记录数
			 * @param currentPage 当前页数
			 */ 
			page = PageUtils.createPage(pageCount, currentPage);
		}else{
			int count = countCommentBypostid(postid);
			if(count == 0){
//				json.put("pageNum", count);
				resultData.setData(null);
				return resultData;
			}else{
				page = PageUtils.createPage(pageCount, count, currentPage);
//				json.put("pageNum", page.getTotalPage());
			}
		}	
		custom.setPage(page);
		List<Comment> list = commentMapperCustom.selectCommentsPageByPostId(custom);
		resultData.setData(list);
		return resultData;
	}
	
	public int countCommentBypostid(int postid) {
		CommentExample commentExample = new CommentExample();
		com.hangh.home.po.CommentExample.Criteria criteria = commentExample.createCriteria();
		criteria.andPostidEqualTo(postid);
		return commentMapper.countByExample(commentExample);
	}


	@Override
	public void insert(Comment record) {
		commentMapperCustom.insertCommentGetCommentId(record);
	}


	@Override
	public Comment selectByPrimaryKey(Integer id) {
		return commentMapper.selectByPrimaryKey(id);
	}

}
