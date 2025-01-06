/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import java.util.List;
import com.agm.model.paintingInfo;
/**
 *
 * @author Prasamsha Singh
 */
public class insertionSort {
    /**
     * Sorts the paintings by name using the Insertion Sort algorithm in ascending order.
     * 
     * @param artItemList the list of paintingInfo objects
     * @param isDesc specifies whether to sort in descending order (true) or ascending (false)
     * @return sorted list of paintingInfo objects
     */
    public List<paintingInfo> sortByName(List<paintingInfo> artItemList, boolean isDesc) {
        // Iterating from the second element (index 1)
        for (int i = 1; i < artItemList.size(); i++) {
            paintingInfo current = artItemList.get(i); // Current element to be inserted
            int j = i - 1;

            // Compare the current name with the previous elements
            // Move elements that are greater (or smaller based on isDesc) than current.name one position ahead
            while (j >= 0 && shouldSwap(artItemList.get(j).getName(), current.getName(), isDesc)) {
                artItemList.set(j + 1, artItemList.get(j)); // Shift element to the right
                j--; // Move j to the left
            }

            // Insert the current element into the correct position
            artItemList.set(j + 1, current);
        }

        return artItemList; // Return the sorted list
    }

    /**
     * Determines whether the current value should be swapped with the extremum value.
     * 
     * @param current the current value
     * @param extremum the extremum value (previous value in case of ascending order)
     * @param isDesc specifies whether to sort in descending (true) or ascending (false)
     * @return true if the current value should be swapped with the extremum, false otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        return isDesc ? current.compareTo(extremum) > 0 : current.compareTo(extremum) < 0;
    }
}
