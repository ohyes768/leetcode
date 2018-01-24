package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class Code004 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
        double result2 = findMedianSortedArrays2(nums1, nums2);
        System.out.println(result2);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> all = new ArrayList();
        double result = 0;
        for (int i : nums1) {
            all.add(i);
        }
        for (int j : nums2) {
            all.add(j);
        }
        Collections.sort(all);
        if (all.size() % 2 == 0) {
            int tmp = all.size() / 2;
            result = ((double) all.get(tmp - 1) + all.get(tmp)) / 2;
        } else {
            int tmp = (all.size() - 1) / 2;
            result = all.get(tmp);
        }
        return result;
    }

    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

