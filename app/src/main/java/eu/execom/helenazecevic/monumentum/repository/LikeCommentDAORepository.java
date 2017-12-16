package eu.execom.helenazecevic.monumentum.repository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;

import eu.execom.helenazecevic.monumentum.database.DatabaseHelper;
import eu.execom.helenazecevic.monumentum.database.dao.LikeCommentDAO;
import eu.execom.helenazecevic.monumentum.models.Comment;
import eu.execom.helenazecevic.monumentum.models.LikeComment;
import eu.execom.helenazecevic.monumentum.utils.ConstantsDatabase;
import eu.execom.helenazecevic.monumentum.utils.Preferences;
import eu.execom.helenazecevic.monumentum.utils.Preferences_;


/**
 * Created by Helena Zecevic on 27.05.2016..
 */
@EBean
public class LikeCommentDAORepository {

    private static final String TAG = LikeCommentDAORepository.class.getSimpleName();

    @Bean
    UserDAORepository userDAORepository;

    @Bean
    CommentDAORepository commentDAORepository;

    @Pref
    Preferences_ prefs;

    @OrmLiteDao(helper = DatabaseHelper.class)
    LikeCommentDAO likeCommentDAO;

    public LikeComment userLiked(int commentID) {
        try {
            return likeCommentDAO.queryBuilder().where().eq(ConstantsDatabase.COMMENT_FIELD_NAME, commentID).and()
                    .eq(ConstantsDatabase.USER_FIELD_NAME, prefs.id().get()).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean toggleLike(Comment comment) {

        final LikeComment likeComment = userLiked(comment.getId());

        if (likeComment == null) {
            likeCommentDAO.create(new LikeComment(comment.getUser(), comment));
            commentDAORepository.addLike(comment);
            return true;
        } else {
            likeCommentDAO.delete(likeComment);
            commentDAORepository.removeLike(comment);
            return false;
        }
    }

}
