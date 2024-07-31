package com.zhuravishkin.courses.javarush.jaxbexample;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
public class Zoo {
    @XmlElementWrapper(name = "animals", nillable = true)
    public List animals = new ArrayList();
}

@XmlType(name = "tiger")
class Cat {
    @XmlElement(name = "catname")
    public String name;
    @XmlElement(name = "catage")
    public int age;
    @XmlAttribute(name = "catweighr")
    public int weight;
}

@XmlType(name = "mops")
class Dog {
    @XmlElement(name = "dogname")
    public String name;
    @XmlAttribute
    public int age;
    @XmlAttribute(name = "dogweight")
    public int weight;
}

class jaxbMain {
    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat();
        cat.name = "Musay";
        cat.age = 15;
        cat.weight = 4;

        Dog dog = new Dog();
        dog.name = "Nicka";
        dog.age = 6;
        dog.weight = 5;

        Zoo zoo = new Zoo();
        zoo.animals.add(cat);
        zoo.animals.add(dog);

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Zoo.class, Cat.class, Dog.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(zoo, writer);

        System.out.println(writer);

        StringReader reader = new StringReader(writer.toString());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Zoo animals = (Zoo) unmarshaller.unmarshal(reader);

        System.out.println(animals.animals.getClass().getSimpleName() + ": " + animals.animals);
    }
}
