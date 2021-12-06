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
//    val author: Author

)
////
////data class Author(
////    val id: Long,
////    val name: String
////)
////
////fun main(){
////    val post = Post(
////        id = 0,
////        title_news = "TESTsss",
////        date_news = "00:00",
////        news = "jlkhk",
////        Author(1, "Test");
////    )
////
////    val copy = post.copy(
////           author = post.author.copy(
////               name = "test"
////           )
////       )
//
//
//}


//fun count_app(count: Int): String {
//    when {
//
//        count in 1000..9999 -> return "1." + (count % 1000 / 100).toString() + "K"
//        count in 10000..999999 ->
//            return (count / 10000).toString() + "." + (count % 10000 / 1000).toString() + "K"
//        count >= 1000000 ->
//            return (count / 1000000).toString() + "." + (count % 1000000 / 100000).toString() + "M"
//    }
//    return count.toString()
//}
