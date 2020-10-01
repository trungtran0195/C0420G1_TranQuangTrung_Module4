package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.FavouriteList;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("favList")
public class BlogController {
    @ModelAttribute("favList")
    public FavouriteList listFav(){
        return new FavouriteList();
    }

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blog")
    public ModelAndView listBlogs(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,@RequestParam(value = "by",defaultValue = "all")String by) {
        Page<Blog> blogs = blogService.findAllBlogBySearch(search,by,pageable);
        if (blogs.isEmpty()) {
            return new ModelAndView("list", "message", "Không tìm thấy blog trong DB");
        } else {
            ModelAndView modelAndView = new ModelAndView("list");
            modelAndView.addObject("blogs", blogs);
            modelAndView.addObject("search", search);
            return modelAndView;
        }
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }else {
            return new ModelAndView("list", "message", "Không tìm thấy blog nào");
        }
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        modelAndView.addObject("categories",categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("blog", blog);
            modelAndView.addObject("categories",categoryService.findAllCategory());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/blog";
    }

    @PostMapping("/add-fav")
    public ModelAndView addFav(@RequestParam Integer id, @SessionAttribute("favList") FavouriteList list){
        Blog blog = blogService.findById(id);
        if (blog==null){
            ModelAndView modelAndView = new ModelAndView ("list","message","error");
            return modelAndView;
        }else {
            list.addToList(blog);
            ModelAndView modelAndView = new ModelAndView("view", "message", "add favourite blog");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        }
    }

    @GetMapping("/favList")
    public ModelAndView getFavList(@SessionAttribute("favList") FavouriteList list){
        return new ModelAndView("favList","favList",list.getList());
    }


    @GetMapping("/favList/{id}/add")
    public String amountCart(@PathVariable int id, @SessionAttribute("favList")FavouriteList favList, Model model){
        Blog blog = blogService.findById(id);
        favList.addToList(blog);
        model.addAttribute("favList",favList.getList());
        return "favList";
    }
    @GetMapping("/favList/{id}/sub")
    public String amountCartSub(@PathVariable int id,@SessionAttribute("favList")FavouriteList favList,Model model){
        Blog blog = blogService.findById(id);
        favList.sub(blog);
        model.addAttribute("favList",favList.getList());
        return "favList";
    }


}
