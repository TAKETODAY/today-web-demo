package cn.taketoday.web.demo.controller;

import cn.taketoday.web.annotation.Controller;
import cn.taketoday.web.annotation.PUT;
import cn.taketoday.web.annotation.PathVariable;
import cn.taketoday.web.annotation.RequestBody;
import cn.taketoday.web.annotation.RequestMapping;
import cn.taketoday.web.demo.domain.Article;
import cn.taketoday.web.demo.view.Json;

/**
 * @author TODAY <br>
 *         2018-10-21 17:33
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @PUT("/{id}")
    public Json update(@RequestBody Article article, @PathVariable final long id) {
        return Json.success("文章更新成功");
    }

}
