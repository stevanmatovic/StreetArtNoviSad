package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.LikeMonument;

/**
 * Created by Helena Zecevic on 27.05.2016..
 */
public class LikeMonumentDAO extends RuntimeExceptionDao<LikeMonument, Integer> {

    public LikeMonumentDAO(Dao<LikeMonument, Integer> dao) {
        super(dao);
    }
}
