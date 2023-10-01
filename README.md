## Estructura del proyecto

La estructura del proyecto es la clásica de un proyecto
gradle con varios subproyectos. Nos encontraremos los 
siguientes archivos y carpetas:

- `lib` Subproyecto para la librería.
- `app` Subproyecto para la aplicación de consola.
- `gradlew[.bat]` Script para usar gradle incluido en el proyecto.
- `settings.gradle` Archivo de configuración donde se define el nombre del proyecto
  así como los subproyectos incluidos.

## Librería
El subproyecto de librería está destinado a crear la lógica
de negocio separada de la propia aplicación. 

## Aplicación
El subproyecto de aplicación está destinado a la implementación de
una aplicación de consola (CLI - Command Line Interface).

## Compilación del proyecto
Para compilar el proyecto completo
```
./gradlew build
```

Para compilar uno de los subproyectos en concreto:
```
./gradlew build -p lib
./gradlew build -p app
```
## Comprobar tests en el proyecto
Para lanzar todos los tests del proyecto
```
./gradlew test
```

Para lanzar los test de un subproyecto en concreto:
```
./gradlew test -p lib
./gradlew test -p app
```
## Uso de la aplicación de consola

Al compilar el subproyecto `app` se genera una distribución de la
aplicación como archivo comprimido `build/distributions/app.zip`. 
Al descomprimir, nos aparecerá una carpeta `app` que contendrá los .jar
generados de la compilacion (subcarpeta `lib`) y los scripts para 
lanzarla la aplicación (subcarpeta `app`).

## Comandos disponibles

```
app.bat add <key> <value>  # Añade un valor a la librería en la coleccion default
app.bat add <key> <value> -collect <collection> # Agrega un nuevo par de clave-valor a la colección indicada
app.bat put <key> <value>  # Actualiza un valor de la librería en la coleccion default si existe
app.bat put <key> <value> -collect <collection> # Actualiza un par de clave-valor en la colección indicada si existe, sino lo crea
app.bat get <key>          # Obtiene un valor de la librería en la coleccion default si existe
app.bat get <key> -collect <collection> # Obtiene un valor de la Colección indicada si existe
app.bat remove <key>       # Elimina un valor de la librería en la coleccion default si existe
app.bat remove <key> -collect <collection> # Elimina un valor de la Colección indicada si existe
app.bat exists <key>       # Comprueba si existe un valor en la librería en la coleccion default
app.bat exists <key> -collect <collection> # Comprueba si existe un valor en la Colección indicada
app.bat get-all            # Obtiene todas las claves de la librería en la coleccion default
app.bat get-all -collect <collection> # Obtiene todas las claves de la Colección indicada
app.bat get-all -c        # Obtiene la cantidad de valores de la librería en la coleccion default
app.bat get-all -c -collect <collection> # Obtiene la cantidad de valores de la Colección indicada

```

### Test unitarios
El proyecto cuenta con test unitarios que comprueban el correcto funcionamiento de cada uno de los métodos y clases implementadas

### Colecciones
El proyecto cuenta con colecciones de datos que permiten almacenar y recuperar datos de forma eficiente. En el caso de que no se indique una coleccion los datos se almacenaran en una coleccion "default".
Para indicar la coleccion es necesario utilizar cualquiera de los siguientes parametros:
- -collect <nombre-de-la-coleccion>
- --collection <nombre-de-la-coleccion>

### Persistencia con Encriptacion
Todos los datos almacenados se encuentran encriptados para que en caso de acceder al archivo de persistencia no se puede acceder a la información

### Persistencia con compresion
Todos los datos almacenados se encuentran comprimidos en un solo archivo zip por cada colección.



[gradle]: https://gradle.org
[picocli]: https://picocli.info
