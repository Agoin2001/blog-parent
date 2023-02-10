package com.wpx.blog.Controller;

import com.wpx.blog.Vo.Result;
import com.wpx.blog.Vo.TagVo;
import com.wpx.blog.service.TagsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    @GetMapping("/hot")
    public Result listHotTags() {
        int limit = 6;
        List<TagVo> tagVoList = tagsService.hot(limit);
        return Result.success(tagVoList);
    }
}
