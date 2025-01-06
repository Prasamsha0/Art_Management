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
 * @author Dell
 */
public class mergeSort {
    public List<paintingInfo> mergeSortByPrice(List<paintingInfo> list, boolean isDesc) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<paintingInfo> left = mergeSortByPrice(list.subList(0, mid), isDesc);
        List<paintingInfo> right = mergeSortByPrice(list.subList(mid, list.size()), isDesc);

        return merge(left, right, isDesc);
    }

    private List<paintingInfo> merge(List<paintingInfo> left, List<paintingInfo> right, boolean isDesc) {
        List<paintingInfo> result = new ArrayList<>();
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

