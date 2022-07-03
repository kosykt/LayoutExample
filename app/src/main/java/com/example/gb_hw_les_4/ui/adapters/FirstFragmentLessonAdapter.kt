package com.example.gb_hw_les_4.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gb_hw_les_4.Lesson
import com.example.gb_hw_les_4.R
import com.example.gb_hw_les_4.databinding.ItemClassesBinding

class FirstFragmentLessonAdapter(
    val zoom: (Lesson) -> Unit,
) : ListAdapter<Lesson, FirstFragmentLessonAdapter.LessonViewHolder>(LessonCallback) {
    inner class LessonViewHolder(private val vb: ItemClassesBinding) :
        RecyclerView.ViewHolder(vb.root) {
        fun show(lesson: Lesson) {
            vb.itemClassesLessonLabel.text = lesson.lesson
            vb.itemClassesLessonTimeTextView.text = lesson.time
            if (lesson.canOpenIn) {
                vb.itemLessonGroupOpenIn.visibility = View.VISIBLE
                vb.itemClassesOpenInBackground.setOnClickListener {
                    zoom(lesson)
                }
            } else {
                vb.itemLessonGroupOpenIn.visibility = View.GONE
            }
            if (lesson.description.isNotEmpty()) {
                vb.itemClassesCardConstraint.background =
                    vb.itemClassesCardConstraint.context.getDrawable(
                        R.drawable.shape_gradient_background
                    )
            }
            when (lesson.lesson) {
                "History" -> {
                    vb.itemClassesLessonLogoImageView.setImageResource(R.drawable.bow_and_arrow)
                }
                "Literature" -> {
                    vb.itemClassesLessonLogoImageView.setImageResource(R.drawable.book)
                }
                "Physical Education" -> {
                    vb.itemClassesLessonLogoImageView.setImageResource(R.drawable.ball_basketball_dribbble_logo_icon)
                }
                "Math" -> {
                    vb.itemClassesLessonLogoImageView.setImageResource(R.drawable.math_icon)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(
            ItemClassesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.show(currentList[position])
    }

    companion object LessonCallback : DiffUtil.ItemCallback<Lesson>() {
        override fun areItemsTheSame(
            oldItem: Lesson,
            newItem: Lesson
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Lesson,
            newItem: Lesson
        ): Boolean {
            return oldItem == newItem
        }
    }
}