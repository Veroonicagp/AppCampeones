package com.turing.alan.cpifp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.turing.alan.cpifp.R
import com.turing.alan.cpifp.data.Champion
import com.turing.alan.cpifp.data.ChampionsRepository
import com.turing.alan.cpifp.data.InMemoryChampionsRepository
import com.turing.alan.cpifp.databinding.FragmentChampionListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChampionListFragment : Fragment() {

    private val repository:ChampionsRepository = InMemoryChampionsRepository.getInstance()
    private lateinit var binding: FragmentChampionListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_task_list, container, false)
        binding = FragmentChampionListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //¡?
        super.onViewCreated(view, savedInstanceState)
        val adapter = CampeonesListAdapter(::toChampionDetail)
        val rv = binding.rvCampeones
        rv.adapter = adapter
        (rv.adapter as  CampeonesListAdapter).submitList(repository.getChampions())
    }
    //..
    override fun onResume() {
        super.onResume()
        val recyclerView = binding.rvCampeones
        (recyclerView.adapter as CampeonesListAdapter).submitList(repository.getChampions())
    }

    private fun toChampionDetail(champion: Champion) {
        val action = ChampionListFragmentDirections.actionChampionListFragment2ToChampionInfoFragment2(champion.id)
        findNavController().navigate(action)
    }


}