package com.hly.springCloudOAuth.service;


import com.hly.springCloudOAuth.domain.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticles();
    void deleteArticle(int id);
}
