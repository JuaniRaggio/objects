= Empezamos con Java - SubwayCentral
_Este ejercicio es de parcial_

Se desea implementar un conjunto de clases que *modelen el sistema* de *tarjetas* de viaje en subte

// Importante que primero definan bien las responsabilidades:
//
// - Quien es el responsable de ponerle el precio a un viaje?
// - Quien mantiene el saldo de una tarjeta?
// - Quien dice "Puede pagar", "No puede pagar"?
// - Quien es el responsable de hacer el pago?
// - Quien tiene que descontar del pago realizado?

// #align(center)[== Cualidades de las *tarjetas*]
// - *Almacenan un saldo*. Inicio saldo = 0
// - *Recargable*
// - *Consultar saldo*
// - Pertenecen a una *central* emisora
//
// #align(center)[== Cualidades de una *central*]
// - Determina el precio de los viajes
// - Puede *setear* el _precio_ de los viajes




// #align(center)[= Notemos las ventajas de la POO]
// _Si las responsabilidades estan bien distribuidas..._
// - *Agregar "features"* a mi sistema es *sencillo* (no deberia tener que cambiar muchas cosas)
// - *Reutilizacion de codigo* de forma natural
// - Los contratos me permiten tener *control de un proyecto*
//
// *Aprovechen estas ventajas*

