package com.squad_gyan.common_helper

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            /*if (parent.getChildAdapterPosition(view) == 0) {
                top = spaceHeight
            }*/
            top = spaceHeight
            left = spaceHeight
            right = spaceHeight
            bottom = spaceHeight
        }
    }
}
