package memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/15.
 */
public class TestConsistency {

    @Test
    public void main() throws IOException {
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("192.168.2.113:11211 192.168.2.118:11211 192.168.2.119:11211"));
        MemcachedClient memcachedClient = builder.build();

        try {
            memcachedClient.set("key", 0, "Hello World! KKK");
            String value = memcachedClient.get("key");
            System.out.println("key值：" + value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            memcachedClient.shutdown();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
