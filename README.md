# Foro API REST

API REST desarrollada en **Java** con **Spring Boot** para gestionar un foro donde los usuarios pueden crear tópicos y responderlos. La autenticación se realiza mediante **JWT (JSON Web Tokens)**.

---

## Funcionalidades

- Registro de usuarios (simulado para pruebas).
- Login con generación de token JWT.
- Crear, listar, actualizar y eliminar tópicos (requiere autenticación).
- Seguridad con JWT y filtro de autorización.
- Manejo de errores con códigos HTTP adecuados (401, 403, 201, 200, etc.).

---

## Tecnologías

- Java 17
- Spring Boot
- Spring Security
- JWT (io.jsonwebtoken)
- Maven
- Base de datos (puede ser H2, MySQL, PostgreSQL, según configuración)

---

## Endpoints principales

| Método | URL                   | Descripción                          | Autenticación |
|--------|----------------------|--------------------------------------|---------------|
| POST   | `/login`             | Generar token JWT                     | No            |
| GET    | `/api/topicos`       | Listar todos los tópicos              | Sí            |
| POST   | `/api/topicos`       | Crear un nuevo tópico                 | Sí            |
| PUT    | `/api/topicos/{id}`  | Actualizar un tópico                  | Sí            |
| DELETE | `/api/topicos/{id}`  | Eliminar un tópico                    | Sí            |

---

## Cómo usar

1. **Clonar el repositorio**
```bash
git clone https://github.com/rafriky45/api-rest.git
cd api-rest
