package com.squad_insight.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squad_insight.MainActivity
import com.squad_insight.common_helper.Application
import com.squad_insight.common_helper.BundleKey
import com.squad_insight.common_helper.ConstantHelper
import com.squad_insight.common_helper.DefaultHelper.decrypt
import com.squad_insight.common_helper.DefaultHelper.forceLogout
import com.squad_insight.common_helper.DefaultHelper.showToast
import com.squad_insight.common_helper.OnCurrentFragmentVisibleListener
import com.squad_insight.retrofit.APIService
import com.squad_insight.ui.home.adapter.MatchDetailsAdapter
import com.squad_insight.ui.home.model.MatchDetailsModel
import com.squad_insight.ui.home.view_model.MatchListViewModel
import com.squad_insight.databinding.FragmentMatchDetailsBinding
import javax.inject.Inject

class MatchDetailFragment : Fragment() {
    @Inject
    lateinit var apiService: APIService

    private var callback: OnCurrentFragmentVisibleListener? = null

    private lateinit var layoutManager: LinearLayoutManager
    private var list: ArrayList<MatchDetailsModel.Data.Prediction> = ArrayList()
    private var adapter: MatchDetailsAdapter? = null

    private lateinit var viewModel: MatchListViewModel
    private var mBinding: FragmentMatchDetailsBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        Application.instance?.getComponent()?.inject(this)
        viewModel = ViewModelProvider(this).get(MatchListViewModel::class.java)
        mBinding = FragmentMatchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        callback?.onSetToolbarTitle(true, MatchDetailFragment::class.java.simpleName)
        setAdapter()

        val bundle = arguments
        if (bundle != null) {
            val matchId = bundle.getString(BundleKey.MatchId.toString()).toString()
            val matchType = bundle.getString(BundleKey.MatchType.toString()).toString()

            getMatchDetails(matchId, matchType)
        }
    }

    fun setOnCurrentFragmentVisibleListener(activity: MainActivity) {
        callback = activity
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    private fun setAdapter() {
        layoutManager = LinearLayoutManager(context)
        mBinding?.rvMatchDetails?.layoutManager = layoutManager
        adapter = MatchDetailsAdapter(
            context as FragmentActivity, list
        )
        mBinding?.rvMatchDetails?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    private fun getMatchDetails(matchId: String, matchType: String) {
        viewModel.getMatchDetails(context as FragmentActivity, apiService, matchId, matchType)?.observe(viewLifecycleOwner, { matchDetailsModel ->
            if (matchDetailsModel != null) {
                if (matchDetailsModel.force_logout != ConstantHelper.forceLogout) {
                    forceLogout(context as FragmentActivity, "")
                }
                when (matchDetailsModel.status) {
                    ConstantHelper.success -> {
                        setMatchDetails(matchDetailsModel.data?.match_details)
                        if (matchDetailsModel.data?.prediction?.isNotEmpty() == true) {
                            mBinding?.rvMatchDetails?.visibility = View.VISIBLE
                            this.list = matchDetailsModel.data.prediction as ArrayList<MatchDetailsModel.Data.Prediction>
                            adapter?.addData(list)
                        }
                    }
                    ConstantHelper.failed -> {
                        setNoDataLayout(decrypt(matchDetailsModel.message))
                    }
                    ConstantHelper.authorizationFailed -> {
                        setNoDataLayout(decrypt(matchDetailsModel.message))
                    }
                    ConstantHelper.apiFailed -> {
                        showToast(context, decrypt(matchDetailsModel.message))
                    }
                    ConstantHelper.noInternet -> {
                        setNoDataLayout(decrypt(matchDetailsModel.message))
                    }
                }
            }
        })
    }

    private fun setNoDataLayout(msg: String) {
        if (msg.isNotEmpty()) {
            mBinding?.clNoData?.tvNoDataLayout?.text = msg
            mBinding?.clNoData?.clNoDataParent?.visibility = View.VISIBLE
        }
    }

    private fun setMatchDetails(matchDetails: MatchDetailsModel.Data.MatchDetails?) {
        if (matchDetails != null) {
            mBinding?.clMatchDetail?.visibility = View.VISIBLE
            mBinding?.cvMatchDetails?.visibility = View.VISIBLE
            mBinding?.tvTitle?.visibility = View.VISIBLE
            if (decrypt(matchDetails.title).isNotEmpty()) {
                mBinding?.tvTitle?.text = decrypt(matchDetails.title)
            }
            if (decrypt(matchDetails.match).isNotEmpty()) {
                mBinding?.tvMatchValue?.text = decrypt(matchDetails.match)
            }
            if (decrypt(matchDetails.tournament).isNotEmpty()) {
                mBinding?.tvTournamentValue?.text = decrypt(matchDetails.tournament)
            }
            if (decrypt(matchDetails.match_date).isNotEmpty()) {
                val value = decrypt(matchDetails.match_date).split(" ")
                val date = value[0]
                val time = value[1]
                mBinding?.tvDateValue?.text = date
                mBinding?.tvTimeValue?.text = time
            }
        }
    }

}