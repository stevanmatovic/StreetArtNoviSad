package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.Monument;

/**
 * Created by Helena Zecevic on 17.05.2016..
 */
public class MonumentDAO extends RuntimeExceptionDao<Monument, Integer> {

    public MonumentDAO(Dao<Monument, Integer> dao) {
        super(dao);
    }
}
