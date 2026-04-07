class Robot {

    int width, height;
    int x, y;
    int dir;

    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    String[] dirNames = {"East", "North", "West", "South"};

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0; 
        this.perimeter = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        num = num % perimeter;

        while (num > 0) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

           
            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4; 
                continue;
            }

            x = nx;
            y = ny;
            num--;
        }

        if (num == 0 && x == 0 && y == 0) {
            dir = 3; // South
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirNames[dir];
    }
}
