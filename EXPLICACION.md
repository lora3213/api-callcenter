# Explicacion 

La solucion al problema se decidio abordar por medio del uso de hilos con spring boot, donde cada hilo es un empleado.

* El hilo 1 es el operador
* El hilo 2 es el supervisor
* El hilo 3 es el director

Se creo una clase de tipo CommandLineRunner que hace un ejemplo de ejecucion antes de iniciar el spring boot, en la consola se puede visualizar como trabajan los hilos, y el estado de las llamadas

Adicionalmente se dio solucion a los extra por medio del framework spring boot