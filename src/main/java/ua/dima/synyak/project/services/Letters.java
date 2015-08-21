package ua.dima.synyak.project.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 8/13/15.
 */
@Service
public class Letters {
    private List<String> list;
    public Letters() {
        list = new ArrayList<String>();
        list.add("А");
        list.add("Б");
        list.add("В");
        list.add("Г");
        list.add("Д");
        list.add("Е");
        list.add("Ё");
        list.add("Ж");
        list.add("З");
        list.add("И");
        list.add("К");
        list.add("Л");
        list.add("М");
        list.add("Н");
        list.add("О");
        list.add("П");
        list.add("Р");
        list.add("С");
        list.add("Т");
        list.add("У");
        list.add("Ф");
        list.add("Х");
        list.add("Ц");
        list.add("Ч");
        list.add("Ш");
        list.add("Щ");
        list.add("Э");
        list.add("Ю");
        list.add("Я");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
