package co.edu.javeriana.middlewaresn.entities;

import co.edu.javeriana.middlewaresn.entities.NodeType;
import co.edu.javeriana.middlewaresn.entities.ProtocolType;
import co.edu.javeriana.middlewaresn.entities.Service;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeAttribute;
import co.edu.javeriana.middlewaresn.entities.ServiceNodeValue;
import co.edu.javeriana.middlewaresn.entities.ServiceType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T22:52:50")
@StaticMetamodel(ServiceNode.class)
public class ServiceNode_ { 

    public static volatile SingularAttribute<ServiceNode, ServiceType> serviceType;
    public static volatile ListAttribute<ServiceNode, ServiceNodeValue> serviceNodeValueList;
    public static volatile SingularAttribute<ServiceNode, Integer> idServiceNode;
    public static volatile SingularAttribute<ServiceNode, Service> service;
    public static volatile SingularAttribute<ServiceNode, String> ip;
    public static volatile ListAttribute<ServiceNode, ServiceNodeAttribute> serviceNodeAttributeList;
    public static volatile SingularAttribute<ServiceNode, ProtocolType> protocolType;
    public static volatile SingularAttribute<ServiceNode, NodeType> nodeType;
    public static volatile SingularAttribute<ServiceNode, String> idNode;
    public static volatile SingularAttribute<ServiceNode, Integer> serviceNodeState;
    public static volatile SingularAttribute<ServiceNode, String> idSwsn;

}