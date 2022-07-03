package com.example.gb_hw_les_4.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gb_hw_les_4.Lesson
import com.example.gb_hw_les_4.R
import com.example.gb_hw_les_4.databinding.FragmentSecondBinding
import com.example.gb_hw_les_4.getListLessons
import com.example.gb_hw_les_4.ui.adapters.SecondFragmentLessonAdapter

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding
        get() = _binding ?: throw RuntimeException("FragmentSecondBinding? = null")

    private val lessonAdapter by lazy {
        SecondFragmentLessonAdapter(zoom = this::launchZoomApp)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_second_fragment_action_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_secondfragment_search -> {
                Toast.makeText(context, "SEARCH", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item_secondfragment_options -> {
                Toast.makeText(context, "OPTIONS", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item_secondfragment_list -> {
                Toast.makeText(context, "TAB LIST", Toast.LENGTH_SHORT).show()
                true
            }
            android.R.id.home -> {
                findNavController().popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sFragmentClassesRecycler.adapter = lessonAdapter
        lessonAdapter.submitList(getListLessons())
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