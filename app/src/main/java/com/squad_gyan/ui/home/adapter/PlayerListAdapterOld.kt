package com.squad_gyan.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squad_gyan.R
import com.squad_gyan.common_helper.DefaultHelper.decrypt
import com.squad_gyan.databinding.RowItemPlayerListBinding
import com.squad_gyan.ui.home.model.PlayersModel

class PlayerListAdapterOld(
    private val context: Context, private val list: ArrayList<PlayersModel>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var mcontext: Context

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemPlayerListBinding: RowItemPlayerListBinding = RowItemPlayerListBinding.bind(itemView)
    }

    override fun getItemCount(): Int {
        return 1//list?.size!!
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

               /* if (position == 0) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameFirstBatsmen.text = decrypt(list!![position].name)
                }

                if (position == 1) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameFirstBatsmen.text = decrypt(list!![position].name)
                }

                if (position == 2) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameSecondBatsmen.text = decrypt(list!![position].name)
                }

                if (position == 3) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameThirdBatsmen.text = decrypt(list!![position].name)
                }

                if (position == 4) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameFourthBatsmen.text = decrypt(list!![position].name)
                }

                if (position == 5) {
                    println("playerName: " + decrypt(list!![position].name))
                    holder.itemPlayerListBinding.tvPlayerNameFifthBatsmen.text = decrypt(list!![position].name)
                }*/

                /* val name = decrypt(list!![position].name)
                 holder.itemPlayerListBinding.tvPlayerName.text = name

                 if (decrypt(list[position].isCaptain).isNotEmpty()) {
                     if (decrypt(list[position].isCaptain) == "1") {
                         holder.itemPlayerListBinding.tvType.visibility = View.VISIBLE
                         holder.itemPlayerListBinding.tvType.text = context.getString(R.string.captain)
                     }
                 }

                 if (decrypt(list[position].isViceCaptain).isNotEmpty()) {
                     if (decrypt(list[position].isViceCaptain) == "1") {
                         holder.itemPlayerListBinding.tvType.visibility = View.VISIBLE
                         holder.itemPlayerListBinding.tvType.text = context.getString(R.string.vice_captain)
                     }
                 }

                 if (decrypt(list[position].profilePic).isNotEmpty()) {
                     Glide.with(context).load(decrypt(list[position].profilePic)).centerCrop().into(holder.itemPlayerListBinding.ivPlayer)
                 }*/

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    interface MatchListClickListener {
        fun onMatchClick(id: String, matchType: String)
        fun onShowErrorDialog()
    }

}