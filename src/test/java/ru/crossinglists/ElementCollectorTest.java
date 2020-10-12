package ru.crossinglists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementCollectorTest {
    ElementCollector elementCollector = new ElementCollector();
    Element element1 = new Element("Element1");
    Element element2 = new Element("Element1");
    Element element3 = new Element("Element1");
    Element element4 = new Element("Element1");


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
    void whenAddingElementFromList1ThenElementWithTypeMustHaveType_0() {
        elementCollector.AddElement(element1, 1, 0);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(0,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList2ThenErrorElementMustHaveType_1() {
        elementCollector.AddElement(element1, 0, 1);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(1,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList1WhenExistsElementFromList2ThenElementWithTypeMustHaveType_2() {
        elementCollector.AddElement(element1, 0, 1);
        elementCollector.AddElement(element2, 1, 0);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(2,elementWithType.getType());
    }

    @Test
    void whenAddingElementFromList2WhenExistsElementFromList1ThenElementWithTypeMustHaveType_2() {
        elementCollector.AddElement(element1, 1, 0);
        elementCollector.AddElement(element2, 0, 1);
        ElementWithType elementWithType = elementCollector.GetElementWiithTypeByElement(element1);
        assertEquals(2,elementWithType.getType());
    }

}
