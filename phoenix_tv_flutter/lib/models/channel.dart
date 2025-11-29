class Program {
  final String id;
  final String title;
  final String description;
  final String cardImageUrl;
  final String backgroundImageUrl;
  final String videoUrl;
  final bool isLive;
  final String channelLogoUrl;
  final String channelName;

  Program({
    required this.id,
    required this.title,
    required this.description,
    required this.cardImageUrl,
    required this.backgroundImageUrl,
    required this.videoUrl,
    this.isLive = false,
    required this.channelLogoUrl,
    required this.channelName,
  });
}

class Channel {
  final String id;
  final String name;
  final String logoUrl;
  final List<Program> programs;

  Channel({
    required this.id,
    required this.name,
    required this.logoUrl,
    required this.programs,
  });
}
