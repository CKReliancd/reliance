import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.70.129", 6379);

        jedis.auth("123321");

        String ping = jedis.ping();

        System.out.println(ping);

        jedis.close();
    }

}
