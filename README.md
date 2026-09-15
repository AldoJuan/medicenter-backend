# Medicenter — Sistema de Gestión Clínica

Backend desarrollado como parte de la evaluación técnica para el cargo de **Desarrollador Backend** en **LVL Consulting S.A.C.**

> Repositorio: [github.com/AldoJuan/medicenter-backend](https://github.com/AldoJuan/medicenter-backend)

## 1. Descripción del proyecto

Medicenter es el backend de un software clínico que cubre el ciclo completo de atención a un paciente: desde su registro y la reserva de una cita, pasando por el triaje y la atención médica, hasta la facturación y el cobro. El alcance funcional se definió en 7 módulos:

- **Admisión** — administración de pacientes (registro universal, credenciales de acceso).
- **Citas** — programación, reserva (con pago o adelanto) y activación.
- **Triaje** — registro ágil e historial.
- **Historia Clínica** — atenciones, recetas, y alertas.
- **Facturación** — comprobantes (boleta/factura/nota de venta), venta a crédito, cuotas y cobranza.
- **Usuarios** — administración de cuentas según roles.
- **Reportes y Estadísticas** — indicadores de gestión para la alta dirección.

## 2. Stack técnico

| Componente | Tecnología |
|---|---|
| Lenguaje | Java 25 |
| Framework | Spring Boot 4 |
| Persistencia | Spring Data JPA / Hibernate |
| Base de datos | SQL Server |
| Seguridad de credenciales | BCrypt (Spring Security Crypto) |
| Mapeo de datos | Lombok (`@Data`) |
| Build | Maven |

## 3. Arquitectura y patrón de capas

El proyecto sigue un patrón de 4 capas por cada entidad de negocio:

```
Controller  →  Facade  →  Service  →  Repository  →  Domain (Entity)
```

- **Domain**: entidad JPA, mapea 1:1 a la tabla física (`@Entity`, `@Table`, `@Column`).
- **Repository**: interfaz `JpaRepository`, acceso a datos y queries derivadas.
- **Service**: reglas de negocio (validaciones, valores por defecto controlados por el sistema, transacciones con `@Transactional`).
- **Facade**: traduce entre DTOs (lo que ve el cliente de la API) y entidades de dominio (lo que se persiste). Es la única capa que conoce ambos mundos.
- **Controller**: expone los endpoints REST, delega todo al Facade.

Los **DTOs** están separados en `Request` (lo que puede entrar) y `Response` (lo que puede salir), para no filtrar datos sensibles (ej. `passwordHash` nunca sale en un Response) ni permitir que el cliente manipule datos que debe controlar el sistema (ej. `estado`, `fechaCreacion`, `fechaEmision`).

## 4. Modelo de datos — decisiones clave

- **Usuario es la entidad central de identidad.** Tanto `Paciente` como `Medico` referencian a `Usuario` por `usuarioId` en vez de duplicar nombre, documento, email y credenciales — evita inconsistencias entre registros.
- **Los permisos de sistema (`RolUsuario`) están separados de los datos de negocio (`Medico`, `Paciente`).** Un usuario puede tener el rol "MEDICO" (acceso) sin que eso implique automáticamente que exista su fila en `MC_MEDICO` (datos clínicos) — son conceptos distintos: uno es seguridad, el otro es dominio.
- **Cita se reserva y se activa en dos pasos distintos**, reflejando la regla de negocio "reserva de cita previo pago o adelanto": `POST /citas` reserva, `PATCH /citas/{id}/activar` confirma con el adelanto.
- **Un pago no se elimina** una vez registrado — no hay `DELETE /pagos`, para no alterar el historial de cobranza.

## 5. Módulos de negocio implementados (16 entidades)

Usuario, Rol, RolUsuario, Especialidad, Medicamento, Medico, Paciente, HorarioMedico, Cita, Triaje, AtencionMedica, RecetaDetalle, Factura, FacturaDetalle, Cuota, Pago.

## 6. Cómo ejecutar el proyecto

### Requisitos previos
- JDK 25
- SQL Server (local o remoto)
- Maven

### Pasos

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/AldoJuan/medicenter-backend.git
   ```
2. Ejecutar el script de base de datos física (`Medicenter_Fisico.sql`, generado desde el modelo ER en ER/Studio) contra tu instancia de SQL Server. Esto crea la base `MedicenterDB` con las 16 tablas y sus relaciones.
3. Configurar `src/main/resources/application.yml` con tus credenciales de conexión:
   ```yaml
   spring:
     datasource:
       url: jdbc:sqlserver://<TU_SERVIDOR>:1433;databaseName=MedicenterDB;encrypt=true;trustServerCertificate=true
       username: <TU_USUARIO>
       password: <TU_PASSWORD>
   ```
4. Ejecutar la aplicación (desde IntelliJ o `mvn spring-boot:run`). Hibernate validará (`ddl-auto: validate`) que las entidades coincidan con las tablas creadas en el paso 2.

## 7. Documentación adicional

- Diagrama de contexto del proyecto: `docs/diagrama-contexto.png`
- Resumen y sustento del planteamiento de la solución: `docs/sustento-tecnico.md`
- Modelo ER: `docs/er-medicenter.png`
- Script de base de datos física: `Medicenter_Fisico.sql`

## 8. Autor

Aldo — evaluación técnica para Desarrollador Backend, LVL Consulting S.A.C.
