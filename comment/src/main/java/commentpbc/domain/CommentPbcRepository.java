package commentpbc.domain;

import commentpbc.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "commentPbcs",
    path = "commentPbcs"
)
public interface CommentPbcRepository
    extends PagingAndSortingRepository<CommentPbc, String> {}
