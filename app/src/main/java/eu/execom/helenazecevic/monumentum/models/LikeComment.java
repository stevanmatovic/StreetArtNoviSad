package eu.execom.helenazecevic.monumentum.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

import eu.execom.helenazecevic.monumentum.utils.ConstantsDatabase;

/**
 * Created by Helena Zecevic on 27.05.2016..
 */
@DatabaseTable(tableName = "commentLikes")
public class LikeComment {

    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.USER_FIELD_NAME, foreign = true)
    private User user;

    @DatabaseField(columnName = ConstantsDatabase.COMMENT_FIELD_NAME, foreign = true)
    private Comment comment;

    public LikeComment() {
    }

    public LikeComment(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LikeComment{" +
                "id=" + id +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }
}
