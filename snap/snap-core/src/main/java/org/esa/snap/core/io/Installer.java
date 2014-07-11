/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.esa.snap.core.io;

import org.openide.modules.OnStart;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.lookup.Lookups;

import java.util.Set;

/**
 * @author Norman
 */
@OnStart
public class Installer implements Runnable, LookupListener {
    @Override
    public void run() {
        Lookup lookup = Lookups.forPath("Snap/ProductReaders");
        Lookup.Result result = lookup.lookupResult(ProductReaderSpi.class);
        result.addLookupListener(this);
    }

    @Override
    public void resultChanged(LookupEvent ev) {
        Lookup.Result result = (Lookup.Result) ev.getSource();
        Set<Class<ProductReaderSpi>> types = result.allClasses();
        for (Class<ProductReaderSpi> type : types) {
            System.out.println(">>> ProductReaderSpi: " + type);
        }
    } 
}
