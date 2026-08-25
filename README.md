![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# Actividad Formativa – Semana 2
## Desarrollo Orientado a Objetos II

---

## Autor del proyecto

- **Nombre completo:** Juan Bonilla
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## Descripción general del sistema

**SpeedFast** es un prototipo de software orientado a objetos desarrollado en Java para una empresa de reparto a domicilio. En esta segunda semana el proyecto se estructura sobre una **clase abstracta** `Pedido`, que reúne los atributos y el comportamiento común a todos los tipos de pedido y obliga a cada subclase a definir el cálculo de su tiempo de entrega.

Cada tipo de pedido calcula su tiempo estimado de entrega con una lógica propia:

- **Comida** (restaurantes): 15 min base + 2 min por cada kilómetro.
- **Encomienda** (documentos o paquetes): 20 min base + 1.5 min por kilómetro (ajustado a entero).
- **Compras Express** (supermercado o farmacia): 10 min base; si la distancia supera los 5 km, se suman 5 min extra.

El objetivo de la actividad es aplicar **clases abstractas** y **herencia**, definiendo un método abstracto que se implementa de forma diferenciada en cada subclase.

---

## Estructura del proyecto

### Paquete `speedfast`

- **`Pedido`** *(clase abstracta)*
  - Atributos comunes: `idPedido`, `direccionEntrega`, `distanciaKm`.
  - Método implementado `mostrarResumen()`, que imprime los datos básicos del pedido.
  - Método abstracto `calcularTiempoEntrega()`, implementado por cada subclase.

- **`PedidoComida`** *(extiende Pedido)*
  - Implementa `calcularTiempoEntrega()`: 15 min + 2 min por km.

- **`PedidoEncomienda`** *(extiende Pedido)*
  - Implementa `calcularTiempoEntrega()`: 20 min + 1.5 min por km.

- **`PedidoExpress`** *(extiende Pedido)*
  - Implementa `calcularTiempoEntrega()`: 10 min base + 5 min si supera 5 km.

- **`Main`**
  - Clase de prueba del sistema.
  - Instancia un objeto de cada subclase y llama a `mostrarResumen()` y `calcularTiempoEntrega()`.

---

## Conceptos aplicados

- **Clase abstracta**: `Pedido` no se puede instanciar y define la estructura común.
- **Método abstracto**: `calcularTiempoEntrega()` obliga a cada subclase a dar su propia implementación.
- **Herencia y reutilización**: las subclases heredan `mostrarResumen()` de la clase base.
- **Polimorfismo**: un arreglo de tipo `Pedido` ejecuta el cálculo correcto de cada subclase en tiempo de ejecución.

---

## Instrucciones para clonar y ejecutar el proyecto

```bash
git clone https://github.com/JMDevx/OOD-2.git
cd OOD-2
git checkout S2
```

1. Abrir el proyecto en **IntelliJ IDEA**.
2. Verificar que la carpeta `src` esté configurada como *source root* y que el paquete `speedfast` se reconozca correctamente.
3. Ejecutar la clase `Main.java` del paquete `speedfast`.
4. Revisar la salida en la consola.

También se puede compilar y ejecutar desde la terminal:

```bash
javac -encoding UTF-8 -d out src/speedfast/*.java
java -cp out speedfast.Main
```

---

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Programación Orientada a Objetos
- Clases y métodos abstractos
- Herencia y polimorfismo
- Javadoc

---

## Fecha de entrega

23/08/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones
