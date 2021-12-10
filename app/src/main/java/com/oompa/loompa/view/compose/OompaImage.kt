package com.oompa.loompa.view.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.oompa.loompa.data.model.OompaDetail

@Composable
fun OompaImage(oompaDetail: OompaDetail) {
    Image(
        painter = painterResource(
            id = oompaDetail.image.toInt()),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(4.dp)
                .height(140.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
        )
}