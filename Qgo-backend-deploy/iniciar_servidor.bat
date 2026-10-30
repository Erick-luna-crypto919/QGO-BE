@echo off
title Qgo Spring Boot Backend
set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.3.9-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo ========================================================
echo       INICIANDO SERVIDOR BACKEND QGO (SPRING BOOT)
echo ========================================================
echo Java: JDK 21 Eclipse Adoptium
echo Puerto: http://localhost:8080
echo API Health: http://localhost:8080/api/prueba
echo ========================================================
echo.
call .\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=h2
pause
