# Backend - Gestión de Personajes

Este es el backend de la aplicación de gestión de personajes, desarrollado con Java y Spring Boot.

## Tecnologías Utilizadas
- Java 17
- Spring Boot
- Hibernate / JPA
- MySQL
- Maven
- Spring Boot starter cache

## Estructura del Proyecto
```
/backend
  ├── src/main/java/com/pb/personajes_backend
  │     ├── config
  │     ├── controller
  │     ├── dto
  │     ├── exception
  │     ├── mapper
  │     ├── model
  │     ├── repository
  │     ├── service
  ├── src/main/resources
  │     ├── application.properties
  ├── pom.xml
```

## Instalación y Configuración
### Prerrequisitos
1. Tener instalado Java 17, MySQL y Maven.
2. Crear la base de datos en MySQL:
   ```sql
   CREATE DATABASE personajes_db;
   ```
3. Configurar `application.properties` con los datos de conexión a MySQL.

### Instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/AlejandroG095/personajes-backend.git
   ```
2. Ir al directorio del backend:
   ```bash
   cd backend
   ```
3. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints Principales
| Método | Endpoint             | Descripción                   |
|--------|----------------------|-------------------------------|
| GET | /api/characters      | Obtener todos los personajes  |
| GET | /api/characters/{id} | Obtener un personaje por ID   |
| POST | /api/characters      | Crear un personaje            |
| POST | /api/files/upload    | Cargar un archivo al servidor |
| PUT | /api/characters/{id} | Actualizar un personaje       |
| DELETE | /api/characters/{id} | Eliminar un personaje         |



## Mejoras Futuras
- Implementación de autenticación con JWT.
- Integración con un servicio de almacenamiento de imágenes.
- Optimización del rendimiento mediante paginación y caché.
