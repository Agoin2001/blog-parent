package com.wpx.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wpx.blog.Vo.ArticleVo;
import com.wpx.blog.Vo.Result;
import com.wpx.blog.Vo.TagVo;
import com.wpx.blog.Vo.params.PageParams;
import com.wpx.blog.dao.mapper.ArticleMapper;
import com.wpx.blog.dao.pojo.Archives;
import com.wpx.blog.dao.pojo.Article;
import com.wpx.blog.dao.pojo.SysUser;
import com.wpx.blog.service.ArticleService;
import com.wpx.blog.service.SysUserService;
import com.wpx.blog.service.TagsService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private TagsService tagsService;

    public ArticleVo copy(Article article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        if (isAuthor) {
            SysUser sysUser = sysUserService.findSysUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTags){
            List<TagVo> tags = tagsService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article,isAuthor,isBody,isTags);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }




    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        Page<Article> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());

        //????????????????????????,        //?????????????????????????????????order by create_data desc
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);

        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);


        List<ArticleVo> articleVoList = copyList(articlePage.getRecords(),true,false,true);
        return articleVoList;
    }

    @Override
    public Result hotArticle(int limit) {

        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit " + limit);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false,false));
    }

    @Override
    public Result newArticles(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id,title from article order by create_date desc limit 5
        List<Article> articles = articleMapper.selectList(queryWrapper);

        return Result.success(copyList(articles,false,false,false));
    }

    @Override
    public Result listArchives() {
        List<Archives> archivesList = articleMapper.listArchives();
        return Result.success(archivesList);
    }

    @Override
    public Result findArticleById(Long articleId) {
        /**
         * 1. ??????id?????? ????????????
         * 2. ??????bodyId???categoryid ??????????????????
         */
        Article article = this.articleMapper.selectById(articleId);
        ArticleVo articleVo = copy(article, true, true,true);
        //????????????????????????????????????????????????????????????
        //??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // ?????? ???????????????????????? ?????? ?????????????????????????????????????????? ?????????????????????
        //?????????  ????????????????????? ?????????????????????????????????????????????????????????
        //threadService.updateArticleViewCount(articleMapper,article);
        return Result.success(articleVo);

    }
}
