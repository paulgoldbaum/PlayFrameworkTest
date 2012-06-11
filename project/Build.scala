import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "PlayFrameworkTest"
    val appVersion      = "1.0"

    val appDependencies = Seq(
      "org.squeryl" % "squeryl_2.9.2" % "0.9.5-2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
