package org.esa.snap.module3;

import org.openide.modules.OnStart;

/**
 * @author Norman Fomferra
 */
@OnStart
public class Init implements Runnable {

    @Override
    public void run() {
        System.out.println(">>>>>>>>>>>>>>>>>> " + getClass() + " started!!");                
    }
    
}
