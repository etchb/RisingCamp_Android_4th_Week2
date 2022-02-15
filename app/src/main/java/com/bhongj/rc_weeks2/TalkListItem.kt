package com.bhongj.rc_weeks2

import android.graphics.drawable.Drawable

data class TalkListItem(
    var name: String,
    var message: String,
    var imgRsc: Int
)

val TalkListItemList = mutableListOf<TalkListItem>(
    TalkListItem(
        name = "토스뱅크",
        message = "안녕하세요. 토스뱅크입니다.",
        imgRsc = R.drawable.ic_toss
    ),

    TalkListItem(
        name = "미스터피자",
        message = "안녕하세요. 미스터피자입니다.",
        imgRsc = R.drawable.ic_mrpizza
    ),
    TalkListItem(
        name = "교보문고",
        message = "안녕하세요. 교보문고입니다.",
        imgRsc = R.drawable.ic_gyobo
    ),
)