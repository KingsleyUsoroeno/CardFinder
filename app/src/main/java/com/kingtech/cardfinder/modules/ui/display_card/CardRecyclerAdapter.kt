package com.kingtech.cardfinder.modules.ui.display_card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.cardfinder.R
import com.kingtech.cardfinder.data.entities.Bin
import com.kingtech.cardfinder.data.entities.Result
import com.kingtech.cardfinder.databinding.LayoutCardListBinding

class CardRecyclerAdapter : ListAdapter<Result, CardRecyclerAdapter.CardViewHolder>(
    NotificationDiffUtil()
) {

    private lateinit var viewBinding: LayoutCardListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_card_list, parent, false
        )
        return CardViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cardResult = getItem(position).bin
        holder.bind(cardResult)
    }

    inner class CardViewHolder(view: LayoutCardListBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(bin: Bin) {
            viewBinding.card = bin
            viewBinding.executePendingBindings()
        }
    }

    class NotificationDiffUtil : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.bin == newItem.bin
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

}