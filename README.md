# Student Course Enrollment — Full‑Stack (Spring Boot + HTML/CSS/JS)

A full‑stack application to manage **courses** and **student enrollments**. The backend is built with Spring Boot and MySQL; the frontend is a lightweight static site (plain **HTML/CSS/JS**) that calls the REST APIs.


---

##  Table of Contents
- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Repository Structure](#repository-structure)
- [Backend](#backend)
  - [Configuration](#configuration)
  - [Run the Backend](#run-the-backend)
  - [REST API](#rest-api)
- [Frontend](#frontend)
  - [Run the Frontend](#run-the-frontend)
- [Author](#author)

---

## Overview
This project exposes RESTful APIs to:
- Create and list **enrollments**
- Create, retrieve, update, and delete **courses**

The frontend consumes these APIs to render course lists, submit new enrollments, and display enrollments in a table.

---

## Tech Stack
**Backend**
- Java **21**
- Spring Boot **4.0.1** (Spring Web MVC, Spring Data JPA)
- MySQL (JDBC + Hibernate)
- Maven

**Frontend**
- Plain **HTML/CSS/JavaScript** (no framework)

---

## Repository Structure
```
student-course-enrollment/
├─ backend/
│  ├─ pom.xml
│  ├─ src/main/java/com/student_course_enrollment/backend
│  │  ├─ controller/
│  │  │  ├─ CourseController.java
│  │  │  └─ EnrollmentController.java
│  │  ├─ model/
│  │  │  ├─ Courses.java
│  │  │  ├─ Enrollments.java
│  │  │  └─ EnrollmentStatus.java
│  │  ├─ repository/
│  │  │  ├─ CourseRepository.java
│  │  │  └─ EnrollmentRepository.java
│  │  └─ service/ (not shown here but present in project)
│  └─ src/main/resources/application.properties
│
├─ frontend/
│  ├─ index.html          # Courses list
│  ├─ enroll.html         # Create enrollment form
│  ├─ enrollments.html    # Enrollment table
│  ├─ styles.css          # Apply styles to the pages
│  └─ app.js              # Fetch logic and DOM updates
```


---

## Backend

### Configuration
**`pom.xml` highlights**
- Spring Boot parent: `org.springframework.boot:spring-boot-starter-parent:4.0.1`
- Java: `21`
- Starters: `spring-boot-starter-webmvc`, `spring-boot-starter-data-jpa`
- Runtime: `mysql-connector-j`

**`src/main/resources/application.properties` (current default: MySQL)**
```properties
spring.application.name=student-course-enrollment
spring.datasource.url=jdbc:mysql://localhost:3306/<db_name>
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update

```


### Run the Backend
```bash
mvn clean spring-boot:run
```
App will start at **http://localhost:8080**


### REST API
**Enrollments** (`/enrollments`)
- `GET /enrollments` → List all enrollments → `List<EnrollmentResponseDTO>`
- `POST /enrollments` → Create enrollment → `EnrollmentResponseDTO`

**Courses** (`/courses`)
- `GET /courses` → List all courses → `List<Courses>`
- `POST /courses` → Create a course → `Courses`
- `PUT /courses/{id}` → Update → `Courses`
- `DELETE /courses/{id}` → Delete → `"Course deleted successfully"`

---

## Frontend
The frontend is a static site (no framework) that uses `fetch` to call the backend.

Files:
- `index.html` — Lists courses using `GET /courses`
- `enroll.html` — Populates course dropdown and posts to `POST /enrollments`
- `enrollments.html` — Displays table from `GET /enrollments`
- `app.js` — Contains `BASE_URL` and functions: `loadCourses()`, `loadEnrollments()`, `addEnrollment()`
- `styles.css` — Optional; not required to run

### Run the Frontend

**VS Code Live Server**
- Open the folder in VS Code → Right‑click `index.html` → **Open with Live Server**

Frontend will start at **http://localhost:5500**

---

## Author
**Anjana K**  

- GitHub: Anjana-K-Trumio
