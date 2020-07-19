package jianzhi_offer;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_new {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int na = scanner.nextInt();
        int nb = scanner.nextInt();
        int[] stations = new int[na];
        int[] lights = new int[nb];
        int idx = 0;
        while (scanner.hasNext()) {
            stations[idx++] = scanner.nextInt();
            if (idx == stations.length) {
                break;
            }
        }
        idx = 0;
        while (scanner.hasNext()) {
            lights[idx++] = scanner.nextInt();
            if (idx == lights.length) {
                break;
            }
        }
//
//        int[] stations ={3,1,4,2};
//        int[] lights = {3};
        Arrays.sort(stations);
        Arrays.sort(lights);
        int high = 0;
        int low = 0;
        int t,j = 0;
        for(int i = 0; i < stations.length; i++){
            t = i;
            while(stations[i] != lights[j]){
                i++;
            }
            low = Math.max(low,stations[i]-stations[t]);
            if(j == lights.length-1){
                high = Math.max(high,stations[stations.length-1]-lights[lights.length-1]);
                break;
            }else {
                high = Math.max(high,lights[j+1] - lights[j]);
            }
            j++;
        }
        int ans = Math.max(high,low);
        System.out.println(ans);

    }
}
