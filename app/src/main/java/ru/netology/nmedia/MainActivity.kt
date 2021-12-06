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
        viewModel.data.observe(this) { post ->
            with(binding) {
                titleNews.text = post.title_news
                news.text = post.news
                dateNews.text = post.date_news
                countLike.text = Utils.numbers(post.likesCount)
                shareNews.text = Utils.numbers(post.sharesCount)
                countVisio.text = Utils.numbers(post.visioCount)
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked
                    else R.drawable.ic_baseline_favorite_24
                )
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
