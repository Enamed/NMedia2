package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // устанавливаем начальное кол-во лайков с помощью setText
        val countFavorite = 999
        count_like.setText(countFavorite.toString())

        //арифметика для лайков
        val plusLike: Int = countFavorite + 1
        val minusLike: Int = plusLike - 1

        // устанавливаем начальное кол-во share - для проверки работы алгоритма
        var count_FinalShare = 0
        share_news.setText(count_FinalShare.toString())

        // устанавливаем начальное кол-во просмотров- для проверки работы алгоритма
        var counter_visio = 1000
        count_visio.setText(count_app(counter_visio))


        val post = Post(
            id = 1,
            title_news = "Нетология. Университет интернет-профессий будущего",
            date_news = "21 мая в 18:36",
            news = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. " +
                    "Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы меняемся сами и помогаем меняться студентам: расти от новичков до уверенных профессионалов.  " +
                    "Но самое важное остаётся — наша вера в то, что в каждом заложена сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. " +
                    "А наша миссия — помочь выбрать путь и начать цепочку перемен → http://netolo.gy/fyb",
            likedByMe = false,

            )
        with(binding) {


            title_news.text = post.title_news
            date_news.text = post.date_news
            news.text = post.news

            if (post.likedByMe) {
                like?.setImageResource(R.drawable.ic_liked)
            }

            like?.setOnClickListener {
                post.likedByMe = !post.likedByMe

                // меняем цвет сердечка
                like.setImageResource(
                    if (post.likedByMe)
                        R.drawable.ic_liked
                    else
                        R.drawable.ic_baseline_favorite_24
                )

                // арифметическая логика для лайка
//                if (post.likedByMe)
//                count_like.setText(plusLike.toString())
//                else
//                count_like.setText(minusLike.toString())

                if (post.likedByMe)
                    count_like.setText(count_app(plusLike))
                else
                    count_like.setText(count_app(minusLike))






            }

            share.setOnClickListener {
                count_FinalShare++
                share_news.setText(count_app(count_FinalShare))
            }

//            visio.setOnClickListener {
//                counte_FinalShare++
//                share_news.setText(longToString(count_FinalShare))
//            }

        }
    }
}

