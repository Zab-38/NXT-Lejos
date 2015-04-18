package com.bitcold.nlites.view.quicksummary;

import org.collab.swt.utils.NLitesStandardSWTFactory;

public class QuickView {
	
	FormFactory formFactory = new FormFactory();
	
	
	
	public static void main(String[] args) {
		
		QuickView quickView = new QuickView();
		
		NLitesStandardSWTFactory.viewPopup(quickView.formFactory, 0,0, 200, 200);
	}

}
