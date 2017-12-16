package eu.execom.helenazecevic.monumentum.utils;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by Helena Zecevic on 15.05.2016..
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface Preferences {

    int id();
}