package todos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtils {
    static  java.sql.Date toSqlDate(LocalDateTime time){
        return java.sql.Date.valueOf(time.toLocalDate());
    }
    static  LocalDateTime toLocalDate(java.sql.Timestamp time){
        return time.toLocalDateTime();
    }

    static  java.sql.Timestamp toSqlTimestamp(LocalDateTime time){
        return java.sql.Timestamp.valueOf(time);
    }
}
