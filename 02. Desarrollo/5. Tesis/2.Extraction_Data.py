import pymysql
import pandas
import csv


class ConexionODSDW:
    def __init__(self):
        
        # Conexion con la base de datos MySQL.
        self.connection = pymysql.connect(
            host="localhost",  # IP
            user="root",  # username
            password="root",  # password
            db="niote2"  # database
        )

        self.cursor = self.connection.cursor()
        print("Conexion establecida")

    # Limpieza de tabla a donde se realizara la inserción.
    def truncate_table(self,variable_climatica):
        cursor = self.connection.cursor()
        sql = f'TRUNCATE `niote2`.`{variable_climatica}`;'
        cursor.execute(sql)
        result = cursor.rowcount
        self.connection.commit()
        cursor.close()
        return result

    # Funcioón para realizar la inserción a la base de datos desde el archivo csv.
    def insert_variable(self,path,variable_climatica):
        cursor = self.connection.cursor()
        with open(path, 'r', encoding='utf8') as csvFile:
            reader = csv.reader(csvFile, delimiter=',')
            for row in reader:
                sql = f'INSERT INTO niote.{variable_climatica} VALUES (%s, %s, %s, %s, %s, %s,%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)'
                cursor.execute(sql, (str(row[0]), str(row[1]), str(row[2]), str(row[3]), str(row[4]), str(row[5]),
                    str(row[6]), str(row[7]), str(row[8]), str(row[9]),
                    str(row[10]), str(row[11]), str(row[12]), str(row[13]), str(row[14]), str(row[15]), str(row[16])))
        csvFile.close()
        result = cursor.rowcount
        self.connection.commit()
        cursor.close()
        return result

# Variables
# Path: ruta donde se encuentra el csv con los registros a insertar.

path='C:/Users/acer/Downloads/Daots2015/Presi_n_Atmosf_rica.csv'

variable_climatica = 'presion'

databaseInsert = ConexionODSDW()
print("Iniciando proceso")
databaseInsert.truncate_table(variable_climatica)
databaseInsert.insert_variable(path,variable_climatica)
print("Insertado")
