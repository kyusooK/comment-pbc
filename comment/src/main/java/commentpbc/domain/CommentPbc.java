package commentpbc.domain;

import commentpbc.CommentApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CommentPbc_table")
@Data
public class CommentPbc {

    @Id
    private String topicId;

    private String userId;

    @ElementCollection
    private List<String> content;

    @PostPersist
    public void onPostPersist() {}

    public static CommentPbcRepository repository() {
        CommentPbcRepository commentPbcRepository = CommentApplication.applicationContext.getBean(
            CommentPbcRepository.class
        );
        return commentPbcRepository;
    }

    public void comment(CommentCommand commentCommand) {
        //implement business logic here: Create a new Comment if there`s no topicId and existing entity. and add the userId and content.
        this.userId = commentCommand.getUserId();
        this.content = commentCommand.getContent();

        CommentPbcRepository repository = CommentApplication.applicationContext.getBean(CommentPbcRepository.class);
        repository.save(this);
        repository().save(this);

        //publish event
        CommentAdded commentAdded = new CommentAdded(this);
        commentAdded.publishAfterCommit();
    }
}
