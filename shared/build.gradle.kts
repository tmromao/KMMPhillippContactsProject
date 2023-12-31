plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.squareup.sqldelight")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

  /*  targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export("dev.icerock.moko:mvvm-core:0.16.1")
        }
    }*/

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            export("dev.icerock.moko:mvvm-core:0.16.1")
            //export("dev.icerock.moko:resources:0.23.0")
            //export("dev.icerock.moko:graphics:0.9.0")

        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation("org.jetbrains.kotlinx:atomicfu:0.21.0")
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                api("dev.icerock.moko:resources:0.23.0")

                api("dev.icerock.moko:mvvm-core:0.16.1")
                api("dev.icerock.moko:mvvm-compose:0.16.1")
                api("dev.icerock.moko:mvvm-flow:0.16.1")
                api("dev.icerock.moko:mvvm-flow-compose:0.16.1")

                implementation("com.squareup.sqldelight:runtime:1.5.5")
                implementation("com.squareup.sqldelight:coroutines-extensions:1.5.5")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core:1.10.1")
                implementation("com.squareup.sqldelight:android-driver:1.5.5")
                implementation("androidx.appcompat:appcompat:1.6.1")
                implementation("androidx.activity:activity-compose:1.7.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:1.5.5")
            }
            //dependsOn(commonMain) //make commonMain a dependency of iosMain
            //iosX64Main.dependsOn(this)
            //iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
      /*  val iosTest by creating {
            dependsOn(commonTest) //make commonTest a dependency of iosTest
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }*/
    }

}


android {
    namespace = "com.example.kmmphillippcontactsproject"
    compileSdk = 33
    defaultConfig {
        minSdk = 28
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    database("ContactDatabase") {
        packageName = "com.example.kmmphillippcontactsproject"
        sourceFolders = listOf("sqldelight")
    }
}




multiplatformResources {
    multiplatformResourcesPackage = "com.example.kmmphillippcontactsproject"
    multiplatformResourcesClassName = "SharedRes"
}