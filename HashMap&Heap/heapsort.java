public class heapsort{
    
    public static int compareTo(int[] arr,boolean isMax,int i,int j){
        if(isMax) return arr[i] - arr[j];    //this - other
        else return arr[j] - arr[i];             //other - this
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void downHeapify(int[] arr,int n,boolean isMax,int pi){
        int maxidx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if(lci <= n && compareTo(arr,isMax,lci,maxidx) > 0) maxidx = lci;
        if(rci <= n && compareTo(arr,isMax,rci,maxidx) > 0) maxidx = rci;

        if(pi != maxidx){
            swap(arr,maxidx,pi);
            downHeapify(arr,n,isMax,maxidx);
        }
    }
     
    public static void main(String[] args){

        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        //int[][] arr = { {10, 20}, {30, -2}, {-3, -4}, {5, 6}, {7, 8}, {9, 22}, {11, 13} };
        
        int n = arr.length - 1;
        boolean isMax = false;
        
        for(int i = n; i >= 0 ; i--) downHeapify(arr,n,isMax,i);


        for(int i = 0; i <= n; i++){
            swap(arr,0, n - i);
            downHeapify(arr,n-i-1,isMax,0);
        }

        for(int d: arr) System.out.print(d + " " ); 
    }


}
