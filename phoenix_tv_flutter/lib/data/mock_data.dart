import '../models/channel.dart';
import '../models/movie.dart';

final List<Movie> mockMovies = [
  Movie(
    id: 1,
    title: 'Zeitgeist 2010: Year in Review',
    description: 'Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.',
    studio: 'Studio Zero',
    videoUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4',
    backgroundImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/bg.jpg',
    cardImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg',
  ),
  Movie(
    id: 2,
    title: 'Google Demo Slam: 20ft Search',
    description: 'Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.',
    studio: 'Studio One',
    videoUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4',
    backgroundImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/bg.jpg',
    cardImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search/card.jpg',
  ),
  Movie(
    id: 3,
    title: 'Introducing Gmail Blue',
    description: 'Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.',
    studio: 'Studio Two',
    videoUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Gmail%20Blue.mp4',
    backgroundImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Gmail%20Blue/bg.jpg',
    cardImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Gmail%20Blue/card.jpg',
  ),
  Movie(
    id: 4,
    title: 'Introducing Google Fiber to the Pole',
    description: 'Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.',
    studio: 'Studio Three',
    videoUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4',
    backgroundImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/bg.jpg',
    cardImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Fiber%20to%20the%20Pole/card.jpg',
  ),
  Movie(
    id: 5,
    title: 'Introducing Google Nose',
    description: 'Fusce id nisi turpis. Praesent viverra bibendum semper. Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.',
    studio: 'Studio Four',
    videoUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Nose.mp4',
    backgroundImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Nose/bg.jpg',
    cardImageUrl: 'https://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool\'s%202013/Introducing%20Google%20Nose/card.jpg',
  ),
];

final List<String> movieCategories = [
  "Category Zero",
  "Category One",
  "Category Two",
  "Category Three",
  "Category Four",
  "Category Five"
];

final List<Channel> mockChannels = [
  Channel(
    id: "1",
    name: "Live News",
    logoUrl: "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
    programs: [
      Program(
        id: "101",
        title: "Live Breaking News",
        description: "The latest news from around the world.",
        cardImageUrl: "https://via.placeholder.com/500x280/FF0000/FFFFFF?Text=Live+News",
        backgroundImageUrl: "https://via.placeholder.com/1920x1080/FF0000/FFFFFF?Text=Live+News",
        videoUrl: "",
        isLive: true,
        channelLogoUrl: "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
        channelName: "Live News",
      ),
      Program(
        id: "102",
        title: "Morning News",
        description: "A look at the day\'s headlines.",
        cardImageUrl: "https://via.placeholder.com/500x280/FF0000/FFFFFF?Text=Morning+News",
        backgroundImageUrl: "https://via.placeholder.com/1920x1080/FF0000/FFFFFF?Text=Morning+News",
        videoUrl: "",
        isLive: false,
        channelLogoUrl: "https://via.placeholder.com/150/FF0000/FFFFFF?Text=News",
        channelName: "Live News",
      ),
    ],
  ),
  Channel(
    id: "2",
    name: "Live Sports",
    logoUrl: "https://via.placeholder.com/150/00FF00/FFFFFF?Text=Sports",
    programs: [
      Program(
        id: "201",
        title: "Live Football Match",
        description: "The biggest match of the season.",
        cardImageUrl: "https://via.placeholder.com/500x280/00FF00/FFFFFF?Text=Live+Football",
        backgroundImageUrl: "https://via.placeholder.com/1920x1080/00FF00/FFFFFF?Text=Live+Football",
        videoUrl: "",
        isLive: true,
        channelLogoUrl: "https://via.placeholder.com/150/00FF00/FFFFFF?Text=Sports",
        channelName: "Live Sports",
      ),
    ],
  ),
];