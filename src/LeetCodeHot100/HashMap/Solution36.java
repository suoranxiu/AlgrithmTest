package LeetCodeHot100.HashMap;

import java.time.Instant;
import java.util.HashMap;

public class Solution36 {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     数字 1-9 在每一行只能出现一次。
     数字 1-9 在每一列只能出现一次。
     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

     说明:
     一个有效的数独（部分已被填充）不一定是可解的。
     只需要根据以上规则，验证已经填入的数字是否有效即可。
     给定数独序列只包含数字 1-9 和字符 '.' 。
     给定数独永远是 9x9 形式的。
     *
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            columns[i] = new HashMap<>();
            rows[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int cur_num = (int) num;
                    int box_index = (i / 3) * 3 + (j / 3);
                    rows[i].put(cur_num, rows[i].getOrDefault(cur_num, 0) + 1);
                    columns[j].put(cur_num, columns[j].getOrDefault(cur_num, 0) + 1);
                    boxes[box_index].put(cur_num, boxes[box_index].getOrDefault(cur_num, 0) + 1);

                    if (rows[i].get(cur_num) > 1 || columns[j].get(cur_num)>1 || boxes[box_index].get(cur_num)>1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
