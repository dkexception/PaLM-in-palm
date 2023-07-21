import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltDependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.apply {
            add("implementation", DaggerHilt.hilt)
            add("kapt", DaggerHilt.hiltAndroidCompiler)
            add("implementation", DaggerHilt.hiltComposeNavigation)
        }
    }
}
