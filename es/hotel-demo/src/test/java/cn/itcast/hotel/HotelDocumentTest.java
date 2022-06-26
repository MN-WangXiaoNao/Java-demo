package cn.itcast.hotel;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;

import cn.itcast.hotel.pojo.Hotel;
import cn.itcast.hotel.pojo.HotelDoc;
import cn.itcast.hotel.service.IHotelService;

@SpringBootTest
public class HotelDocumentTest {

    @Autowired
    private RestHighLevelClient client;
    @Autowired
    private IHotelService iHotelService;

    public static final String HOSTNAME = "xxx";
    public static final int PORT = 9200;
    public static final String SCHEME = "http";

    /**
     * 文档新增<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-index.html
     * 
     * @throws IOException
     */
    @Test
    void testAddDocument() throws IOException {
        // 先从 db 中查询数据
        Hotel hotel = iHotelService.getById(36934);
        // hotel 转换 hotelDoc
        HotelDoc hotelDoc = new HotelDoc(hotel);
        String json = JSON.toJSONString(hotelDoc);

        IndexRequest request = new IndexRequest("hotel");
        request.id(hotelDoc.getId().toString());
        request.source(json, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 根据id获取文档<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-get.html
     * 
     * @throws IOException
     */
    @Test
    void testGetDocumentById() throws IOException {
        GetRequest request = new GetRequest("hotel", "36934");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        String json = response.getSourceAsString();
        HotelDoc hotelDoc = JSON.parseObject(json, HotelDoc.class);
        System.out.println(hotelDoc);
    }

    /**
     * 更新文档-增量修改<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-update.html
     */
    @Test
    void testUpdateDocument() throws IOException {
        // 1.准备Request
        UpdateRequest request = new UpdateRequest("hotel", "36934");
        // 2.准备参数
        request.doc("price", "870");
        // 3.发送请求
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 删除文档<br/>
     * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-document-delete.html
     * 
     * @throws IOException
     */
    @Test
    void testDeleteDocument() throws IOException {
        // 1.准备Request
        DeleteRequest request = new DeleteRequest("hotel", "36934");
        // 2.发送请求
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }

    /**
     * 批量导入数据<br/>
     *
     */
    @Test
    void testBulk() throws IOException {
        // 查询所有的酒店数据
        List<Hotel> list = iHotelService.list();

        // 1.准备Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数
        for (Hotel hotel : list) {
            // 2.1.转为HotelDoc
            HotelDoc hotelDoc = new HotelDoc(hotel);
            // 2.2.转json
            String json = JSON.toJSONString(hotelDoc);
            // 2.3.添加请求
            request.add(new IndexRequest("hotel").id(hotel.getId().toString()).source(json, XContentType.JSON));
        }

        // 3.发送请求
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response);
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
