package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val title_news: String,
    val date_news: String,
    val news: String,
    val likedByMe: Boolean = false,
    val likes: Long = 16123L,
    val likesCount: Int = 0,
    val share: Boolean = false,
    val sharesCount: Int = 0,
    val visioCount: Int = 0

)
