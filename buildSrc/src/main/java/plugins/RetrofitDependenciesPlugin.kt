import org.gradle.api.Plugin
import org.gradle.api.Project

class RetrofitDependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.apply {
            add("implementation", Retrofit.retrofit)
            add("implementation", Retrofit.gsonConvertor)
            add("implementation", Retrofit.okHttp)
            add("implementation", Retrofit.okHttpInterceptor)
        }
    }
}
