plugins {
    alias(libs.plugins.spring.boot)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    testImplementation(platform(libs.spring.boot.bom))
    implementation(project(":core"))
    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.data.jpa)
    runtimeOnly(libs.h2)
    testImplementation(libs.spring.boot.test)
}
