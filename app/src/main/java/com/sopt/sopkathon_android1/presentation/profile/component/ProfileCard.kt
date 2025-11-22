package com.sopt.sopkathon_android1.presentation.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = SopkathonTheme.colors.gray_300,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_profile),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(70.dp)
        )

        Spacer(modifier = Modifier.width(21.dp))

        Column(
            modifier = Modifier
        ) {
            Text(
                text = "불멸의 아라",
                color = Color.Black,
                style = SopkathonTheme.typography.bodyMedium16
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "밸런스 참여 횟수 ",
                    color = Color.Black,
                    style = SopkathonTheme.typography.descriptionMedium12
                )
                Text(
                    text = "13",
                    color = SopkathonTheme.colors.blue_500,
                    style = SopkathonTheme.typography.descriptionMedium12
                )
                Text(
                    text = " 회",
                    color = Color.Black,
                    style = SopkathonTheme.typography.descriptionMedium12
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileCardPreview() {
    SOPKATHONTheme {
        ProfileCard()
    }
}