package lesson13.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ObjectBinding<T> {
    private final JAXBContext context;
    private final T instance;
    private final File file;

    public ObjectBinding(T object, String fileName) throws JAXBException {
        this.context = JAXBContext.newInstance(object.getClass());
        this.instance = object;
        this.file = new File(fileName);
    }

    public void objectToXML() throws JAXBException{
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(instance, file);
    }

    @SuppressWarnings("unchecked")
    public T objectFromXML() throws JAXBException {
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (T) unmarshaller.unmarshal(file);
    }
}
