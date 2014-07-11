/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.esa.snap.gui;

import java.util.Map;
import java.util.Set;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import org.netbeans.swing.tabcontrol.TabDisplayerUI;
import org.openide.modules.OnStart;

/**
 *
 * @author Norman
 */
@OnStart
public class Installer implements Runnable {

    @Override
    public void run() {
        UIDefaults settings = UIManager.getDefaults();
        

        Set<Map.Entry<Object, Object>> entries = settings.entrySet();
        System.out.println("UIManager: size = " + entries.size());
        for (Map.Entry entry : entries) {
             //System.out.println("UIManager: " + entry.getKey() + " = " + entry.getValue());
        }
                
        TabDisplayerUI old = (TabDisplayerUI) UIManager.get("EditorTabDisplayerUI");
        System.out.println("EditorTabDisplayerUI: " + old);
        UIManager.put("EditorTabDisplayerUI", SnapTabDisplayerUI.class);
    }
    
}
