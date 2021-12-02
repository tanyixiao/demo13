package com.example.goods.Controller;

import com.example.goods.Service.commentService;
import com.example.goods.common.Resulet01;
import com.example.goods.pojo.Good_comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private commentService commentService;
    @RequestMapping("page")
    public @ResponseBody Resulet01<Good_comment> page(@RequestParam(value = "start",defaultValue = "1") int start, @RequestParam(value = "size",defaultValue = "5") int size
            , @RequestParam(value = "title",defaultValue = "") String title){
        return commentService.page(start,size,title);
    }
}
