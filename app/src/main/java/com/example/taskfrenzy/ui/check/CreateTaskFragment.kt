package com.example.taskfrenzy.ui.check

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskfrenzy.databinding.FragmentKreateTaskBinding
import com.example.taskfrenzy.domain.TaskModel

class CreateTaskFragment : Fragment() {

    companion object {
        const val CREATE_TASK_KEY = "create_task"
        const val TASK_KEY = "task_key"
    }

    private var binding: FragmentKreateTaskBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKreateTaskBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )

        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding?.btnCreate?.setOnClickListener {

            val title = binding?.etTitle?.text?.toString()
            val desc = binding?.etDesc?.text?.toString()

            if (title.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Заполните поле \"Title\"", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val model = TaskModel(
                    title = title,
                    description = desc ?: "",
                )

                val result = bundleOf(
                    TASK_KEY to model
                )



                setFragmentResult(
                    CREATE_TASK_KEY,
                    result
                )

                findNavController().navigateUp()
            }
        }
    }
}