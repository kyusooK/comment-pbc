package commentpbc.infra;

import commentpbc.domain.*;

import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/commentPbcs")
@Transactional
public class CommentPbcController {

    @Autowired
    CommentPbcRepository commentPbcRepository;

    @RequestMapping(
        value = "commentPbcs/{id}/comment",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ArrayList<CommentPbc> commentPbc(
        @PathVariable(value = "id") String id,
        @RequestBody CommentCommand commentCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /commentPbc/commentPbc  called #####");

        final ArrayList<CommentPbc> commentPbcContainer = new ArrayList<CommentPbc>();

        commentPbcRepository
            .findById(id)
            .ifPresentOrElse(commentPbc ->{
                commentPbc.comment(commentCommand);

                commentPbcRepository.save(commentPbc);
                commentPbcContainer.add(commentPbc);
            }, ()-> {
                CommentPbc commentPbc = new CommentPbc();

                if(commentPbc.getTopicId() == null) {
                    commentPbc.setTopicId(id);
                }
                commentPbc.comment(commentCommand);
                commentPbcRepository.save(commentPbc);
                commentPbcContainer.add(commentPbc);
            });

        return commentPbcContainer;
    }
}
