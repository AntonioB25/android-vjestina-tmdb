package com.e.tmdb.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.e.tmdb.models.CastMember

@Composable
fun CastMemberCard(
    member: CastMember,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .width(125.dp),
        elevation = 10.dp
    ) {
        Column {
            Image(
                painter = painterResource(id = member.imageUrl),
                contentDescription = "Image of ${member.name}",
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(170.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = member.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            // Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = member.characterName,
                fontWeight = FontWeight.Thin,
                fontSize = 10.sp
            )


        }
    }
}