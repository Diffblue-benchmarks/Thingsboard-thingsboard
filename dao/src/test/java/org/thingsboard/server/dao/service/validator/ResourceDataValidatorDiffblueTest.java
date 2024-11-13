package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.TenantEntityWithDataDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.TbResourceDao;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.widget.WidgetTypeDao;

@ContextConfiguration(classes = {ResourceDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class ResourceDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private ResourceDataValidator resourceDataValidator;

  @MockBean
  private TbResourceDao tbResourceDao;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private WidgetTypeDao widgetTypeDao;

  /**
   * Test {@link ResourceDataValidator#validateCreate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateCreate(TenantId, TbResource)}
   */
  @Test
  public void testValidateCreateWithTenantIdTbResource_givenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    resourceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, resource);

    // Assert that nothing has changed
    verify(resource, atLeast(1)).getData();
  }

  /**
   * Test {@link ResourceDataValidator#validateCreate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateCreate(TenantId, TbResource)}
   */
  @Test
  public void testValidateCreateWithTenantIdTbResource_givenEmptyArrayOfByte() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(new byte[]{});

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource, atLeast(1)).getData();
  }

  /**
   * Test {@link ResourceDataValidator#validateCreate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateCreate(TenantId, TbResource)}
   */
  @Test
  public void testValidateCreateWithTenantIdTbResource_whenTbResource() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new TbResource()));
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code JS_MODULE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTbResource_givenJsModule() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.JS_MODULE);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult = resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTbResource_givenLwm2mModel() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult = resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTbResource_givenLwm2mModel_whenNull() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    TbResource actualValidateUpdateResult = resourceDataValidator.validateUpdate(null, resource);

    // Assert
    verify(resource).getData();
    verify(resource).getResourceType();
    assertSame(resource, actualValidateUpdateResult);
  }

  /**
   * Test {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)} with
   * {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()}.</li>
   *   <li>Then return {@link TbResource#TbResource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateUpdate(TenantId, TbResource)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTbResource_whenTbResource_thenReturnTbResource() {
    // Arrange
    TbResource resource = new TbResource();

    // Act and Assert
    assertSame(resource, resourceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, resource));
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn(null);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_givenEmptyString() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("");
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code Resource Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_givenResourceKey() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act
    resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>Given {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_givenSlash() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("/");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource} {@link TbResource#getData()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_whenTbResourceGetDataReturnNull() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act
    resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource);

    // Assert
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource} {@link TbResourceInfo#getFileName()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_whenTbResourceGetFileNameReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn(null);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(resource.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
    verify(resource, atLeast(1)).getData();
    verify(resource).getFileName();
    verify(resource).getId();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   * with {@code TenantId}, {@code TbResource}.
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDataImpl(TenantId, TbResource)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTbResource_whenTbResourceTitleIsDr() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setTitle("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, resource));
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(ModelConstants.NULL_UUID), 3L);

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(tbResourceDao.getResourceSize(Mockito.<TenantId>any(), Mockito.<TbResourceId>any())).thenReturn(3L);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(ModelConstants.NULL_UUID), 3L);

    // Assert
    verify(tbResourceDao).getResourceSize(isA(TenantId.class), isA(TbResourceId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <ul>
   *   <li>Then calls
   * {@link TenantEntityWithDataDao#sumDataSizeByTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize_thenCallsSumDataSizeByTenantId() {
    // Arrange
    when(tbResourceDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);
    when(tbResourceDao.getResourceSize(Mockito.<TenantId>any(), Mockito.<TbResourceId>any())).thenReturn(3L);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(1L)
        .maxCustomers(1L)
        .maxDPStorageDays(1L)
        .maxDashboards(1L)
        .maxDevices(1L)
        .maxEmails(1L)
        .maxJSExecutions(1L)
        .maxOtaPackagesInBytes(1L)
        .maxREExecutions(1L)
        .maxResourceSize(3L)
        .maxResourcesInBytes(1L)
        .maxRuleChains(1L)
        .maxRuleNodeExecutionsPerMessage(3)
        .maxSms(1L)
        .maxTbelExecutions(1L)
        .maxTransportDataPoints(1L)
        .maxTransportMessages(1L)
        .maxUsers(1L)
        .maxWsSessionsPerCustomer(3)
        .maxWsSessionsPerPublicUser(3)
        .maxWsSessionsPerRegularUser(3)
        .maxWsSessionsPerTenant(3)
        .maxWsSubscriptionsPerCustomer(1L)
        .maxWsSubscriptionsPerPublicUser(1L)
        .maxWsSubscriptionsPerRegularUser(1L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    when(tenantProfile.getDefaultProfileConfiguration()).thenReturn(buildResult);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(ModelConstants.NULL_UUID), 3L);

    // Assert
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tbResourceDao).sumDataSizeByTenantId(isA(TenantId.class));
    verify(tbResourceDao).getResourceSize(isA(TenantId.class), isA(TbResourceId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize_thenThrowDataValidationException() {
    // Arrange
    when(tbResourceDao.getResourceSize(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(ModelConstants.NULL_UUID), 3L));
    verify(tbResourceDao).getResourceSize(isA(TenantId.class), isA(TbResourceId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize_thenThrowIllegalArgumentException() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(1L)
        .maxCustomers(1L)
        .maxDPStorageDays(1L)
        .maxDashboards(1L)
        .maxDevices(1L)
        .maxEmails(1L)
        .maxJSExecutions(1L)
        .maxOtaPackagesInBytes(1L)
        .maxREExecutions(1L)
        .maxResourceSize(1L)
        .maxResourcesInBytes(1L)
        .maxRuleChains(1L)
        .maxRuleNodeExecutionsPerMessage(3)
        .maxSms(1L)
        .maxTbelExecutions(1L)
        .maxTransportDataPoints(1L)
        .maxTransportMessages(1L)
        .maxUsers(1L)
        .maxWsSessionsPerCustomer(3)
        .maxWsSessionsPerPublicUser(3)
        .maxWsSessionsPerRegularUser(3)
        .maxWsSessionsPerTenant(3)
        .maxWsSubscriptionsPerCustomer(1L)
        .maxWsSubscriptionsPerPublicUser(1L)
        .maxWsSubscriptionsPerRegularUser(1L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    when(tenantProfile.getDefaultProfileConfiguration()).thenReturn(buildResult);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> resourceDataValidator.validateResourceSize(tenantId, new TbResourceId(ModelConstants.NULL_UUID), 3L));
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}.
   * <ul>
   *   <li>When {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateResourceSize(TenantId, TbResourceId, long)}
   */
  @Test
  public void testValidateResourceSize_whenTbResourceId() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    resourceDataValidator.validateResourceSize(tenantId, mock(TbResourceId.class), 3L);

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  public void testValidateDelete() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDelete(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(widgetTypeDao).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  public void testValidateDelete_givenArrayListAddWidgetTypeDetails() {
    // Arrange
    ArrayList<WidgetTypeDetails> widgetTypeDetailsList = new ArrayList<>();
    widgetTypeDetailsList.add(new WidgetTypeDetails());
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsList);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceDataValidator.validateDelete(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(widgetTypeDao).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeDao#findWidgetTypesInfosByTenantIdAndResourceId(UUID, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}
   */
  @Test
  public void testValidateDelete_thenCallsFindWidgetTypesInfosByTenantIdAndResourceId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesInfosByTenantIdAndResourceId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    resourceDataValidator.validateDelete(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(widgetTypeDao).findWidgetTypesInfosByTenantIdAndResourceId(isA(UUID.class), isA(UUID.class));
  }
}
