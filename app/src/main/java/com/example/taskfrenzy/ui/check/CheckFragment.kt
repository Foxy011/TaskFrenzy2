package com.example.taskfrenzy.ui.check

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskfrenzy.R
import com.example.taskfrenzy.databinding.FragmentCheckBinding
import com.example.taskfrenzy.domain.TaskModel
import com.example.taskfrenzy.ui.tasks.TaskAdapter

class CheckFragment: Fragment() {

    private var binding: FragmentCheckBinding? = null
    private val taskAdapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCheckBinding.inflate(LayoutInflater.from(context), container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }


    private fun initViews() {
        binding?.rvTasks?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvTasks?.adapter = taskAdapter
    }


    private fun initListeners(){
        binding?.btnFab?.setOnClickListener(){
            findNavController().navigate(R.id.createTaskFragment)
        }


        setFragmentResultListener(
            CreateTaskFragment.CREATE_TASK_KEY
        ) { _: String, bundle: Bundle ->

            val taskModel = bundle.getSerializable(CreateTaskFragment.TASK_KEY) as TaskModel
            taskAdapter.add(taskModel)
            Log.d("task", taskModel.toString())
        }
    }

}