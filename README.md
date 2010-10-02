assembly-sbt
============

*Deploy fat JARs. Restart processes.*

assembly-sbt is a [simple-build-tool](http://code.google.com/p/simple-build-tool/)
plugin for building a single JAR file of your project which includes all of its
dependencies, allowing to deploy the damn thing as a single file without dicking
around with shell scripts and lib directories or, worse, welding your
configuration to your deployable in the form of a WAR file.

Requirements
------------

* Simple Build Tool
* The burning desire to have a simple deploy procedure.


How To Use
----------

**First**, specify assembly-sbt as a dependency in
`project/plugins/Plugins.scala`:

    class Plugins(info: sbt.ProjectInfo) extends sbt.PluginDefinition(info) {
      val codaRepo = "Coda Hale's Repository" at "http://repo.codahale.com/"
      val assemblySBT = "com.codahale" % "assembly-sbt" % "0.1-SNAPSHOT"
    }

(You may need to check this project's tags to see what the most recent release
is. I'm notoriously crap about updating the version numbers in my READMEs.)

**Second**, add the `AssemblyBuilder` trait to your project:
    
    class MyProject(info: ProjectInfo) extends DefaultProject(info) with assembly.AssemblyBuilder {
      // etc.
    }


Now you'll have an awesome new `assembly` task which will compile your project,
run your tests, and then pack your class files and all your dependencies into a
single JAR file: `target/scala_X.X.X/projectname-assembly-X.X.X.jar`.

If you specify a `mainClass` in simple-build-tool (or just let it autodetect
one) then you'll end up with a fully executable JAR, ready to rock.


License
-------

Copyright (c) 2010 Coda Hale

Published under The MIT License, see LICENSE