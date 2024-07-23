package PreparedStatements;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class TimestampConverter {

        public static Timestamp convertToTimestamp(LocalDateTime dateTime) {
            return Timestamp.valueOf(dateTime);
        }

        public static LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
            return timestamp.toLocalDateTime();
        }
    }
