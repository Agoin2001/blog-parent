package com.wpx.blog.service;

import com.wpx.blog.Vo.TagVo;

import java.util.List;

public interface TagsService {
    List<TagVo> findTagsByArticleId(Long id);


    List<TagVo> hot(int limit);

}
