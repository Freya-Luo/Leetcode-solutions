### Thinking
- Logic: traditional BFS
  - record each bus stop belongs to which route
  - when BFS
    - need to keep both `stops & routes` visited status
    - 1st, searching in the current route
      - mark each visited bus stops
    - 2nd, after done with the current route, searching next route
      - mark the current route as finished