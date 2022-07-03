package com.example.gb_hw_les_4.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.gb_hw_les_4.*
import com.example.gb_hw_les_4.databinding.FragmentFirstBinding
import com.example.gb_hw_les_4.ui.adapters.FirstFragmentLessonAdapter
import com.example.gb_hw_les_4.ui.adapters.HomeWorkAdapter


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() = _binding ?: throw RuntimeException("FragmentFirstBinding? = null")

    private val lessonAdapter by lazy {
        FirstFragmentLessonAdapter(zoom = this::launchZoomApp)
    }

    private val homeWorkAdapter by lazy {
        HomeWorkAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_first_fragment_action_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_firstfragment_search -> {
                Toast.makeText(context, "SEARCH", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item_firstfragment_checked -> {
                Toast.makeText(context, "CHECKED LIST", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item_firstfragment_avatar -> {
                Toast.makeText(context, "PROFILE", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fFragmentClassesRecycler.adapter = lessonAdapter
        binding.fFragmentHomeWorkRecycler.adapter = homeWorkAdapter
        lessonAdapter.submitList(getListLessons())
        homeWorkAdapter.submitList(getListHomeWorks())
        MyTimer(
            h1 = binding.fFragmentTimerHour1,
            h2 = binding.fFragmentTimerHour2,
            m1 = binding.fFragmentTimerMinutes1,
            m2 = binding.fFragmentTimerMinutes2,
            s1 = binding.fFragmentTimerSeconds1,
            s2 = binding.fFragmentTimerSeconds2,
        ).start()
    }

    private fun launchZoomApp(lesson: Lesson) {
        val uri = Uri.parse("zoomus://zoom.us/join?confno=7618757358&pwd=ghR5nb")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}