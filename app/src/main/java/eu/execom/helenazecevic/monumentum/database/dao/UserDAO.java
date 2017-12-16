package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.User;

/**
 * Created by Helena Zecevic on 17.05.2016..
 */
public class UserDAO extends RuntimeExceptionDao<User, Integer> {

    public UserDAO(Dao<User, Integer> dao) {
        super(dao);
    }
}
