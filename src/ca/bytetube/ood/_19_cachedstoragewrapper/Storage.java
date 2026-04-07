package ca.bytetube.ood._19_cachedstoragewrapper;

import java.util.Optional;

public interface Storage {
    void write(String key, String value);

    Optional<String> read(String key);

    void delete(String key);
}
