package com.riscoapp.riscoappbackend.service;

import com.riscoapp.riscoappbackend.datamodel.Element;

import java.util.List;

public interface IElementService {
    List<Element> selectItems(float maxWeight, float minCalories);
}
