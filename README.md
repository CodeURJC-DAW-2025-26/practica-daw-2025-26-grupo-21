# La Phonoteka


## Integrantes

| Nombre | Apellidos | Correo | GitHub
| ------ | --------- | ------ | -------
| Adrián | Morales | a.morales.2019@alumnos.urjc.es | Adri-md-1208

# Preparación 1: Definición del proyecto

## Descripción general del proyecto
La Phonoteka es una plataforma online dedicada a la compra y venta de vinilos. Permite a los usuarios registrarse, publicar vinilos en venta, realizar compras y valorar a otros usuarios.

## Entidades

### Usuario
Representa una persona registrada en la plataforma.

### Vinilo
Representa un objeto que se puede comprar/vender en la plataforma.

### Compra/Venta
Representa una acción de compra o venta de una entidad Vinilo.

### Mensaje
Representa un mensaje privado de un Usuario hacia otro Usuario.

### Valoración
Representa una valoración que realiza un Usuario acerca de otro Usuario tras realizar una Compra/Venta entre ellos.

La relación se tiene porque un Usuario realiza Compra/Venta de un Vinilo y puede recibir/dar una Valoración. Los Usuarios pueden escribirse mensajes entre ellos.

![ER Diagram](assets/diagrams/ERD.svg)

## Permisos de los usuarios
Claro, aquí tienes la información en una tabla Markdown.

| Funcionalidad | Anónimo | Registrado | Administrador | Descripción |
| :--- | :---: | :---: | :---: | :--- |
| **Visualizar vinilos** | Sí | Sí | Sí | Todos pueden ver los vinilos disponibles. |
| **Buscar vinilos** | Sí | Sí | Sí | Búsqueda por artista, título, género, etc. |
| **Ver detalles de vinilo** | Sí | Sí | Sí | Acceso a la información completa de un vinilo. |
| **Registrarse** | Sí | No | No | Solo usuarios anónimos pueden registrarse. |
| **Iniciar sesión** | Sí | No | No | Solo usuarios anónimos pueden iniciar sesión. |
| **Cerrar sesión** | No | Sí | Sí | |
| **Publicar vinilo en venta** | No | Sí | Sí | Un usuario registrado puede poner sus vinilos a la venta. |
| **Editar/Eliminar vinilo propio** | No | Sí | Sí | Solo el propietario del vinilo o un administrador pueden editarlo/eliminarlo. |
| **Comprar un vinilo** | No | Sí | Sí | Los usuarios registrados pueden realizar compras. |
| **Ver historial de compras/ventas** | No | Sí | Sí | Cada usuario ve su propio historial. |
| **Enviar mensaje a otro usuario** | No | Sí | Sí | Comunicación entre usuarios. |
| **Ver/responder mensajes** | No | Sí | Sí | Acceso a la bandeja de entrada/salida. |
| **Dejar una valoración** | No | Sí | Sí | Valorar transacciones o a otros usuarios. |
| **Modificar perfil propio** | No | Sí | Sí | Cambiar datos personales, avatar, etc. |
| **Gestionar todos los vinilos** | No | No | Sí | CRUD completo sobre todos los vinilos de la plataforma. |
| **Gestionar todos los usuarios** | No | No | Sí | CRUD completo sobre todos los usuarios de la plataforma. |
| **Ver estadísticas de la plataforma** | No | No | Sí | Acceso a los gráficos y métricas del sistema. |

## Imágenes

La aplicación contiene varios tipos de imágenes:

- **Foto de perfil**: foto opcional que se podrá subir al crear el perfil o al modificarlo. 1 usuario tiene 0 o 1 fotos.
- **Foto de vinilo**: foto obligatoria del vinilo que el usuario va a vender. 1 Vinilo tiene 1 foto.

## Gráficos

La aplicación ofrecerá gráficos a los administradores para que tengan una visión general del estado de la plataforma:

- **Ventas a lo largo del tiempo** (gráfico de líneas)
- **Nuevos registros de usuarios** (gráfico de líneas)
- **Distribución de vinilos en base a sus atributos** (gráfico de tarta)
- **Usuarios más vendedores y más compradores** (gráfico de ranking)

## Tecnología complementaria
Envío automático de mails para avisar a los usuarios cuando ha sido vendido su vinilo o cuando han recibido un comentario.


## Algoritmo o consulta avanzada
Búsqueda avanzada con filtros por atributos de los vinilos o por valoraciones de los usuarios.
