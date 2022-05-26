package clowoodive.gitblog.example.zoneddatetime;

import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class ZonedDateTimeService {
    public LocalDateTime convertToServerTimeZonedDateTime(int serviceTimeZone, LocalDateTime serviceCheckTime) {
        var serviceZonedDateTime = ZonedDateTime.of(serviceCheckTime, ZoneOffset.ofHours(serviceTimeZone));
        var systemDefaultZoneId = ZoneId.systemDefault();

        var zonedDateTime = serviceZonedDateTime.withZoneSameInstant(systemDefaultZoneId);

        return zonedDateTime.toLocalDateTime();
    }
}
