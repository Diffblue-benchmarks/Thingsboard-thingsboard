package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.TenantNotFoundException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.HashPartitionService.QueueConfig;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {HashPartitionService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class HashPartitionServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private HashPartitionService hashPartitionService;

  @MockBean
  private QueueRoutingInfoService queueRoutingInfoService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TenantRoutingInfoService tenantRoutingInfoService;

  @MockBean
  private TopicService topicService;

  /**
   * Test {@link HashPartitionService#init()}.
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init()")
  void testInit() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queueRoutingInfo.getPartitions()).thenReturn(1);
    when(queueRoutingInfo.getQueueName()).thenReturn("Queue Name");
    when(queueRoutingInfo.getQueueTopic()).thenReturn("Queue Topic");
    when(queueRoutingInfo.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<QueueRoutingInfo> queueRoutingInfoList = new ArrayList<>();
    queueRoutingInfoList.add(queueRoutingInfo);
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(queueRoutingInfoList);

    // Act
    hashPartitionService.init();

    // Assert
    verify(queueRoutingInfo).getPartitions();
    verify(queueRoutingInfo).getQueueName();
    verify(queueRoutingInfo).getQueueTopic();
    verify(queueRoutingInfo).getTenantId();
    verify(queueRoutingInfo).isDuplicateMsgToAllPartitions();
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Given {@link QueueRoutingInfo} {@link QueueRoutingInfo#getTenantId()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); given QueueRoutingInfo getTenantId() return 'null'")
  void testInit_givenQueueRoutingInfoGetTenantIdReturnNull() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queueRoutingInfo.getPartitions()).thenReturn(1);
    when(queueRoutingInfo.getQueueName()).thenReturn("Queue Name");
    when(queueRoutingInfo.getQueueTopic()).thenReturn("Queue Topic");
    when(queueRoutingInfo.getTenantId()).thenReturn(null);

    ArrayList<QueueRoutingInfo> queueRoutingInfoList = new ArrayList<>();
    queueRoutingInfoList.add(queueRoutingInfo);
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(queueRoutingInfoList);

    // Act
    hashPartitionService.init();

    // Assert
    verify(queueRoutingInfo).getPartitions();
    verify(queueRoutingInfo).getQueueName();
    verify(queueRoutingInfo).getQueueTopic();
    verify(queueRoutingInfo).getTenantId();
    verify(queueRoutingInfo).isDuplicateMsgToAllPartitions();
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#getServiceType()} return
   * {@code tb-transport}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); given TbServiceInfoProvider getServiceType() return 'tb-transport'")
  void testInit_givenTbServiceInfoProviderGetServiceTypeReturnTbTransport() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("tb-transport");

    // Act
    hashPartitionService.init();

    // Assert
    verify(tbServiceInfoProvider).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Given {@link UUID#UUID(long, long)} with one and one.</li>
   *   <li>Then calls {@link QueueRoutingInfo#isDuplicateMsgToAllPartitions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); given UUID(long, long) with one and one; then calls isDuplicateMsgToAllPartitions()")
  void testInit_givenUuidWithOneAndOne_thenCallsIsDuplicateMsgToAllPartitions() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queueRoutingInfo.getPartitions()).thenReturn(1);
    when(queueRoutingInfo.getQueueName()).thenReturn("Queue Name");
    when(queueRoutingInfo.getQueueTopic()).thenReturn("Queue Topic");
    when(queueRoutingInfo.getTenantId()).thenReturn(new TenantId(new UUID(1L, 1L)));

    ArrayList<QueueRoutingInfo> queueRoutingInfoList = new ArrayList<>();
    queueRoutingInfoList.add(queueRoutingInfo);
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(queueRoutingInfoList);

    // Act
    hashPartitionService.init();

    // Assert
    verify(queueRoutingInfo).getPartitions();
    verify(queueRoutingInfo).getQueueName();
    verify(queueRoutingInfo).getQueueTopic();
    verify(queueRoutingInfo).getTenantId();
    verify(queueRoutingInfo).isDuplicateMsgToAllPartitions();
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Then calls
   * {@link QueueRoutingInfoService#getAllQueuesRoutingInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls getAllQueuesRoutingInfo()")
  void testInit_thenCallsGetAllQueuesRoutingInfo() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(new ArrayList<>());

    // Act
    hashPartitionService.init();

    // Assert
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw IllegalArgumentException")
  void testInit_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.getPartitions()).thenThrow(new IllegalArgumentException("murmur3_128"));
    when(queueRoutingInfo.getQueueName()).thenReturn("Queue Name");
    when(queueRoutingInfo.getQueueTopic()).thenReturn("Queue Topic");
    when(queueRoutingInfo.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<QueueRoutingInfo> queueRoutingInfoList = new ArrayList<>();
    queueRoutingInfoList.add(queueRoutingInfo);
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(queueRoutingInfoList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> hashPartitionService.init());
    verify(queueRoutingInfo).getPartitions();
    verify(queueRoutingInfo).getQueueName();
    verify(queueRoutingInfo).getQueueTopic();
    verify(queueRoutingInfo).getTenantId();
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw IllegalArgumentException")
  void testInit_thenThrowIllegalArgumentException2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.getPartitions()).thenThrow(new IllegalArgumentException("murmur3_128"));
    when(queueRoutingInfo.getQueueName()).thenReturn("Queue Name");
    when(queueRoutingInfo.getQueueTopic()).thenReturn("Queue Topic");
    when(queueRoutingInfo.getTenantId()).thenReturn(null);

    ArrayList<QueueRoutingInfo> queueRoutingInfoList = new ArrayList<>();
    queueRoutingInfoList.add(queueRoutingInfo);
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(queueRoutingInfoList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> hashPartitionService.init());
    verify(queueRoutingInfo).getPartitions();
    verify(queueRoutingInfo).getQueueName();
    verify(queueRoutingInfo).getQueueTopic();
    verify(queueRoutingInfo).getTenantId();
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#init()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw RuntimeException")
  void testInit_thenThrowRuntimeException() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenThrow(new RuntimeException("murmur3_128"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService.init());
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#partitionsInit()}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#getServiceType()} return
   * {@code Service Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#partitionsInit()}
   */
  @Test
  @DisplayName("Test partitionsInit(); given TbServiceInfoProvider getServiceType() return 'Service Type'")
  void testPartitionsInit_givenTbServiceInfoProviderGetServiceTypeReturnServiceType() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("Service Type");

    // Act
    hashPartitionService.partitionsInit();

    // Assert that nothing has changed
    verify(tbServiceInfoProvider).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#partitionsInit()}.
   * <ul>
   *   <li>Then calls
   * {@link QueueRoutingInfoService#getAllQueuesRoutingInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#partitionsInit()}
   */
  @Test
  @DisplayName("Test partitionsInit(); then calls getAllQueuesRoutingInfo()")
  void testPartitionsInit_thenCallsGetAllQueuesRoutingInfo() {
    // Arrange
    when(tbServiceInfoProvider.getServiceType()).thenReturn("tb-transport");
    when(queueRoutingInfoService.getAllQueuesRoutingInfo()).thenReturn(new ArrayList<>());

    // Act
    hashPartitionService.partitionsInit();

    // Assert that nothing has changed
    verify(queueRoutingInfoService).getAllQueuesRoutingInfo();
    verify(tbServiceInfoProvider, atLeast(1)).getServiceType();
  }

  /**
   * Test {@link HashPartitionService#getMyPartitions(QueueKey)}.
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType, Queue)} with type is
   * {@code TB_CORE} and queue is {@link Queue#Queue()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#getMyPartitions(QueueKey)}
   */
  @Test
  @DisplayName("Test getMyPartitions(QueueKey); when QueueKey(ServiceType, Queue) with type is 'TB_CORE' and queue is Queue(); then return 'null'")
  void testGetMyPartitions_whenQueueKeyWithTypeIsTbCoreAndQueueIsQueue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(hashPartitionService.getMyPartitions(new QueueKey(ServiceType.TB_CORE, new Queue())));
  }

  /**
   * Test {@link HashPartitionService#getMyPartitions(QueueKey)}.
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#getMyPartitions(QueueKey)}
   */
  @Test
  @DisplayName("Test getMyPartitions(QueueKey); when QueueKey(ServiceType) with type is 'TB_CORE'; then return 'null'")
  void testGetMyPartitions_whenQueueKeyWithTypeIsTbCore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(hashPartitionService.getMyPartitions(new QueueKey(ServiceType.TB_CORE)));
  }

  /**
   * Test {@link HashPartitionService#getMyPartitions(QueueKey)}.
   * <ul>
   *   <li>When {@link QueueKey}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#getMyPartitions(QueueKey)}
   */
  @Test
  @DisplayName("Test getMyPartitions(QueueKey); when QueueKey; then return 'null'")
  void testGetMyPartitions_whenQueueKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(hashPartitionService.getMyPartitions(mock(QueueKey.class)));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and
   * {@link QueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashPartitionService.QueueConfig#equals(Object)}
   *   <li>{@link HashPartitionService.QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object), and hashCode(); when other is equal; then return equal")
  void testQueueConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashPartitionService.QueueConfig queueConfig = new HashPartitionService.QueueConfig(
        new QueueRoutingInfo(new Queue()));
    HashPartitionService.QueueConfig queueConfig2 = new HashPartitionService.QueueConfig(
        new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig2);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig2.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and
   * {@link QueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HashPartitionService.QueueConfig#equals(Object)}
   *   <li>{@link HashPartitionService.QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object), and hashCode(); when other is same; then return equal")
  void testQueueConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HashPartitionService.QueueConfig queueConfig = new HashPartitionService.QueueConfig(
        new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService.QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is different; then return not equal")
  void testQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getName()).thenReturn("Name");
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(queue.getId()).thenReturn(null);
    HashPartitionService.QueueConfig queueConfig = new HashPartitionService.QueueConfig(new QueueRoutingInfo(queue));

    // Act and Assert
    assertNotEquals(queueConfig, new HashPartitionService.QueueConfig(new QueueRoutingInfo(new Queue())));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService.QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is 'null'; then return not equal")
  void testQueueConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HashPartitionService.QueueConfig(new QueueRoutingInfo(new Queue())), null);
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService.QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is wrong type; then return not equal")
  void testQueueConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HashPartitionService.QueueConfig(new QueueRoutingInfo(new Queue())),
        "Different type to QueueConfig");
  }

  /**
   * Test QueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link HashPartitionService.QueueConfig#setDuplicateMsgToAllPartitions(boolean)}
   *   <li>{@link HashPartitionService.QueueConfig#toString()}
   *   <li>{@link HashPartitionService.QueueConfig#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig getters and setters")
  void testQueueConfigGettersAndSetters() {
    // Arrange
    HashPartitionService.QueueConfig queueConfig = new HashPartitionService.QueueConfig(
        new QueueRoutingInfo(new Queue()));

    // Act
    queueConfig.setDuplicateMsgToAllPartitions(true);
    String actualToStringResult = queueConfig.toString();

    // Assert that nothing has changed
    assertEquals("HashPartitionService.QueueConfig(duplicateMsgToAllPartitions=true)", actualToStringResult);
    assertTrue(queueConfig.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test QueueConfig {@link QueueConfig#QueueConfig(QueueRoutingInfo)}.
   * <ul>
   *   <li>Then return not DuplicateMsgToAllPartitions.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService.QueueConfig#QueueConfig(QueueRoutingInfo)}
   */
  @Test
  @DisplayName("Test QueueConfig new QueueConfig(QueueRoutingInfo); then return not DuplicateMsgToAllPartitions")
  void testQueueConfigNewQueueConfig_thenReturnNotDuplicateMsgToAllPartitions() {
    // Arrange, Act and Assert
    assertFalse(
        (new HashPartitionService.QueueConfig(new QueueRoutingInfo(new Queue()))).isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link HashPartitionService#updateQueues(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#updateQueues(List)}
   */
  @Test
  @DisplayName("Test updateQueues(List); given 'null'; when ArrayList() add 'null'")
  @Disabled("TODO: Complete this test")
  void testUpdateQueues_givenNull_whenArrayListAddNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.thingsboard.server.gen.transport.TransportProtos$QueueUpdateMsg.getTenantIdMSB()" because "queueUpdateMsg" is null
    //       at org.thingsboard.server.queue.discovery.QueueRoutingInfo.<init>(QueueRoutingInfo.java:57)
    //       at org.thingsboard.server.queue.discovery.HashPartitionService.updateQueues(HashPartitionService.java:189)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ArrayList<TransportProtos.QueueUpdateMsg> queueUpdateMsgs = new ArrayList<>();
    queueUpdateMsgs.add(null);

    // Act
    hashPartitionService.updateQueues(queueUpdateMsgs);
  }

  /**
   * Test {@link HashPartitionService#updateQueues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#updateQueues(List)}
   */
  @Test
  @DisplayName("Test updateQueues(List); when ArrayList()")
  void testUpdateQueues_whenArrayList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    hashPartitionService.updateQueues(new ArrayList<>());
  }

  /**
   * Test {@link HashPartitionService#removeQueues(List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeQueues(List)}
   */
  @Test
  @DisplayName("Test removeQueues(List); given DefaultInstance; when ArrayList() add DefaultInstance")
  void testRemoveQueues_givenDefaultInstance_whenArrayListAddDefaultInstance() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    ArrayList<TransportProtos.QueueDeleteMsg> queueDeleteMsgs = new ArrayList<>();
    queueDeleteMsgs.add(TransportProtos.QueueDeleteMsg.getDefaultInstance());

    // Act
    hashPartitionService.removeQueues(queueDeleteMsgs);

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#removeQueues(List)}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#isService(ServiceType)} return
   * {@code false}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeQueues(List)}
   */
  @Test
  @DisplayName("Test removeQueues(List); given TbServiceInfoProvider isService(ServiceType) return 'false'; when ArrayList()")
  void testRemoveQueues_givenTbServiceInfoProviderIsServiceReturnFalse_whenArrayList() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(false);

    // Act
    hashPartitionService.removeQueues(new ArrayList<>());

    // Assert that nothing has changed
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#removeQueues(List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeQueues(List)}
   */
  @Test
  @DisplayName("Test removeQueues(List); then throw RuntimeException")
  void testRemoveQueues_thenThrowRuntimeException() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService.removeQueues(new ArrayList<>()));
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#removeQueues(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link TbServiceInfoProvider#isService(ServiceType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeQueues(List)}
   */
  @Test
  @DisplayName("Test removeQueues(List); when ArrayList(); then calls isService(ServiceType)")
  void testRemoveQueues_whenArrayList_thenCallsIsService() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    // Act
    hashPartitionService.removeQueues(new ArrayList<>());

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#removeTenant(TenantId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeTenant(TenantId)}
   */
  @Test
  @DisplayName("Test removeTenant(TenantId); when 'null'")
  @Disabled("TODO: Complete this test")
  void testRemoveTenant_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "org.thingsboard.server.common.data.id.TenantId.equals(Object)" because "tenantId" is null
    //       at org.thingsboard.server.queue.discovery.HashPartitionService.lambda$removeTenant$5(HashPartitionService.java:221)
    //       at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    //       at java.base/java.util.concurrent.ConcurrentHashMap$KeySpliterator.forEachRemaining(ConcurrentHashMap.java:3573)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:575)
    //       at java.base/java.util.stream.AbstractPipeline.evaluateToArrayNode(AbstractPipeline.java:260)
    //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:616)
    //       at java.base/java.util.stream.ReferencePipeline.toArray(ReferencePipeline.java:622)
    //       at java.base/java.util.stream.ReferencePipeline.toList(ReferencePipeline.java:627)
    //       at org.thingsboard.server.queue.discovery.HashPartitionService.removeTenant(HashPartitionService.java:221)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    hashPartitionService.removeTenant(null);
  }

  /**
   * Test {@link HashPartitionService#removeTenant(TenantId)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is fromString
   * {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#removeTenant(TenantId)}
   */
  @Test
  @DisplayName("Test removeTenant(TenantId); when TenantId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  void testRemoveTenant_whenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    hashPartitionService.removeTenant(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link HashPartitionService#isManagedByCurrentService(TenantId)}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#isService(ServiceType)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#isManagedByCurrentService(TenantId)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentService(TenantId); given TbServiceInfoProvider isService(ServiceType) return 'false'")
  void testIsManagedByCurrentService_givenTbServiceInfoProviderIsServiceReturnFalse() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(false);

    // Act
    boolean actualIsManagedByCurrentServiceResult = hashPartitionService
        .isManagedByCurrentService(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbServiceInfoProvider, atLeast(1)).isService(Mockito.<ServiceType>any());
    assertTrue(actualIsManagedByCurrentServiceResult);
  }

  /**
   * Test {@link HashPartitionService#isManagedByCurrentService(TenantId)}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#isService(ServiceType)} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#isManagedByCurrentService(TenantId)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentService(TenantId); given TbServiceInfoProvider isService(ServiceType) return 'true'")
  void testIsManagedByCurrentService_givenTbServiceInfoProviderIsServiceReturnTrue() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    // Act
    boolean actualIsManagedByCurrentServiceResult = hashPartitionService
        .isManagedByCurrentService(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_CORE));
    assertTrue(actualIsManagedByCurrentServiceResult);
  }

  /**
   * Test {@link HashPartitionService#isManagedByCurrentService(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#isManagedByCurrentService(TenantId)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentService(TenantId); then throw RuntimeException")
  void testIsManagedByCurrentService_thenThrowRuntimeException() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService
        .isManagedByCurrentService(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_CORE));
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService hashPartitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> hashPartitionService.resolve(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService hashPartitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolve(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'")
  @Disabled("TODO: Complete this test")
  void testResolveWithServiceTypeQueueNameTenantIdEntityId3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Invalid UUID string: 42
    //       at java.base/java.util.UUID.fromString1(UUID.java:280)
    //       at java.base/java.util.UUID.fromString(UUID.java:258)
    //       at org.thingsboard.server.common.data.id.AlarmId.fromString(AlarmId.java:36)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    hashPartitionService.resolve(ServiceType.TB_CORE, "Queue Name", tenantId, AlarmId.fromString("42"));
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(ServiceType.TB_CORE, "Queue Name", tenantId,
        null, 1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(eq("${queue.core.topic}"));
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition2() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(null, "Queue Name", tenantId, null, 1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(isNull());
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition3() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(ServiceType.TB_CORE, null, tenantId, null, 1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(eq("${queue.core.topic}"));
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition4() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenThrow(new RuntimeException("Main"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService.resolve(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, 1));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(eq("${queue.core.topic}"));
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'; when empty string")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition_whenEmptyString() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(ServiceType.TB_CORE, "", tenantId, null, 1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(eq("${queue.core.topic}"));
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <ul>
   *   <li>When {@code Main}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'; when 'Main'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition_whenMain() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(ServiceType.TB_CORE, "Main", tenantId, null,
        1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(eq("${queue.core.topic}"));
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}, {@code partition}.
   * <ul>
   *   <li>When {@code TB_RULE_ENGINE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId, Integer)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId, Integer) with 'serviceType', 'queueName', 'tenantId', 'entityId', 'partition'; when 'TB_RULE_ENGINE'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityIdPartition_whenTbRuleEngine() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualResolveResult = hashPartitionService.resolve(ServiceType.TB_RULE_ENGINE, "Queue Name",
        tenantId, null, 1);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    verify(topicService).buildTopicName(isNull());
    assertEquals("Build Topic Name", actualResolveResult.getTopic());
    assertEquals("Build Topic Name.1", actualResolveResult.getFullTopicName());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualResolveResult.isMyPartition());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    TenantId expectedGetResult = tenantId.SYS_TENANT_ID;
    assertSame(expectedGetResult, tenantId2.get());
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   * with {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then calls
   * {@link TenantRoutingInfoService#getRoutingInfo(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then calls getRoutingInfo(TenantId)")
  void testResolveWithServiceTypeTenantIdEntityId_thenCallsGetRoutingInfo() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolve(ServiceType.TB_CORE, tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   * with {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then throw {@link TenantNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then throw TenantNotFoundException")
  void testResolveWithServiceTypeTenantIdEntityId_thenThrowTenantNotFoundException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolve(ServiceType.TB_CORE, tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   * with {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; when 'null'")
  void testResolveWithServiceTypeTenantIdEntityId_whenNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolve(null, tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   * with {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>When {@code TB_RULE_ENGINE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; when 'TB_RULE_ENGINE'")
  void testResolveWithServiceTypeTenantIdEntityId_whenTbRuleEngine() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolve(ServiceType.TB_RULE_ENGINE, tenantId,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link TenantRoutingInfoService}.</li>
   *   <li>When fromString {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolveAll(ServiceType, String, TenantId, EntityId); given TenantRoutingInfoService; when fromString '42'")
  @Disabled("TODO: Complete this test")
  void testResolveAll_givenTenantRoutingInfoService_whenFromString42() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Invalid UUID string: 42
    //       at java.base/java.util.UUID.fromString1(UUID.java:280)
    //       at java.base/java.util.UUID.fromString(UUID.java:258)
    //       at org.thingsboard.server.common.data.id.AlarmId.fromString(AlarmId.java:36)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    hashPartitionService.resolveAll(ServiceType.TB_CORE, "Queue Name", tenantId, AlarmId.fromString("42"));
  }

  /**
   * Test
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolveAll(ServiceType, String, TenantId, EntityId); then throw IllegalStateException")
  void testResolveAll_thenThrowIllegalStateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService hashPartitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> hashPartitionService.resolveAll(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link TenantNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolveAll(ServiceType, String, TenantId, EntityId); then throw TenantNotFoundException")
  void testResolveAll_thenThrowTenantNotFoundException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService hashPartitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    // Act and Assert
    assertThrows(TenantNotFoundException.class, () -> hashPartitionService.resolveAll(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link HashPartitionService#isMyPartition(ServiceType, TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#isMyPartition(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test isMyPartition(ServiceType, TenantId, EntityId); then return 'false'")
  void testIsMyPartition_thenReturnFalse() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenThrow(new TenantNotFoundException(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Act
    boolean actualIsMyPartitionResult = hashPartitionService.isMyPartition(ServiceType.TB_CORE,
        new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    assertFalse(actualIsMyPartitionResult);
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  void testRecalculatePartitions_givenDefaultInstance_whenArrayListAddDefaultInstance() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());

    // Act
    hashPartitionService.recalculatePartitions(currentService, otherServices);

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * <ul>
   *   <li>Given DefaultInstance.</li>
   *   <li>When {@link ArrayList#ArrayList()} add DefaultInstance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); given DefaultInstance; when ArrayList() add DefaultInstance")
  void testRecalculatePartitions_givenDefaultInstance_whenArrayListAddDefaultInstance2() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    ArrayList<TransportProtos.ServiceInfo> otherServices = new ArrayList<>();
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());
    otherServices.add(TransportProtos.ServiceInfo.getDefaultInstance());

    // Act
    hashPartitionService.recalculatePartitions(currentService, otherServices);

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#isService(ServiceType)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); given TbServiceInfoProvider isService(ServiceType) return 'false'")
  void testRecalculatePartitions_givenTbServiceInfoProviderIsServiceReturnFalse() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(false);
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); then throw RuntimeException")
  void testRecalculatePartitions_thenThrowRuntimeException() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any()))
        .thenThrow(new RuntimeException("Recalculating partitions"));
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> hashPartitionService.recalculatePartitions(currentService, new ArrayList<>()));
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link TbServiceInfoProvider#isService(ServiceType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#recalculatePartitions(TransportProtos.ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); when ArrayList(); then calls isService(ServiceType)")
  void testRecalculatePartitions_whenArrayList_thenCallsIsService() {
    // Arrange
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);
    TransportProtos.ServiceInfo currentService = TransportProtos.ServiceInfo.getDefaultInstance();

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(tbServiceInfoProvider).isService(eq(ServiceType.TB_RULE_ENGINE));
  }

  /**
   * Test {@link HashPartitionService#getAllServiceIds(ServiceType)}.
   * <p>
   * Method under test: {@link HashPartitionService#getAllServiceIds(ServiceType)}
   */
  @Test
  @DisplayName("Test getAllServiceIds(ServiceType)")
  void testGetAllServiceIds() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService.getAllServiceIds(ServiceType.TB_CORE));
    verify(tbServiceInfoProvider).getServiceInfo();
  }

  /**
   * Test {@link HashPartitionService#getAllServices(ServiceType)}.
   * <p>
   * Method under test: {@link HashPartitionService#getAllServices(ServiceType)}
   */
  @Test
  @DisplayName("Test getAllServices(ServiceType)")
  void testGetAllServices() {
    // Arrange
    when(tbServiceInfoProvider.getServiceInfo()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hashPartitionService.getAllServices(ServiceType.TB_CORE));
    verify(tbServiceInfoProvider).getServiceInfo();
  }

  /**
   * Test {@link HashPartitionService#getOtherServices(ServiceType)}.
   * <p>
   * Method under test: {@link HashPartitionService#getOtherServices(ServiceType)}
   */
  @Test
  @DisplayName("Test getOtherServices(ServiceType)")
  void testGetOtherServices() {
    // Arrange, Act and Assert
    assertTrue(hashPartitionService.getOtherServices(ServiceType.TB_CORE).isEmpty());
  }

  /**
   * Test {@link HashPartitionService#resolvePartitionIndex(UUID, int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolvePartitionIndex(UUID, int)}
   */
  @Test
  @DisplayName("Test resolvePartitionIndex(UUID, int); then return zero")
  void testResolvePartitionIndex_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0,
        hashPartitionService.resolvePartitionIndex(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link HashPartitionService#evictTenantInfo(TenantId)}.
   * <p>
   * Method under test: {@link HashPartitionService#evictTenantInfo(TenantId)}
   */
  @Test
  @DisplayName("Test evictTenantInfo(TenantId)")
  void testEvictTenantInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    hashPartitionService.evictTenantInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link HashPartitionService#evictTenantInfo(TenantId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#evictTenantInfo(TenantId)}
   */
  @Test
  @DisplayName("Test evictTenantInfo(TenantId); when 'null'")
  @Disabled("TODO: Complete this test")
  void testEvictTenantInfo_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
    //       at java.base/java.util.concurrent.ConcurrentHashMap.replaceNode(ConcurrentHashMap.java:1111)
    //       at java.base/java.util.concurrent.ConcurrentHashMap.remove(ConcurrentHashMap.java:1102)
    //       at org.thingsboard.server.queue.discovery.HashPartitionService.evictTenantInfo(HashPartitionService.java:508)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    hashPartitionService.evictTenantInfo(null);
  }

  /**
   * Test {@link HashPartitionService#countTransportsByType(String)}.
   * <p>
   * Method under test: {@link HashPartitionService#countTransportsByType(String)}
   */
  @Test
  @DisplayName("Test countTransportsByType(String)")
  void testCountTransportsByType() {
    // Arrange, Act and Assert
    assertEquals(0, hashPartitionService.countTransportsByType("Type"));
  }

  /**
   * Test
   * {@link HashPartitionService#getIsolatedOrSystemTenantId(ServiceType, TenantId)}.
   * <ul>
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#getIsolatedOrSystemTenantId(ServiceType, TenantId)}
   */
  @Test
  @DisplayName("Test getIsolatedOrSystemTenantId(ServiceType, TenantId); then return SYS_TENANT_ID")
  void testGetIsolatedOrSystemTenantId_thenReturnSys_tenant_id() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(
        new TenantRoutingInfo(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null, true));

    // Act
    TenantId actualIsolatedOrSystemTenantId = hashPartitionService.getIsolatedOrSystemTenantId(ServiceType.TB_CORE,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    assertSame(actualIsolatedOrSystemTenantId.SYS_TENANT_ID, actualIsolatedOrSystemTenantId);
  }

  /**
   * Test
   * {@link HashPartitionService#getIsolatedOrSystemTenantId(ServiceType, TenantId)}.
   * <ul>
   *   <li>When {@code TB_RULE_ENGINE}.</li>
   *   <li>Then calls
   * {@link TenantRoutingInfoService#getRoutingInfo(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#getIsolatedOrSystemTenantId(ServiceType, TenantId)}
   */
  @Test
  @DisplayName("Test getIsolatedOrSystemTenantId(ServiceType, TenantId); when 'TB_RULE_ENGINE'; then calls getRoutingInfo(TenantId)")
  void testGetIsolatedOrSystemTenantId_whenTbRuleEngine_thenCallsGetRoutingInfo() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenThrow(new RuntimeException("foo"));

    // Act
    hashPartitionService.getIsolatedOrSystemTenantId(ServiceType.TB_RULE_ENGINE,
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>Then calls {@link QueueKey#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); then calls getTenantId()")
  void testResolveByPartitionIdx_thenCallsGetTenantId() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    servers.add(TransportProtos.ServiceInfo.getDefaultInstance());
    QueueKey queueKey = mock(QueueKey.class);
    when(queueKey.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(queueKey.getType()).thenReturn(ServiceType.TB_CORE);

    // Act
    TransportProtos.ServiceInfo actualResolveByPartitionIdxResult = hashPartitionService.resolveByPartitionIdx(servers,
        queueKey, 1, new HashMap<>());

    // Assert
    verify(queueKey).getTenantId();
    verify(queueKey).getType();
    Descriptors.Descriptor descriptorForType = actualResolveByPartitionIdxResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.SystemInfoProto systemInfo = actualResolveByPartitionIdxResult.getSystemInfo();
    Descriptors.Descriptor descriptorForType2 = systemInfo.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(178);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(179);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(4);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult4.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualResolveByPartitionIdxResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, systemInfo.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList assignedTenantProfilesList = actualResolveByPartitionIdxResult.getAssignedTenantProfilesList();
    assertSame(assignedTenantProfilesList, defaultInstanceForType.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult3.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult2.getReservedNameList());
    assertSame(assignedTenantProfilesList, defaultInstanceForType2.getDependencyList());
    assertSame(assignedTenantProfilesList, toProtoResult.getDependencyList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getServiceTypesList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getTransportsList());
    assertSame(systemInfo, actualResolveByPartitionIdxResult.getSystemInfoOrBuilder());
    assertSame(systemInfo, systemInfo.getDefaultInstanceForType());
    assertSame(actualResolveByPartitionIdxResult, actualResolveByPartitionIdxResult.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); when ArrayList(); then return 'null'")
  void testResolveByPartitionIdx_whenArrayList_thenReturnNull() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act and Assert
    assertNull(hashPartitionService.resolveByPartitionIdx(servers, queueKey, 1, new HashMap<>()));
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); when QueueKey(ServiceType) with type is 'TB_CORE'")
  void testResolveByPartitionIdx_whenQueueKeyWithTypeIsTbCore() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    servers.add(TransportProtos.ServiceInfo.getDefaultInstance());
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act
    TransportProtos.ServiceInfo actualResolveByPartitionIdxResult = hashPartitionService.resolveByPartitionIdx(servers,
        queueKey, 1, new HashMap<>());

    // Assert
    Descriptors.Descriptor descriptorForType = actualResolveByPartitionIdxResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.SystemInfoProto systemInfo = actualResolveByPartitionIdxResult.getSystemInfo();
    Descriptors.Descriptor descriptorForType2 = systemInfo.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(178);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(179);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(4);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult4.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualResolveByPartitionIdxResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, systemInfo.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList assignedTenantProfilesList = actualResolveByPartitionIdxResult.getAssignedTenantProfilesList();
    assertSame(assignedTenantProfilesList, defaultInstanceForType.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult3.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult2.getReservedNameList());
    assertSame(assignedTenantProfilesList, defaultInstanceForType2.getDependencyList());
    assertSame(assignedTenantProfilesList, toProtoResult.getDependencyList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getServiceTypesList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getTransportsList());
    assertSame(systemInfo, actualResolveByPartitionIdxResult.getSystemInfoOrBuilder());
    assertSame(systemInfo, systemInfo.getDefaultInstanceForType());
    assertSame(actualResolveByPartitionIdxResult, actualResolveByPartitionIdxResult.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_CORE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); when QueueKey(ServiceType) with type is 'TB_CORE'")
  void testResolveByPartitionIdx_whenQueueKeyWithTypeIsTbCore2() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    servers.add(TransportProtos.ServiceInfo.getDefaultInstance());
    servers.add(TransportProtos.ServiceInfo.getDefaultInstance());
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);

    // Act
    TransportProtos.ServiceInfo actualResolveByPartitionIdxResult = hashPartitionService.resolveByPartitionIdx(servers,
        queueKey, 1, new HashMap<>());

    // Assert
    Descriptors.Descriptor descriptorForType = actualResolveByPartitionIdxResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.SystemInfoProto systemInfo = actualResolveByPartitionIdxResult.getSystemInfo();
    Descriptors.Descriptor descriptorForType2 = systemInfo.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(178);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(179);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(4);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult4.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualResolveByPartitionIdxResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, systemInfo.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList assignedTenantProfilesList = actualResolveByPartitionIdxResult.getAssignedTenantProfilesList();
    assertSame(assignedTenantProfilesList, defaultInstanceForType.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult3.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult2.getReservedNameList());
    assertSame(assignedTenantProfilesList, defaultInstanceForType2.getDependencyList());
    assertSame(assignedTenantProfilesList, toProtoResult.getDependencyList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getServiceTypesList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getTransportsList());
    assertSame(systemInfo, actualResolveByPartitionIdxResult.getSystemInfoOrBuilder());
    assertSame(systemInfo, systemInfo.getDefaultInstanceForType());
    assertSame(actualResolveByPartitionIdxResult, actualResolveByPartitionIdxResult.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType)} with type is
   * {@code TB_RULE_ENGINE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); when QueueKey(ServiceType) with type is 'TB_RULE_ENGINE'")
  void testResolveByPartitionIdx_whenQueueKeyWithTypeIsTbRuleEngine() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    servers.add(TransportProtos.ServiceInfo.getDefaultInstance());
    QueueKey queueKey = new QueueKey(ServiceType.TB_RULE_ENGINE);

    // Act
    TransportProtos.ServiceInfo actualResolveByPartitionIdxResult = hashPartitionService.resolveByPartitionIdx(servers,
        queueKey, 1, new HashMap<>());

    // Assert
    Descriptors.Descriptor descriptorForType = actualResolveByPartitionIdxResult.getDescriptorForType();
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    DescriptorProtos.DescriptorProto toProtoResult2 = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult2.getFieldList();
    assertEquals(5, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(5, fields.size());
    DescriptorProtos.DescriptorProto defaultInstanceForType = toProtoResult2.getDefaultInstanceForType();
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult2.getFieldOrBuilderList());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult.getMessageTypeOrBuilderList());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult.getSourceCodeInfo();
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    Descriptors.FieldDescriptor getResult = fields.get(0);
    DescriptorProtos.FieldOptions options3 = getResult.getOptions();
    assertSame(features, options3.getFeatures());
    assertSame(features, options3.getFeaturesOrBuilder());
    assertSame(features, defaultInstanceForType3.getFeatures());
    assertSame(features, options.getFeatures());
    assertSame(features, defaultInstanceForType3.getFeaturesOrBuilder());
    assertSame(features, options.getFeaturesOrBuilder());
    assertSame(features, options2.getFeaturesOrBuilder());
    TransportProtos.SystemInfoProto systemInfo = actualResolveByPartitionIdxResult.getSystemInfo();
    Descriptors.Descriptor descriptorForType2 = systemInfo.getDescriptorForType();
    assertSame(file, descriptorForType2.getFile());
    Descriptors.Descriptor getResult2 = messageTypes.get(178);
    assertSame(file, getResult2.getFile());
    Descriptors.Descriptor getResult3 = messageTypes.get(179);
    assertSame(file, getResult3.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult.getFile());
    Descriptors.FieldDescriptor getResult4 = fields.get(1);
    assertSame(file, getResult4.getFile());
    Descriptors.FieldDescriptor getResult5 = fields.get(3);
    assertSame(file, getResult5.getFile());
    Descriptors.FieldDescriptor getResult6 = fields.get(4);
    assertSame(file, getResult6.getFile());
    DescriptorProtos.MessageOptions options4 = options2.getDescriptorForType().getOptions();
    assertSame(options4, defaultInstanceForType.getOptions());
    DescriptorProtos.DescriptorProto toProtoResult3 = descriptorForType2.toProto();
    assertSame(options4, toProtoResult3.getOptions());
    assertSame(options4, toProtoResult2.getOptions());
    assertSame(options4, defaultInstanceForType.getOptionsOrBuilder());
    assertSame(options4, toProtoResult3.getOptionsOrBuilder());
    assertSame(options4, toProtoResult2.getOptionsOrBuilder());
    assertSame(options4, options4);
    assertSame(options4, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options4, options.getDescriptorForType().getOptions());
    assertSame(options4, toProtoResult.getDescriptorForType().getOptions());
    assertSame(options4, descriptorForType2.getOptions());
    assertSame(options4, getResult2.getOptions());
    assertSame(options4, getResult3.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    DescriptorProtos.FieldDescriptorProto toProtoResult4 = getResult.toProto();
    assertSame(options3, toProtoResult4.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult5 = getResult4.toProto();
    assertSame(options3, toProtoResult5.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult6 = getResult5.toProto();
    assertSame(options3, toProtoResult6.getOptions());
    DescriptorProtos.FieldDescriptorProto toProtoResult7 = getResult6.toProto();
    assertSame(options3, toProtoResult7.getOptions());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult7.getOptionsOrBuilder());
    assertSame(options3, options3.getDefaultInstanceForType());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(toProtoResult4, fieldList.get(0));
    assertSame(descriptorForType2, getResult5.getMessageType());
    assertSame(descriptorForType2, messageTypes.get(1));
    assertSame(descriptorForType, getResult.getContainingType());
    assertSame(descriptorForType, getResult4.getContainingType());
    assertSame(descriptorForType, getResult5.getContainingType());
    assertSame(descriptorForType, getResult6.getContainingType());
    assertSame(descriptorForType, messageTypes.get(0));
    UnknownFieldSet unknownFields = actualResolveByPartitionIdxResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, options3.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult7.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, systemInfo.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    ProtocolStringList assignedTenantProfilesList = actualResolveByPartitionIdxResult.getAssignedTenantProfilesList();
    assertSame(assignedTenantProfilesList, defaultInstanceForType.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult3.getReservedNameList());
    assertSame(assignedTenantProfilesList, toProtoResult2.getReservedNameList());
    assertSame(assignedTenantProfilesList, defaultInstanceForType2.getDependencyList());
    assertSame(assignedTenantProfilesList, toProtoResult.getDependencyList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getServiceTypesList());
    assertSame(assignedTenantProfilesList, actualResolveByPartitionIdxResult.getTransportsList());
    assertSame(systemInfo, actualResolveByPartitionIdxResult.getSystemInfoOrBuilder());
    assertSame(systemInfo, systemInfo.getDefaultInstanceForType());
    assertSame(actualResolveByPartitionIdxResult, actualResolveByPartitionIdxResult.getDefaultInstanceForType());
  }

  /**
   * Test
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}.
   * <ul>
   *   <li>When {@link QueueKey}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HashPartitionService#resolveByPartitionIdx(List, QueueKey, int, Map)}
   */
  @Test
  @DisplayName("Test resolveByPartitionIdx(List, QueueKey, int, Map); when QueueKey; then return 'null'")
  void testResolveByPartitionIdx_whenQueueKey_thenReturnNull() {
    // Arrange
    ArrayList<TransportProtos.ServiceInfo> servers = new ArrayList<>();
    QueueKey queueKey = mock(QueueKey.class);

    // Act and Assert
    assertNull(hashPartitionService.resolveByPartitionIdx(servers, queueKey, 1, new HashMap<>()));
  }

  /**
   * Test {@link HashPartitionService#forName(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then throw IllegalArgumentException")
  void testForName_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> HashPartitionService.forName("Name"));
  }
}
