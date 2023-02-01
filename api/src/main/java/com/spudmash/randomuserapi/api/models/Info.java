package com.spudmash.randomuserapi.api.models;

public class Info {
    private String seed;
    private Integer results;
    private Integer page;
    private String version;

    public Info() {

    }

    public String getSeed() { return this.seed; }
    public void setSeed(String seed) {
        this.seed = seed;
    }

    public Integer getResults() { return this.results; }
    public void setResults(Integer results) { this.results = results; }

    public Integer getPage() { return this.page; }
    public void setPage(Integer page) { this.page = page; }

    public String getVersion() { return this.version; }
    public void setVersion(String version) {
        this.version = version;
    }
}
