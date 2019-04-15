# API-CALLCENTER
Microservicio que se encarga del control de llamadas en el callcenter

# Tecnologias
* [Gradle] - Herramienta de construcción de empaquetados y manejo de dependencias
* [Spring boot] - Creación de aplicativos stand-alone
* [Junit] - Pruebas unitarias

# Ejeucion local
Para correr el aplicativo se debe ejecutar el comando en consola
```sh
$java -Dspring.profiles.active=dev  -Dfile.encoding="UTF-8" -Dsun.jnu.encoding="UTF-8"  -jar build/libs/api-callcenter-0.1.0.jar  
```

# Sugerencias 
### Agregar el parámetro de JVM para el correr el perfil DEV

Al agregar las pruebas unitarias también se agregó la perfilación para que al momento de ejetucar los UT no se tome en cuenta el descubrimiento del Eureka y haga las pruebas de base de datos en un esquema (colección) de pruebas, para esto el UT reconoce automáticamente el perfil de pruebas pero para la ejecución normal se debe agregar el siguiente parámetro a través de la JVM
```sh
-Dspring.profiles.active=dev
```

Tener en cuennta las variables de ambiente y configuraciones que se encuentran en el archivo application.yml

