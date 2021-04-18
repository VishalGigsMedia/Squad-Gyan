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
import com.squad_gyan.ui.home.model.MatchDetailsModel.Data.FantasyTeams.Team1
import com.squad_gyan.ui.home.model.MatchDetailsModel.Data.FantasyTeams.Team2
import com.squad_gyan.ui.home.model.PlayersModel

class TeamDetailFragment : Fragment() {

    private var mBinding: FragmentTeamDetailBinding? = null
    private val binding get() = mBinding!!

    private val gson = Gson()
    private lateinit var preferenceHelper: PreferenceHelper

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
        preferenceHelper = PreferenceHelper(requireContext())
        setTeamFirst()
        setTeamSecond()
    }

    private fun setTeamFirst() {

        val teamFirst = preferenceHelper.getString("team1")
        val teamFirstObject: Team1 = gson.fromJson(teamFirst, Team1::class.java)

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


    private fun setTeamSecond() {

        val teamSecond = preferenceHelper.getString("team2")
        val teamSecondObject: Team2 = gson.fromJson(teamSecond, Team2::class.java)

        // wicket keeper
        if (teamSecondObject.wicket_keepers?.isNotEmpty()!!) {
            val batsmen: ArrayList<PlayersModel> = ArrayList()
            for (i in teamSecondObject.wicket_keepers) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                batsmen.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), batsmen)
            mBinding?.rvTeamSecondWicketKeeper?.adapter = playerListAdapter
            mBinding?.rvTeamSecondWicketKeeper?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }

        //batsmen
        if (teamSecondObject.batsmens?.isNotEmpty()!!) {
            val batsmen: ArrayList<PlayersModel> = ArrayList()
            for (i in teamSecondObject.batsmens) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                batsmen.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), batsmen)
            mBinding?.rvTeamSecondBatsmen?.adapter = playerListAdapter
            mBinding?.rvTeamSecondBatsmen?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }

        //all rounder
        if (teamSecondObject.allrounders?.isNotEmpty()!!) {
            val allRounders: ArrayList<PlayersModel> = ArrayList()
            for (i in teamSecondObject.allrounders) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                allRounders.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), allRounders)
            mBinding?.rvTeamSecondAllRound?.adapter = playerListAdapter
            mBinding?.rvTeamSecondAllRound?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }

        //bowler
        /*if (teamSecondObject.bowlers?.isNotEmpty()!!) {
            val bowler: ArrayList<PlayersModel> = ArrayList()
            for (i in teamSecondObject.bowlers) {
                val playerModel = PlayersModel(i?.id.toString(), i?.name.toString(), i?.profile_pic.toString(), i?.type.toString())
                bowler.add(playerModel)
            }

            val playerListAdapter = PlayerListAdapter(requireActivity(), bowler)
            mBinding?.rvBowler?.adapter = playerListAdapter
            mBinding?.rvBowler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            playerListAdapter.notifyDataSetChanged()

        }*/

    }


}