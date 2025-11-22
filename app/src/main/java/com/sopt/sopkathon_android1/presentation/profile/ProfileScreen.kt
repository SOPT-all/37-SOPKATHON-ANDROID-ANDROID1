package com.sopt.sopkathon_android1.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.sopkathon_android1.core.designsystem.component.SopkathonTopappbar
import com.sopt.sopkathon_android1.core.designsystem.theme.SOPKATHONTheme
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.presentation.profile.component.ProfileCard

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val paddedModifier = Modifier.padding(horizontal = 16.dp)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SopkathonTheme.colors.gray_100)
    ) {
        SopkathonTopappbar("마이페이지")

        Spacer(modifier = Modifier.height(10.dp))

        ProfileCard(modifier = paddedModifier)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "내가 참여한 밸런스게임",
            style = SopkathonTheme.typography.titleSemiBold16,
            modifier = paddedModifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    SOPKATHONTheme{
        ProfileScreen()
    }
}
