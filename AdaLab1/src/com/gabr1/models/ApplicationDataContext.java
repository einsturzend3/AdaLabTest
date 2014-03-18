package com.gabr1.models;

import android.content.Context;

import com.mobandme.ada.ObjectContext;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

public class ApplicationDataContext extends ObjectContext {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "myDataBase.db";
	private ObjectSet<User> usersSet;

	public ApplicationDataContext(Context pContext) throws AdaFrameworkException {
		super(pContext, DATABASE_NAME, DATABASE_VERSION);
		usersSet = new ObjectSet<User>(User.class, this);
	}

	public ObjectSet<User> getUsersSet() {
		return usersSet;
	}

}
