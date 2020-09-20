public class Tested {

public static void main(String args[]){
    System.out.println(cowNum(20));
    }

    static int cowNum(int year){
    System.out.println((year)+"递归");
        int n=0;
        int sumCow=1;
        for(n=1;n<=year;n++){
            System.out.println("第"+n+"年"+"MAX"+year+"sumCow"+sumCow);
            if(n>=4){

                if((year-n)>3){

                    sumCow+=cowNum(year-n);
                    
                }else{
                    sumCow++;
                    
                }
            }
        }
        System.out.println("//");
        return sumCow;
    }

}
