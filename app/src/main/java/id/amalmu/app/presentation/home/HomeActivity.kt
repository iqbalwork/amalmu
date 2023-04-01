package id.amalmu.app.presentation.home

import android.graphics.Color
import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.view.Surface
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import id.amalmu.app.R
import id.amalmu.app.databinding.ActivityHomeBinding
import id.amalmu.app.domain.abstraction.BaseActivity
import id.amalmu.app.ui.component.ImageView
import id.amalmu.app.ui.theme.AmalmuAmaliyahMuridTheme

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmalmuAmaliyahMuridTheme {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(modifier = Modifier) {
                        ImageView(
                            resource = R.drawable.ic_location,
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(16.dp)
                        )
                        ImageView(
                            resource = R.drawable.ic_settings, modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }

}