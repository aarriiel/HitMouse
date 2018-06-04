package sample;

public class BubbleSort {

    public void bubblesort(int[] list, int[] hi, int[][] sort, int a) {
        boolean NextPass = true;
        for (int k = 0; k < a - 1 && NextPass; k++) {
            NextPass = false;
            for (int i = k + 1; i < a; i++) {
                if (hi[k] > hi[i]) {
                    int tmp = hi[i];
                    hi[i] = hi[k];
                    hi[k] = tmp;
                    tmp = list[i];
                    list[i] = list[k];
                    list[k] = tmp;
                    tmp = sort[i][0];
                    sort[i][0] = sort[k][0];
                    sort[k][0] = tmp;
                    tmp = sort[i][1];
                    sort[i][1] = sort[k][1];
                    sort[k][1] = tmp;
                    NextPass = true;
                }
            }
        }
    }

    public static void selectionSort(int[] num,int[][] sort,int count){
        for(int i = 0; i < count; i++) {
            int m = i;
            for(int j = i + 1; j < count; j++){
                if(num[j] > num[m]) m = j;
            }
            if(i != m){
                swap(num,sort,i,m);
            }
        }
    }


    private static void swap(int[] number,int[][] sort, int i, int j) {
        int t = number[i];
        number[i] = number[j];
        number[j] = t;
        t= sort[i][0];
        sort[i][0] = sort[j][0];
        sort[j][0] = t;
        t = sort[i][1];
        sort[i][1] = sort[j][1];
        sort[j][1] = t;
    }
}


