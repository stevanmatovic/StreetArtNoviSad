package eu.execom.helenazecevic.monumentum.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import eu.execom.helenazecevic.monumentum.models.Comment;

/**
 * Created by Helena Zecevic on 27.05.2016..
 */
public class CommentDAO extends RuntimeExceptionDao<Comment, Integer> {

    public CommentDAO(Dao<Comment, Integer> dao) {
        super(dao);
    }
}
