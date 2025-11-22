import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.sopkathon_android1.R
import com.sopt.sopkathon_android1.core.designsystem.theme.SopkathonTheme

// 투표 선택 상태를 나타내는 Enum
enum class VoteSelection {
    OPTION1, OPTION2, NONE
}

// 승/패 상태를 나타내는 Enum
enum class ResultStatus {
    WIN, LOSE, NONE
}

@Composable
fun VoteResultComponent(
    option1Title: String,       // 옵션1 텍스트
    option2Title: String,       // 옵션2 텍스트
    option1Total: Int,          // 옵션1 투표 수
    option2Total: Int,          // 옵션2 투표 수
    memberOption: String,       // 사용자의 선택 ("OPTION1" or "OPTION2")
    option1Result: ResultStatus = ResultStatus.NONE, // 옵션1 결과 (WIN, LOSE, NONE)
    option2Result: ResultStatus = ResultStatus.NONE  // 옵션2 결과 (WIN, LOSE, NONE)
) {
    val totalVotes = option1Total + option2Total

    // 투표 수가 0일 경우 0.5f로 기본 설정 (오류 방지)
    val option1Ratio = if (totalVotes == 0) 0.5f else option1Total.toFloat() / totalVotes
    val option2Ratio = if (totalVotes == 0) 0.5f else option2Total.toFloat() / totalVotes

    // memberOption을 VoteSelection으로 변환
    val userSelection = when (memberOption) {
        "OPTION1" -> VoteSelection.OPTION1
        "OPTION2" -> VoteSelection.OPTION2
        else -> VoteSelection.NONE
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 옵션 제목 표시 (위쪽)
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = option1Title + "  VS  " + option2Title,
                style = SopkathonTheme.typography.descriptionMedium12,
                color = SopkathonTheme.colors.gray_800,
                modifier = Modifier.weight(option1Ratio)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // 투표 바 (Bar)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, color = SopkathonTheme.colors.gray_400, RoundedCornerShape(10.dp))
        ) {
            // [옵션1 영역]
            VoteSection(
                text = "",
                weight = option1Ratio,
                isSelected = (userSelection == VoteSelection.OPTION1),
                isLeftArgs = true,
                resultStatus = option1Result
            )

            // [옵션2 영역]
            VoteSection(
                text = "",
                weight = option2Ratio,
                isSelected = (userSelection == VoteSelection.OPTION2),
                isLeftArgs = false,
                resultStatus = option2Result
            )
        }
    }
}

@Composable
fun RowScope.VoteSection(
    text: String,
    weight: Float,
    isSelected: Boolean,
    isLeftArgs: Boolean,
    resultStatus: ResultStatus = ResultStatus.NONE
) {
    // 배경색 결정: 선택되고 결과가 있을 때만 색상 적용
    val backgroundColor = when {
        isSelected && resultStatus == ResultStatus.WIN -> SopkathonTheme.colors.blue_100 // 파란 색
        isSelected && resultStatus == ResultStatus.LOSE -> SopkathonTheme.colors.subPink // 핑크 색
        else -> Color.White
    }

    Box(
        modifier = Modifier
            .weight(weight)
            .fillMaxHeight()
            .background(backgroundColor, shape = RoundedCornerShape(size = 10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isLeftArgs) Arrangement.Start else Arrangement.End
        ) {
            when {
                // 선택되었고 WIN 상태: 아이콘 + 텍스트
                isSelected && resultStatus == ResultStatus.WIN -> {
                    if (isLeftArgs) {
                        VoteIcon(iconResId = R.drawable.icon_win)
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                    Text(
                        text = "이겼어요!",
                        style = SopkathonTheme.typography.descriptionMedium10,
                        color = SopkathonTheme.colors.blue_500
                    )

                    if (!isLeftArgs) {
                        Spacer(modifier = Modifier.width(8.dp))
                        VoteIcon(iconResId = R.drawable.icon_win)
                    }
                }

                // 선택되었고 LOSE 상태: 아이콘만
                isSelected && resultStatus == ResultStatus.LOSE -> {
                    if (isLeftArgs) {
                        VoteIcon(iconResId = R.drawable.icon_loose)
                    } else {
                        VoteIcon(iconResId = R.drawable.icon_loose)
                    }
                }

                // 그 외: 텍스트만 (WIN/LOSE 아닐 때는 아무것도 표시 안함)
                else -> {
                    // 텍스트 표시 안함
                }
            }
        }
    }
}

@Composable
fun VoteIcon(iconResId: Int) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = Modifier.size(29.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewVoteResultWin() {
    // 케이스 1: OPTION1 선택 및 WIN
    Box(modifier = Modifier.padding(16.dp)) {
        VoteResultComponent(
            option1Title = "똥 맛 카레",
            option2Title = "카레 맛 똥",
            option1Total = 662,
            option2Total = 332,
            memberOption = "OPTION1",
            option1Result = ResultStatus.WIN,
            option2Result = ResultStatus.NONE
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVoteResultLose() {
    // 케이스 2: OPTION2 선택 및 LOSE
    Box(modifier = Modifier.padding(16.dp)) {
        VoteResultComponent(
            option1Title = "치킨",
            option2Title = "피자",
            option1Total = 1203,
            option2Total = 988,
            memberOption = "OPTION2",
            option1Result = ResultStatus.WIN,
            option2Result = ResultStatus.LOSE
        )
    }
}