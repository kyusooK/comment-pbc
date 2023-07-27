package commentpbc.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class CommentCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String topicId;

    private String userId;
    private List<String> content;
}
