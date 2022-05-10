
plugins {
    `java-library`
    id("ca.cutterslade.analyze") version "1.9.0"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    compileOnly("com.squareup.okhttp3:okhttp")
    api("org.jetbrains.kotlin:kotlin-stdlib")
}
