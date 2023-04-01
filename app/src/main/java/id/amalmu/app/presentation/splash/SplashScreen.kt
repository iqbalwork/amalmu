package id.amalmu.app.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import id.amalmu.app.R
import id.amalmu.app.ui.component.ImageBackground
import id.amalmu.app.ui.component.ImageView
import id.amalmu.app.ui.theme.AmalmuAmaliyahMuridTheme
import id.amalmu.app.ui.theme.Teal800

/**
 * Created by Iqbal Fauzi at 30/01/23
 * iqbal.fauzi.if99@gmail.com
 */
@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AmalmuAmaliyahMuridTheme {
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