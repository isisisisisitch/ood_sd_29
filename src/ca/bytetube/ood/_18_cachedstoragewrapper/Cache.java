package ca.bytetube.ood._18_cachedstoragewrapper;

import java.util.Optional;

public interface Cache {
    void put(String key, String value);

    void remove(String key);

    void clear();

    Optional<String> get(String key);

    int size();
}
