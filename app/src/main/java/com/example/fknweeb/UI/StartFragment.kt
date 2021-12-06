package com.example.fknweeb.UI

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fknweeb.ApiResponse
import com.example.fknweeb.WEB.ApiClient
import com.example.fknweeb.adapters.AnimeSearchAdapter
import com.example.fknweeb.adapters.TrendingAnimeAdapter
import com.example.fknweeb.databinding.FragmentStartBinding
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.repos.AnimeRepository
import com.example.fknweeb.vms.AnimeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

open class StartFragment : Fragment(), SearchView.OnQueryTextListener,
    TrendingAnimeAdapter.OnClickListener {

    private val adapter = TrendingAnimeAdapter(this)
    protected lateinit var binding: FragmentStartBinding

    private val viewModel = AnimeViewModel(AnimeRepository(ApiClient()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentStartBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI(view)

        viewModel.trending.observe(viewLifecycleOwner) {
            when (it) {
                is ApiResponse.Failure -> Toast.makeText(
                    this.context,
                    it.error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                is ApiResponse.Success<*> -> {

                    adapter.updateData(it.data as List<AnimeInfo>)
                }
            }

        }

        lifecycleScope.launch { viewModel.loadTrendingAnime() }
    }

    private fun initUI(view: View) {
        binding = FragmentStartBinding.bind(view)
        binding.fragmentSearchTrendingAnime.adapter = adapter
        binding.fragmentSearchTrendingAnime.layoutManager = LinearLayoutManager(this.context)
        binding.fragmentSearchView.setOnQueryTextListener(this)
    }

    private fun goToAnimeFragment(arg: AnimeInfo) {
        val directions = StartFragmentDirections.actionSearchFragmentToAnimeInfoFragment(arg)
        findNavController().navigate(directions)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StartFragment()
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        if (checkInternetConnection()) {
            if (p0 != null && p0 != "") {
                val searchAdapter = AnimeSearchAdapter(this)
                binding.fragmentSearchTrendingAnime.adapter = searchAdapter
                lifecycleScope.launch {
                    viewModel.getAnime(p0).collectLatest { searchAdapter.submitData(it) }

                }
            } else Toast.makeText(this.context, "Please type something", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this.context, "No internet!!!", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean = false

    private fun checkInternetConnection(): Boolean {

        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            ?: return false

        return cm.activeNetworkInfo != null

    }

    override fun onClick(item: AnimeInfo) = goToAnimeFragment(item)



}