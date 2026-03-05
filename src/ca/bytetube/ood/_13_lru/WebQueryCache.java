package ca.bytetube.ood._13_lru;

public class WebQueryCache {
    Cache<String, String> cache;

    public WebQueryCache(int capacity) {
        this.cache = new LRUCache<>(capacity);
    }

    public String getQueryResult(String query) {
        String result = cache.get(query);
        if (result == null) {

            result = executeQuery(query);
            cache.put(query, result);
        }

        return result;
    }

    private String executeQuery(String query) {

        return "Result for query:" + query;
    }

}