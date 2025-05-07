plugins {
	id("java")
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.BarbirMS"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.postgresql:postgresql:42.7.2")
	implementation(platform("org.hibernate.orm:hibernate-platform:6.6.11.Final"))
	implementation("jakarta.transaction:jakarta.transaction-api")
	implementation("org.hibernate.orm:hibernate-core")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.test {
	useJUnitPlatform()
}
