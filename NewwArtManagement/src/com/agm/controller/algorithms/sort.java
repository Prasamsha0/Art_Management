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
    
    public List<paintingInfo> sortById(List<paintingInfo> itemsList, boolean isDesc) {
        this.artItemList.clear();
        this.artItemList.addAll(itemsList);
        if (artItemList == null || artItemList.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty.");
        }

        for (int i = 0; i < artItemList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(artItemList, i, isDesc);
            if (i != extremumIndex) {
                swap(artItemList, i, extremumIndex);
            }
        }
        return artItemList;
    }
    
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }
    
    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param artSortList the list of paintingInfo objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<paintingInfo> artSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < artSortList.size(); j++) {
            if (shouldSwap(artSortList.get(j).getArtId(), artSortList.get(extremumIndex).getArtId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

     /**
     * Swaps two elements in the list.
     *
     * @param artSortList the list of paintingInfo objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<paintingInfo> artSortList, int i, int j) {
        paintingInfo temp = artSortList.get(i);
        artSortList.set(i, artSortList.get(j));
        artSortList.set(j, temp);
    }
    
     public List<paintingInfo> sortByName(List<paintingInfo> unsortedData, boolean isDesc) {
        
        List<paintingInfo> dataToSort = new ArrayList(); 
        dataToSort.addAll(unsortedData);
        
        for (int i = 0; i < dataToSort.size() - 1; i++) {
            //min value
            int minIndex = i;
            for (int j = i + 1; j < dataToSort.size(); j++) {
                // compare and assign
                if (isDesc) {
                    if (dataToSort.get(j).getName().compareToIgnoreCase(dataToSort.get(minIndex).getName())>0 ) {
                        minIndex = j;
                    }
                } else {
                    if (dataToSort.get(j).getName().compareToIgnoreCase(dataToSort.get(minIndex).getName())<0) {
                        minIndex = j;
                    }
                }
            }
            //swap
            paintingInfo tempStudent = dataToSort.get(minIndex);
            dataToSort.set(minIndex, dataToSort.get(i));
            dataToSort.set(i, tempStudent);
        }
        return dataToSort;
    }
    
}
