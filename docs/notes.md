# Technical Notes & Assignment Reflections

## 🐳 The Biggest Docker Problem Faced & Solution
- **The Problem:** During initial containerization phases, the Hibernate entity layer in Spring Boot threw a `java.sql.SQLSyntaxErrorException: Unknown column 'e1_0.enrollment_id'` error. This happened because Hibernate was mapping CamelCase variables to snake_case column parameters (`enrollment_id`), causing queries to crash on existing MySQL structures utilizing native `enrollmentId` identifiers.
- **The Solution:** I enforced strict naming strategies within the `application.properties` layer by deploying `PhysicalNamingStrategyStandardImpl`. Additionally, I designed a multi-stage Docker build utilizing `maven:3.9.6-eclipse-temurin-21` and `eclipse-temurin:21-jre-alpine` targets. This not only isolated compilation steps from development dependencies but drastically shrank runtime boundaries to ensure reproducible runtime environments.

## 🐙 The Most Important Git/GitHub Lesson Learned
- **The Lesson:** I discovered that maintainable microservice management starts with a clean setup strategy. Properly managing `.gitignore` and `.dockerignore` files before running commands blocks deployment bloat (such as massive compiled `/target` binaries or ide internal cache trees) from poluting repository branches. Keeping commit messages organized via semantic prefixes (like `feat:`, `chore:`, `docker:`) establishes an audit trail that guarantees team members can spin up codebases efficiently.
