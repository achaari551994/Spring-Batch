# Spring Batch CSV Upload Project

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.0-brightgreen.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## Overview
This project demonstrates how to use Spring Batch to upload a CSV file and save a list of students to a PostgreSQL database. It uses Java 17, Spring Data JPA, and PostgreSQL.

![Screenshot](images/screenshot.png)

## Features
- Upload CSV file containing student information
- Validate and process CSV data using Spring Batch
- Persist student data to PostgreSQL using Spring Data JPA
- RESTful endpoints for file upload

## Prerequisites
- Java 17
- Maven 3.6+
- PostgreSQL 16
- Docker (optional, for containerized PostgreSQL)

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/yourusername/spring-batch-csv-upload.git
cd spring-batch-csv-upload
