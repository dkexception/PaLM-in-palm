private object Version {

    // Core & Kotlin
    const val core = "1.10.1"
    const val kotlinBom = "1.8.22"
    const val appCompat = "1.6.1"
    const val activityCompose = "1.7.2"

    // Compose BOM
    const val composeBom = "2023.01.00"

    // Navigation
    const val navigation = "2.6.0"

    // Coroutines
    const val kotlinCoroutine = "1.6.4"

    // Lifecycle
    const val lifecycle = "2.5.1"
    const val lifecycleCompose = "2.6.1"

    // LiveData
    const val liveData = "2.6.1"

    // Rx*
    const val rxJava = "2.2.21"
    const val rxAndroid = "2.1.1"

    // Retrofit
    const val retrofit = "2.9.0"
    const val gson = "2.10.1"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "5.0.0-alpha.3"

    // Hilt
    const val hilt = "2.44"
    const val hiltComposeNav = "1.0.0"

    // Firebase
    const val firebaseCore = "17.4.3"
    const val firebaseMessaging = "20.2.4"

    // Biometric
    const val biometric = "1.1.0"

    // Testing
    const val testRunner = "1.5.2"
    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.5"
    const val androidTestEspresso = "3.5.1"
    const val mockito = "3.9.0"
    const val mockitoKotlin = "2.0.0"
    const val mockitoInline = "2.25.0"
}

object Core {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:${Version.kotlinBom}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val activityCompose = "androidx.activity:activity-compose:${Version.activityCompose}"
}

object ComposeBOM {
    const val composeBom = "androidx.compose:compose-bom:${Version.composeBom}"
    const val composeUI = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composeM3 = "androidx.compose.material3:material3"
    const val composeIcons = "androidx.compose.material:material-icons-extended"

    //    const val composeM2 = "androidx.compose.material:material"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composePreviewDebug = "androidx.compose.ui:ui-tooling"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata"
}

object Navigation {
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navUI = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val navCompose = "androidx.navigation:navigation-compose:${Version.navigation}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutine}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutine}"
}

object Lifecycle {
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycleCompose}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
}

object LiveData {
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.liveData}"
}

object Rx {
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gson = "com.google.code.gson:gson:${Version.gson}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Version.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val hiltComposeNavigation =
        "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNav}"
}

object Firebase {
    const val firebaseMessaging =
        "com.google.firebase:firebase-messaging:${Version.firebaseMessaging}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Version.firebaseCore}"
}

object Biometric {
    const val biometric = "androidx.biometric:biometric:${Version.biometric}"
}

object TestImplementation {
    const val junit = "junit:junit:${Version.testImplJunit}"
    const val kotlinxCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.kotlinCoroutine}"
    const val mockito = "org.mockito:mockito-core:${Version.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
}

object AndroidTestImplementation {
    const val junit = "androidx.test.ext:junit:${Version.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.androidTestEspresso}"
}
