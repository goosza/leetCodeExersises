public class MedianOfTwoSortedArrays {
    public int[] merge(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] mergedArray = new int[m+n];
        int j = 0, k = 0, i = 0;
            while (j < m && k < n){
                if (nums1[j] <= nums2[k]){
                    mergedArray[i] = nums1[j];
                    j++;
                }else{
                    mergedArray[i] = nums2[k];
                    k++;
                }
                i++;
            }
            while (j < m) {
                mergedArray[i++] = nums1[j++];
            }
            while (k < n) {
                mergedArray[i++] = nums2[k++];
            }
        return mergedArray;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = merge(nums1, nums2);
        int length = mergedArray.length;
        double median;
        if (mergedArray.length % 2 == 0){
            median = (mergedArray[length/2] + mergedArray[length/2 - 1])/2d;
        }
        else{
            median = mergedArray[length/2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
