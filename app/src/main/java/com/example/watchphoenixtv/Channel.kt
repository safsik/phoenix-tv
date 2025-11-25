package com.example.watchphoenixtv

import java.io.Serializable

data class Channel(
    val id: String,
    val name: String,
    val logoUrl: String,
    val programs: List<Program>
) : Serializable

data class Program(
    val id: String,
    val title: String,
    val description: String,
    val cardImageUrl: String,
    val backgroundImageUrl: String,
    val videoUrl: String,
    val isLive: Boolean = false,
    val channelLogoUrl: String,
    val channelName: String
) : Serializable
