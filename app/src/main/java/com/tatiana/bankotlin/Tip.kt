package com.tatiana.bankotlin

import android.media.MediaPlayer
import androidx.annotation.DrawableRes
import javax.security.auth.Subject

data class Tip(
    val title: String,
    val subtitle: String,
    @DrawableRes val logo: Int,
    @DrawableRes val background: Int
)