package com.example.fknweeb.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.fknweeb.databinding.ItemTrendingAnimeBinding
import com.example.fknweeb.domain.AnimeInfo

class AnimeSearchAdapter (private val listener : TrendingAnimeAdapter.OnClickListener):
    PagingDataAdapter<AnimeInfo, TrendingAnimeAdapter.TrendingAnimeItemViewHolder>(AnimeDiffCallback) {
    override fun onBindViewHolder(
        holder: TrendingAnimeAdapter.TrendingAnimeItemViewHolder,
        position: Int
    ) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingAnimeAdapter.TrendingAnimeItemViewHolder =
        TrendingAnimeAdapter.TrendingAnimeItemViewHolder(
            itemViewBinding = ItemTrendingAnimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            listener = listener
        )


}

object AnimeDiffCallback : DiffUtil.ItemCallback<AnimeInfo>() {
    override fun areItemsTheSame(oldItem: AnimeInfo, newItem: AnimeInfo): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: AnimeInfo, newItem: AnimeInfo): Boolean =
        oldItem == newItem
}
