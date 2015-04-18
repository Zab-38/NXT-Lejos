package com.bitcold.nlites.view.quicksummary;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.collab.swt.utils.NLitesStandardSWTFactory;
import org.collab.swt.utils.INLitesTkFormFactory;
import org.collab.swt.utils.ILocalResourceManagerProvider;

public class FormFactory implements INLitesTkFormFactory, ILocalResourceManagerProvider {
	
	Color background;

	Text patientName;
	Text Location;
	Text age;
	Text sex;

	private LocalResourceManager resManager;
	
	
	@Override
	public Composite createForm(Composite parent) {

		resManager = new LocalResourceManager(JFaceResources.getResources(), parent);
		
		setOverallLayout(parent);
		createTextPatientName(parent);
		createTextLocation(parent);
		createTextAge(parent);
		return null;
	}
	
	

	private void setOverallLayout(Composite parent)
	{
		GridLayout layout = NLitesStandardSWTFactory.createGridLayout(3);
		parent.setLayout(layout);
	}
	
	private Text createTextPatientName(Composite parent)
	{

		patientName = createGenericText(parent);
		patientName.setText("name");
		
		return patientName;
	}
	
	private Text createTextLocation(Composite parent)
	{

	     Location = createGenericText(parent);
	     Location.setText("world");
	
		return Location;
	}
	
	
	private Text createTextAge(Composite parent)
	{
		age  = createGenericText(parent);
		age.setText("age");
		return age;
	}
	
	
	private Text createGenericText(Composite parent)
	{
		GridData gd = NLitesStandardSWTFactory.createHorizontallyFilledGridData();
		Text text = new Text(parent, SWT.BORDER_SOLID);
		text.setLayoutData(gd);
		text.setBackground(getBackground());
		return text;
	}
	
	

	
	private Color getBackground()
	{
		background = NLitesStandardSWTFactory.blue;
		return background;
		
	}
	
	
	

	public static void main(String[] args) {
		NLitesStandardSWTFactory.viewForm(new FormFactory());
	}



	@Override
	public LocalResourceManager getLocalResourceManager() {

		return resManager;
	}

}
