import 'package:flutter/material.dart';
import 'package:flutter_animate/flutter_animate.dart';
import 'package:phoenix_tv_flutter/data/mock_data.dart';
import 'package:phoenix_tv_flutter/screens/epg_screen.dart';
import 'package:phoenix_tv_flutter/widgets/content_carousel.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: CustomScrollView(
        slivers: [
          SliverAppBar(
            expandedHeight: 200.0,
            floating: false,
            pinned: true,
            flexibleSpace: FlexibleSpaceBar(
              title: const Text('Phoenix TV').animate().fadeIn(delay: 300.ms, duration: 500.ms),
              background: Image.network(
                mockMovies.first.backgroundImageUrl,
                fit: BoxFit.cover,
              ),
            ),
            actions: [
              IconButton(
                icon: const Icon(Icons.tv),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const EpgScreen(),
                    ),
                  );
                },
              ),
            ],
          ),
          SliverList(
            delegate: SliverChildBuilderDelegate(
              (context, index) {
                return ContentCarousel(
                  title: movieCategories[index],
                  movies: mockMovies,
                );
              },
              childCount: movieCategories.length,
            ),
          ),
        ],
      ),
    );
  }
}
