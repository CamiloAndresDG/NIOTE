package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Actuador;
import co.edu.usbbog.datan.piico.piicows.model.Dato;
import co.edu.usbbog.datan.piico.piicows.model.Nodo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile SingularAttribute<Sensor, String> descripcion;
    public static volatile SingularAttribute<Sensor, Short> estado;
    public static volatile SingularAttribute<Sensor, String> tipo;
    public static volatile SingularAttribute<Sensor, Integer> frecuencia;
    public static volatile ListAttribute<Sensor, Dato> datoList;
    public static volatile ListAttribute<Sensor, Actuador> actuadorList;
    public static volatile SingularAttribute<Sensor, String> magnitud;
    public static volatile SingularAttribute<Sensor, String> id;
    public static volatile SingularAttribute<Sensor, Nodo> nodo;

}