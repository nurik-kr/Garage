package kg.nurik.garage.utils

import android.widget.SeekBar
import kotlinx.android.synthetic.main.fragment_age.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun startCoroutinesTimer(
    delayMillis: Long, //сколько времени
    repeatCount: Long,//сколько раз
    scope: CoroutineScope,
    action: () -> Unit
) {
    scope.launch {
        delay(delayMillis)
        var position = 0
        if (repeatCount > 0) {
            while (position < repeatCount) {
                action()// замыкание
                delay(delayMillis)
                position++
            }
            scope.cancel()
        } else {
            action()
        }
    }
}

fun SeekBar.setSeekBarChangeListener(action: (Int) -> Unit) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            action(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    })
}
