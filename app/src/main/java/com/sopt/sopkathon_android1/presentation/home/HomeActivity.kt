package com.sopt.sopkathon_android1.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import com.sopt.sopkathon_android1.presentation.home.bottomNavi.BottomNavi
import com.sopt.sopkathon_android1.presentation.home.bottomNavi.BottomNaviType
import com.sopt.sopkathon_android1.presentation.profile.ProfileScreen
import com.sopt.sopkathon_android1.presentation.search.SearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Contents()
        }
    }

    @Composable
    private fun Contents() {
        var selectedScreen by remember { mutableStateOf(BottomNaviType.HOME) }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            when(selectedScreen) {
                BottomNaviType.HOME -> HomeScreen(modifier = Modifier.weight(1f))
                BottomNaviType.SEARCH -> SearchScreen(modifier = Modifier.weight(1f))
                BottomNaviType.PROFILE -> ProfileScreen(modifier = Modifier.weight(1f))
            }

            BottomNavi(
                homeOnClick = { selectedScreen = BottomNaviType.HOME },
                searchOnClick = { selectedScreen = BottomNaviType.SEARCH },
                profileOnClick = { selectedScreen = BottomNaviType.PROFILE }
            )
        }
    }
}