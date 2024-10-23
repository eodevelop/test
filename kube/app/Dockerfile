# 1. OpenJDK 베이스 이미지 사용
FROM openjdk:17

# 2. 빌드된 JAR 파일을 복사 (Gradle로 빌드된 파일을 정확한 경로에서 복사)
COPY build/libs/app-0.0.1-SNAPSHOT.jar app.jar

# 3. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]