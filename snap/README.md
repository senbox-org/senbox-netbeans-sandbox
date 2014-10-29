IntelliJ IDEA Runtime Configuration
-----------------------------------

Select checkbox *Single instance only*

*Name:*

    SNAP

*Main class:*

    org.netbeans.Main

*VM options:*

    -Xmx4G -Dnetbeans.logger.console=true -Dnetbeans.home="./snap-app/target/snap" -ea

*Program arguments: (examples)*

    --modules --list --userdir ./userdir --fontsize 13 --branding snap

*Working directory:*:

    C:\Users\Norman\JavaProjects\senbox-netbeans-sandbox\snap

*Use classpath of module:*

    snap-app

Notes: 
* Branding does not work with this configuration. TODO: Find out why! 
* Sys prop netbeans.home is not required. TODO find out which installation path is used instead.
* Sys prop netbeans.user can be used instead of --userdir option. 

More info:

* Look into C:\Users\Norman\JavaProjects\senbox-netbeans-sandbox\snap\snap-app\target\snap\etc
* http://wiki.netbeans.org/FaqStartupParameters
* http://wiki.netbeans.org/FaqNetbeansConf
* http://netbeans.dzone.com/news/using-intellij-idea-netbeans, "4. Create a Runtime Configuration"