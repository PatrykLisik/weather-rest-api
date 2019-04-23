package nbd5.nbd5.controllers;

import com.google.gson.Gson;
import nbd5.nbd5.domain.Entry;
import nbd5.nbd5.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
public class EntryController {
    private EntryService entryService;

    private Gson gson = new Gson();

    @Autowired
    public void setEntryService(EntryService entryService) {
        this.entryService = entryService;
    }

    @RequestMapping("/")
    public String redirToList() {
        return "redirect:/entry/list";
    }

    @RequestMapping(name = "/entry/list")
    @ResponseBody()
    public String listentrys() {
        String responseJSON = gson.toJson(entryService.listAll());
        return responseJSON;
    }

    @RequestMapping("/entry/show/{id}")
    @ResponseBody()
    public String getEntry(@PathVariable String id) {
        String responseJSON = gson.toJson(entryService.getById(UUID.fromString(id)));
        return responseJSON;
    }


    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public void saveOrUpdateEntry(@RequestBody Entry entry) {
        entryService.saveOrUpdate(entry);
    }

    @RequestMapping("/entry/delete/{id}")
    public String delete(@PathVariable String id) {
        entryService.delete(UUID.fromString(id));
        return "redirect:/entry/list";
    }
}
