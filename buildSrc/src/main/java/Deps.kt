/**
 * Describe：
 */
object Versions {
    const val compile_sdk = 32
    const val target_sdk = 32
    const val min_sdk = 26
    const val version_code = 1
    const val version_name = "1.0"

    const val core_ktx = "1.7.0"
    const val appcompat = "1.5.1"
    const val material = "1.6.1"
    const val constraint_layout = "2.1.4"
    const val junit = "4.13.2"
    const val ext_junit = "1.1.3"
    const val espresso_core = "3.4.0"

    const val arch_version = "2.3.1"
    const val extensions_version = "2.2.0"

    //hilt
    const val hilt_version = "2.42"

    const val life_version = "2.5.1"

    //retrofit
    const val retrofit = "2.9.0"

    //PermissionX
    const val permission_x = "1.7.1"

    //ARouter
    const val arouter = "1.5.2"
}

object Dependencies {
    const val kotlin_core = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val ext_junit = "androidx.test.ext:junit:${Versions.ext_junit}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    const val arch_lifecycle =
        "androidx.lifecycle:lifecycle-extensions:${Versions.extensions_version}"
    const val arch_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.arch_version}"
    const val arch_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.arch_version}"
    const val arch_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.arch_version}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_version}"

    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.life_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val permission_x = "com.guolindev.permissionx:permissionx:${Versions.permission_x}"

    const val arouter_api = "com.alibaba:arouter-api:${Versions.arouter}"
    const val arouter_compiler = "com.alibaba:arouter-compiler:${Versions.arouter}"
}