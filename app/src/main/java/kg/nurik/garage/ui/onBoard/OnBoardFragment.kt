package kg.nurik.garage.ui.onBoard

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kg.nurik.garage.R
import kg.nurik.garage.base.BaseFragment
import kg.nurik.garage.data.MyBroadcastReceiver
import kg.nurik.garage.data.TimeBroadcastReceiver
import kotlinx.android.synthetic.main.fragment_onboard.*

class OnBoardFragment : BaseFragment() {
    override fun getViewId() = R.layout.fragment_onboard

    var receiver = TimeBroadcastReceiver()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        requireContext().registerReceiver(receiver, IntentFilter("android.intent.action.TIME-TICK"))//регистрируем и смс приходит когда измениться время
    }

    private fun setupListeners() {
        button.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_onBoardInputName)
        }
        sendBroadcastt()
    }

    private fun sendBroadcastt() {      //по клику получаем смс имени приложения
        val intent = Intent(requireContext(), MyBroadcastReceiver::class.java)
        intent.action = "kg.nurik.garage"
        requireActivity().sendBroadcast(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        requireContext().unregisterReceiver(receiver) //  итак же важно его отписать
    }

}