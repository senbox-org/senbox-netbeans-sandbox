IntelliJ IDEA Runtime Configuration
-----------------------------------

Select checkbox *Single instance only*

*Name:*

    SNAP

*Main class:*

    org.netbeans.Main

*VM options:*

    -Xmx4G -Dnetbeans.logger.console=true -ea

*Program arguments: (examples)*

    --modules --list --userdir ./userdir --fontsize 13 --branding snap

*Working directory:*:

    C:\Users\Norman\JavaProjects\senbox-netbeans-sandbox\snap

*Use classpath of module:*

    snap-app

    
Problems with this configuration 

* Branding does (and probably other NetBeans features do) not work with this
  configuration, because this requires starting the platform from the fully 
  built and packaged application structure as found after `mvn package` in 
  `./snap-app/target/snap`.
  But for fast development cycles we don't want to re-package the project
  each time we have a little change and need to run the app. This is
  annoyingly slow because for some reason, Maven will zip each and every
  artifact's JAR, even is there wasn't any source change at all.

  
Notes:
* To get all NBP configuration options, do the following:

    > cd snap-app/target/snap/bin
    > ./snap64 --help

* System property `netbeans.user` can be used instead of `--userdir` option. 
* We don't use the `netbeans.home` system property as suggested by Geertjan's 
  blog, because NB launcher says: "system property netbeans.home has 
  been obsoleted in favour of InstalledFileLocator/Places" - whatever this 
  means.
* The applications configuration is stored in `snap-app/target/snap/etc`.

NB Wiki pages on NetBeans configuration:
* http://wiki.netbeans.org/FaqStartupParameters
* http://wiki.netbeans.org/FaqNetbeansConf
* http://wiki.netbeans.org/NBINativeLaunchers
* http://wiki.netbeans.org/NBINativeLauncherCommandLineOptions
* http://wiki.netbeans.org/Splash_Screen_Beginner_Tutorial

Description of all NB system properties:
* http://bits.netbeans.org/dev/javadoc/properties.html

NB Maven Plugin (nbm):
* http://mojo.codehaus.org/nbm-maven/nbm-maven-plugin/
* http://mojo.codehaus.org/nbm-maven/nbm-maven-plugin/cluster-app-mojo.html
* http://mojo.codehaus.org/nbm-maven/nbm-maven-plugin/run-platform-mojo.html

Related NB configuration info:
* https://platform.netbeans.org/articles/installation.html
* http://netbeans.dzone.com/news/using-intellij-idea-netbeans, "4. Create a Runtime Configuration"
* http://netbeans.dzone.com/using-maven-and-intellij-idea
* http://sett.ociweb.com/sett/settSep2013.html
* http://andrzejgrzesik.info/2012/09/18/debugging-netbeans-rcp-from-intellij/