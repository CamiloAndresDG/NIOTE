USE niote;

###################################################################################################################################################

####
# Eliminación de registros no necesarios para humedad
####
DELETE FROM niote.humedad WHERE CodigoEstacion='CodigoEstacion';

####
# Eliminación de registros no necesarios para precipitacion
####
DELETE FROM niote.precipitacion WHERE CodigoEstacion='CodigoEstacion';

####
# Eliminación de registros no necesarios para presion
####
DELETE FROM niote.presion WHERE CodigoEstacion='CodigoEstacion';

####
# Eliminación de registros no necesarios para temperatura
####
DELETE FROM niote.temperatura WHERE CodigoEstacion='CodigoEstacion';
