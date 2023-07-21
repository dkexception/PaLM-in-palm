import org.gradle.api.Plugin
import org.gradle.api.Project

class CoreDependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.apply {
            add("implementation", Core.core)
            add("implementation", Core.appCompat)
            add("implementation", Core.activityCompose)
            platform(Core.kotlinBom)
        }
    }
}
