IntelliJ IDEA Runtime Configuration
-----------------------------------

Select checkbox *Single instance only*

*Main class:*

    org.netbeans.Main

*VM options:*

    -Xmx4G -Dnetbeans.logger.console=true -ea

*Program arguments:*

    --modules --list --userdir ./userdir --fontsize 14 --branding snap

*Working directory:*:

    C:\Users\Norman\JavaProjects\sentbx-netbeans-sandbox\snap

*Use classpath of module:*

    snap-app

Note: branding does not work with this configuration.

More info:

* Look into C:\Users\Norman\JavaProjects\sentbx-netbeans-sandbox\snap\snap-app\target\snap\etc
* http://wiki.netbeans.org/FaqStartupParameters
* http://wiki.netbeans.org/FaqNetbeansConf
* http://netbeans.dzone.com/news/using-intellij-idea-netbeans, "4. Create a Runtime Configuration"