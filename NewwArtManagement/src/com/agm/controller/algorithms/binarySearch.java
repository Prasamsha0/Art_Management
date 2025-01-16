/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import com.agm.model.GalleryModel;
import java.util.List;

/**
 *
 * @author Prasamsha Singh
 */
public class BinarySearch {
    public GalleryModel searchName(String searchValue, List<GalleryModel> artItemList, int left, int right) {
    if (right < left) {
        return null;
    }

    int mid = (left + right) / 2;

    // Convert to lowercase for case-insensitive comparison
    String midName = artItemList.get(mid).getName().toLowerCase();
    String searchKey = searchValue.toLowerCase();

    if (midName.equals(searchKey)) {
        return artItemList.get(mid);
    } else if (searchKey.compareTo(midName) < 0) {
        return searchName(searchValue, artItemList, left, mid - 1);
    } else {
        return searchName(searchValue, artItemList, mid + 1, right);
    }
}

}
