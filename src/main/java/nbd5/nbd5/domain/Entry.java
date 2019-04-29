package nbd5.nbd5.domain;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Table("weather_entries")
@Data
public class Entry implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    private Date date;

    @NonNull
    @CassandraType(type = DataType.Name.INT)
    private Integer degreesFromMean;

    @NotBlank
    private String stationId;

    @NotBlank
    private String longitude;

    @NotBlank
    private String latitude;

    @NonNull
    @CassandraType(type = DataType.Name.INT)
    private Integer maxTemp;

    @NonNull
    @CassandraType(type = DataType.Name.INT)
    private Integer minTemp;

    @NotBlank
    private String stationName;

    @NotBlank
    private String type;

    @NonNull
    @CassandraType(type = DataType.Name.INT)
    private Integer serialId;

    public Entry() {
        id = UUID.randomUUID();
    }
}
