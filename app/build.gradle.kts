plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)

}

android {
    namespace = "com.example.foodordering"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.foodordering"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation("com.google.firebase:firebase-analytics")
    //Custom progress bar
    implementation ("com.github.ybq:Android-SpinKit:1.4.0")
    // Add the Firebase SDK for Google Analytics
    implementation ("com.google.firebase:firebase-analytics:17.2.2")
    // Add the Firebase SDK for Firebase Realtime Database
    implementation ("com.google.firebase:firebase-database:19.2.0")
    // Add the Firebase Authentication SDK
    implementation ("com.google.firebase:firebase-auth:19.2.0")


}