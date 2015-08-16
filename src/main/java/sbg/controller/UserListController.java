package sbg.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sbg.domain.User;
import sbg.service.UserService;

import javax.inject.Inject;

/**
 * Created by benoit on 15/08/15.
 */
@Controller
public class UserListController {

    private final UserService userService;

    @Inject
    public UserListController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/ihm/user_list.html")
    public ModelAndView getListUsersView(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "3") Integer pageSize) {
        ModelMap model = new ModelMap();
        Page<User> paginatedList = userService.findAll(pageNumber-1, pageSize);
        model.addAttribute("users", paginatedList.getContent());
        model.addAttribute("totalElements", paginatedList.getTotalElements());
        model.addAttribute("totalPages", paginatedList.getTotalPages());
        model.addAttribute("pageNumber", pageNumber);
        return new ModelAndView("user_list", model);
    }
}
