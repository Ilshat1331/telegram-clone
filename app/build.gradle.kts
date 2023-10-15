plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.telegram"
    compileSdk = 34
    viewBinding.enable = true

    defaultConfig {
        applicationId = "com.example.telegram"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0-beta01")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Drawer
    implementation("com.mikepenz:materialdrawer:9.0.1")
    //required support lib modules
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("androidx.annotation:annotation:1.7.0")
    implementation ("com.google.android.material:material:1.11.0-alpha03") // requires at least 1.5.0-x
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    // Add for NavController support
    implementation ("com.mikepenz:materialdrawer-nav:9.0.1")
    // Add for Android-Iconics support
    implementation ("com.mikepenz:materialdrawer-iconics:9.0.1")
}