import pandas as pd
from datetime import datetime

###
#TODO Apertura del csv
###
abierto=pd.read_csv(r"C:\Users\acer\Documents\GitHub\NIOTE\02. Desarrollo\4. Ante Proyecto\Data\Datos_Hidrometeorol_gicos_Crudos_-_Red_de_Estaciones_IDEAM___Temperatura\Datos_Hidrometeorol_gicos_Crudos_-_Red_de_Estaciones_IDEAM___Temperatura.csv")
#abierto['FechaObservacion2'] = abierto['FechaObservacion'].replace('/','')


###
#TODO Verificación de la data descargada
###

## Retorno de los primeros registros
# abierto.head()

## Retorno de los ultimos registros
# abierto.tail()

# # Descripción del tipo de dato de las columnas
# abierto.info()

## Muestreo estadistico de la tabla (estadistica descriptiva)
# print(abierto.describe(include="all"))

#Promedio de la temperatura en Bogota
#print(abierto["ValorObservado"].mean())


###
#TODO Limpieza de data
###

## Impresión del Pandas (CSV)
#print(abierto)

## Eliminación de filas con NAs dentro del DataFrame
#DataSinNA=abierto.dropna(axis=0, inplace=True)
#abierto.dropna(axis=0, inplace=True) Elimina directamente dentro del DataFrame los datos NA


## Impresión del Pandas (CSV) sin NAs
#print(DataSinNA)

#Extraemos las fechas de los archivos que se van a descargar

abierto["ValorObservado2"]= pd.to_datetime(abierto["ValorObservado"])
print(abierto)

abierto2=pd.read_csv(r"C:\Users\acer\Documents\GitHub\NIOTE\02. Desarrollo\4. Ante Proyecto\Data\Datos_Hidrometeorol_gicos_Crudos_-_Red_de_Estaciones_IDEAM___Temperatura\DataComprobar.csv")
print(abierto2)
