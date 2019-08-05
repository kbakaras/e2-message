package ru.kbakaras.e2.message;

import org.dom4j.Element;

@SuppressWarnings("WeakerAccess")
public class E2SystemError {

    protected Element xml;

    public final E2SystemResponse parent;


    public E2SystemError(Element xml, E2SystemResponse parent) {
        this.xml = xml;
        this.parent = parent;
    }


    public E2SystemError setText(String text) {
        xml.setText(text);
        return this;
    }

}