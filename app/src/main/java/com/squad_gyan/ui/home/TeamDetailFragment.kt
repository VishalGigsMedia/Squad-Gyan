package com.squad_gyan.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.squad_gyan.common_helper.PreferenceHelper
import com.squad_gyan.databinding.FragmentTeamDetailBinding
import com.squad_gyan.ui.home.adapter.PlayerListAdapter
import com.squad_gyan.ui.home.model.MatchDetailsModel
import com.squad_gyan.ui.home.model.PlayersModel

class TeamDetailFragment : Fragment() {

    private var mBinding: FragmentTeamDetailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        setAdapter()
    }

    private fun setAdapter() {
        val gson = Gson()
        val preferenceHelper = PreferenceHelper(requireContext())
        val teamFirst = preferenceHelper.getString("team1")
        val teamFirstObject: MatchDetailsModel.Data.FantasyTeams.Team1 = gson.fromJson(teamFirst, MatchDetailsModel.Data.FantasyTeams.Team1::class.java)

        println("teamFirst : $teamFirst")

        // wicket keeper
        /* if (teamFirstObject.wicket_keepers?.isNotEmpty()!!) {
             var batsmen: ArrayList<PlayersModel> = ArrayList()
             for (i in teamFirstObject.wicket_keepers) {
                 val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                 batsmen.add(playerModel)
             }

             val playerListAdapter = PlayerListAdapter(requireActivity(), batsmen)
             mBinding?.rvBatsmen?.adapter = playerListAdapter
             mBinding?.rvBatsmen?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
             playerListAdapter.notifyDataSetChanged()

         }*/

        //batsmen
        if (teamFirstObject.batsmens?.isNotEmpty()!!) {
            val batsmen: ArrayList<PlayersModel> = ArrayList()
            for (i in teamFirstObject.batsmens) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                batsmen.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), batsmen)
            mBinding?.rvBatsmen?.adapter = playerListAdapter
            mBinding?.rvBatsmen?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }

        //all rounder
        if (teamFirstObject.allrounders?.isNotEmpty()!!) {
            val allRounders: ArrayList<PlayersModel> = ArrayList()
            for (i in teamFirstObject.allrounders) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                allRounders.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), allRounders)
            mBinding?.rvAllRound?.adapter = playerListAdapter
            mBinding?.rvAllRound?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }

        //bowler
         if (teamFirstObject.bowlers?.isNotEmpty()!!) {
             val bowler: ArrayList<PlayersModel> = ArrayList()
             for (i in teamFirstObject.bowlers) {
                 val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                 bowler.add(playerModel)
             }

              val playerListAdapter = PlayerListAdapter(requireActivity(), bowler)
              mBinding?.rvBowler?.adapter = playerListAdapter
              mBinding?.rvBowler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
              playerListAdapter.notifyDataSetChanged()

         }

    }


}