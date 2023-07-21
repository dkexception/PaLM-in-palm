import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeBOMDependenciesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.apply {
            val composeDep = platform(ComposeBOM.composeBom)
            add("implementation", composeDep)
            add("androidTestImplementation", composeDep)

            add("implementation", ComposeBOM.composeUI)
            add("implementation", ComposeBOM.composeGraphics)
            add("implementation", ComposeBOM.composeIcons) // Icons
            add("implementation", ComposeBOM.composeM3) // MD3
            add("implementation", ComposeBOM.composePreview) // Preview
            add("debugImplementation", ComposeBOM.composePreviewDebug)
            add("implementation", ComposeBOM.composeLiveData) // LiveData
        }
    }
}
