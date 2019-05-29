package ru.kbakaras.e2.message;

import org.dom4j.Element;

public class E2SystemResponse extends E2Payload {

    public final E2Response parent;

    public E2SystemResponse(Element xml, E2Response parent) {
        super(xml);
        this.parent = parent;
    }

}