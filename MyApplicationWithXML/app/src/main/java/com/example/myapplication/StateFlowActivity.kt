package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityStateFlowBinding
import kotlinx.coroutines.launch

class StateFlowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStateFlowBinding
    private val viewModel : StateFlowViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStateFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun initView() = with(binding) {
        countTxt.text = "0"
        stateBtn.text = "로딩"
    }

    fun initViewModel(){
        with(viewModel){
            lifecycleScope.launch {
                testUIState.collect{state->
                    with(binding){
//                        countTxt.visibility =
                    }
                }
            }
        }
    }
}