package com.wpx.blog.service;

import com.wpx.blog.Vo.ArticleVo;
import com.wpx.blog.Vo.Result;
import com.wpx.blog.Vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    List<ArticleVo> listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);


    Result newArticles(int limit);

    Result listArchives();


    Result findArticleById(Long articleId);


}
