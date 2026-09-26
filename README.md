# SpeedFast - Semana 6

Aplicación de escritorio desarrollada en Java para registrar, consultar, asignar y procesar pedidos de una empresa de reparto. El proyecto integra la interfaz gráfica solicitada en la semana 6 con el modelo orientado a objetos y la simulación concurrente desarrollados durante las semanas anteriores.

## Funcionalidades

- Registro de pedidos de comida, encomienda y express.
- Generación automática del identificador de cada pedido.
- Validación de dirección, distancia, peso y estado del embalaje.
- Registro de encomiendas rechazadas para conservar su trazabilidad.
- Listado de pedidos mediante una tabla actualizable.
- Asignación de repartidores a pedidos pendientes.
- Comprobación de disponibilidad y mochila térmica según el tipo de pedido.
- Reserva, despacho y procesamiento de pedidos aptos para entrega.
- Simulación concurrente con varios repartidores sobre una zona de carga compartida.
- Visualización del resultado final en la interfaz y de los cambios de estado en la consola.

## Reglas principales

- Un pedido de comida requiere un repartidor disponible con mochila térmica.
- Un pedido express requiere un repartidor disponible.
- Una encomienda debe tener un peso mayor que 0 y menor o igual a 50 kg.
- Una encomienda rechazada se registra, pero no permite asignación ni entrega.
- Un pedido debe tener un repartidor compatible antes de ingresar a la zona de carga.
- Los pedidos procesados avanzan desde `PENDIENTE` a `EN_REPARTO` y finalmente a `ENTREGADO`.

## Estructura del proyecto

```text
src/
|-- gestor/
|   |-- ControladorDeEnvios.java
|   `-- ZonaDeCarga.java
|-- interfaces/
|   |-- Cancelable.java
|   |-- Despachable.java
|   `-- Rastreable.java
|-- main/
|   `-- Main.java
|-- modelo/
|   |-- EstadoPedido.java
|   |-- Pedido.java
|   |-- PedidoComida.java
|   |-- PedidoEncomienda.java
|   |-- PedidoExpress.java
|   `-- Repartidor.java
`-- vista/
    |-- LogoSpeedFast.java
    |-- VentanaListaPedidos.java
    |-- VentanaPrincipal.java
    `-- VentanaRegistroPedido.java
```

## Clases principales

- `Pedido`: clase abstracta que concentra los datos y comportamientos comunes.
- `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`: especializaciones con reglas propias.
- `Repartidor`: implementa `Runnable` y procesa los pedidos que tiene asignados.
- `ControladorDeEnvios`: administra el registro, la asignación y la preparación de pedidos.
- `ZonaDeCarga`: mantiene la cola compartida utilizada por los repartidores.
- `VentanaPrincipal`: permite navegar por las funciones y ejecutar la simulación.
- `VentanaRegistroPedido`: valida y registra nuevos pedidos.
- `VentanaListaPedidos`: presenta la colección mediante `JTable` y `DefaultTableModel`.

## Tecnologías y conceptos aplicados

- Java y Java Swing.
- Programación orientada a objetos.
- Herencia, abstracción, polimorfismo y sobrecarga.
- Interfaces y encapsulamiento.
- Colecciones `List` y `BlockingQueue`.
- Hilos mediante `Runnable` y `ExecutorService`.
- Generación de identificadores con `AtomicInteger`.
- Validaciones y manejo de excepciones.

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que exista un JDK 8 o superior configurado.
3. Abrir la clase `Main`, ubicada en el paquete `main`.
4. Ejecutar el método `main()`.
5. Utilizar los botones de la ventana principal para registrar, listar, asignar e iniciar pedidos.
6. Revisar la interfaz gráfica y la consola para observar los resultados de la simulación.

## Persistencia

Los pedidos y sus cambios se conservan en memoria mientras el programa está abierto. Al cerrar la aplicación, la información se reinicia porque esta versión no utiliza archivos ni una base de datos.

## Autora

Nicole Ortega
