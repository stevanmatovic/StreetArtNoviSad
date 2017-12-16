package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.MonumentType;

/**
 * Created by Helena Zecevic on 17.05.2016..
 */
public class MonumentTypeDAO extends RuntimeExceptionDao<MonumentType, Integer> {

    public MonumentTypeDAO(Dao<MonumentType, Integer> dao) {
        super(dao);
    }
}
