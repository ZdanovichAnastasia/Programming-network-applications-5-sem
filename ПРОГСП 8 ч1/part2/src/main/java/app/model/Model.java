package app.model;

import app.entities.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<Result> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(Result result) {
        model.clear(); model.add(result);
    }
    public List<String> size() {
        return model.stream()
                .map(Result::getSize)
                .collect(Collectors.toList());
    }

    public List<String> list() {
        return model.stream()
                .map(Result::getmasStr)
                .collect(Collectors.toList());
    }
}
