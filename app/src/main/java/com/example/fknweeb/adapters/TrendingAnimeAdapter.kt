package com.example.fknweeb.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fknweeb.databinding.ItemTrendingAnimeBinding
import com.example.fknweeb.domain.AnimeInfo

class TrendingAnimeAdapter(private val listener: TrendingAnimeAdapter.OnClickListener) :
    RecyclerView.Adapter<TrendingAnimeAdapter.TrendingAnimeItemViewHolder>() {
    private val list = mutableListOf<AnimeInfo>()


    class TrendingAnimeItemViewHolder(
        itemViewBinding: ItemTrendingAnimeBinding,
        val listener: OnClickListener
    ) :
        RecyclerView.ViewHolder(itemViewBinding.root) {

        private val title = itemViewBinding.itemAnimeTitle
        private val image = itemViewBinding.itemImage
        private val root = itemViewBinding.root

        fun bind(anime: AnimeInfo) {
            title.text = anime.name
            image.load(anime.image)
            root.setOnClickListener { listener.onClick(anime) }
        }
    }

    interface OnClickListener {
        fun onClick(item : AnimeInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAnimeItemViewHolder =
        TrendingAnimeItemViewHolder(
            itemViewBinding = ItemTrendingAnimeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            listener = listener
        )


    override fun onBindViewHolder(holder: TrendingAnimeItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(new: List<AnimeInfo>) {

        list.clear()
        list.addAll(new)
        notifyDataSetChanged()

    }

}