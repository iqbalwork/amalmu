package id.amalmu.app.domain.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by Iqbal Fauzi at 12/07/22
 * iqbal.fauzi.if99@gmail.com
 */
abstract class BaseActivity<VB : ViewBinding>(
    private val viewBinder: (LayoutInflater) -> ViewBinding
) : AppCompatActivity() {

    @Suppress("UNCHECKED_CAST")
    protected val binding by lazy(LazyThreadSafetyMode.NONE) { viewBinder.invoke(layoutInflater) as VB }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onSetupUI()
        onSetupViewModel()
    }

    abstract fun onSetupUI()

    abstract fun onSetupViewModel()
}