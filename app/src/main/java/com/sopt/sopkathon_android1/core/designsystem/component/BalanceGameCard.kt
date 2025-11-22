package com.sopt.sopkathon_android1.core.designsystem.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R.drawable.image_crop
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.util.noRippleClickable

private const val IMAGE_RATIO = 167 / 167f

@Composable
fun BalanceGameCard(
    option1Title: String,
    option1Total: Int,
    option2Title: String,
    option2Total: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var clickStatus by mutableStateOf(false)
    val total = option1Total + option2Total
    val (weight1, weight2) = if (clickStatus && total > 0) {
        option1Total.toFloat() / total to option2Total.toFloat() / total
    } else 0.5f to 0.5f
    val animatedWeight1 by animateFloatAsState(targetValue = weight1, label = "weight1")
    val animatedWeight2 by animateFloatAsState(targetValue = weight2, label = "weight2")

    Row(
        modifier = modifier.noRippleClickable(
            onClick = {
                onClick()
                clickStatus = true
            },
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        DefaultCard(
            title = option1Title,
            modifier = Modifier.weight(animatedWeight1),
        )
        DefaultCard(
            title = option2Title,
            modifier = Modifier.weight(animatedWeight2),
        )
    }
}

@Composable
private fun DominatingCard(
    title: String,
    total: Int,
    percentage: Float,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp),
            )
            .height(92.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Image(
            painter = painterResource(image_crop),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 75.dp)
                .requiredHeight(167.dp),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .padding(start = 10.dp),
        ) {
            Text(
                text = title,
                color = textColor,
                style = SopkathonTheme.typography.titleSemiBold16,
            )

            Text(
                text = "(${percentage * 100}% / ${total}명)",
                color = textColor,
                style = SopkathonTheme.typography.bodyMedium16,
            )
        }
    }
}

@Composable
private fun DefaultCard(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier = modifier
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.gray_600,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(
                horizontal = 44.5.dp,
                vertical = 35.5.dp,
            ),
        color = SopkathonTheme.colors.gray_800,
        style = SopkathonTheme.typography.titleSemiBold16,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun BalanceGameCardPreview() {
    SOPKATHONTheme {
        BalanceGameCard(
            option1Title = "환승 이별",
            option1Total = 10,
            option2Title = "잠수 이별",
            option2Total = 20,
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun DominatingCardPreview() {
    SOPKATHONTheme {
        DominatingCard(
            title = "환승 이별",
            total = 10,
            percentage = 0.5f,
            backgroundColor = SopkathonTheme.colors.subPink,
            textColor = SopkathonTheme.colors.gray_100,
        )
    }
}
