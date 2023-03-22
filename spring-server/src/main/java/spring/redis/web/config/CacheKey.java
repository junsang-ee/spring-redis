package spring.redis.web.config;

public class CacheKey {
    public static final int DEFAULT_EXPIRE_SEC = 600; // 10 mimutes
    public static final int POST_EXPIRE_SEC = 3600; // 1 hour
    public static final String POST = "post";

    public static final String GET = "get";
}
