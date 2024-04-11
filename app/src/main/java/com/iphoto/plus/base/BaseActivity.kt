package com.iphoto.plus.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding, VM : ViewModel> : AppCompatActivity() {
 
    lateinit var binding: T
    protected lateinit var viewModel: VM
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        providerVMClass()?.let {
            viewModel = ViewModelProvider(this).get(it)
        }
        setContentView(binding.root)
        initView()
        setListener()
 
    }
 
    abstract fun providerVMClass(): Class<VM>?
 
    protected abstract fun getViewBinding(): T
 
    abstract fun initView()
 
    abstract fun setListener()
}