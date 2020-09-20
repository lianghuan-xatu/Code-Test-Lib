import java.util.Arrays;

public class MergeSort {
    private static int count;

    /**
     * 在合并两数组时，两数组分别有序所以逆序数为0，i和j指针分别遍历，
     * 当i指针对应的值小于j指针对应的值说明顺序，反之逆序，
     * 当前i指针对应的值和i指针之后对应的值都比i对应的值大，均可构成一对逆序对
     * 所以总体的逆序数应该加上mid-i+1.
     * @param args
     */
    public static void main(String args[]){
        int []arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("逆序对数:"+count);
        }
        public static void mergeSort(int[] arr,int lo,int hi){
        int mid = (lo+hi)/2;
        if(lo<hi){
            int[] temp = new int[arr.length];
            mergeSort(arr,lo,mid);
            mergeSort(arr,mid+1,hi);
            merge(arr,lo,hi,mid,temp);
        }
        }
        public static void merge(int[] arr,int lo,int hi,int mid,int[] temp){
            int i = lo;
            int j = mid+1;
            int t = 0;
            while(i<=mid&&j<=hi){
                if(arr[i]<=arr[j]){
                    temp[t] = arr[i];
                    t++;
                    i++;
                }else{
                    temp[t] = arr[j];
                    t++;
                    j++;
                    count += mid -i +1;
                }
            }
            while(i<=mid){
                temp[t] = arr[i];
                i++;
                t++;
            }
            while(j<=hi){
                temp[t] = arr[j];
                t++;
                j++;
            }
            //将临时数组值复制到原数组
            t = 0;
            while(lo<=hi) {
                arr[lo++] = temp[t++];
            }
    }
}
