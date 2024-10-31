# Sistema de Gestión para Veterinaria "PetVet"

Este repositorio contiene un sistema desarrollado en Java que permite a la veterinaria "PetVet" gestionar de manera eficiente los registros de pacientes, la programación de citas, el seguimiento de tratamientos, y la gestión de historias clínicas. Este sistema resuelve los problemas actuales de PetVet, que depende de procesos manuales y registros en papel, agilizando la atención y mejorando la experiencia de los clientes y sus mascotas.

## Requisitos Previos

Antes de comenzar, asegúrate de tener lo siguiente instalado en tu equipo:

- **Java JDK** (versión recomendada: 8 o superior)
- **XAMPP** (para ejecutar el servidor MySQL)
- **IDE** como **NetBeans** o **Eclipse**

## Configuración de la Base de Datos

Sigue los pasos a continuación para importar y configurar la base de datos que el sistema necesita para funcionar correctamente:

1. **Inicia XAMPP** y asegúrate de que el servidor MySQL esté en ejecución.
2. **Importa la Base de Datos**:
   - Abre tu navegador e ingresa a `http://localhost/phpmyadmin/`.
   - Crea una nueva base de datos llamada **`petvet`** (o el nombre especificado en el código).
   - Dirígete a la pestaña **Importar** y selecciona el archivo SQL ubicado en la carpeta `BD` de este proyecto.
   - Ejecuta la importación para cargar las tablas y datos requeridos en el servidor MySQL.

## Configuración en Java

Para conectar tu proyecto Java con la base de datos en XAMPP, sigue estos pasos:

1. **Agregar el archivo JAR de MySQL a las Librerías del Proyecto**:
   - En tu IDE, haz clic derecho en el proyecto y selecciona **Properties** (Propiedades).
   - Ve a la sección **Libraries** (Librerías).
   - Haz clic en **Add JAR/Folder...** y selecciona el archivo `.jar` que se encuentra en la carpeta `jar` de este proyecto.
   - Esto agregará el conector MySQL necesario para establecer la conexión.

2. **Configurar los Parámetros de Conexión** en tu código:
   - Define el nombre de la base de datos, usuario y contraseña que configuraste en XAMPP (por ejemplo, usuario `root` y contraseña en blanco).
   - Usa el controlador `com.mysql.cj.jdbc.Driver` para la conexión.
   - Asegúrate de que los parámetros de conexión en el código coincidan con tu configuración en XAMPP.

## Ejecución del Proyecto

Después de completar los pasos anteriores:

1. Compila y ejecuta el proyecto desde tu IDE.
2. El sistema debe conectarse a la base de datos MySQL en XAMPP y mostrar un mensaje de éxito si la conexión es establecida correctamente.
3. Explora las funcionalidades del sistema, que incluyen la gestión de pacientes, el seguimiento de citas, y la administración de historias clínicas.

## Archivos Incluidos

- **/BD**: Contiene el archivo SQL para importar la base de datos en MySQL, con las tablas necesarias para gestionar los pacientes, servicios y citas de "PetVet".
- **/jar**: Contiene el archivo `.jar` necesario para conectar Java con MySQL.

## Funcionalidades Principales

Este sistema incluye las siguientes funcionalidades para mejorar la gestión de "PetVet":

- **Registro de Pacientes**: Permite agregar y editar la información de cada mascota.
- **Programación de Citas**: Sistema para organizar y gestionar citas, optimizando la asignación de recursos.
- **Gestión de Historias Clínicas**: Lleva un registro detallado de los tratamientos y cirugías.
- **Reportes**: Genera reportes de las consultas y tratamientos realizados.

## Recursos Adicionales

Para aprender más sobre la conexión de Java con MySQL y otros aspectos técnicos, consulta:

- [Documentación oficial de MySQL Connector/J](https://dev.mysql.com/doc/connector-j/8.0/en/)
- [XAMPP](https://www.apachefriends.org/es/index.html)
- [Documentación de JDBC en Java](https://docs.oracle.com/javase/tutorial/jdbc/)

---

Con esta configuración y guía, "PetVet" estará equipada para gestionar de manera eficaz los registros de sus pacientes y servicios, mejorando la calidad de atención y reduciendo los errores en los procesos.
