# Student Enrollment System

A professional, production-ready university course registration dashboard built with **Spring Boot** and fully containerized using **Docker** and **Docker Compose**. This documentation serves as a comprehensive onboarding manual, allowing any new developer to cleanly build, run, and verify the entire standalone project environment locally within minutes.

## 🛠️ Tech Stack
- **Backend:** Java 21, Spring Boot, Spring Data JPA
- **Database:** MySQL 8.0 (Persistent via Docker Volumes)
- **Frontend:** HTML5, CSS3, JavaScript (Fetch API), Bootstrap 5, FontAwesome
- **Orchestration:** Docker, Docker Compose (Multi-stage Build Optimized)
- **Automation Tools:** GNU Makefile, GitHub Actions (CI Workflow integrated)

---

## 📋 Prerequisites for New Developers
To run this project locally, a new developer **does NOT need to install Java, Maven, or MySQL** on their workstation machine. The application stack is entirely self-contained. The only core requirements are:
1. **Git** (installed on your system).
2. **Docker Desktop** (installed and running).

---

## ⚙️ Configuration Notes (Ports & Environment Values)
The system is configured to execute using automated workspace network parameters isolated inside the internal Docker bridge:
- **Application Web Port:** Exposed locally on port `8082` (`http://localhost:8082/`).
- **Database Port:** MySQL internal engine maps locally to port `3306` inside the environment containers.
- **Environment Properties:** Active credentials, datasource URLs, and Hibernate schema generation modes are fully automated via the `docker-compose.yml` manifest to guarantee instant multi-service connectivity.

---

## 🚀 How to Build and Run Using Docker (Step-by-Step)

Follow these explicit commands to fetch, compile, and deploy the application ecosystem:

### Option A: Using Standard Docker Compose Commands
```bash
# 1. Clone the repository framework
git clone https://github.com
cd StudentEnrollment-Core-Service

# 2. Build images and spin up live container orchestration
docker-compose up --build
```

### Option B: Using Shortcut Commands (Bonus Makefile Integration)
If your terminal workspace supports GNU Make utilities, you can spin up the environment using a one-word execution shortcut:
```bash
make run
```
*Note: Wait a minute until the build logs freeze and display: `Tomcat started on port 8082`, confirming your reproducible web runtime environment is live.*

---

## 🌐 How to Test the Project (UI & Endpoint Verification)

Once the containers are running successfully, any reviewer or developer can fully verify the system functionalities by executing the following functional checklist:

1. Open your internet web browser and navigate to the local interface dashboard:
   👉 **[http://localhost:8082/](http://localhost:8082/)**
2. **Test the "Add" Feature:** Go to the left sidebar menu inputs. Enter a mock Student ID (e.g., `1202211`), a numerical Course ID (e.g., `1001`), pick a registration date from the calendar dashboard, and click the **Add** button.
3. **Verify Persistence Validation:** A temporary popup alert confirming successful database storage will trigger, and the new row will immediately render inside the live responsive HTML data grid on the right side.
4. **Test "Update" & "Delete":** Highlight any active row inside the data table grid. The existing parameters will load back up inside the sidebar form for rapid field modifications or deletion triggers using the **Update** or **Delete** action control elements.

---

## 🛑 How to Stop the Container and Clean Up (Basic)

To safely close down execution states and manage memory resources, deploy the corresponding commands inside your project root directory:

### Standard Graceful Shutdown
Stops container boundaries safely while fully retaining saved user logs and tables data inside the local physical Docker volumes layer:
```bash
docker-compose down
# Or using Makefile shortcut:
make stop
```

### Deep Environment Reset
Wipes active containers, teardowns the backend virtual network configurations, and completely removes persistent data storage caches to reset the environment state:
```bash
docker-compose down -v
# Or using Makefile shortcut:
make clean
```

---

## 📜 Attribution & License
- **Project Provenance:** This software application framework was developed independently from scratch as a unique university project codebase assignment.
- **Attribution:** The frontend view presentation layer embeds baseline layout styling components and native grid structures from the open-source **Bootstrap v5.3.2** responsive layout frameworks.
