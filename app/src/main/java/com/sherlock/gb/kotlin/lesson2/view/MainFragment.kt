package com.sherlock.gb.kotlin.lesson2.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sherlock.gb.kotlin.lesson2.R
import com.sherlock.gb.kotlin.lesson2.databinding.FragmentMainBinding
import com.sherlock.gb.kotlin.lesson2.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        val observer0 = object : Observer<Any> {
//            override fun onChanged(t: Any?) {
//                renderData(t!!)
//            }
//        }
/**
 * Здесь ошибка, пришлось перенести как в уроке в onActivityCreated
        val observer = Observer<Any>{
            renderData(it)
        }

        viewModel.getData().observe(viewLifecycleOwner,observer)
*/
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //настроим так, что если что-то изменится в getData в классе MainViewModel,
        // то будет вызываться метод renderData
        val observer = Observer<Any>{
            renderData(it)
        }
        viewModel.getData().observe(viewLifecycleOwner,observer)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun renderData(data: Any){
        Toast.makeText(context,"data",Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}