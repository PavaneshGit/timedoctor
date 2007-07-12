/*******************************************************************************
 * Copyright (c) 2007 NXP Semiconductors B.V.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License version 1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     NXP Semiconductors B.V. - initial API and implementation
 *******************************************************************************/
package com.nxp.timedoctor.product.workbench.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.update.ui.UpdateManagerUI;

import com.nxp.timedoctor.ui.ITimeDoctorUIConstants;

public class ManageConfigurationAction extends Action implements IWorkbenchAction {
	private static final String ID = "com.nxp.timedoctor.ui.manageConfiguration";
	private IWorkbenchWindow window;
	
	public ManageConfigurationAction(IWorkbenchWindow window) {		
		this.window = window;
		setId(ID);
		setText("&Manage Configuration");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(ITimeDoctorUIConstants.TD_UI_PLUGIN, 
				ITimeDoctorUIConstants.TOOLBAR_ENABLED_IMG_PATH + "configs.gif"));
	}

	public void dispose() {
	}
	
	@Override
	public void run() {
		BusyIndicator.showWhile(window.getShell().getDisplay(), new Runnable() {
            public void run() {
                UpdateManagerUI.openConfigurationManager(window.getShell());
            }
        });
	}
}
