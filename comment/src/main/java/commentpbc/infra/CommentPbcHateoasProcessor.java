package commentpbc.infra;

import commentpbc.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommentPbcHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<CommentPbc>> {

    @Override
    public EntityModel<CommentPbc> process(EntityModel<CommentPbc> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/comment")
                .withRel("comment")
        );

        return model;
    }
}
