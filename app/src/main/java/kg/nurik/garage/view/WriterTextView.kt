package kg.nurik.garage.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import kg.nurik.garage.utils.startCoroutinesTimer
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class WriterTextView(context: Context, attributeSet: AttributeSet) : // animation to textView
    AppCompatTextView(context, attributeSet) {

    private val scope = MainScope()
    private var text = ""
    private var position = 0

    fun animateText(text: String, delay: Long = 40) {
        startCoroutinesTimer(delay, text.length.toLong(), scope) {
//            if (position < text.length) {
            val newText = "${this.text}${text[position]}"
            this.text = newText
            setText(this.text)
            position++

//            } else {
//                scope.cancel()
//            }
        }
    }

    override fun onDetachedFromWindow() {
        scope.cancel()
        super.onDetachedFromWindow()
    }
}