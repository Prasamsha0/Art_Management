/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.controller.algorithms;
import com.agm.model.paintingInfo;
import java.util.List;

/**
 *
 * @author Dell
 */
public class binarySearch {
    public paintingInfo searchByName(String searchValue, List<paintingInfo> studentList, int left, int right) {
    if (right < left) {
        return null;
    }

    int mid = (left + right) / 2;

    // Convert to lowercase for case-insensitive comparison
    String midName = studentList.get(mid).getName().toLowerCase();
    String searchKey = searchValue.toLowerCase();

    if (midName.equals(searchKey)) {
        return studentList.get(mid);
    } else if (searchKey.compareTo(midName) < 0) {
        return searchByName(searchValue, studentList, left, mid - 1);
    } else {
        return searchByName(searchValue, studentList, mid + 1, right);
    }
}

}
