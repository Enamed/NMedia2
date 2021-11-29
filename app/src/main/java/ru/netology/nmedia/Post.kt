package ru.netology.nmedia

data class Post(
    val id: Long,
    val title_news: String,
    val date_news: String,
    val news: String,
    var likedByMe: Boolean = false,
    var likes: Long = 16123L

)

fun count_app(count: Int): String {
    when {

        count in 1000..9999 -> return "1." + (count % 1000 / 100).toString() + "K"
        count in 10000..999999 ->
            return (count / 10000).toString() + "." + (count % 10000 / 1000).toString() + "K"
        count >= 1000000 ->
            return (count / 1000000).toString() + "." + (count % 1000000 / 100000).toString() + "M"
    }
    return count.toString()
}
