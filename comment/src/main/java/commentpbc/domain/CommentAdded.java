package commentpbc.domain;

import commentpbc.domain.*;
import commentpbc.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CommentAdded extends AbstractEvent {

    private String topicId;
    private String userId;
    private List<String> content;

    public CommentAdded(CommentPbc aggregate) {
        super(aggregate);
    }

    public CommentAdded() {
        super();
    }
}
