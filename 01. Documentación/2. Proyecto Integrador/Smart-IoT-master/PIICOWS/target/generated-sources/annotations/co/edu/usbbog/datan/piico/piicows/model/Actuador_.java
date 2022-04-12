package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Nodo;
import co.edu.usbbog.datan.piico.piicows.model.OrdenActuador;
import co.edu.usbbog.datan.piico.piicows.model.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Actuador.class)
public class Actuador_ { 

    public static volatile SingularAttribute<Actuador, String> descripcion;
    public static volatile SingularAttribute<Actuador, Short> estado;
    public static volatile SingularAttribute<Actuador, String> tipo;
    public static volatile SingularAttribute<Actuador, Sensor> sensor;
    public static volatile SingularAttribute<Actuador, String> id;
    public static volatile SingularAttribute<Actuador, Nodo> nodo;
    public static volatile ListAttribute<Actuador, OrdenActuador> ordenActuadorList;

}