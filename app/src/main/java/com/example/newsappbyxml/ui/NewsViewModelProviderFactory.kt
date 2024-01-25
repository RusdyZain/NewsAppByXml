package com.example.newsappbyxml.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappbyxml.repository.NewsRepository

class NewsViewModelProviderFactory(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return NewsViewModel(newsRepository) as T
    }
}