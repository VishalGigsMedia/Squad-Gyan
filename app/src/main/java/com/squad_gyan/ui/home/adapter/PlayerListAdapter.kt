package com.squad_gyan.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squad_gyan.R
import com.squad_gyan.common_helper.DefaultHelper
import com.squad_gyan.databinding.RowItemPlayerListBinding
import com.squad_gyan.ui.home.CricketMatchListFragment
import com.squad_gyan.ui.home.model.MatchListModel
import java.util.*

class PlayerListAdapter(
    private val context: Context, private val list: ArrayList<MatchListModel.Data.Match>, private val matchListClickListener: CricketMatchListFragment
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mcontext: Context

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemPlayerListBinding: RowItemPlayerListBinding = RowItemPlayerListBinding.bind(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        mcontext = viewGroup.context

        val view = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.row_item_player_list, viewGroup, false
        )
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            try {

                holder.itemPlayerListBinding.tvPlayerName.text = ""

                if (DefaultHelper.decrypt(list[position].title).isNotEmpty()) {
                    //holder.itemOffersBinding.tvTitle.text = DefaultHelper.decrypt(list[position].title)
                }

                /*holder.itemOffersBinding.cvParent.setOnClickListener {
                    matchListClickListener.onMatchClick(list[position].id, ConstantHelper.cricket)
                }*/

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun addData(list: List<MatchListModel.Data.Match>?) {
        this.list.addAll(list!!)
        notifyDataSetChanged()
    }


    interface MatchListClickListener {
        fun onMatchClick(id: String, matchType: String)
        fun onShowErrorDialog()
    }

}