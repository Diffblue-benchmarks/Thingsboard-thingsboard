package org.thingsboard.server.queue.usagestats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.SchedulerComponent;

@ContextConfiguration(classes = {DefaultTbApiUsageReportClient.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultTbApiUsageReportClientDiffblueTest {
  @Autowired
  private DefaultTbApiUsageReportClient defaultTbApiUsageReportClient;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private SchedulerComponent schedulerComponent;

  @MockBean
  private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   * with {@code tenantId}, {@code customerId}, {@code key}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey) with 'tenantId', 'customerId', 'key'")
  void testReportWithTenantIdCustomerIdKey() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId, customerId, ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", customerId.getId().toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   * with {@code tenantId}, {@code customerId}, {@code key}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey) with 'tenantId', 'customerId', 'key'")
  void testReportWithTenantIdCustomerIdKey2() {
    // Arrange
    TenantId tenantId = new TenantId(new UUID(1L, 1L));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId, customerId, ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    assertEquals("00000000-0000-0001-0000-000000000001", tenantId.getId().toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", customerId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}
   * with {@code tenantId}, {@code customerId}, {@code key}, {@code value}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey, long) with 'tenantId', 'customerId', 'key', 'value'")
  void testReportWithTenantIdCustomerIdKeyValue() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId,
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ApiUsageRecordKey.TRANSPORT_MSG_COUNT,
        42L);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}
   * with {@code tenantId}, {@code customerId}, {@code key}, {@code value}.
   * <ul>
   *   <li>When {@code ACTIVE_DEVICES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey, long)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey, long) with 'tenantId', 'customerId', 'key', 'value'; when 'ACTIVE_DEVICES'")
  void testReportWithTenantIdCustomerIdKeyValue_whenActiveDevices() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId,
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), ApiUsageRecordKey.ACTIVE_DEVICES, 42L);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   * with {@code tenantId}, {@code customerId}, {@code key}.
   * <ul>
   *   <li>When {@code ACTIVE_DEVICES}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey) with 'tenantId', 'customerId', 'key'; when 'ACTIVE_DEVICES'")
  void testReportWithTenantIdCustomerIdKey_whenActiveDevices() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId, customerId, ApiUsageRecordKey.ACTIVE_DEVICES);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", customerId.getId().toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   * with {@code tenantId}, {@code customerId}, {@code key}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey) with 'tenantId', 'customerId', 'key'; when 'null'")
  void testReportWithTenantIdCustomerIdKey_whenNull() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(null, customerId, ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", customerId.getId().toString());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   * with {@code tenantId}, {@code customerId}, {@code key}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageReportClient#report(TenantId, CustomerId, ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test report(TenantId, CustomerId, ApiUsageRecordKey) with 'tenantId', 'customerId', 'key'; when TenantId(UUID) with id is randomUUID")
  void testReportWithTenantIdCustomerIdKey_whenTenantIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbApiUsageReportClient.report(tenantId, customerId, ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", customerId.getId().toString());
  }
}
