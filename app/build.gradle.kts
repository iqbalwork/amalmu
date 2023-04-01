plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

android {
    compileSdk = 33
    namespace = "id.amalmu.app"
    defaultConfig {
        applicationId = "id.amalmu.app"
        minSdk = 24
        targetSdk =  33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            resValue("string", "app_name", "AmalMu: Amaliyah Murid")
        }
        getByName("debug") {
            applicationIdSuffix = ".dev"
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            resValue("string", "app_name", "AmalMu")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    /* Compose Library */
    implementation("androidx.compose.ui:ui:1.5.0-alpha01")
    implementation("androidx.compose.material:material:1.5.0-alpha01")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0-alpha01")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation("androidx.compose.material3:material3:1.1.0-beta01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0-alpha01")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0-alpha01")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.0-alpha01")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.3")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.5.3")

    // Jetpack Compose Integration
//    implementation "androidx.navigation:navigation-compose:$nav_version"

    /* ViewModel & Live Data */
//    def lifecycle_version = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    /* Hilt */
//    def hilt_version = "2.44.2"
    implementation("com.google.dagger:hilt-android:2.45")
    kapt("com.google.dagger:hilt-compiler:2.44.2")

    /* Networking */
//    def retrofit = "2.9.0" // retrofit
//    def okhttp = "4.9.3"
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

    /* Logger*/
//    def timber = "5.0.1"
//    def pretty_logger = "2.2.0"
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.orhanobut:logger:2.2.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}