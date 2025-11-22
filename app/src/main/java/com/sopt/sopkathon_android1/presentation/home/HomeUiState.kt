package com.sopt.sopkathon_android1.presentation.home

import com.sopt.sopkathon_android1.data.dto.info.BalanceGameInfo

data class HomeUiState(
    val todayBalanceGame: BalanceGameInfo = BalanceGameInfo(
        id = 1,
        title = "가장 최악의 이별을 고르자면?",
        option1Title = "잠수 이별",
        option2Title = "환승 이별",
        isLike = true,
        likeCount = 1,
        memberOption = "OPTION1",
        option1Total = 208,
        option2Total = 830,
        deadline = "2025-11-24T22:00:00",
        category = "FOOD"
    ),
    val participatingBalanceGames: List<BalanceGameInfo> = listOf(
        BalanceGameInfo(
            id = 7,
            title = "이상한 메뉴 선택",
            option1Title = "민초 피자 먹기",
            option2Title = "와사비 케이크 먹기",
            isLike = true,
            likeCount = 2,
            memberOption = "OPTION2",
            option1Total = 120,
            option2Total = 98,
            deadline = "2030-05-08T04:00:00",
            category = "HUMOR"
        ),
        BalanceGameInfo(
            id = 1,
            title = "썸 연락 템포",
            option1Title = "생각날 때마다 톡 보내기",
            option2Title = "매일 밤 정리해서 보내기",
            isLike = true,
            likeCount = 3,
            memberOption = "OPTION1",
            option1Total = 2410,
            option2Total = 1980,
            deadline = "2030-05-10T13:00:00",
            category = "LOVE"
        ),
        BalanceGameInfo(
            id = 4,
            title = "시험 전날 루틴",
            option1Title = "새벽 몰아 공부",
            option2Title = "충분히 자고 일찍 일어나기",
            isLike = false,
            likeCount = 2,
            memberOption = "OPTION2",
            option1Total = 650,
            option2Total = 1020,
            deadline = "2030-05-15T00:00:00",
            category = "STUDY"
        ),
        BalanceGameInfo(
            id = 10,
            title = "주말 루틴 정하기",
            option1Title = "토요일 몰아서 쉬기",
            option2Title = "토일 일정 분배",
            isLike = false,
            likeCount = 3,
            memberOption = "OPTION2",
            option1Total = 710,
            option2Total = 690,
            deadline = "2030-05-18T02:00:00",
            category = "ETC"
        ),
        BalanceGameInfo(
            id = 5,
            title = "스터디 모임 방식",
            option1Title = "대면 스터디",
            option2Title = "온라인 스터디",
            isLike = true,
            likeCount = 3,
            memberOption = "OPTION1",
            option1Total = 720,
            option2Total = 540,
            deadline = "2030-05-25T10:00:00",
            category = "STUDY"
        ),
        BalanceGameInfo(
            id = 8,
            title = "회의 복장 밸런스",
            option1Title = "파자마 입고 회의",
            option2Title = "정장 입고 캠핑",
            isLike = false,
            likeCount = 3,
            memberOption = "OPTION1",
            option1Total = 560,
            option2Total = 630,
            deadline = "2030-05-30T00:00:00",
            category = "HUMOR"
        ),
        BalanceGameInfo(
            id = 2,
            title = "기념일 이벤트 기획",
            option1Title = "깜짝 여행 준비",
            option2Title = "감성 디너 예약",
            isLike = true,
            likeCount = 4,
            memberOption = "OPTION2",
            option1Total = 1850,
            option2Total = 2200,
            deadline = "2030-06-02T09:00:00",
            category = "LOVE"
        ),
        BalanceGameInfo(
            id = 11,
            title = "홈카페 장비 투자",
            option1Title = "에스프레소 머신 들이기",
            option2Title = "핸드드립 세트 완성",
            isLike = true,
            likeCount = 3,
            memberOption = "OPTION1",
            option1Total = 430,
            option2Total = 820,
            deadline = "2030-06-11T23:30:00",
            category = "ETC"
        )
    ),
    val hotBalanceGames: List<BalanceGameInfo> = listOf(
        BalanceGameInfo(
            id = 2,
            title = "기념일 이벤트 기획",
            option1Title = "깜짝 여행 준비",
            option2Title = "감성 디너 예약",
            isLike = true,
            likeCount = 4,
            memberOption = "OPTION2",
            option1Total = 1850,
            option2Total = 2200,
            deadline = "2030-06-02T18:00:00",
            category = "LOVE"
        ),
        BalanceGameInfo(
            id = 1,
            title = "썸 연락 템포",
            option1Title = "생각날 때마다 톡 보내기",
            option2Title = "매일 밤 정리해서 보내기",
            isLike = true,
            likeCount = 3,
            memberOption = "OPTION1",
            option1Total = 2410,
            option2Total = 1980,
            deadline = "2030-05-10T22:00:00",
            category = "LOVE"
        ),
        BalanceGameInfo(
            id = 10,
            title = "주말 루틴 정하기",
            option1Title = "토요일 몰아서 쉬기",
            option2Title = "토일 일정 분배",
            isLike = false,
            likeCount = 3,
            memberOption = "OPTION2",
            option1Total = 710,
            option2Total = 690,
            deadline = "2030-05-18T11:00:00",
            category = "ETC"
        )
    )
)
