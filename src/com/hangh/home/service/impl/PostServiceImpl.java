package com.hangh.home.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hangh.home.mapper.PostMapper;
import com.hangh.home.mapper.PostMapperCustom;
import com.hangh.home.po.Post;
import com.hangh.home.po.PostExample;
import com.hangh.home.po.PostExample.Criteria;
import com.hangh.home.pojo.Page;
import com.hangh.home.pojo.PostCustom;
import com.hangh.home.service.PostService;
import com.hangh.home.utils.PageUtils;
import com.hangh.home.utils.ResultData;

@Transactional
@Service
public class PostServiceImpl implements PostService{

	@Resource
	private PostMapper postMapper;
	@Resource
	private PostMapperCustom postMapperCustom;


	public int deleteByPrimaryKey(Integer id) {
		return postMapper.deleteByPrimaryKey(id);
	}

	public int insert(Post record) {
		return postMapper.insert(record);
	}
	
	public int update(Post record){
		return postMapper.updateByPrimaryKey(record);
	}
		

	public Post selectByPrimaryKey(Integer id) {
		return postMapper.selectByPrimaryKey(id);
	}

	@Override
	public ResultData<List<Post>> selectPosts(Integer currentPage, Integer pageCount, Integer homeid) throws Exception {
        PostCustom custom=new PostCustom();
        custom.setVillageId(homeid);
		Page page;
		ResultData<List<Post>> resultData = new ResultData<>();
		
		if(currentPage>=2){
			page = PageUtils.createPage(pageCount, currentPage);
		}else{
			int count = countByHomeid(homeid);
			page = PageUtils.createPage(pageCount, count, currentPage);
			if(count == 0){
//				json.put("pageNum", count);
				resultData.setData(null);
			}else{
//				json.put("pageNum", page.getTotalPage());
				page = PageUtils.createPage(pageCount, currentPage);
			}
		}	
		custom.setPage(page);
		List<Post> list = postMapperCustom.selectPostpage(custom);
		resultData.setData(list);
		return resultData;
	}

	
	public int countByHomeid(Integer homeid) {
		PostExample postExample = new PostExample();
		Criteria criteria = postExample.createCriteria();
		criteria.andVillageIdEqualTo(homeid);
		return postMapper.countByExample(postExample);
	}
	
}
