package org.thingsboard.server.dao.sql.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaQueueDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaQueueDao jpaQueueDao;

  @MockBean
  private QueueRepository queueRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaQueueDao#getEntityClass()}
   *   <li>{@link JpaQueueDao#getEntityType()}
   *   <li>{@link JpaQueueDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaQueueDao jpaQueueDao = new JpaQueueDao();

    // Act
    Class<QueueEntity> actualEntityClass = jpaQueueDao.getEntityClass();
    EntityType actualEntityType = jpaQueueDao.getEntityType();

    // Assert
    assertNull(jpaQueueDao.getRepository());
    assertEquals(EntityType.QUEUE, actualEntityType);
    Class<QueueEntity> expectedEntityClass = QueueEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaQueueDao#findQueueByTenantIdAndTopic(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueDao#findQueueByTenantIdAndTopic(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndTopic_thenReturnQueue() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueRepository.findByTenantIdAndTopic(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(queueEntity);

    // Act
    Queue actualFindQueueByTenantIdAndTopicResult = jpaQueueDao
        .findQueueByTenantIdAndTopic(ModelConstants.SYSTEM_TENANT, "Topic");

    // Assert
    verify(queueEntity).setCreatedTime(eq(1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("Name"));
    verify(queueEntity).setPackProcessingTimeout(eq(1L));
    verify(queueEntity).setPartitions(eq(1));
    verify(queueEntity).setPollInterval(eq(42));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("Topic"));
    verify(queueEntity).toData();
    verify(queueRepository).findByTenantIdAndTopic(isA(UUID.class), eq("Topic"));
    assertSame(queue, actualFindQueueByTenantIdAndTopicResult);
  }

  /**
   * Test {@link JpaQueueDao#findQueueByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Given {@link QueueEntity} {@link QueueEntity#toData()} return
   * {@link Queue#Queue()}.</li>
   *   <li>Then return {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueDao#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName_givenQueueEntityToDataReturnQueue_thenReturnQueue() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(queueEntity);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = jpaQueueDao.findQueueByTenantIdAndName(ModelConstants.SYSTEM_TENANT,
        "Name");

    // Assert
    verify(queueEntity).setCreatedTime(eq(1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("Name"));
    verify(queueEntity).setPackProcessingTimeout(eq(1L));
    verify(queueEntity).setPartitions(eq(1));
    verify(queueEntity).setPollInterval(eq(42));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("Topic"));
    verify(queueEntity).toData();
    verify(queueRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link JpaQueueDao#findAllByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link QueueEntity} {@link QueueEntity#toData()} return
   * {@link Queue#Queue()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllByTenantId(TenantId)}
   */
  @Test
  public void testFindAllByTenantId_givenQueueEntityToDataReturnQueue_thenReturnSizeIsOne() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueEntity> queueEntityList = new ArrayList<>();
    queueEntityList.add(queueEntity);
    when(queueRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(queueEntityList);

    // Act
    List<Queue> actualFindAllByTenantIdResult = jpaQueueDao.findAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueEntity).setCreatedTime(eq(1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("Name"));
    verify(queueEntity).setPackProcessingTimeout(eq(1L));
    verify(queueEntity).setPartitions(eq(1));
    verify(queueEntity).setPollInterval(eq(42));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("Topic"));
    verify(queueEntity).toData();
    verify(queueRepository).findByTenantId(isA(UUID.class));
    assertEquals(1, actualFindAllByTenantIdResult.size());
    assertSame(queue, actualFindAllByTenantIdResult.get(0));
  }

  /**
   * Test {@link JpaQueueDao#findAllByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllByTenantId(TenantId)}
   */
  @Test
  public void testFindAllByTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllByTenantIdResult = jpaQueueDao.findAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueRepository).findByTenantId(isA(UUID.class));
    assertTrue(actualFindAllByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findAllMainQueues()}.
   * <ul>
   *   <li>Given {@link QueueEntity} {@link QueueEntity#toData()} return
   * {@link Queue#Queue()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllMainQueues()}
   */
  @Test
  public void testFindAllMainQueues_givenQueueEntityToDataReturnQueue_thenReturnSizeIsOne() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Main");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Main");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueEntity> queueEntityList = new ArrayList<>();
    queueEntityList.add(queueEntity);
    when(queueRepository.findAllByName(Mockito.<String>any())).thenReturn(queueEntityList);

    // Act
    List<Queue> actualFindAllMainQueuesResult = jpaQueueDao.findAllMainQueues();

    // Assert
    verify(queueEntity).setCreatedTime(eq(1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("Main"));
    verify(queueEntity).setPackProcessingTimeout(eq(1L));
    verify(queueEntity).setPartitions(eq(1));
    verify(queueEntity).setPollInterval(eq(42));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("Main"));
    verify(queueEntity).toData();
    verify(queueRepository).findAllByName(eq("Main"));
    assertEquals(1, actualFindAllMainQueuesResult.size());
    assertSame(queue, actualFindAllMainQueuesResult.get(0));
  }

  /**
   * Test {@link JpaQueueDao#findAllMainQueues()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllMainQueues()}
   */
  @Test
  public void testFindAllMainQueues_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findAllByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllMainQueuesResult = jpaQueueDao.findAllMainQueues();

    // Assert
    verify(queueRepository).findAllByName(eq("Main"));
    assertTrue(actualFindAllMainQueuesResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findAllQueues()}.
   * <ul>
   *   <li>Given {@link QueueEntity} {@link QueueEntity#toData()} return
   * {@link Queue#Queue()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllQueues()}
   */
  @Test
  public void testFindAllQueues_givenQueueEntityToDataReturnQueue_thenReturnSizeIsOne() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("Name");
    queueEntity.setPackProcessingTimeout(1L);
    queueEntity.setPartitions(1);
    queueEntity.setPollInterval(42);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("Topic");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueEntity> queueEntityList = new ArrayList<>();
    queueEntityList.add(queueEntity);
    when(queueRepository.findAll()).thenReturn(queueEntityList);

    // Act
    List<Queue> actualFindAllQueuesResult = jpaQueueDao.findAllQueues();

    // Assert
    verify(queueRepository).findAll();
    verify(queueEntity).setCreatedTime(eq(1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("Name"));
    verify(queueEntity).setPackProcessingTimeout(eq(1L));
    verify(queueEntity).setPartitions(eq(1));
    verify(queueEntity).setPollInterval(eq(42));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("Topic"));
    verify(queueEntity).toData();
    assertEquals(1, actualFindAllQueuesResult.size());
    assertSame(queue, actualFindAllQueuesResult.get(0));
  }

  /**
   * Test {@link JpaQueueDao#findAllQueues()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueDao#findAllQueues()}
   */
  @Test
  public void testFindAllQueues_thenReturnEmpty() {
    // Arrange
    when(queueRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllQueuesResult = jpaQueueDao.findAllQueues();

    // Assert
    verify(queueRepository).findAll();
    assertTrue(actualFindAllQueuesResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = jpaQueueDao.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindQueuesByTenantIdResult.getTotalPages());
    assertFalse(actualFindQueuesByTenantIdResult.hasNext());
    assertTrue(actualFindQueuesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantId_thenReturnDataSizeIsOne() {
    // Arrange
    QueueEntity queueEntity = mock(QueueEntity.class);
    Queue queue = new Queue();
    when(queueEntity.toData()).thenReturn(queue);
    doNothing().when(queueEntity).setCreatedTime(anyLong());
    doNothing().when(queueEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setConsumerPerPartition(anyBoolean());
    doNothing().when(queueEntity).setName(Mockito.<String>any());
    doNothing().when(queueEntity).setPackProcessingTimeout(anyLong());
    doNothing().when(queueEntity).setPartitions(anyInt());
    doNothing().when(queueEntity).setPollInterval(anyInt());
    doNothing().when(queueEntity).setProcessingStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setSubmitStrategy(Mockito.<JsonNode>any());
    doNothing().when(queueEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(queueEntity).setTopic(Mockito.<String>any());
    queueEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setConsumerPerPartition(true);
    queueEntity.setCreatedTime(-1L);
    queueEntity.setId(ModelConstants.NULL_UUID);
    queueEntity.setName("42");
    queueEntity.setPackProcessingTimeout(-1L);
    queueEntity.setPartitions(-1);
    queueEntity.setPollInterval(0);
    queueEntity.setProcessingStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setSubmitStrategy(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    queueEntity.setTenantId(ModelConstants.NULL_UUID);
    queueEntity.setTopic("42");
    queueEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueEntity> content = new ArrayList<>();
    content.add(queueEntity);
    PageImpl<QueueEntity> pageImpl = new PageImpl<>(content);
    when(queueRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = jpaQueueDao.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueEntity).setCreatedTime(eq(-1L));
    verify(queueEntity).setId(isA(UUID.class));
    verify(queueEntity).setUuid(isA(UUID.class));
    verify(queueEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(queueEntity).setConsumerPerPartition(eq(true));
    verify(queueEntity).setName(eq("42"));
    verify(queueEntity).setPackProcessingTimeout(eq(-1L));
    verify(queueEntity).setPartitions(eq(-1));
    verify(queueEntity).setPollInterval(eq(0));
    verify(queueEntity).setProcessingStrategy(isA(JsonNode.class));
    verify(queueEntity).setSubmitStrategy(isA(JsonNode.class));
    verify(queueEntity).setTenantId(isA(UUID.class));
    verify(queueEntity).setTopic(eq("42"));
    verify(queueEntity).toData();
    verify(queueRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Queue> data = actualFindQueuesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertSame(queue, data.get(0));
  }

  /**
   * Test {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueDao#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = jpaQueueDao.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindQueuesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindQueuesByTenantIdResult.getTotalPages());
    assertFalse(actualFindQueuesByTenantIdResult.hasNext());
    assertTrue(actualFindQueuesByTenantIdResult.getData().isEmpty());
  }
}
