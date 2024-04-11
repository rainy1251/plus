package com.iphoto.plus.ui.dashboard

import com.iphoto.plus.base.BaseFragment
import com.iphoto.plus.bean.PhoneBean
import com.iphoto.plus.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(
    FragmentDashboardBinding::inflate, DashboardViewModel::class.java
) {
    override fun initFragment(binding: FragmentDashboardBinding, viewModel: DashboardViewModel?) {

        val phoneBean = PhoneBean("13839131251")

        binding.btnLogin.setOnClickListener {
            val sendPhoneCode = viewModel?.sendPhoneCode(phoneBean)
            sendPhoneCode?.observe(viewLifecycleOwner) {
                binding.textDashboard.text = it
            }
        }

    }

}