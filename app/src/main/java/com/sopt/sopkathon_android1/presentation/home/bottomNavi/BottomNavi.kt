package com.sopt.sopkathon_android1.presentation.home.bottomNavi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.util.noRippleClickable

enum class BottomNaviType {
    HOME, SEARCH, PROFILE
}

@Composable
fun BottomNavi(
    homeOnClick: () -> Unit,
    searchOnClick: () -> Unit,
    profileOnClick: () -> Unit,
    modifier: Modifier = Modifier
) {
     var selectedItem by remember { mutableStateOf(BottomNaviType.HOME) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.HOME
                    homeOnClick()
                },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_home),
                tint = if (selectedItem == BottomNaviType.HOME) Color.Cyan
                        else Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.SEARCH
                    searchOnClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                tint = if (selectedItem == BottomNaviType.SEARCH) Color.Cyan
                else Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .noRippleClickable {
                    selectedItem = BottomNaviType.PROFILE
                    profileOnClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_profile),
                tint = if (selectedItem == BottomNaviType.PROFILE) Color.Cyan
                else Color.Unspecified,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}