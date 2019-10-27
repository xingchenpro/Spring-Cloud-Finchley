package com.javahly.serviceblog.controller;


import com.javahly.serviceblog.entity.Blog;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/15
 */

//http://localhost:8763/swagger-ui.html
@RestController
@RequestMapping(value = "/blogs")     // 通过这里配置使下面的映射都在/blogs下，可去除
public class BlogController {

    static Map<String, Blog> blogs = Collections.synchronizedMap(new HashMap<String, Blog>());

    @ApiOperation(value = "获取博客列表", notes = "")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Blog> getBlogList() {
        List<Blog> r = new ArrayList<Blog>(blogs.values());
        return r;
    }

    @ApiOperation(value = "创建博客", notes = "根据Blog对象创建博客")
    @ApiImplicitParam(name = "blog", value = "博客详细实体blog", required = true, dataType = "Blog")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postBlog(@RequestBody Blog blog) {
        blogs.put(blog.getId(), blog);
        return "success";
    }

    @ApiOperation(value = "获取博客详细信息", notes = "根据url的id来获取博客详细信息")
    @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog getBlog(@PathVariable String id) {
        return blogs.get(id);
    }

    @ApiOperation(value = "更新博客详细信息", notes = "根据url的id来指定更新对象，并根据传过来的blog信息来更新博客详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "String"),
            @ApiImplicitParam(name = "blog", value = "博客详细实体blog", required = true, dataType = "Blog")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putBlog(@PathVariable String id, @RequestBody Blog blog) {
        Blog u = blogs.get(id);
        u.setTitle("sirius");
        blogs.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除博客", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "博客ID", required = true, dataType = "String")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBlog(@PathVariable String id) {
        blogs.remove(id);
        return "success";
    }

}
