package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.LikeComment;

/**
 * Created by Helena Zecevic on 27.05.2016..
 */
public class LikeCommentDAO extends RuntimeExceptionDao<LikeComment, Integer> {

    public LikeCommentDAO(Dao<LikeComment, Integer> dao) {
        super(dao);
    }
}
