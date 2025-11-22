package com.sopt.sopkathon_android1.presentation.home.bottomNavi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.util.noRippleClickable

enum class BottomNaviType {
    HOME, COMMUNITY, HI, PROFILE
}

@Composable
fun BottomNavi(
    homeOnClick: () -> Unit,
    communityOnClick: () -> Unit,
    profileOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedItem by remember { mutableStateOf(BottomNaviType.HOME) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.HOME
                    homeOnClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_home),
                tint = if (selectedItem == BottomNaviType.HOME) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "홈",
                style = SopkathonTheme.typography.descriptionMedium10,
                color = if (selectedItem == BottomNaviType.HOME) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.COMMUNITY
                    communityOnClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_users),
                tint = if (selectedItem == BottomNaviType.COMMUNITY) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "광장",
                style = SopkathonTheme.typography.descriptionMedium10,
                color = if (selectedItem == BottomNaviType.COMMUNITY) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.HI
                    communityOnClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_plus),
                tint = if (selectedItem == BottomNaviType.HI) SopkathonTheme.colors.blue_500
                else SopkathonTheme.colors.gray_500,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "주제 생성",
                style = SopkathonTheme.typography.descriptionMedium10,
                color = if (selectedItem == BottomNaviType.HI) SopkathonTheme.colors.blue_500
                else SopkathonTheme.colors.gray_500
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.PROFILE
                    profileOnClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_user),
                tint = if (selectedItem == BottomNaviType.PROFILE) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "마이페이지",
                style = SopkathonTheme.typography.descriptionMedium10,
                color = if (selectedItem == BottomNaviType.PROFILE) SopkathonTheme.colors.blue_500
                        else SopkathonTheme.colors.gray_500,
            )
        }
    }
}

@Preview
@Composable
private fun BottomNaviPreview() {
    SOPKATHONTheme {
        BottomNavi(
            homeOnClick = {},
            communityOnClick = {},
            profileOnClick = {},
            modifier = Modifier
        )
    }
}
