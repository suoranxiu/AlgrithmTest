//package LeetCodeHot100.BFS;
//
//
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution1293 {
//    class Node{
//        public int x;
//        public int y;
//        public int layer;
//        public int blockCount;
//        public Node(int x,int y,int layer,int blockCount) {
//            this.x = x;
//            this.y = y;
//            this.layer = layer;
//            this.blockCount = blockCount;
//
//        }
//    }
//    private static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
//    public int shortestPath(int[][] grid, int k) {
//        Queue<Node> queue = new LinkedList<>();
////        if(grid[]
////        )
//        queue.add(new Node(0, 0, 0, ));
//        int x = -1;
//        int y = -1;
//        int blockCount = 0;
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            //找到最后结果
//            if (node.x == grid.length - 1 && node.y == grid[0].length - 1) {
//                return node.layer;
//            }
//            for (int[] dic : direction) {
//                x = node.x + dic[0];
//                y = node.x + dic[1];
//                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
//                    continue;
//                }
//                if (node.blockCount < k) {
//                    if (grid[x][y] == 1) {
//                        queue.offer(new Node(x, y, node.layer + 1, node.blockCount + 1));
//                    } else if (grid[x][y] == 0) {
//                        queue.offer(new Node(x, y, node.layer + 1, node.blockCount));
//                    }
//                    grid[x][y] = -1;
//                }
//            }
//            System.out.println("-1");
//
//            return null;
//        }
//    }
//}
