package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Actuador;
import co.edu.usbbog.datan.piico.piicows.model.PuertaDeEnlace;
import co.edu.usbbog.datan.piico.piicows.model.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Nodo.class)
public class Nodo_ { 

    public static volatile SingularAttribute<Nodo, String> descripcion;
    public static volatile SingularAttribute<Nodo, PuertaDeEnlace> puertaDeEnlace;
    public static volatile SingularAttribute<Nodo, Short> estado;
    public static volatile ListAttribute<Nodo, Actuador> actuadorList;
    public static volatile ListAttribute<Nodo, Sensor> sensorList;
    public static volatile SingularAttribute<Nodo, String> id;
    public static volatile SingularAttribute<Nodo, String> protocoloComunicacion;

}