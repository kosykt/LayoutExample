package com.example.gb_hw_les_4.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_hw_les_4.HomeWork
import com.example.gb_hw_les_4.R
import com.example.gb_hw_les_4.databinding.ItemHomeWorkBinding

class HomeWorkAdapter() :
    ListAdapter<HomeWork, HomeWorkAdapter.HomeWorkViewHolder>(HomeWorkCallback) {
    class HomeWorkViewHolder(private val vb: ItemHomeWorkBinding) :
        RecyclerView.ViewHolder(vb.root) {
        fun show(homeWork: HomeWork) {
            vb.itemHomeWorkTitle.text = homeWork.lesson
            vb.itemHomeWorkDescription.text = homeWork.description
            vb.itemHomeWorkTimeTextView.text = homeWork.time
            when (homeWork.lesson) {
                "History" -> {
                    vb.itemHomeWorkImageView.setImageResource(R.drawable.bow_and_arrow)
                }
                "Literature" -> {
                    vb.itemHomeWorkImageView.setImageResource(R.drawable.book)
                }
                "Physics" -> {
                    vb.itemHomeWorkImageView.setImageResource(R.drawable.physics_icon)
                }
                "Math" -> {
                    vb.itemHomeWorkImageView.setImageResource(R.drawable.math_icon)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeWorkViewHolder {
        return HomeWorkViewHolder(
            ItemHomeWorkBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeWorkViewHolder, position: Int) {
        holder.show(currentList[position])
    }

    companion object HomeWorkCallback : DiffUtil.ItemCallback<HomeWork>() {
        override fun areItemsTheSame(
            oldItem: HomeWork,
            newItem: HomeWork
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: HomeWork,
            newItem: HomeWork
        ): Boolean {
            return oldItem == newItem
        }
    }
}