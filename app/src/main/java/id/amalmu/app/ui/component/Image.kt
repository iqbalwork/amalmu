package id.amalmu.app.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.amalmu.app.R

/**
 * Created by Iqbal Fauzi at 30/01/23
 * iqbal.fauzi.if99@gmail.com
 */
@Composable
fun ImageBackground() {
    Image(
        painter = painterResource(id = R.drawable.bg_screen),
        contentDescription = null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageView(resource: Int, width: Int, height: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = resource),
        contentDescription = null,
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
    )
}

@Composable
fun ImageView(resource: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = resource),
        contentDescription = null,
        modifier = modifier
    )
}