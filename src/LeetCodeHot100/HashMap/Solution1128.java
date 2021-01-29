package LeetCodeHot100.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Domino,Integer> map = new HashMap<>();
        for(int[] domino:dominoes){
            Domino d = new Domino(domino[0],domino[1]);
            map.put(d,map.getOrDefault(d,0)+1);
        }
        int ans = 0;
        for(int count:map.values()){
            ans+=(count*(count-1))/2;
        }
        return  ans;
    }
}

class Domino{
    private int head;
    private int tail;

    public Domino(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domino)) return false;
        Domino domino = (Domino) o;
        return (head == domino.head && tail == domino.tail) || (head == domino.tail && tail == domino.head);
    }

    @Override
    public int hashCode() {
        return head>tail ? tail*10+head : head*10+tail;
    }
}
