use niote;

###################################################################################################################################################

####
# Promedios horarios para los registros de humedad
####
INSERT INTO humedad_promedios SELECT CodigoEstacion,CodigoSensor,FechaObservacion,Dia,Mes,Anio,Fecha,Hora,AVG(ValorObservado) as ValorObservado,NombreEstacion,
Departamento,Municipio,ZonaHidrografica,Latitud,Longitud,DescripcionSensor,UnidadMedida FROM niote.humedad GROUP BY CodigoEstacion,Fecha,Hora;

####
# Promedios horarios para los registros de precipitación
####
use niote;
INSERT INTO precipitacion_promedio SELECT CodigoEstacion,CodigoSensor,FechaObservacion,Dia,Mes,Anio,Fecha,Hora,AVG(ValorObservado) as ValorObservado,NombreEstacion,
Departamento,Municipio,ZonaHidrografica,Latitud,Longitud,DescripcionSensor,UnidadMedida FROM niote.precipitacion GROUP BY CodigoEstacion,Fecha,Hora;

####
# Promedios horarios para los registros de presión
####
use niote;
INSERT INTO presion_promedio SELECT CodigoEstacion,CodigoSensor,FechaObservacion,Dia,Mes,Anio,Fecha,Hora,AVG(ValorObservado) as ValorObservado,NombreEstacion,
Departamento,Municipio,ZonaHidrografica,Latitud,Longitud,DescripcionSensor,UnidadMedida FROM niote.presion GROUP BY CodigoEstacion,Fecha,Hora;

####
# Promedios horarios para los registros de temperatura
####
use niote;
INSERT INTO temperatura_promedio SELECT CodigoEstacion,CodigoSensor,FechaObservacion,Dia,Mes,Anio,Fecha,Hora,AVG(ValorObservado) as ValorObservado,NombreEstacion,
Departamento,Municipio,ZonaHidrografica,Latitud,Longitud,DescripcionSensor,UnidadMedida FROM niote.temperatura GROUP BY CodigoEstacion,Fecha,Hora;