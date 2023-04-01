package id.amalmu.app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.amalmu.app.R
import id.amalmu.app.ui.component.ImageView
import id.amalmu.app.ui.theme.AmalmuAmaliyahMuridTheme

/**
 * Created by Iqbal Fauzi at 30/01/23
 * iqbal.fauzi.if99@gmail.com
 */
@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AmalmuAmaliyahMuridTheme {
        Surface(color = Color.DarkGray) {
            Box(modifier = Modifier) {
                ImageView(
                    resource = R.drawable.ic_location,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                        .background(Color.Green)
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