package nbd5.nbd5.controllers;

import com.google.gson.Gson;
import nbd5.nbd5.domain.Entry;
import nbd5.nbd5.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
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
    public String listentrys() {
        return gson.toJson(entryService.listAll());
    }

    @RequestMapping("/entry/show/{id}")
    public String getEntry(@PathVariable String id) {
        return gson.toJson(entryService.getById(UUID.fromString(id)));
    }


    @RequestMapping(
            value = "/entry",
            method = {RequestMethod.POST, RequestMethod.PUT}
    )
    public void saveOrUpdateEntry(@Valid @RequestBody Entry entry) {
        entryService.saveOrUpdate(entry);
    }

    @RequestMapping("/entry/delete/{id}")
    public String delete(@PathVariable String id) {
        entryService.delete(UUID.fromString(id));
        return "redirect:/entry/list";
    }
}
