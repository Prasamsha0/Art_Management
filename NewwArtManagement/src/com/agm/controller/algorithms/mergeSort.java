/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;

import com.agm.model.paintingInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class mergeSort {

    /**
     * Recursive merge sort method.
     *
     * @param artItemList the list to be sorted
     * @return the sorted list
     */
    public List<paintingInfo> sort(List<paintingInfo> artItemList) {
        if (artItemList.size() <= 1) {
            return artItemList; // Base case: already sorted
        }

        // Split the list into two halves
        int mid = artItemList.size() / 2;
        List<paintingInfo> left = new ArrayList<>(artItemList.subList(0, mid));
        List<paintingInfo> right = new ArrayList<>(artItemList.subList(mid, artItemList.size()));

        // Recursively sort both halves
        left = sort(left);
        right = sort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    /**
     * Merges two sorted lists into one sorted list.
     *
     * @param left the left sorted list
     * @param right the right sorted list
     * @return the merged sorted list
     */
    private List<paintingInfo> merge(List<paintingInfo> left, List<paintingInfo> right) {
        List<paintingInfo> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge elements from both lists in sorted order
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getPrice() <= right.get(j).getPrice()) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add any remaining elements from the left list
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        // Add any remaining elements from the right list
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}
