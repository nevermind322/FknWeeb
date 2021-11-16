package com.example.fknweeb.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.fknweeb.WEB.ApiClient
import com.example.fknweeb.databinding.FragmentSearchBinding
import com.example.fknweeb.domain.AnimeInfo
import com.example.fknweeb.domain.AnimeRepository
import com.example.fknweeb.vms.AnimeViewModel
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {


    private lateinit var binding: FragmentSearchBinding

    private val viewModel = AnimeViewModel(AnimeRepository(ApiClient()))


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        // Inflate the layout for this fragment

        FragmentSearchBinding.inflate(inflater, container, false).root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        viewModel.res = MutableLiveData()
        viewModel.res.observe(viewLifecycleOwner) {
            goToAnimeFragment(it)
        }
        binding.searchButton.setOnClickListener {

            lifecycleScope.launch {
                if (binding.textInputLayout.editText?.text.toString() != "") {

                    viewModel.find(binding.textInputLayout.editText?.text.toString())
                }
                else Toast.makeText(this@SearchFragment.context, "Please, type something", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun goToAnimeFragment(arg: AnimeInfo) {
        val directions = SearchFragmentDirections.actionSearchFragmentToAnimeInfoFragment(arg)
        findNavController().navigate(directions)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment()
    }

}