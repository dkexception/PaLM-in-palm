import org.gradle.api.Plugin
import org.gradle.api.Project

class TestingDependencies : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.apply {
            add("testImplementation", TestImplementation.junit)
            add("androidTestImplementation", AndroidTestImplementation.junit)
            add("androidTestImplementation", AndroidTestImplementation.espresso)
        }
    }
}
