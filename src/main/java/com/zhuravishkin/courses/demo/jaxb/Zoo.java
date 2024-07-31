package com.zhuravishkin.courses.demo.jaxb;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "zoo")
@XmlRootElement
public class Zoo {
    @XmlElementWrapper(name = "wild_animals", nillable = true)
    @XmlElement(name = "tiger")
    public List<Cat> animals = new ArrayList<>();
}

class Cat {
    @XmlElement(name = "cat_name")
    public String name;
    @XmlAttribute(name = "cat_age")
    public int age;
    @XmlAttribute(name = "cat_weight")
    public int weight;
}
