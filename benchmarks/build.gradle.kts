plugins {
    alias(libs.plugins.jmh)
}

dependencies {
    implementation(project(":core"))
    implementation(libs.jmh.core)
    annotationProcessor(libs.jmh.annprocess)
}

jmh {
    jmhVersion.set("1.37")
}
