# Sistemas de Estudiantes App.
### Aplicación de Sistema de Estudiantes con MySQL y MAVEN.
#### La aplicación de sistema de estudiantes, en la cual vamos a poder listar varios estudiantes, vamos a poder buscar un estudiante y proporcionando un identificador, un ID.
#### Posteriormente podemos agregar, modificar o finalmente eliminar también un estudiante.
#### Toda esta información se va a guardar en una base de datos.
#### Vamos a utilizar la base de datos entonces las operaciones conocidas como
#### CRUD, Create, Read, Update y Delete, que son las operaciones básicas para trabajar con una tabla de base de datos.
### Nuestro sistema va a tener las siguientes clases:
####   La clase de dominio.
####   La clase de estudiante contiene los siguientes campos id estudiante el nombre, el apellido, el teléfono y el email.
####   Por otro lado, tenemos nuestra capa de datos donde vamos a tener una clase que se llama Estudiante, aplicando el patrón de diseño DAO (Data access Object).
#### Y básicamente este patrón se utiliza para poder interactuar con una tabla de base de datos.
#### Así que vamos a tener los métodos de buscar estudiante por ID y listar estudiantes a agregar un estudiante, modificarlo o eliminar un estudiante.
#### Todo esto relacionado con la tabla de estudiante que ya hemos definido anteriormente.
#### Finalmente tenemos nuestra capa de presentación, que es la aplicación de consola que hemos visto anteriormente.
