package ru.netology.nmedia

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.utils.Utils
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this){
                post ->
            with(binding) {
            title_news.text = post.title_news
            news.text = post.news
            date_news.text = post.date_news
            count_like.text = Utils().numbers(post.likesCount)
            share_news.text = Utils().numbers(post.sharesCount)
                count_visio.text = Utils().numbers(post.visioCount)
            like.setImageResource(if (post.likedByMe) R.drawable.ic_liked
            else R.drawable.ic_baseline_favorite_24)
            }
        }

        like.setOnClickListener {
            viewModel.like()
        }

        share.setOnClickListener {
            viewModel.share()
        }

    }
}






//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)




//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//

//
//        // устанавливаем начальное кол-во лайков с помощью setText
//        val countFavorite = 999
//        count_like.setText(countFavorite.toString())
//
//        //арифметика для лайков
//        val plusLike: Int = countFavorite + 1
//        val minusLike: Int = plusLike - 1
//
//        // устанавливаем начальное кол-во share - для проверки работы алгоритма
//        var count_FinalShare = 0
//        share_news.setText(count_FinalShare.toString())
//
//        // устанавливаем начальное кол-во просмотров- для проверки работы алгоритма
//        var counter_visio = 1000
//        count_visio.setText(count_app(counter_visio))
//
//
//val viewModel: PostViewModel by viewModels()
//        viewModel.data.observe(this){
//        post ->
//        with(binding){
//            title_news.text = post.author
//            news.text = post.content
//            date_news.text = post.published
//            likesCount.text = Utils().reductionInNumbers(post.likesCount)
//            shareCount.text = Utils().reductionInNumbers(post.sharesCount)
//            like.setImageResource(if (post.likedByMe) R.drawable.ic_baseline_favorite_24
//            else R.drawable.ic_baseline_favorite_border_24)
//        }
//        }
//            with(binding) {
//
//                title_news.text = post.title_news
//                date_news.text = post.date_news
//                news.text = post.news
//
////                like.setImageResource(
//////                if (post.likedByMe) {
//////                    like?.setImageResource(R.drawable.ic_liked)
//////                }
////
////                )
//        }
//
//
//
//
//
//
//            like?.setOnClickListener {
//                post.likedByMe = !post.likedByMe
//
//                // меняем цвет сердечка
//                like.setImageResource(
//                    if (post.likedByMe)
//                        R.drawable.ic_liked
//                    else
//                        R.drawable.ic_baseline_favorite_24
//                )
//
//                // арифметическая логика для лайка
//                if (post.likedByMe)
//                    count_like.setText(plusLike.toString())
//                else
//                    count_like.setText(minusLike.toString())
//
//
//
//                share.setOnClickListener {
//                    count_FinalShare++
//                    share_news.setText(count_app(count_FinalShare))
//                }
//
//
////            binding.root.setOnClickListener{
////                count_FinalShare++
////                share_news.setText(count_app(count_FinalShare))
////            }
////            binding.like.setOnClickListener{
////                count_FinalShare++
////                share_news.setText(count_app(count_FinalShare))
////            }
////
////            avatar.setOnClickListener{
////                count_FinalShare++
////                share_news.setText(count_app(count_FinalShare))
////            }
//
//            }
//        }
//    }
////}
//
