package com.wpx.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wpx.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(Long id);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> hotsTagIds);

}
