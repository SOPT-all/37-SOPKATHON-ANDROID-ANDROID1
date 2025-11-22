package com.sopt.sopkathon_android1.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.component.BalanceGameCard
import com.sopt.sopkathon_android1.core.designsystem.component.SopkathonTopappbar
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme
import com.sopt.sopkathon_android1.core.util.noRippleClickable
import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo
import com.sopt.sopkathon_android1.data.dto.info.CommentInfo
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.WHITE,
            )
        )

        setContent {

            var balanceGameInfo by remember { mutableStateOf<BalanceGameInfo?>(null) }
            var commentList by remember { mutableStateOf<List<CommentInfo>>(emptyList()) }

            LaunchedEffect(Unit) {
                viewModel.getTodayBalanceGame()

                viewModel.todayBalanceGame.collect {
                    balanceGameInfo = it
                    viewModel.getCommentList(it?.id ?: 0)
                }
            }

            LaunchedEffect(Unit) {
                viewModel.commentList.collect {
                    commentList = it
                }
            }

            LaunchedEffect(Unit) {
                viewModel.writeCommentSuccess.collect {
                    if(it) {
                        viewModel.getCommentList(balanceGameInfo?.id ?: 0)
                    }
                }
            }

            if(commentList.isNotEmpty()) {
                Contents(
                    balanceGameInfo = balanceGameInfo!!,
                    commentList = commentList,
                    likeOnClick = { isLike ->
                        viewModel.likeBalanceGame(balanceGameInfo?.id ?: 0, isLike)
                    },
                    writeComment = { id, comment ->
                        viewModel.writeComment(id, comment)
                    }
                )
            }

        }
    }

    @Composable
    private fun Contents(
        balanceGameInfo: BalanceGameInfo,
        commentList: List<CommentInfo>,
        likeOnClick: (Boolean) -> Unit,
        writeComment: (id: Int, content: String) -> Unit
    ) {

        var isLike by remember { mutableStateOf(balanceGameInfo.isLike) }
        var likeCount by remember { mutableStateOf(balanceGameInfo.likeCount) }

        var commentText by remember { mutableStateOf("") }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(SopkathonTheme.colors.gray_100)
        ) {
            SopkathonTopappbar(
                title = "오늘의 밸런스",
                modifier = Modifier.zIndex(1f),
                navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_left),
                        contentDescription = null,
                        tint = SopkathonTheme.colors.gray_800,
                        modifier = Modifier
                            .size(24.dp)
                            .noRippleClickable {
                                finish()
                            },
                    )
                }
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = balanceGameInfo.title,
                        style = SopkathonTheme.typography.titleSemiBold16,
                        color = SopkathonTheme.colors.gray_800
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "투표 종료까지 ${calculateTargetTime(balanceGameInfo.deadline)} 남았습니다",
                        style = SopkathonTheme.typography.descriptionMedium12,
                        color = SopkathonTheme.colors.blue_500
                    )

                    Spacer(Modifier.height(16.dp))
                    
                    BalanceGameCard(
                        option1Title = balanceGameInfo.option1Title,
                        option1Total = balanceGameInfo.option1Total,
                        option2Title = balanceGameInfo.option2Title,
                        option2Total = balanceGameInfo.option2Total,
                        onClick = {
                            val index = if(balanceGameInfo.option1Total > balanceGameInfo.option2Total) 0 else 1
                            viewModel.voteBalanceGame(balanceGameInfo.id, index)
                        },
                        modifier = Modifier.padding(horizontal = 24.dp),
                    )

                    Spacer(Modifier.height(12.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = if(isLike) ImageVector.vectorResource(R.drawable.icon_heart_fill)
                            else ImageVector.vectorResource(R.drawable.icon_heart_empty),
                            tint = Color.Unspecified,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .noRippleClickable {
                                    isLike = !isLike
                                    if(isLike) {
                                        likeCount = likeCount + 1
                                    } else {
                                        likeCount = likeCount - 1
                                    }
                                    likeOnClick(isLike)
                                }
                        )

                        Spacer(Modifier.width(4.dp))

                        Text(
                            text = "$likeCount 명",
                            style = SopkathonTheme.typography.descriptionMedium12,
                            color = SopkathonTheme.colors.gray_600
                        )
                    }

                    Spacer(Modifier.height(16.dp))
                }

                HorizontalDivider(thickness = 2.dp, color = SopkathonTheme.colors.gray_400)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = "${balanceGameInfo.option1Total + balanceGameInfo.option2Total}명의 아고라 회원들이\n당신과 같은 의견이에요",
                        style = SopkathonTheme.typography.bodyMedium16,
                        color = SopkathonTheme.colors.gray_800
                    )

                    Spacer(Modifier.height(18.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CommentItemView(commentList[3])
                        Spacer(Modifier.height(8.dp))
                        CommentItemView(commentList[2])
                        Spacer(Modifier.height(8.dp))
                        CommentItemView(commentList[1])
                        Spacer(Modifier.height(8.dp))
                        CommentItemView(commentList[0])
                    }
                }

                Spacer(Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    BasicTextField(
                        value = commentText,
                        onValueChange = { commentText = it },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .border(
                                width = 1.dp,
                                color = SopkathonTheme.colors.gray_500,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(horizontal = 24.dp),
                        textStyle = SopkathonTheme.typography.bodyRegular14,
                        decorationBox = { innerTextField ->
                            Box(
                                contentAlignment = Alignment.CenterStart,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if (commentText.isEmpty()) {
                                    Text(
                                        text = "댓글을 입력해주세요",
                                        style = SopkathonTheme.typography.bodyRegular14,
                                        color = SopkathonTheme.colors.gray_500
                                    )
                                }
                                innerTextField()
                            }
                        }
                    )

                    Spacer(Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .background(
                                color = SopkathonTheme.colors.blue_500,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .noRippleClickable {
                                writeComment(balanceGameInfo.id, commentText)
                                commentText = ""
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.icon_arrow_up),
                            tint = SopkathonTheme.colors.gray_100,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun CommentItemView(
        commentInfo: CommentInfo
    ) {
        when(commentInfo.option) {
            "OPTION1" -> {
                Row(
                    modifier = Modifier
                        .height(52.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.image_profile_blue),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Spacer(Modifier.width(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = SopkathonTheme.colors.blue_100,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row {
                            Text(
                                text = commentInfo.author,
                                style = SopkathonTheme.typography.descriptionMedium12,
                                color = SopkathonTheme.colors.gray_800
                            )

                            Spacer(Modifier.width(8.dp))

                            Text(
                                text = "${calculateMinutesAgo(commentInfo.createdAt)}분 전",
                                style = SopkathonTheme.typography.descriptionMedium10,
                                color = SopkathonTheme.colors.gray_600
                            )
                        }

                        Text(
                            text = commentInfo.content,
                            style = SopkathonTheme.typography.bodyRegular14,
                            color = SopkathonTheme.colors.gray_800
                        )
                    }
                }
            }
            "OPTION2" -> {
                Row(
                    modifier = Modifier
                        .height(52.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(
                                color = SopkathonTheme.colors.subPink,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .padding(horizontal = 24.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row {
                            Text(
                                text = commentInfo.author,
                                style = SopkathonTheme.typography.descriptionMedium12,
                                color = SopkathonTheme.colors.gray_800
                            )

                            Spacer(Modifier.width(8.dp))

                            Text(
                                text = "${calculateMinutesAgo(commentInfo.createdAt)}분 전",
                                style = SopkathonTheme.typography.descriptionMedium10,
                                color = SopkathonTheme.colors.gray_600
                            )
                        }

                        Text(
                            text = commentInfo.content,
                            style = SopkathonTheme.typography.bodyRegular14,
                            color = SopkathonTheme.colors.gray_800
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    Image(
                        painter = painterResource(R.drawable.image_profile_pink),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
    }

    fun calculateMinutesAgo(dateTimeString: String): Long {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val dateTime = formatter.parse(dateTimeString)

        val targetTime = dateTime?.time ?: 0L
        val currentTime = System.currentTimeMillis()

        val diffMillis = currentTime - targetTime
        val minutes = diffMillis / 60000  // 밀리초 → 분

        return minutes
    }

    fun calculateTargetTime(targetDateString: String): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val dateTime = formatter.parse(targetDateString)

        val targetTime = dateTime?.time ?: 0L
        val currentTime = System.currentTimeMillis()

        val diffMillis = targetTime - currentTime
        val hours = 4
        val minutes = (diffMillis % 3600000) / 60000
        val seconds = (diffMillis % 60000) / 1000


        return "${hours}시간 ${minutes}분 ${seconds}초"
    }




    @Preview
    @Composable
    private fun ContentsPreview() {
        val balanceGameInfo = BalanceGameInfo(
            id = 1,
            title = "가장 최악의 이별을 고르자면?",
            option1Title = "OPTION1",
            option2Title = "OPTION2",
            isLike = true,
            likeCount = 15,
            memberOption = "OPTION1",
            option1Total = 10,
            option2Total = 5,
            deadline = "2025-11-27T12:34:56",
            category = "LOVE"
        )
        val commentList = listOf(
            CommentInfo(
                option = "OPTION1",
                content = "이게 맞지",
                author = " User1",
                createdAt = "2025-11-23T04:00:00"
            ),
            CommentInfo(
                option = "OPTION2",
                content = "아닌데?",
                author = "User2",
                createdAt = "2025-11-23T04:10:00"
            ),
            CommentInfo(
                option = "OPTION1",
                content = "1번이 진리",
                author = "User3",
                createdAt = "2025-11-23T04:20:00"
            ),
            CommentInfo(
                option = "OPTION2",
                content = "2번 고름",
                author = "User4",
                createdAt = "2025-11-23T04:30:00"
            )
        )
        Contents(balanceGameInfo = balanceGameInfo, commentList = commentList, likeOnClick = {}, writeComment = { _, _ -> })
    }
}

@Composable
fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}