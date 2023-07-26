package com.riscoapp.riscoappbackend.service.impl;

import com.riscoapp.riscoappbackend.datamodel.Element;
import com.riscoapp.riscoappbackend.repository.IElementRepository;
import com.riscoapp.riscoappbackend.service.IElementService;
import com.riscoapp.riscoappbackend.util.ElementComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementServiceImpl implements IElementService {

    @Autowired
    IElementRepository elementRepository;


    @Override
    public List<Element> selectItems(float maxWeight, float minCalories){

        List<Element> elements = elementRepository.findAll();
        int n = elementRepository.findAll().size();

        elements.sort(new ElementComparator());

        float[][] matriz = new float[n + 1][(int) maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (elements.get(i - 1).getWeight() <= w) {
                    matriz[i][w] = Math.max(elements.get(i - 1).getCalories() + matriz[i - 1][(int) (w - elements.get(i - 1).getWeight())], matriz[i - 1][w]);
                } else {
                    matriz[i][w] = matriz[i - 1][w];
                }
            }
        }

        List<Element> selectedItems = new ArrayList<>();
        int w = (int) maxWeight;

        for (int i = n; i > 0; i--) {
            if (matriz[i][w] != matriz[i - 1][w]) {
                selectedItems.add(elements.get(i - 1));
                w -= elements.get(i - 1).getWeight();
            }
        }

        return selectedItems;

    }


    public String selectExecutor(){

        // Definir los valores de las restricciones
        float minCalories = 100.0f;
        float maxWeight = 5.0f;

        // Resolver el problema de la mochila utilizando programación dinámica
        List<Element> selectedItems = this.selectItems(minCalories, maxWeight);

        // Mostrar los elementos seleccionados
        String message = "Elementos seleccionados:";
        for (Element item : selectedItems) {
            message = message + item.getName() + " - Peso: " + item.getWeight() + " - Calorías: " + item.getCalories();
        }
        return message;
    }


}
