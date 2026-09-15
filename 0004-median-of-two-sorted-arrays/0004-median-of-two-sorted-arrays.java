class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Make nums1 the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            int partition1 = (low + high) / 2;

            int partition2 = (m + n + 1) / 2 - partition1;

            // Left and right values of nums1
            int left1;
            int right1;

            if (partition1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[partition1 - 1];
            }

            if (partition1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[partition1];
            }

            // Left and right values of nums2
            int left2;
            int right2;

            if (partition2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[partition2 - 1];
            }

            if (partition2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[partition2];
            }

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd number of elements
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even number of elements
                else {
                    return (Math.max(left1, left2)
                            + Math.min(right1, right2)) / 2.0;
                }
            }

            // Move partition1 to the left
            else if (left1 > right2) {
                high = partition1 - 1;
            }

            // Move partition1 to the right
            else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }
}