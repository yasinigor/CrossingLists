package ru.crossinglists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElementCollector {
    List<ElementWithType> elements = new ArrayList<>();
    public void AddElement(Element element, int itsList1Element, int itsList2Element) {
        if (element == null) return;
        ElementWithType elementWithType = GetElementWiithTypeByElement(element);
        int typeNewElement = CalculateType(itsList1Element, itsList2Element);
        if (elementWithType == null) // its new element
            elements.add(new ElementWithType(element, typeNewElement));
        else {
            if (elementWithType.getType() == 3) return; // The element type already set: "exists in both arrays"
            if (elementWithType.getType() != typeNewElement)
                elementWithType.setType(3);
        }
    }

    public int CalculateType(int itsList1Element, int itsList2Element) {
        int type = itsList1Element + 2 * itsList2Element;
        return type;
    }

    public List<ElementWithType> getElements() {
        return elements;
    }

    public ElementWithType GetElementWiithTypeByElement(Element element) {
        return elements.stream()
                .filter(element1 -> element.equals(element1.getElement()))
                .findAny()
                .orElse(null);
    }

    public void PrintResult() {
        elements.stream().forEach(elementWiithType -> {
            String stringType = "";
            switch (elementWiithType.getType()){
                case 1 : stringType = "List1"; break;
                case 2 : stringType = "List2"; break;
                case 3 : stringType = "List1,List2"; break;
            }
            System.out.println(elementWiithType.getElement().getName()+" : "+stringType);
        });
    }
}
