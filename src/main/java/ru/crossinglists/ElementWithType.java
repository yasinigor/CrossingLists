package ru.crossinglists;

public class ElementWithType {

    Element element;
    int type;

    public ElementWithType(Element element, int type) {
        this.element = element;
        this.type = type;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
