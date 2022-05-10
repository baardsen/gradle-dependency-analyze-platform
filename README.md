# gradle-dependency-analyze-platform
Sample project to show the [gradle-dependency-analyze](https://github.com/gradle-dependency-analyze/gradle-dependency-analyze) plugin failing when trying to resolve dependencies whose versions come from a bom file.

```shell
$ ./gradlew check
> Task :analyzeClassesDependencies FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':analyzeClassesDependencies'.
> Could not resolve all files for configuration ':apiHelper'.
   > Could not find org.jetbrains.kotlin:kotlin-stdlib:.
     Required by:
         project :

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 2s
2 actionable tasks: 1 executed, 1 up-to-date
```
