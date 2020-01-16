package atguigu.recursion;

public class MiGong {

    public static void main(String[] args) {

        int[][] map = new int[8][7];
        drawMap(map);


    }

    /**
     * 使用递归回溯来给小球找路
     * 说明
     * 1、map表示地图
     * 2、i，j表示从地图的那个位置开始出发(i,j)
     * 3、如果小球能到map[6][5]位置，说明通路找到
     * 4、约定：当map[i][j]为 0表示该点没有走过，1表示墙，2表示通路可以走，3表示该点已经走过，但是走不通
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map,int i, int j){


    }

    private static void drawMap(int[][] map) {
        //使用1表示墙，顶行和底行设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右两列设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图的情况");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


}
