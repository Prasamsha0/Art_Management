/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
The is the model class where is the base for most of the classes on this program. 
*/
package com.agm.controller.algorithms;
import com.agm.model.GalleryModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Prasamsha Singh 
 * 
 */

public class SelectionSort {
        List<GalleryModel> artItemList;

    public SelectionSort(){
        artItemList = new ArrayList<>();
    }
    
    public List<GalleryModel> sortById(List<GalleryModel> itemsList, boolean isDesc) {
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
     * @param artSortList the list of GalleryModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<GalleryModel> artSortList, int startIndex, boolean isDesc) {
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
     * @param artSortList the list of GalleryModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<GalleryModel> artSortList, int i, int j) {
        GalleryModel temp = artSortList.get(i);
        artSortList.set(i, artSortList.get(j));
        artSortList.set(j, temp);
    }
}
