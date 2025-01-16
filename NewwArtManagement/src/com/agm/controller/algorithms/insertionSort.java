/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import java.util.List;
import com.agm.model.GalleryModel;
import java.util.ArrayList;
/**
 *
 * @author Prasamsha Singh
 */
    public class InsertionSort {
     List<GalleryModel> artItemList;
     
     public InsertionSort(){
        artItemList = new ArrayList<>();
    }
    /**
     * Sorts the list of GalleryModel objects by name using Insertion Sort algorithm.
     * 
     * 
     * @param itemsList
     * @param isDesc specifies whether to sort in descending (true) or ascending (false)
     * @return the sorted list of GalleryModel objects
     */
    public List<GalleryModel> sortByName(List<GalleryModel> itemsList, boolean isDesc) {
        // Loop through the list starting from the second element (index 1)
        this.artItemList.clear();
        this.artItemList.addAll(itemsList);
                if (artItemList == null || artItemList.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty.");
        }
        for (int i = 1; i < artItemList.size(); i++) {
            GalleryModel current = artItemList.get(i); // The current element to be inserted
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
    
public List<GalleryModel> sortByname(List<GalleryModel> unsortedData, boolean isDesc) {
    // Create a copy of the data to sort
    List<GalleryModel> dataToSort = new ArrayList<>();
    dataToSort.addAll(unsortedData);

    for (int i = 1; i < dataToSort.size(); i++) {
        // Extract the current element
        GalleryModel current = dataToSort.get(i);
        int j = i - 1;

        // Move elements of the sorted portion to make space for the current element
        while (j >= 0 && (
                isDesc 
                ? dataToSort.get(j).getName().compareToIgnoreCase(current.getName()) < 0 
                : dataToSort.get(j).getName().compareToIgnoreCase(current.getName()) > 0
        )) {
            dataToSort.set(j + 1, dataToSort.get(j));
            j--;
        }

        // Insert the current element at its correct position
        dataToSort.set(j + 1, current);
    }

    return dataToSort;
}

    

    /**
     * Compares two names to determine if they should be swapped based on the order (ascending or descending).
     * 
     * @param current the name of the current GalleryModel object
     * @param extremum the name of the GalleryModel object to compare with
     * @param isDesc specifies whether to sort in descending order (true) or ascending order (false)
     * @return true if the current name should be swapped with the extremum name, false otherwise
     */
    private boolean shouldSwap(String current, String extremum, boolean isDesc) {
        return isDesc ? current.compareTo(extremum) > 0 : current.compareTo(extremum) < 0;
    }
}

