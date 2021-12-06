package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post


class PostRepositoryInMemory: PostRepository {

    var post = Post(
        id = 1,
        title_news = "Нетология. Университет интернет-профессий будущего",
        date_news = "21 мая в 18:36",
        news = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы меняемся сами и помогаем меняться студентам: расти от новичков до уверенных профессионалов.  " +
                "Но самое важное остаётся — наша вера в то, что в каждом заложена сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. " +
                "А наша миссия — помочь выбрать путь и начать цепочку перемен → http://netolo.gy/fyb",
        likedByMe = false,
        likesCount = 999,
        sharesCount = 0,
        visioCount = 1000


        )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data

    override fun like() {
        val counter = if(post.likedByMe)
            post.likesCount - 1 else
                post.likesCount + 1
post = post.copy(likedByMe = !post.likedByMe, likesCount = counter)
        data.value = post
    }

    override fun share() {
        val counter = post.sharesCount + 1
        post = post.copy(share = true, sharesCount = counter)
        data.value = post
    }
}