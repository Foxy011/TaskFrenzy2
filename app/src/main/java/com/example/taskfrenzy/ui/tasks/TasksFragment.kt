package com.example.taskfrenzy.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskfrenzy.databinding.FragmentTasksBinding

class TasksFragment: Fragment() {

    private var binding: FragmentTasksBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

}