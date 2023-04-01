package id.amalmu.app.presentation.splash

import android.os.Bundle
import android.view.Surface
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import id.amalmu.app.R
import id.amalmu.app.domain.navigation.ActivityScreen
import id.amalmu.app.domain.navigation.NavigationRouter
import id.amalmu.app.ui.component.ImageBackground
import id.amalmu.app.ui.component.ImageView
import id.amalmu.app.ui.theme.AmalmuAmaliyahMuridTheme
import id.amalmu.app.ui.theme.Teal800
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashActivity : AppCompatActivity() {

    private val navigation = NavigationRouter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmalmuAmaliyahMuridTheme(dynamicColor = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier) {
                        ImageBackground()
                        Box(modifier = Modifier.align(Alignment.Center)) {
                            ImageView(
                                resource = R.mipmap.ic_launcher_adaptive_fore,
                                width = 256,
                                height = 256
                            )
                            Text(
                                text = stringResource(id = R.string.app_name),
                                color = Teal800,
                                fontSize = 32.sp,
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
            }
        }

        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                navigation.openActivity(this@SplashActivity, ActivityScreen.HOME_SCREEN, isClearStack = true)
            }
        }
    }
}