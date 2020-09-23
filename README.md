# comedor-api

## Getting Started (Como levantar COMEDOR-API en un ambiente local)

La siguiente guía te permitirá descargar este proyecto y levantar la aplicación de forma local.

#### Requisitos

* JDK 1.8 
* Git (Opciones: Git for Windows o Cygwin)

#### Descarga del proyecto


```git
$ git clone https://github.com/MAPAW-UNLP/comedor-api.git
```


#### Construir y Levantar la aplicación :

Es necesario apuntar la variable de entorno **JAVA_HOME** a la version 1.8 para poder compilar.

```bash
$ export JAVA_HOME=/path/to/jdk1.8
```

Build:

Desde la raiz del proyecto 

```bash
$ ./gradlew assemble
```

Luego:  

```bash
$ $JAVA_HOME/bin/java -jar build/libs/comedor-api.jar
```

Si usas eclipse:

* Importa el repositorio como un proyecto Gradle, dejando la opción Gradle wrapper.
* Para descargar las dependencias, botón derecho sobre el proyecto -> **Gradle -> Refresh Gradle Project**.
* Para lanzar la aplicación:  botón derecho sobre ComedorApplication.java -> Run As : Java Application

#### Codificacion y Formatter:

* Enconding: UTF-8. **En eclipse:** Project -> Properties -> Resoure
* Line Delimiter: Windows (CRLF). **En eclipse:** Project -> Properties -> Resoure
* Formatter: Eclipse [built-in]

#### Sobre liquibase

Sobre el plugin de liquibase se puede leer (no es requerido) https://github.com/liquibase/liquibase-gradle-plugin

Para la creacion de tablas y datos se decidio usar XML en liquibase: https://docs.liquibase.com/concepts/basic/xml-format.html

