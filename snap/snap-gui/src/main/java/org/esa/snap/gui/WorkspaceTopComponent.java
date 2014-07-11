/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.esa.snap.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import org.netbeans.swing.tabcontrol.TabData;
import org.netbeans.swing.tabcontrol.TabbedContainer;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * @author Norman
 */
@TopComponent.Description(
        preferredID = "WorkspaceTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(
        mode = "editor",
        openAtStartup = true)
@ActionID(category = "Window", id = "org.snap.gui.WorkspaceTopComponent")
@ActionReference(path = "Menu/Window", position = -1000)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_WorkspaceTopComponent",
        preferredID = "WorkspaceTopComponent"
)
@Messages({"CTL_WorkspaceTopComponentAction=Workspace Window",
                  "CTL_WorkspaceTopComponent=Workspace",
                  "HINT_WorkspaceTopComponent=This is a Workspace window",
          })
public class WorkspaceTopComponent extends TopComponent implements InternalFrameListener, ChangeListener {

    private TabbedContainer tabbedContainer;
    private JDesktopPane desktopPane;
    private Map<TabData, JInternalFrame> tabToFrameMap;
    private Map<JInternalFrame, TabData> frameToTabMap;
    private int tabCount;

    public static WorkspaceTopComponent instance;

    public WorkspaceTopComponent() {
        initComponents();
        setName(Bundle.CTL_WorkspaceTopComponent());
        setToolTipText(Bundle.HINT_WorkspaceTopComponent());
        frameToTabMap = new HashMap<>();
        tabToFrameMap = new HashMap<>();

        instance = this;
    }

    public static WorkspaceTopComponent getInstance() {
        return instance;
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        tabbedContainer = new TabbedContainer(TabbedContainer.TYPE_EDITOR);
        desktopPane = new JDesktopPane();
        
        TabData tabData = new TabData(new JPanel(), null, "Dummy Tab", "Dummy Tab");
        tabbedContainer.getModel().addTab(0, tabData);

        add(tabbedContainer, BorderLayout.NORTH);
        add(desktopPane, BorderLayout.CENTER);

        tabbedContainer.getSelectionModel().addChangeListener(this);
    }

    public void addComponent(String title, JComponent component) {
        int index = tabCount++;
        JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
        /*
        JComponent tabComponent = new JComponent() {
            @Override
            public void setBounds(int x, int y, int width, int height) {
            }

            @Override
            public void doLayout() {
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension();
            }
        };
                */
        JComponent tabComponent = new JPanel();
        tabComponent.setPreferredSize(new Dimension(0,0));
        //JComponent tabComponent = new JLabel("Tab + " + index);
        TabData tabData = new TabData(tabComponent, null, title, "Tab + " + index);
        tabbedContainer.getModel().addTab(tabbedContainer.getModel().size(), tabData);
        desktopPane.add(internalFrame);
        internalFrame.setContentPane(component);
        internalFrame.setBounds(new Rectangle(tabCount * 24, tabCount * 24, 400, 400));

        frameToTabMap.put(internalFrame, tabData);
        tabToFrameMap.put(tabData, internalFrame);


        internalFrame.addInternalFrameListener(this);

        internalFrame.setVisible(true);
        try {
            internalFrame.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        /*
        SingleSelectionModel selectionModel = tabbedContainer.getSelectionModel();
        if (e.getSource() == selectionModel) {
            int selectedIndex = selectionModel.getSelectedIndex();
            if (selectedIndex >= 0) {
                List<TabData> tabs = tabbedContainer.getModel().getTabs();
                TabData tabData = tabs.get(selectedIndex);
                JInternalFrame internalFrame = tabToFrameMap.get(tabData);
                try {
                    internalFrame.setSelected(true);
                } catch (PropertyVetoException e1) {
                    e1.printStackTrace();
                }
            }
        }
        */
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        e.getInternalFrame().removeInternalFrameListener(this);
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        /*
        JInternalFrame internalFrame = e.getInternalFrame();
        TabData selectedTab = frameToTabMap.get(internalFrame);

        List<TabData> tabs = tabbedContainer.getModel().getTabs();
        for (int i = 0; i < tabs.size(); i++) {
            TabData tab = tabs.get(i);
            if (tab == selectedTab && tabbedContainer.getSelectionModel().getSelectedIndex() != i) {
                tabbedContainer.getSelectionModel().setSelectedIndex(i);
                break;
            }
        }
                */
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening       
    }

    @Override
    public void componentClosed() {
        tabbedContainer.getSelectionModel().removeChangeListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

}
