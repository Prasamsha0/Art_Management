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
    public List<GalleryModel> mergeSortByPrice(List<GalleryModel> list, boolean isDesc) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<GalleryModel> left = mergeSortByPrice(list.subList(0, mid), isDesc);
        List<GalleryModel> right = mergeSortByPrice(list.subList(mid, list.size()), isDesc);

        return merge(left, right, isDesc);
    }

    private List<GalleryModel> merge(List<GalleryModel> left, List<GalleryModel> right, boolean isDesc) {
        List<GalleryModel> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (isDesc
                    ? left.get(i).getPrice() > right.get(j).getPrice()
                    : left.get(i).getPrice() < right.get(j).getPrice()) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }
}

