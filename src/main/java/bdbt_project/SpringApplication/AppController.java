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


        @RequestMapping("/index")
        public String viewHomePage(Model model){ return "index";}


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
        @RequestMapping("/newokaz_admin")
        public String showNewOkazPage(Model model) {
            Okazy okazy = new Okazy();
            model.addAttribute("okazy", okazy);
            return "admin/newokaz_admin";
        }

        @RequestMapping(value = "/saveokaz_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("okazy") Okazy okazy){
            dao2.save(okazy);
            return "redirect:/okazy_admin";
        }
        @RequestMapping("/editokaz/{id_okazu}")
        public ModelAndView showEditOkazyPage(@PathVariable(name = "id_okazu") int id) {
            ModelAndView mav = new ModelAndView("admin/editokaz_admin");
            Okazy okazy = dao2.get(id);
            mav.addObject("okazy", okazy);

            return mav;
        }

        @RequestMapping(value="/updateokaz_admin", method = RequestMethod.POST)
        public String update(@ModelAttribute("okazy") Okazy okazy) {
            dao2.update(okazy);

            return "redirect:/okazy_admin";
        }

        @RequestMapping("/deleteokaz/{id_okazu}")
        public String deleteOkaz(@PathVariable(name = "id_okazu") int id) {
            dao2.delete(id);

            return "redirect:/okazy_admin";
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
        @RequestMapping("/newzbiornik_admin")
        public String showNewZbiornikPage(Model model) {
            Zbiorniki zbiorniki = new Zbiorniki();
            model.addAttribute("zbiorniki", zbiorniki);
            return "admin/newzbiornik_admin";
        }

        @RequestMapping(value = "/savezbiornik_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("zbiorniki") Zbiorniki zbiorniki){
            dao3.save(zbiorniki);
            return "redirect:/zbiorniki_admin";
        }

        @RequestMapping("/editzbiornik/{id_zbiornika}")
        public ModelAndView showEditZbiornikPage(@PathVariable(name = "id_zbiornika") int id) {
            ModelAndView mav = new ModelAndView("admin/editzbiornik_admin");
            Zbiorniki zbiorniki = dao3.get(id);
            mav.addObject("zbiorniki", zbiorniki);

            return mav;
        }

        @RequestMapping(value="/updatezbiornik_admin", method = RequestMethod.POST)
        public String updateZbiornik(@ModelAttribute("zbiorniki") Zbiorniki zbiorniki) {
            dao3.update(zbiorniki);

            return "redirect:/zbiorniki_admin";
        }

        @RequestMapping("/deletezbiornik/{id_zbiornika}")
        public String deleteZbiornik(@PathVariable(name = "id_zbiornika") int id) {
            dao3.delete(id);

            return "redirect:/zbiorniki_admin";
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
        @RequestMapping("/newpracownik_admin")
        public String showNewPracownikPage(Model model) {
            Pracownicy pracownicy = new Pracownicy();
            model.addAttribute("pracownicy", pracownicy);
            return "admin/newpracownik_admin";
        }

        @RequestMapping(value = "/savepracownik_admin", method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy){
            dao4.save(pracownicy);
            return "redirect:/pracownicy_admin";
        }
        @RequestMapping("/editpracownik/{id_pracownika}")
        public ModelAndView showEditPracownikPage(@PathVariable(name = "id_pracownika") int id) {
            ModelAndView mav = new ModelAndView("admin/editpracownik_admin");
            Pracownicy pracownicy = dao4.get(id);
            mav.addObject("pracownicy", pracownicy);

            return mav;
        }

        @RequestMapping(value="/updatepracownik_admin", method = RequestMethod.POST)
        public String updatePracownik(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            dao4.update(pracownicy);

            return "redirect:/pracownicy_admin";
        }

        @RequestMapping("/deletepracownik/{id_pracownika}")
        public String deletePracownik(@PathVariable(name = "id_pracownika") int id) {
            dao4.delete(id);

            return "redirect:/pracownicy_admin";
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