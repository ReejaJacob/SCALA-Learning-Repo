name := """OrderService"""
organization := "com.cart.inventory"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.20"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.2"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.30" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.cart.inventory.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.cart.inventory.binders._"
