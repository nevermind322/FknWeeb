package com.example.fknweeb.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.fknweeb.R
import com.example.fknweeb.databinding.FragmentAnimeInfoBinding

class AnimeInfoFragment : Fragment() {

    private val args by navArgs<AnimeInfoFragmentArgs>()

    private lateinit var binding: FragmentAnimeInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeInfoBinding.bind(view)
        binding.detailTitle.text = args.animeArg.name
        binding.detailAnimePoster.load(args.animeArg.image)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnimeInfoFragment()

    }
}