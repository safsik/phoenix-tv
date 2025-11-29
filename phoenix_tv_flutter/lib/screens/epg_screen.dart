import 'package:flutter/material.dart';
import 'package:phoenix_tv_flutter/data/mock_data.dart';

class EpgScreen extends StatelessWidget {
  const EpgScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Electronic Program Guide'),
      ),
      body: ListView.builder(
        itemCount: mockChannels.length,
        itemBuilder: (context, index) {
          final channel = mockChannels[index];
          return Padding(
            padding: const EdgeInsets.symmetric(vertical: 8.0),
            child: Row(
              children: [
                SizedBox(
                  width: 100,
                  child: Image.network(channel.logoUrl),
                ),
                Expanded(
                  child: SizedBox(
                    height: 100,
                    child: ListView.builder(
                      scrollDirection: Axis.horizontal,
                      itemCount: channel.programs.length,
                      itemBuilder: (context, index) {
                        final program = channel.programs[index];
                        return Container(
                          width: 200,
                          margin: const EdgeInsets.symmetric(horizontal: 4.0),
                          decoration: BoxDecoration(
                            color: program.isLive ? Colors.red : Colors.grey[800],
                            borderRadius: BorderRadius.circular(8),
                          ),
                          child: Padding(
                            padding: const EdgeInsets.all(8.0),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  program.title,
                                  style: const TextStyle(
                                    fontWeight: FontWeight.bold,
                                  ),
                                ),
                                Text(program.description),
                              ],
                            ),
                          ),
                        );
                      },
                    ),
                  ),
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}
