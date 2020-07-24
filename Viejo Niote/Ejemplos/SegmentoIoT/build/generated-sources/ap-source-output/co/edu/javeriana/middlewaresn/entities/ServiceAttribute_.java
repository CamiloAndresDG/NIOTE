package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.AttributeType;
import co.edu.javeriana.middlewaresn.entities.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(ServiceAttribute.class)
public class ServiceAttribute_ { 

    public static volatile SingularAttribute<ServiceAttribute, Integer> idServiceAttribute;
    public static volatile SingularAttribute<ServiceAttribute, AttributeType> attributeType;
    public static volatile SingularAttribute<ServiceAttribute, Service> service;
    public static volatile SingularAttribute<ServiceAttribute, String> description;
    public static volatile SingularAttribute<ServiceAttribute, String> value;

}