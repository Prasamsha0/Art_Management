/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import com.agm.model.GalleryModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prasamsha Singh 23048580 
 * 
 */
public class MergeSort {
    /**
     * Sorts a list of GalleryModel objects by their price using Merge Sort.
     * @param artItemList the list of GalleryModel objects
     * @param isDesc true for descending order otherwise false 
     * @return merge(left, right, isDesc)
     */
    public List<GalleryModel> mergeSortByPrice(List<GalleryModel> artItemList, boolean isDesc) {
        // Base case: if the list size is 1 or less, it is already sorted.
        if (artItemList.size() <= 1) {
            return artItemList;
        }

        // Splitting the list into two parts
        int mid = artItemList.size() / 2;
        List<GalleryModel> left = new ArrayList<>();
        List<GalleryModel> right = new ArrayList<>();

        // Add elements to the left half
        for (int i = 0; i < mid; i++) {
            left.add(artItemList.get(i));
        }

        // Add elements to the right half
        for (int i = mid; i < artItemList.size(); i++) {
            right.add(artItemList.get(i));
        }

        // sort left and right
        left = mergeSortByPrice(left, isDesc);
        right = mergeSortByPrice(right, isDesc);

        // Merge the two sorted left and right
        return merge(left, right, isDesc);
    }

    /**
     * Merges two sorted lists of GalleryModel objects into a single sorted list.
     *
     * @param left the first sorted list
     * @param right the second sorted list
     * @param isDesc true for descending order, false for ascending
     * @return the merged sorted list
     */
    private List<GalleryModel> merge(List<GalleryModel> left, List<GalleryModel> right, boolean isDesc) {
        List<GalleryModel> mergedList = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        // Merge elements from both lists in the desired order
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (isDesc
                    ? left.get(leftIndex).getPrice() >= right.get(rightIndex).getPrice()
                    : left.get(leftIndex).getPrice() <= right.get(rightIndex).getPrice()) {
                mergedList.add(left.get(leftIndex++));
            } else {
                mergedList.add(right.get(rightIndex++));
            }
        }

        // Add any remaining elements from the left list
        while (leftIndex < left.size()) {
            mergedList.add(left.get(leftIndex++));
        }

        // Add any remaining elements from the right list
        while (rightIndex < right.size()) {
            mergedList.add(right.get(rightIndex++));
        }

        return mergedList;
    }
}

