package ru.crossinglists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ElementCollectorTest {
    ElementCollector elementCollector = new ElementCollector();
    Element element1 = new Element("Element1");
    Element element2 = new Element("Element1");
    Element element3 = new Element("Element1");
    Element element4 = new Element("Element1");

    @Test
    void HowItsWorking(){
        List<Element> listElement1 = new ArrayList<>();
        listElement1.add(new Element("Element1"));
        listElement1.add(new Element("Element2"));
        listElement1.add(new Element("Element2"));
        listElement1.add(new Element("Element3"));
        listElement1.add(new Element("Element4"));
        listElement1.add(new Element("Element4"));
        listElement1.add(new Element("Element4"));
        listElement1.add(new Element("Element5"));

        List<Element> listElement2 = new ArrayList<>();
        listElement2.add(new Element("Element4"));
        listElement2.add(new Element("Element5"));
        listElement2.add(new Element("Element5"));
        listElement2.add(new Element("Element5"));
        listElement2.add(new Element("Element6"));
        listElement2.add(new Element("Element7"));
        listElement2.add(new Element("Element7"));
        listElement2.add(new Element("Element7"));

        ElementCollector elementCollector = new ElementCollector();
        listElement1.stream().forEach(element -> elementCollector.AddElement(element,1,0));
        listElement2.stream().forEach(element -> elementCollector.AddElement(element,0,1));

        elementCollector.PrintResult();

    }


    @Test
    void whenitsList1ElementEquals1AnditsList2ElementEquals0ThenTypeIs0() {
        int expected = 1;
        int type = elementCollector.CalculateType(1, 0);
        assertEquals(expected, type);
    }

    @Test
    void whenitsList1ElementEquals0AnditsList2ElementEquals1ThenTypeIs1() {
        int expected = 2;
        int type = elementCollector.CalculateType(0, 1);
        assertEquals(expected, type);
    }

    @Test
    void whenNameInElement1And2EqualThenElement1EqualsElement2() {
        assertEquals(element1, element2);
    }

    @Test
    void whenAddingElementThenArrayIncrease() {
        int expected = 1;
        elementCollector.AddElement(element1, 1, 0);
        int result = elementCollector.getElements().toArray().length;
        assertEquals(expected, result);
    }
    @Test
    void whenAddingElementWhichExistsInArrayThenArrayDoNotIncrease() {
        elementCollector.AddElement(element1, 1, 0);
        int expected = 1;
        elementCollector.AddElement(element2, 1, 0);
        int result = elementCollector.getElements().toArray().length;
        assertEquals(expected, result);
    }
    @Test
    void whenAddingNullElementThenNothingHappened() {
        int expected = 0;
        elementCollector.AddElement(null, 0, 0);
        int result = elementCollector.getElements().toArray().length;
        assertEquals(expected, result);
    }

    @Test
    void whenSearchElementWhichDoesntExistInArrayThenRecieveNull() {
        ElementWithType elementFromArray = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(null,elementFromArray);
    }

    @Test
    void whenAddingElementThenArrayHasThisElement() {
        elementCollector.AddElement(element1, 1, 0);
        ElementWithType elementFromArray = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(element1,elementFromArray.getElement());
    }

    @Test
    void whenAddingElementFromList1ThenElementWithTypeMustHaveType_1() {
        elementCollector.AddElement(element1, 1, 0);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(1,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList2ThenErrorElementMustHaveType_2() {
        elementCollector.AddElement(element1, 0, 1);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(2,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList1WhenExistsElementFromList2ThenElementWithTypeMustHaveType_3() {
        elementCollector.AddElement(element1, 0, 1);
        elementCollector.AddElement(element2, 1, 0);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(3,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList2WhenExistsElementFromList1ThenElementWithTypeMustHaveType_3() {
        elementCollector.AddElement(element1, 1, 0);
        elementCollector.AddElement(element2, 0, 1);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(3,elementWithType.getType());
    }

}
