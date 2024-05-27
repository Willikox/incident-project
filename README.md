# Incident Management System

Este proyecto es un sistema de gestión de incidentes que incluye un backend desarrollado con Spring Boot, un frontend desarrollado con Next.js 14 en conjunto con AppRouter, TypeScript, CSS(Tailwind, PrimeReact) y una base de datos PostgreSQL. También incluye una colección de Postman para la validación de los endpoints.

## Estructura del Proyecto

incident-management/
│
├── backend/
│ └── ... (archivos del proyecto de Spring Boot)
│
├── frontend/
│ └── ... (archivos del proyecto de React)
│
├── database/
│ └── your_backup_name.backup (respaldo de la base de datos)
│
└── postman/
└── Incident_Management_API.postman_collection.json (colección de Postman)


## Prerrequisitos

- [Java 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/)
- [Node.js](https://nodejs.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Postman](https://www.postman.com/)

## Despliegue del Backend

1. **Clonar el Repositorio**:

   ```bash
     git clone git@github.com:Willikox/incident-project.git.
   cd incident-project/backend

Configurar la Base de Datos:

Asegúrate de que PostgreSQL esté corriendo.
Crea una base de datos llamada incident_db.
Restaura el archivo de respaldo ubicado en database/backup.sql que incuso esta en el repositorio.

##Datos creados previamente en la base de datos para partir de un tiempo determinado, la fecha se guardara automaticamente, incluido la hora.
INSERT INTO incident(description, created_at, status, observation)
VALUES('Incidente 1', '2024-05-21T10:00:00', 'Pendiente', ''),
	  ('Incidente 2', '2024-05-21T12:00:00', 'Pendiente', ''),
      ('Incidente 3', '2024-05-21T15:00:00', 'Atendida', 'Resolución Correcta');

INSERT INTO incident(description, created_at, status, observation)
VALUES('Incidente 4', '2024-05-21T10:00:00', '', '');

	SELECT * FROM incident;


 pg_restore -U incident_db -d incident_db -1 ../database/backup

##Configuración en spring
spring.datasource.url=jdbc:postgresql://localhost:5432/incident_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update

#Copila y ejecuta dentro del archivo IncidentsApplication.java y ejecuta como Java Application

##Despliegue del Frontend

Instalar Dependencias:

cd ../frontend
npm install


Configurar Variables de Entorno:

Crea un archivo .env.local en el directorio frontend con la URL del backend.

/// <reference types="next" />
/// <reference types="next/image-types/global" />
/// <reference types="next/navigation-types/compat/navigation" />


