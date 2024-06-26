# Spring Batch Project

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.1-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## Overview
This project demonstrates how to use Spring Batch to upload a CSV file and save a list of students to a PostgreSQL database. It uses Java 17, Spring Data JPA, and PostgreSQL.

<img src="https://miro.medium.com/v2/resize:fit:1400/1*bYPPzvrVk4Y91ZTEp1TPUQ.png"/>

## Features
- Upload CSV file containing student information
- Validate and process CSV data using Spring Batch
- Persist student data to PostgreSQL using Spring Data JPA
- RESTful endpoints for file upload

## Prerequisites
- Java 17
- Maven 3.6+
- PostgreSQL 16

## Project Structure
The project is divided into two subprojects:

1. **savedfile**:
   - This subproject uses Spring Batch to save data by processing a CSV file located in the `resources` folder of the project.

2. **using-api**:
   - This subproject allows you to import a CSV file via an HTTP POST request to `http://localhost:8080/students` by passing the file in the body of the request.

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/achaari551994/Spring-Batch.git
cd Spring-Batch
