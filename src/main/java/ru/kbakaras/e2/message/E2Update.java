package ru.kbakaras.e2.message;

import org.dom4j.Element;

import java.util.UUID;

/**
 * Обертка используемая для выполнения запросов на обновление.
 * Используется в случаях когда необходимо отправить обновленный объект в другие системы через E2.
 * Например созданную в одной системе заявку нужно отправить на обработку в другую систему.
 */
public class E2Update extends E2Payload implements E2XmlProducer {
    public E2Update() {
        super(Use.createRoot("updateRequest", E2.NS));
    }
    public E2Update(Element xml) {
        super(xml);
    }
    public E2Update(String xmlStr) {
        super(Use.parse4Root(xmlStr));
    }


    public UUID systemUid() {
        return UUID.fromString(xml.attributeValue(E2.SYSTEM_UID));
    }

    public String systemName() {
        return xml.attributeValue(E2.SYSTEM_NAME);
    }


    /**
     * uid уникальный для каждой системы присоединенной к E2. В большинстве случаев находится в конфигурационном
     * файле системы.
     * Этот uid используется в E2 при маршрутизации запросов между системами.
     *
     * @param systemUid the system uid
     *
     * @return E2Update объект
     */
    public E2Update setSystemUid(String systemUid) {
        xml.addAttribute(E2.SYSTEM_UID, systemUid);
        return this;
    }

    /**
     * Имя системы. Не влияет на маршрутизацию и обработку данных. Используется для форматирования данных в
     * удобном для человека виде.
     * Например если ответы получены из нескольких систем и человек должен решить ответ какой системы для него
     * наиболее подходящий.
     *
     * @param systemName the system name
     *
     * @return E2Update объект
     */
    public E2Update setSystemName(String systemName) {
        xml.addAttribute(E2.SYSTEM_NAME, systemName);
        return this;
    }

    @Override
    public Element xml() {
        reorderEntitiesAndStates();
        return xml;
    }
}