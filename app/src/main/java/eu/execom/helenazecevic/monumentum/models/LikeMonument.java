package eu.execom.helenazecevic.monumentum.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import eu.execom.helenazecevic.monumentum.utils.ConstantsDatabase;

/**
 * Created by Helena Zecevic on 27.05.2016..
 */
@DatabaseTable(tableName = "monumentLikes")
public class LikeMonument {

    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.USER_FIELD_NAME, foreign = true)
    private User user;

    @DatabaseField(columnName = ConstantsDatabase.MONUMENT_FIELD_NAME, foreign = true)
    private Monument monument;

    public LikeMonument() {

    }

    public LikeMonument(User user, Monument monument) {
        this.user = user;
        this.monument = monument;
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

    public Monument getMonument() {
        return monument;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user +
                ", monument=" + monument +
                '}';
    }
}
