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
    warmupIterations.set(3)
    iterations.set(5)
    fork.set(2)
    timeOnIteration.set("500ms")
    warmup.set("500ms")
}
