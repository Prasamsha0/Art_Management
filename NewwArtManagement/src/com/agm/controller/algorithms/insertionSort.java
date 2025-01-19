/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
/**
 * This class implements the Insertion Sort algorithm to sort the names in the list of GalleryModel Objects
 * Names are sorted in both ascending and descending
 */
import java.util.List;
import com.agm.model.GalleryModel;
import java.util.ArrayList;

/**
 *
 * @author Prasamsha Singh
 */


public class InsertionSort {

    List<GalleryModel> artItemList;

    /**
     * Constructor to initialize the artItemList.
     */
    public InsertionSort() {
        artItemList = new ArrayList<>();
    }

    /**
     * Sorts the list of GalleryModel objects by name using Insertion Sort
     * algorithm.
     *
     * @param itemsList
     * @param isDesc specifies whether to sort in descending (true) or ascending(false)
     * @return the sorted list of GalleryModel objects
     */
    public List<GalleryModel> sortByname(List<GalleryModel> itemsList, boolean isDesc) {
        artItemList.addAll(itemsList);
        for (int i = 1; i < artItemList.size(); i++) {
            GalleryModel current = artItemList.get(i);
            int j = i - 1;
            while (j >= 0 && (isDesc
                    ? artItemList.get(j).getName().compareToIgnoreCase(current.getName()) < 0
                    : artItemList.get(j).getName().compareToIgnoreCase(current.getName()) > 0)) {
                artItemList.set(j + 1, artItemList.get(j));
                j--;
            }
            artItemList.set(j + 1, current);
        }
        return artItemList;
    }
}
