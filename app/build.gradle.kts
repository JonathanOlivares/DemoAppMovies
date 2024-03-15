plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Safe args
    id("androidx.navigation.safeargs.kotlin")
    //kapt
    id("kotlin-kapt")
    //Parcelize
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.demoappmovies"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demoappmovies"
        minSdk = 24
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

    buildFeatures{
        viewBinding = true
    }


}

dependencies {

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Concat Adapter
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("androidx.cardview:cardview:1.0.0")

    //ViewModel and LiveData KTX

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
    implementation("android.arch.lifecycle:extensions:1.1.1")
    kapt("android.arch.lifecycle:compiler:1.1.1")

    // Navigation Component

    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.2")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.2")

    // Retrofit

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Utils
    implementation("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.11.0")

    //Room
    implementation("androidx.room:room-runtime:2.2.6")
    implementation("androidx.room:room-ktx:2.2.6")
    annotationProcessor ("androidx.room:room-compiler:2.2.6")
    kapt("androidx.room:room-compiler:2.2.6")


}