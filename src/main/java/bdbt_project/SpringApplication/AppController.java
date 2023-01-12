package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");


        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/okazy_admin").setViewName("admin/okazy_admin");
        registry.addViewController("/pracownicy_admin").setViewName("admin/pracownicy_admin");
        registry.addViewController("/bilety_admin").setViewName("admin/bilety_admin");
        registry.addViewController("/zbiorniki_admin").setViewName("admin/zbiorniki_admin");

        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/okazy_user").setViewName("user/okazy_user");
        registry.addViewController("/pracownicy_user").setViewName("user/pracownicy_user");
        registry.addViewController("/bilety_user").setViewName("user/bilety_user");
        registry.addViewController("/zbiorniki_user").setViewName("user/zbiorniki_user");

    }



    @Controller
    public class DashboardController {
        @Autowired
        private OceanariumDAO dao;


        @RequestMapping("/index")
        public String viewHomePage(Model model){
            List<Oceanarium> listOceanarium = dao.list();
            model.addAttribute(("listOceanarium"), listOceanarium);
            return "index";
        }


        @RequestMapping("/new")
        public String showNewForm(Model model) {
           Oceanarium oceanarium = new Oceanarium();
           model.addAttribute("oceanarium", oceanarium);
           return "new_form";
        }
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("oceanarium") Oceanarium oceanarium){
            dao.save(oceanarium);
            return "redirect:/index";
        }
        @Autowired
        private OkazyDAO dao2;

        @RequestMapping("/okazy_admin")
        public String viewOkazyAdminPage(Model model) {
            List<Okazy> listOkazy = dao2.list();
            model.addAttribute(("listOkazy"), listOkazy);
            return "admin/okazy_admin";
        }

        @RequestMapping("/okazy_user")
        public String viewOkazyUserPage(Model model) {
            List<Okazy> listOkazy = dao2.list();
            model.addAttribute(("listOkazy"), listOkazy);
            return "user/okazy_user";
        }

        @Autowired
        private ZbiornikiDAO dao3;

        @RequestMapping("/zbiorniki_admin")
        public String viewZbiornikiAdminPage(Model model) {
            List<Zbiorniki> listZbiorniki = dao3.list();
            model.addAttribute(("listZbiorniki"), listZbiorniki);
            return "admin/zbiorniki_admin";
        }
        @RequestMapping("/zbiorniki_user")
        public String viewZbiornikiUserPage(Model model) {
            List<Zbiorniki> listZbiorniki = dao3.list();
            model.addAttribute(("listZbiorniki"), listZbiorniki);
            return "user/zbiorniki_user";
        }

        @Autowired
        private PracownicyDAO dao4;

        @RequestMapping("/pracownicy_admin")
        public String viewPracownicyAdminPage(Model model) {
            List<Pracownicy> listPracownicy = dao4.list();
            model.addAttribute(("listPracownicy"), listPracownicy);
            return "admin/pracownicy_admin";
        }
        @RequestMapping("/pracownicy_user")
        public String viewPracownicyUserPage(Model model) {
            List<Pracownicy> listPracownicy = dao4.list();
            model.addAttribute(("listPracownicy"), listPracownicy);
            return "user/pracownicy_user";
        }

        @Autowired
        private BiletyDAO dao5;

        @RequestMapping("/bilety_admin")
        public String viewBiletyAdminPage(Model model) {
            List<Bilety> listBilety = dao5.list();
            model.addAttribute(("listBilety"), listBilety);
            return "admin/bilety_admin";
        }
        @RequestMapping("/bilety_user")
        public String viewBiletyUserPage(Model model) {
            List<Bilety> listBilety = dao5.list();
            model.addAttribute(("listBilety"), listBilety);
            return "user/bilety_user";
        }

        @RequestMapping("/newbilet_admin")
        public String showNewBiletPage(Model model) {
            Bilety bilety = new Bilety();
            model.addAttribute("bilety", bilety);
            return "admin/newbilet_admin";
        }

        @RequestMapping(value = "/savebilet_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("bilety") Bilety bilety){
            dao5.save(bilety);
            return "redirect:/bilety_admin";
        }
        @RequestMapping("/editbilet/{id_bilet}")
        public ModelAndView showEditBiletPage(@PathVariable(name = "id_bilet") int id) {
            ModelAndView mav = new ModelAndView("admin/editbilet_admin");
            Bilety bilety = dao5.get(id);
            mav.addObject("bilety", bilety);

            return mav;
        }

        @RequestMapping(value="/updatebilet_admin", method = RequestMethod.POST)
        public String updateBilet(@ModelAttribute("bilety") Bilety bilety) {
            dao5.update(bilety);

            return "redirect:/bilety_admin";
        }

        @RequestMapping("/deletebilet/{id_bilet}")
        public String deleteBilet(@PathVariable(name = "id_bilet") int id) {
            dao5.delete(id);

            return "redirect:/bilety_admin";
        }




        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            }
            else {
                return "redirect:/index";
            }
        }

        @RequestMapping("/pracownicy")
        public String SafetyPracownicy(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/pracownicy_admin";
            }
            else if (request.isUserInRole("USER")) {
                return "redirect:/pracownicy_user";
            }
            else {
                return "redirect:/index";
            }
        }

    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) { return "user/main_user"; }


}