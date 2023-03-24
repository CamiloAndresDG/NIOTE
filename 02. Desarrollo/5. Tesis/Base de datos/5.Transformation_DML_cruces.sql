USE niote;

###################################################################################################################################################

####
# Combinación entre humedad y precipitación para la estación 21205710
####
INSERT INTO cruce_humedad_precipitacion (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM humedad_promedios as p1 
INNER JOIN precipitacion_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205710'));


####
# Combinación entre humedad y precipitación para la estación 21205012
####
INSERT INTO cruce_humedad_precipitacion (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM humedad_promedios as p1 
INNER JOIN precipitacion_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205012'));


####
# Combinación entre humedad y precipitación para la estación 21206960
####
INSERT INTO cruce_humedad_precipitacion (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM humedad_promedios as p1 
INNER JOIN precipitacion_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21206960'));


###################################################################################################################################################

####
# Combinación entre presión y temperatura para la estación 21205710
####
INSERT INTO cruce_presion_temperatura (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM presion_promedio as p1 
INNER JOIN temperatura_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205710'));

####
# Combinación entre presión y temperatura para la estación 21205012
####
INSERT INTO cruce_presion_temperatura (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM presion_promedio as p1 
INNER JOIN temperatura_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205012'));

####
# Combinación entre presión y temperatura para la estación 21206960
####
INSERT INTO cruce_presion_temperatura (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservado as ValorObservadoVr1,p1.UnidadMedida as UnidadMedidaVr1,p2.ValorObservado as ValorObservadoVr2,p2.UnidadMedida as UnidadMedidaVr2,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM presion_promedio as p1 
INNER JOIN temperatura_promedio as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21206960'));


###################################################################################################################################################

####
# Combinación entre humedad, presión, precipitación y temperatura para la estación 21205710
####
INSERT INTO cruces_h_p_p_t (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservadoVr1,p1.UnidadMedidaVr1,p1.ValorObservadoVr2,p1.UnidadMedidaVr2,
p2.ValorObservadoVr1 as ValorObservadoVr3,p2.UnidadMedidaVr1 as UnidadMedidaVr3,
p2.ValorObservadoVr2 as ValorObservadoVr4,p2.UnidadMedidaVr2 as UnidadMedidaVr4,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM cruce_humedad_precipitacion as p1 
INNER JOIN cruce_presion_temperatura as p2 
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205710'));

####
# Combinación entre humedad, presión, precipitación y temperatura para la estación 21205012
####
INSERT INTO cruces_h_p_p_t (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservadoVr1,p1.UnidadMedidaVr1,p1.ValorObservadoVr2,p1.UnidadMedidaVr2,
p2.ValorObservadoVr1 as ValorObservadoVr3,p2.UnidadMedidaVr1 as UnidadMedidaVr3,
p2.ValorObservadoVr2 as ValorObservadoVr4,p2.UnidadMedidaVr2 as UnidadMedidaVr4,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM cruce_humedad_precipitacion as p1 
INNER JOIN cruce_presion_temperatura as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21205012'));

####
# Combinación entre humedad, presión, precipitación y temperatura para la estación 21206960
####
INSERT INTO cruces_h_p_p_t (SELECT p1.CodigoEstacion, p1.CodigoSensor,p1.FechaObservacion,p1.Dia,p1.Mes,p1.Anio,p1.Fecha,p1.Hora,
p1.ValorObservadoVr1,p1.UnidadMedidaVr1,p1.ValorObservadoVr2,p1.UnidadMedidaVr2,
p2.ValorObservadoVr1 as ValorObservadoVr3,p2.UnidadMedidaVr1 as UnidadMedidaVr3,
p2.ValorObservadoVr2 as ValorObservadoVr4,p2.UnidadMedidaVr2 as UnidadMedidaVr4,
p1.NombreEstacion,p1.Departamento,p1.Municipio,p1.ZonaHidrografica,p1.Latitud,p1.Longitud
FROM cruce_humedad_precipitacion as p1 
INNER JOIN cruce_presion_temperatura as p2
ON p1.CodigoEstacion=p2.CodigoEstacion 
WHERE (p1.Fecha=p2.Fecha) AND (p1.Hora=p2.Hora) AND (p1.CodigoEstacion='21206960'));