@file:Suppress("SpellCheckingInspection")

group "cl.uchile.dcc"
version "1.0-SNAPSHOT"

val javaFXVersion: String by project
val jbAnnotationsVersion: String by project
val junitVersion: String by project
val commonsLangVersion: String by project

plugins {
    java
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("jacoco")
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
}

application {
    mainClass.set("cl.uchile.dcc.scrabble.gui.Scrabble")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(
        group = "org.openjfx",
        name = "javafx",
        version = javaFXVersion,
        ext = "pom"
    )
    implementation(
        group = "org.jetbrains",
        name = "annotations",
        version = jbAnnotationsVersion
    )
    implementation(
        group = "org.apache.commons",
        name = "commons-lang3",
        version = commonsLangVersion
    )
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

javafx {
    version = javaFXVersion
    modules = mutableListOf("javafx.controls")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}