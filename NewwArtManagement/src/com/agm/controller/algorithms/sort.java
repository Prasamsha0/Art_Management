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
 * @author Prasamsha Singh 
 * 
 */

public class sort {
        List<paintingInfo> artItemList;

    public sort(){
        artItemList = new ArrayList<>();
    }
    
    /**
     * Sorts a list of paintingInfo objects by their LMU ID in ascending or
     * descending order.
     *
     * @param itemsList the list of paintingInfo objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    
        /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }
    
    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param studentSortList the list of paintingInfo objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<paintingInfo> studentSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < studentSortList.size(); j++) {
            if (shouldSwap(studentSortList.get(j).getArtId(), studentSortList.get(extremumIndex).getArtId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

     /**
     * Swaps two elements in the list.
     *
     * @param studentSortList the list of paintingInfo objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<paintingInfo> studentSortList, int i, int j) {
        paintingInfo temp = studentSortList.get(i);
        studentSortList.set(i, studentSortList.get(j));
        studentSortList.set(j, temp);
    }
    
    public List<paintingInfo> sortById(List<paintingInfo> itemsList, boolean isDesc) {
        this.artItemList.clear();
        this.artItemList.addAll(itemsList);
        if (artItemList == null || artItemList.isEmpty()) {
            throw new IllegalArgumentException("Student list cannot be null or empty.");
        }

        for (int i = 0; i < artItemList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(artItemList, i, isDesc);
            if (i != extremumIndex) {
                swap(artItemList, i, extremumIndex);
            }
        }
        return artItemList;
    }
}
