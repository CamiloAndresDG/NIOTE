package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Proyecto;
import co.edu.usbbog.datan.piico.piicows.model.PuertaDeEnlace;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Red.class)
public class Red_ { 

    public static volatile SingularAttribute<Red, String> descripcion;
    public static volatile ListAttribute<Red, PuertaDeEnlace> puertaDeEnlaceList;
    public static volatile SingularAttribute<Red, Proyecto> proyecto;
    public static volatile SingularAttribute<Red, String> id;
    public static volatile SingularAttribute<Red, String> nombre;

}