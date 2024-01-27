package com.example.newsappbyxml.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappbyxml.R
import com.example.newsappbyxml.databinding.ItemArticlePreviewBinding
import com.example.newsappbyxml.model.Article
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticlePreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        val binding = holder.binding
        if (isArticleRemoved(article)) {
           return
        } else {
            with(binding) {
                if (article.urlToImage != null) {
                    GlideApp.with(ivArticleImage).load(article.urlToImage).into(ivArticleImage)
                } else {
                    GlideApp.with(ivArticleImage).load(R.drawable.news_null).into(ivArticleImage)
                }
                tvSource.text = article.source?.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt.convertToReadableDate()

                root.setOnClickListener {
                    onItemClickListener?.let { it(article) }
                }
            }
        }
    }

    private fun isArticleRemoved(article: Article): Boolean {
        return article.title == "[Removed]" || article.description == "[Removed]" || article.content == "[Removed]"
    }

    fun submitFilteredList(filteredList: List<Article>) {
        val nonRemovedList = filteredList.filter { !isArticleRemoved(it) }
        differ.submitList(nonRemovedList)
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit) {
        onItemClickListener = listener
    }


    private fun String?.convertToReadableDate(): String {
        if (this.isNullOrEmpty()) {
            return ""
        }

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())

        try {
            val date = inputFormat.parse(this)
            return outputFormat.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return ""
    }
}
