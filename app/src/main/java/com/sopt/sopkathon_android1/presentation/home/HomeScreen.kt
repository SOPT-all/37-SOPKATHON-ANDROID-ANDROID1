package com.sopt.sopkathon_android1.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.sopkathon_android1.R.drawable.image_logo
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(image_logo),
            contentDescription = null,
        )
        Text(
            text = "Home"
        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    SOPKATHONTheme {
        HomeScreen()
    }
}
