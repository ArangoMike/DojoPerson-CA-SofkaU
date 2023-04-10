package co.com.sofkau.mongo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "Persons")
public class PersonDTO {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
}
