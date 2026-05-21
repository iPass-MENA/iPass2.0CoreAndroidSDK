plugins {
    `maven-publish`
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
//    alias(libs.plugins.androidLibrary)
//    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.iPass.core"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            ndk.debugSymbolLevel = "FULL"
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
//    implementation ("com.regula.documentreader.core:fullauthrfid:7.5.12087@aar")
//    implementation ("com.regula.documentreader.core:fullauthrfid:7.5.12253@aar")
//    implementation("com.regula.documentreader.core:fullauthrfid:8.2.14191@aar")
//      implementation("com.regula.documentreader.core:fullauthrfid:8.3.14528@aar")
    implementation("com.regula.documentreader.core:fullauthrfid:9.3.15695")
}

project.afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.core.iPass2.0"
                artifactId = "Core"
                version = "2.22"
            }
        }
    }
}