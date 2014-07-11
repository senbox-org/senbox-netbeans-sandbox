/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.esa.snap.gui;

import org.netbeans.swing.tabcontrol.TabDisplayer;
import org.openide.modules.OnStart;

import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import java.awt.EventQueue;
import java.util.Map;
import java.util.Set;

@OnStart
public class Installer1 implements Runnable {

    @Override
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //changeEditorTabDisplayerUI("Installer1");
            }
        });
    }

    static void changeEditorTabDisplayerUI(String tag) {
        assert EventQueue.isDispatchThread();
        System.out.println("true = " + true);
        UIDefaults settings = UIManager.getDefaults();
        Set<Map.Entry<Object, Object>> entries = settings.entrySet();
        System.out.println("UIManager: size = " + entries.size());
        for (Map.Entry entry : entries) {
             //System.out.println("UIManager: " + entry.getKey() + " = " + entry.getValue());
        }

        printTabDisplayerUI(tag + " old");

        UIManager.put(TabDisplayer.EDITOR_TAB_DISPLAYER_UI_CLASS_ID, EmptyTabDisplayerUI.class.getName());

        printTabDisplayerUI(tag + " new");
    }

    private static void printTabDisplayerUI(String tag) {
        Object oldUI = UIManager.get(TabDisplayer.EDITOR_TAB_DISPLAYER_UI_CLASS_ID);
        String typeStr = oldUI != null ? oldUI.getClass().getName() : "null";
        System.out.println(tag + " " + TabDisplayer.EDITOR_TAB_DISPLAYER_UI_CLASS_ID + ": " + oldUI + "(type "+ typeStr +")");
    }

}
