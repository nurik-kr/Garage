package kg.nurik.garage.ui.onBoard

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kg.nurik.garage.R
import kg.nurik.garage.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_auth.*

class OnBoardInputName : BaseFragment() {
    override fun getViewId() = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        tvTitle.animateText(getString(R.string.title))
    }

    private fun setupListeners() {
        etName.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                openAgeScreen()
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun openAgeScreen() {
        findNavController().navigate(R.id.action_onBoardInputName_to_ageFragment)
    }

}