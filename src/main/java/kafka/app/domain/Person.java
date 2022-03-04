package kafka.app.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Person {

    @JsonProperty("name")
    private String name;

    @JsonProperty("idnumber")
    private String idNumber;

    @JsonProperty("profession")
    private String profession;


}
