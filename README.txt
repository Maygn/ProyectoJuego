La clase main AdminCreacionPjLimpio es un main dirigido al administrador del juego, no al usuario final, que solo se utiliza para crear archivos de personaje para jugadores o NPC.

Los archivos de jugadores solo tendrán el nombre del jugador y se colocarán por defecto en personaje/personaje.pj 

Los de los pnj se crearán con la informacion completa y se colocarán en baulNPC/nombredelNPC. 

El personaje asociado a un jugador se puede sobreescribir en el mismo archivo. Si el personaje muere no se puede recuperar, deberá reescribirse.

El archivo del personaje del jugador tiene que estar en el directorio personaje/personaje.pj.  EN LA CARPETA DEJO UN PERSONAJE VACIO PARA QUE CREES UNO COMO QUIERAS
Cualquier personaje con el que se vaya a jugar en pvp estará en visitante/personaje.pj. DEJO UN PERSONAJE PRE-HECHO PARA QUE PUEDAS PROBAR EL PVP SIN TENER QUE MOVER ARCHIVOS

La clase App es el main desde el que el usuario jugará el juego. 


