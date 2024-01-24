package com.example.newsappbyxml.repository

import com.example.newsappbyxml.api.RetrofitInstance
import com.example.newsappbyxml.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}