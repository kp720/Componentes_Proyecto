# Proyecto de componentes Visual y No Visual

Descripción
---
Desarrollo de 2 componentes (Visual y no Visual) para su aplicacion y reutilización dentro de la plataforma NeatBeans.

- Componente Visual **Menu Desplegable**:
   interfaz con un menu lateral que puede desplegar el JFrame principal y ocultarlo.

- Componente no Visual **Gestor de contactos**:
  clase principal que gestiona toda la logica del codigo, siendo el guardado y el cargado de los contactos (tanto en txt como en xlsx), filtros de busqueda por listas y metodos de eliminación.

Utilización y Aplicación
---
Desarrollo de una interfaz de agenda telefónica donde el componente visual administre las diferentes ventanas y el componente no visual administra los datos de la misma agenda.

API
---
**Clases auxiliares:**
- Contacto: su utilidad es manejar de forma mas eficiente los datos almacenandolos o manejandolos como **Objetos** siendo que estos pueden ser contactos sencillos (solo nombre, número, correo, dirección y bloqueado) o que puedan tener mas datos (segundo nombre/número/correo).
  
**Métodos principales**
- **numeroRepetido(String n):**
Método el cual verifica la duplicación de números entre la lista de contactos con el **String** recibido y devuelve un **boolean** si la acción fue hecha o no.

- **correoRepetido(String c):**
Método el cual verifica la duplicación de correos entre la lista de contactos con el **String** recibido y devuelve un **boolean** si la acción fue hecha o no.

- **eliminarNumero(String n):**
Método que busca y elimina de la lista actual el contacto relacionado con el **String** dado.

- **eliminarCorreo(String c):**
Método que busca y elimina de la lista actual el contacto relacionado con el **String** dado.

- **filtrarNombre/Correo/Numero(String x):**
Métodos que filtran de la lista actual los contactos cuya variable coincida con el **String** dado y al finalizar devualve una **List** con los elementos que coinciden.

- **filtrarBloqueos():**
Método que filtra de toda la lista de contactos aquellos contactos que se encuentren bloqueados actualmente y los devuelve.

- **guardarContactos()/cargarContactos():**
Métodos que manejan la administración de datos a travez de un archivo xlsx **(excel)** utilizando la librería adjunta de **Apache Poi**.

- **cargarContactos()/leerContactos():**
Métodos que manejan la administración de datos a travez de un archivo txt.

- **getRuta(String x):**
  Método por el cual se puede administrar una ruta personalizada de creación y administracin de los archivos.
