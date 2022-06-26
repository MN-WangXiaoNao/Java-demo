package cn.itcast.hotel;

import static cn.itcast.hotel.contacts.HotelIndexConstants.MAPPING_TEMPLATE;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelIndexTest {

    private RestHighLevelClient client;
    public static final String HOSTNAME = "xxx";
    public static final int PORT = 9200;
    public static final String SCHEME = "http";

    @Test
    void testInit() {
        System.out.println(client);
    }

    /**
     * 创建索引 <br/>
     * 参考：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-create-index.html
     */
    @Test
    void testCreateHotelIndex() throws IOException {
        // 1. 创将 request
        CreateIndexRequest request = new CreateIndexRequest("hotel");
        // 2. 设置请求参数
        request.setTimeout(TimeValue.timeValueMinutes(2));
        request.setMasterTimeout(TimeValue.timeValueMinutes(1));
        request.waitForActiveShards(ActiveShardCount.from(2));
        request.waitForActiveShards(ActiveShardCount.DEFAULT);
        request.source(MAPPING_TEMPLATE, XContentType.JSON);
        // 3. 发起请求
        client.indices().createAsync(request, RequestOptions.DEFAULT, new ActionListener<CreateIndexResponse>() {
            @Override
            public void onResponse(CreateIndexResponse createIndexResponse) {
                boolean acknowledged = createIndexResponse.isAcknowledged();
                boolean shardsAcknowledged = createIndexResponse.isShardsAcknowledged();
                System.out.println("acknowledged: " + acknowledged);
                System.out.println("shardsAcknowledged: " + shardsAcknowledged);
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println("error: " + e.getMessage());

            }
        });
        // 等待 listener
        while (true) {

        }
    }

    /**
     * 判断索引是否存在<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-indices-exists.html
     */
    @Test
    void testExistsHotelIndex() throws IOException {
        // 1. 创建 request 对象
        GetIndexRequest request = new GetIndexRequest("hotel");
        // 2. 发送请求
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        // 3. 输出
        System.out.println(exists ? "索引库已经存在！" : "索引库不存在！");
    }

    /**
     * 删除索引<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-delete-index.html
     */
    @Test
    void testDeleteHotelIndex() throws IOException {
        // 1. 创建 request 对象
        DeleteIndexRequest request = new DeleteIndexRequest("hotel");
        // 2. 发送请求
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        // 3. 输出
        System.out.println(response.isAcknowledged());
    }

    @BeforeEach
    void setUp() {
        client = new RestHighLevelClient(RestClient.builder(
            // 集群的话，配置多个
            new HttpHost(HOSTNAME, PORT, SCHEME)));
    }

    @AfterEach
    void tearDown() throws IOException {
        client.close();
    }

}
