package id.amalmu.app.presentation

import android.annotation.SuppressLint
import dagger.hilt.android.AndroidEntryPoint
import id.amalmu.app.databinding.ActivitySplashBinding
import id.amalmu.app.domain.BaseActivity

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    override fun onSetupUI() {

    }

    override fun onSetupViewModel() {

    }

}