package com.sopt.sopkathon_android1.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.presentation.community.CommunityBalanceItem
import com.sopt.sopkathon_android1.presentation.community.CommunityScreen
import com.sopt.sopkathon_android1.presentation.community.CommunityTabbar
import com.sopt.sopkathon_android1.presentation.generate.GenerateScreen
import com.sopt.sopkathon_android1.presentation.home.bottomNavi.BottomNavi
import com.sopt.sopkathon_android1.presentation.home.bottomNavi.BottomNaviType
import com.sopt.sopkathon_android1.presentation.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Contents()
            //var selectedTab by remember { mutableStateOf<String?>(null) }

//            CommunityBalanceItem()
        }

    }

    @Composable
    private fun Contents() {
        var selectedScreen by remember { mutableStateOf(BottomNaviType.HOME) }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(SopkathonTheme.colors.gray_100)
                .navigationBarsPadding(),
        ) {
            when(selectedScreen) {
                BottomNaviType.HOME -> HomeScreen(modifier = Modifier.weight(1f))
                BottomNaviType.COMMUNITY -> CommunityScreen(modifier = Modifier.weight(1f))
                BottomNaviType.GENERATE -> GenerateScreen(modifier = Modifier.weight(1f))
                BottomNaviType.PROFILE -> ProfileScreen(modifier = Modifier.weight(1f))
            }

            BottomNavi(
                homeOnClick = { selectedScreen = BottomNaviType.HOME },
                communityOnClick = { selectedScreen = BottomNaviType.COMMUNITY },
                generateOnClick = { selectedScreen = BottomNaviType.GENERATE },
                profileOnClick = { selectedScreen = BottomNaviType.PROFILE }
            )
        }
    }
}