package nbd5.nbd5.domain;

import com.datastax.driver.core.DataType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Table("weather_entries")
@Data
public class Entry implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    private Date date;
    private Integer degreesFromMean;
    private String stationId;
    private String longitude;
    private String latitude;
    private Integer maxTemp;
    private Integer minTemp;
    private String stationName;
    private String type;
    private Integer serialId;

    public UUID getId() {
        return id;
    }

    public Entry() {
        id = UUID.randomUUID();
    }
}
