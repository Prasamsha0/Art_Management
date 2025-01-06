/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import java.util.List;
import com.agm.model.paintingInfo;
import java.util.ArrayList;
/**
 *
 * @author Prasamsha Singh
 */
public class insertionSort {


    /**
     * Sorts the list of paintingInfo objects by name using Insertion Sort algorithm.
     * 
     * @param artItemList the list of paintingInfo objects
     * @param isDesc specifies whether to sort in descending (true) or ascending (false)
     * @return the sorted list of paintingInfo objects
     */
    public List<paintingInfo> sortByName(List<paintingInfo> artItemList, boolean isDesc) {
        // Loop through the list starting from the second element (index 1)
        for (int i = 1; i < artItemList.size(); i++) {
            paintingInfo current = artItemList.get(i); // The current element to be inserted
            int j = i - 1;

            // Compare and shift the elements of the sorted portion of the list
            // Shift the elements to the right to make space for the current element
            while (j >= 0 && shouldSwap(current.getName(), artItemList.get(j).getName(), isDesc)) {
                artItemList.set(j + 1, artItemList.get(j)); // Shift element to the right
                j--;  // Move the index back
            }

            // Insert the current element into the correct position in the sorted portion of the list
            artItemList.set(j + 1, current);
        }

        return artItemList; // Return the sorted list
    }

    /**
     * Compares two names to determine if they should be swapped based on the order (ascending or descending).
     * 
     * @param current the name of the current paintingInfo object
     * @param extremum the name of the paintingInfo object to compare with
     * @param isDesc specifies whether to sort in descending order (true) or ascending order (false)
     * @return true if the current name should be swapped with the extremum name, false otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        return isDesc ? current.compareTo(extremum) > 0 : current.compareTo(extremum) < 0;
    }
}

