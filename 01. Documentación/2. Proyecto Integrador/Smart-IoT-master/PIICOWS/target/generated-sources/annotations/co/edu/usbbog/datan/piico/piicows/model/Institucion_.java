package co.edu.usbbog.datan.piico.piicows.model;

import co.edu.usbbog.datan.piico.piicows.model.Proyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T18:33:09")
@StaticMetamodel(Institucion.class)
public class Institucion_ { 

    public static volatile SingularAttribute<Institucion, String> area;
    public static volatile ListAttribute<Institucion, Proyecto> proyectoList;
    public static volatile SingularAttribute<Institucion, String> ciudad;
    public static volatile SingularAttribute<Institucion, Integer> id;
    public static volatile SingularAttribute<Institucion, String> nombre;

}