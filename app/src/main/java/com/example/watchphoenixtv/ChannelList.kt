package com.example.watchphoenixtv

object ChannelList {
    val channels: List<Channel> = listOf(
        Channel(
            id = "1",
            name = "Live News",
            logoUrl = "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
            programs = listOf(
                Program(
                    id = "101",
                    title = "Live Breaking News",
                    description = "The latest news from around the world.",
                    cardImageUrl = "https://via.placeholder.com/500x280/FF0000/FFFFFF?Text=Live+News",
                    backgroundImageUrl = "https://via.placeholder.com/1920x1080/FF0000/FFFFFF?Text=Live+News",
                    videoUrl = "",
                    isLive = true,
                    channelLogoUrl = "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
                    channelName = "Live News"
                ),
                Program(
                    id = "102",
                    title = "Morning News",
                    description = "A look at the day's headlines.",
                    cardImageUrl = "https://via.placeholder.com/500x280/FF0000/FFFFFF?Text=Morning+News",
                    backgroundImageUrl = "https://via.placeholder.com/1920x1080/FF0000/FFFFFF?Text=Morning+News",
                    videoUrl = "",
                    isLive = false,
                    channelLogoUrl = "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
                    channelName = "Live News"
                )
            )
        ),
        Channel(
            id = "2",
            name = "Live Sports",
            logoUrl = "https://via.placeholder.com/150/00FF00/FFFFFF?Text=Sports",
            programs = listOf(
                Program(
                    id = "201",
                    title = "Live Football Match",
                    description = "The biggest match of the season.",
                    cardImageUrl = "https://via.placeholder.com/500x280/00FF00/FFFFFF?Text=Live+Football",
                    backgroundImageUrl = "https://via.placeholder.com/1920x1080/00FF00/FFFFFF?Text=Live+Football",
                    videoUrl = "",
                    isLive = true,
                    channelLogoUrl = "https://via.placeholder.com/150/00FF00/FFFFFF?Text=Sports",
                    channelName = "Live Sports"
                )
            )
        )
    )
}