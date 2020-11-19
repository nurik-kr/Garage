package kg.nurik.garage.ui.onBoard

import android.os.Bundle
import android.view.View
import kg.nurik.garage.R
import kg.nurik.garage.base.BaseFragment
import kg.nurik.garage.utils.AnimationUtils
import kg.nurik.garage.utils.setSeekBarChangeListener
import kotlinx.android.synthetic.main.fragment_age.*

class AgeFragment : BaseFragment() {
    override fun getViewId() = R.layout.fragment_age
    private var lastScale = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        tvAge.animateText(getString(R.string.age), 60)
    }

    private fun setupListeners() {
        seekBar.setSeekBarChangeListener {
            val result = it / 6
            age.text = result.toString()
            if (result < 1) {
                age.text = "1"
            }
            if (result > 15) {
                age.text = "16+"
            }

            when (result) {
                in 1..4 -> {
                    tvAge.text = getString(R.string.age_two)
                }
                in 4..14 -> {
                    tvAge.text = getString(R.string.age)
                }
                in 14..16 -> tvAge.text = getString(R.string.age_three)
            }

            AnimationUtils.animateScale(martyshka, lastScale, it.toFloat())
            lastScale = it.toFloat()

        }
//        buttonOk.setOnClickListener {
//            findNavController().navigate()
//        }
    }
}