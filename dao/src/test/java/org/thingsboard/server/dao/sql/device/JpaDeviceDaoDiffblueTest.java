package org.thingsboard.server.dao.sql.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
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
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.DeviceInfo;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceEntity;
import org.thingsboard.server.dao.model.sql.DeviceInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDeviceDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaDeviceDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private DeviceProfileRepository deviceProfileRepository;

  @MockBean
  private DeviceRepository deviceRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDeviceDao jpaDeviceDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private NativeDeviceRepository nativeDeviceRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDeviceDao#getEntityClass()}
   *   <li>{@link JpaDeviceDao#getEntityType()}
   *   <li>{@link JpaDeviceDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaDeviceDao jpaDeviceDao = new JpaDeviceDao();

    // Act
    Class<DeviceEntity> actualEntityClass = jpaDeviceDao.getEntityClass();
    EntityType actualEntityType = jpaDeviceDao.getEntityType();

    // Assert
    assertNull(jpaDeviceDao.getRepository());
    assertEquals(EntityType.DEVICE, actualEntityType);
    Class<DeviceEntity> expectedEntityClass = DeviceEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link DeviceInfo#DeviceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDeviceInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindDeviceInfoById_thenReturnDeviceInfo() {
    // Arrange
    DeviceInfoEntity deviceInfoEntity = mock(DeviceInfoEntity.class);
    DeviceInfo deviceInfo = new DeviceInfo();
    when(deviceInfoEntity.toData()).thenReturn(deviceInfo);
    doNothing().when(deviceInfoEntity).setCreatedTime(anyLong());
    doNothing().when(deviceInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setVersion(Mockito.<Long>any());
    doNothing().when(deviceInfoEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(deviceInfoEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setDeviceData(Mockito.<JsonNode>any());
    doNothing().when(deviceInfoEntity).setDeviceProfileId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setFirmwareId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setLabel(Mockito.<String>any());
    doNothing().when(deviceInfoEntity).setName(Mockito.<String>any());
    doNothing().when(deviceInfoEntity).setSoftwareId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(deviceInfoEntity).setType(Mockito.<String>any());
    doNothing().when(deviceInfoEntity).setActive(anyBoolean());
    doNothing().when(deviceInfoEntity).setCustomerIsPublic(anyBoolean());
    doNothing().when(deviceInfoEntity).setCustomerTitle(Mockito.<String>any());
    doNothing().when(deviceInfoEntity).setDeviceProfileName(Mockito.<String>any());
    deviceInfoEntity.setActive(true);
    deviceInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setCreatedTime(1L);
    deviceInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setCustomerIsPublic(true);
    deviceInfoEntity.setCustomerTitle("Dr");
    deviceInfoEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setDeviceProfileName("foo.txt");
    deviceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setLabel("Label");
    deviceInfoEntity.setName("Name");
    deviceInfoEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceInfoEntity.setType("Type");
    deviceInfoEntity.setUuid(ModelConstants.NULL_UUID);
    deviceInfoEntity.setVersion(1L);
    when(deviceRepository.findDeviceInfoById(Mockito.<UUID>any())).thenReturn(deviceInfoEntity);

    // Act
    DeviceInfo actualFindDeviceInfoByIdResult = jpaDeviceDao.findDeviceInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(deviceInfoEntity).setCreatedTime(eq(1L));
    verify(deviceInfoEntity).setId(isA(UUID.class));
    verify(deviceInfoEntity).setUuid(isA(UUID.class));
    verify(deviceInfoEntity).setVersion(eq(1L));
    verify(deviceInfoEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(deviceInfoEntity).setCustomerId(isA(UUID.class));
    verify(deviceInfoEntity).setDeviceData(isA(JsonNode.class));
    verify(deviceInfoEntity).setDeviceProfileId(isA(UUID.class));
    verify(deviceInfoEntity).setExternalId(isA(UUID.class));
    verify(deviceInfoEntity).setFirmwareId(isA(UUID.class));
    verify(deviceInfoEntity).setLabel(eq("Label"));
    verify(deviceInfoEntity).setName(eq("Name"));
    verify(deviceInfoEntity).setSoftwareId(isA(UUID.class));
    verify(deviceInfoEntity).setTenantId(isA(UUID.class));
    verify(deviceInfoEntity).setType(eq("Type"));
    verify(deviceInfoEntity).setActive(eq(true));
    verify(deviceInfoEntity).setCustomerIsPublic(eq(true));
    verify(deviceInfoEntity).setCustomerTitle(eq("Dr"));
    verify(deviceInfoEntity).setDeviceProfileName(eq("foo.txt"));
    verify(deviceInfoEntity).toData();
    verify(deviceRepository).findDeviceInfoById(isA(UUID.class));
    assertSame(deviceInfo, actualFindDeviceInfoByIdResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID,
        new PageLink(3, 1, "Text Search"));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId2() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID,
        new PageLink(3, 1, ""));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId3() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, deviceProfileId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then calls {@link DeviceRepository#findByTenantId(UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantId_whenFirst_page_thenCallsFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdResult = jpaDeviceDao.findDevicesByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   * <ul>
   *   <li>Given {@link DeviceEntity#DeviceEntity()} DeviceData is Instance.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  public void testFindDevicesByIds_givenDeviceEntityDeviceDataIsInstance_thenReturnSizeIsOne() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);

    ArrayList<DeviceEntity> deviceEntityList = new ArrayList<>();
    deviceEntityList.add(deviceEntity);
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any())).thenReturn(deviceEntityList);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(new ArrayList<>());

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertEquals(1, actualFindDevicesByIdsResult.size());
    Device getResult = actualFindDevicesByIdsResult.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, customerId.getId());
    assertSame(uuidId, deviceProfileId.getId());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  public void testFindDevicesByIds_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnEmpty() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  public void testFindDevicesByIds_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnEmpty2() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(deviceIds);

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIds(List)}
   */
  @Test
  public void testFindDevicesByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(deviceRepository.findDevicesByIdIn(Mockito.<List<UUID>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Device> actualFindDevicesByIdsResult = jpaDeviceDao.findDevicesByIds(new ArrayList<>());

    // Assert
    verify(deviceRepository).findDevicesByIdIn(isA(List.class));
    assertTrue(actualFindDevicesByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  public void testFindDevicesByIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult = jpaDeviceDao.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  public void testFindDevicesByIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult = jpaDeviceDao.findDevicesByIdsAsync(deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDevicesByIdsAsync(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDevicesByIdsAsync(List)}
   */
  @Test
  public void testFindDevicesByIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByIdsAsyncResult = jpaDeviceDao
        .findDevicesByIdsAsync(new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId2.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, deviceProfileId.getId());
    assertSame(customerId, externalId.getId());
    assertSame(customerId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdResult = jpaDeviceDao.findDevicesByTenantIdAndCustomerId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndProfileId() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID profileId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndProfileId(ModelConstants.NULL_UUID, profileId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(profileId, getResult.getUuidId());
    assertSame(profileId, customerId.getId());
    assertSame(profileId, deviceProfileId.getId());
    assertSame(profileId, externalId.getId());
    assertSame(profileId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndProfileId_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndProfileIdResult = jpaDeviceDao.findDevicesByTenantIdAndProfileId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  public void testFindDevicesIdsByDeviceProfileTransportType_givenOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findIdsByDeviceProfileTransportType(Mockito.<DeviceTransportType>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult = jpaDeviceDao
        .findDevicesIdsByDeviceProfileTransportType(DeviceTransportType.DEFAULT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findIdsByDeviceProfileTransportType(eq(DeviceTransportType.DEFAULT), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalPages());
    assertFalse(actualFindDevicesIdsByDeviceProfileTransportTypeResult.hasNext());
    assertTrue(actualFindDevicesIdsByDeviceProfileTransportTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesIdsByDeviceProfileTransportType(DeviceTransportType, PageLink)}
   */
  @Test
  public void testFindDevicesIdsByDeviceProfileTransportType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findIdsByDeviceProfileTransportType(Mockito.<DeviceTransportType>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<UUID> actualFindDevicesIdsByDeviceProfileTransportTypeResult = jpaDeviceDao
        .findDevicesIdsByDeviceProfileTransportType(DeviceTransportType.DEFAULT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findIdsByDeviceProfileTransportType(eq(DeviceTransportType.DEFAULT), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesIdsByDeviceProfileTransportTypeResult.getTotalPages());
    assertFalse(actualFindDevicesIdsByDeviceProfileTransportTypeResult.hasNext());
    assertTrue(actualFindDevicesIdsByDeviceProfileTransportTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> deviceIds = new ArrayList<>();
    deviceIds.add(ModelConstants.NULL_UUID);
    deviceIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, deviceIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindDevicesByTenantIdCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Device>> actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult = jpaDeviceDao
        .findDevicesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDevicesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDeviceByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindDeviceByTenantIdAndName() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Device> actualFindDeviceByTenantIdAndNameResult = jpaDeviceDao.findDeviceByTenantIdAndName(tenantId,
        "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Device getResult = actualFindDeviceByTenantIdAndNameResult.get();
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualFindDeviceByTenantIdAndNameResult.isPresent());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, deviceProfileId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = jpaDeviceDao.findDevicesByTenantIdAndType(tenantId,
        "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, deviceProfileId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndFirmwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = jpaDeviceDao
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndTypeAndFirmwareIdIsNull(isA(UUID.class), isA(UUID.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_givenOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = jpaDeviceDao
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.SOFTWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndTypeAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnDataSizeIsOne() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(2L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setName("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(2L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID deviceProfileId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = jpaDeviceDao
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.NULL_UUID, deviceProfileId,
            OtaPackageType.SOFTWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndTypeAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getType());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId2 = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId2.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId2.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(deviceProfileId, getResult.getUuidId());
    assertSame(deviceProfileId, customerId.getId());
    assertSame(deviceProfileId, deviceProfileId2.getId());
    assertSame(deviceProfileId, externalId.getId());
    assertSame(deviceProfileId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndTypeAndEmptyOtaPackage(UUID, UUID, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndTypeAndEmptyOtaPackage_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndTypeAndSoftwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult = jpaDeviceDao
        .findDevicesByTenantIdAndTypeAndEmptyOtaPackage(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.SOFTWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndTypeAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndTypeAndEmptyOtaPackageResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}
   */
  @Test
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage() {
    // Arrange
    when(
        deviceRepository.countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = jpaDeviceDao
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.FIRMWARE);

    // Assert
    verify(deviceRepository).countByTenantIdAndDeviceProfileIdAndFirmwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test
   * {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(UUID, UUID, OtaPackageType)}
   */
  @Test
  public void testCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage2() {
    // Arrange
    when(
        deviceRepository.countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(1L);

    // Act
    Long actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult = jpaDeviceDao
        .countDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackage(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            OtaPackageType.SOFTWARE);

    // Assert
    verify(deviceRepository).countByTenantIdAndDeviceProfileIdAndSoftwareIdIsNull(isA(UUID.class), isA(UUID.class));
    assertEquals(1L, actualCountDevicesByTenantIdAndDeviceProfileIdAndEmptyOtaPackageResult.longValue());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, customerId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId2.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, deviceProfileId.getId());
    assertSame(customerId, externalId.getId());
    assertSame(customerId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(deviceRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndCustomerIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findTenantDeviceTypesAsync(UUID)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#findTenantDeviceTypesAsync(UUID)}
   */
  @Test
  public void testFindTenantDeviceTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantDeviceTypesAsyncResult = jpaDeviceDao
        .findTenantDeviceTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantDeviceTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantDeviceTypesAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDeviceByTenantIdAndIdAsync(TenantId, UUID)}
   */
  @Test
  public void testFindDeviceByTenantIdAndIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Device> actualFindDeviceByTenantIdAndIdAsyncResult = jpaDeviceDao
        .findDeviceByTenantIdAndIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindDeviceByTenantIdAndIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindDeviceByTenantIdAndIdAsyncResult);
  }

  /**
   * Test {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#countDevicesByDeviceProfileId(TenantId, UUID)}
   */
  @Test
  public void testCountDevicesByDeviceProfileId() {
    // Arrange
    when(deviceRepository.countByDeviceProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountDevicesByDeviceProfileIdResult = jpaDeviceDao
        .countDevicesByDeviceProfileId(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(deviceRepository).countByDeviceProfileId(isA(UUID.class));
    assertEquals(1L, actualCountDevicesByDeviceProfileIdResult.longValue());
  }

  /**
   * Test {@link JpaDeviceDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(deviceRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaDeviceDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(2L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setName("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(2L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getType());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, customerId.getId());
    assertSame(edgeId, deviceProfileId.getId());
    assertSame(edgeId, externalId.getId());
    assertSame(edgeId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(2L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setName("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(2L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdResult = jpaDeviceDao.findDevicesByTenantIdAndEdgeId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnDataSizeIsOne() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(2L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setName("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("org.thingsboard.server.dao.model.sql.DeviceEntity");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(2L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, edgeId, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.DeviceEntity", getResult.getType());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, customerId.getId());
    assertSame(edgeId, deviceProfileId.getId());
    assertSame(edgeId, externalId.getId());
    assertSame(edgeId, firmwareId.getId());
  }

  /**
   * Test
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findDevicesByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindDevicesByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(deviceRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindDevicesByTenantIdAndEdgeIdAndTypeResult = jpaDeviceDao
        .findDevicesByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindDevicesByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(nativeDeviceRepository.findDeviceIdInfos(Mockito.<Pageable>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = jpaDeviceDao.findDeviceIdInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(nativeDeviceRepository).findDeviceIdInfos(isA(Pageable.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findDeviceIdInfos(PageLink)}
   */
  @Test
  public void testFindDeviceIdInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(nativeDeviceRepository.findDeviceIdInfos(Mockito.<Pageable>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceIdInfo> actualFindDeviceIdInfosResult = jpaDeviceDao
        .findDeviceIdInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(nativeDeviceRepository).findDeviceIdInfos(isA(Pageable.class));
    assertSame(actualFindDeviceIdInfosResult.EMPTY_PAGE_DATA, actualFindDeviceIdInfosResult);
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDeviceDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndExternalIdResult = jpaDeviceDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID,
        externalId);

    // Assert
    verify(deviceRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    JsonNode additionalInfo = actualFindByTenantIdAndExternalIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualFindByTenantIdAndExternalIdResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = actualFindByTenantIdAndExternalIdResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId2.getEntityType());
    DeviceProfileId deviceProfileId = actualFindByTenantIdAndExternalIdResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = actualFindByTenantIdAndExternalIdResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertEquals(firmwareId, actualFindByTenantIdAndExternalIdResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, customerId.getId());
    assertSame(externalId, deviceProfileId.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(MissingNode.getInstance());
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    when(deviceRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(deviceEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Device actualFindByTenantIdAndNameResult = jpaDeviceDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(deviceRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    JsonNode additionalInfo = actualFindByTenantIdAndNameResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualFindByTenantIdAndNameResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = actualFindByTenantIdAndNameResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = actualFindByTenantIdAndNameResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = actualFindByTenantIdAndNameResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertEquals(firmwareId, actualFindByTenantIdAndNameResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, deviceProfileId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID,
        new PageLink(3, 1, ""));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Device getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(getResult.getDeviceDataBytes());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(getResult.getDeviceData());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    DeviceId externalId = getResult.getExternalId();
    assertEquals(EntityType.DEVICE, externalId.getEntityType());
    DeviceProfileId deviceProfileId = getResult.getDeviceProfileId();
    assertEquals(EntityType.DEVICE_PROFILE, deviceProfileId.getEntityType());
    OtaPackageId firmwareId = getResult.getFirmwareId();
    assertEquals(EntityType.OTA_PACKAGE, firmwareId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(customerId.isNullUid());
    assertTrue(deviceProfileId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(firmwareId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertEquals(firmwareId, getResult.getSoftwareId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, deviceProfileId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firmwareId.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnNotDataFirstTenantIdNullUid() {
    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(-1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(null);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("42");
    deviceEntity.setName("42");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    deviceEntity.setTenantId(tenantId);
    deviceEntity.setType("42");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(-1L);

    ArrayList<DeviceEntity> content = new ArrayList<>();
    content.add(deviceEntity);
    PageImpl<DeviceEntity> pageImpl = new PageImpl<>(content);
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink, atLeast(1)).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Device> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    TenantId tenantId2 = data.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then calls {@link DeviceRepository#findByTenantId(UUID, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenCallsFindByTenantId() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link PageLink#PageLink(int, int, String)} with pageSize is three
   * and page is one and {@code Text Search}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenPageLinkWithPageSizeIsThreeAndPageIsOneAndTextSearch() {
    // Arrange
    when(deviceRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Device> actualFindByTenantIdResult = jpaDeviceDao.findByTenantId(ModelConstants.NULL_UUID,
        new PageLink(3, 1, "Text Search"));

    // Assert
    verify(deviceRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with
   * {@code DeviceId}.
   * <p>
   * Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceId() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DeviceId internalId = mock(DeviceId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DeviceId actualExternalIdByInternal = jpaDeviceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DEVICE, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with
   * {@code DeviceId}.
   * <ul>
   *   <li>Then return {@link DeviceId#DeviceId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceId_thenReturnDeviceIdWithIdIsNull_uuid() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DeviceId internalId = new DeviceId(ModelConstants.NULL_UUID);

    // Act
    DeviceId actualExternalIdByInternal = jpaDeviceDao.getExternalIdByInternal(internalId);

    // Assert
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)} with
   * {@code DeviceId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDeviceDao#getExternalIdByInternal(DeviceId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDeviceId_thenReturnNull() {
    // Arrange
    when(deviceRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DeviceId actualExternalIdByInternal = jpaDeviceDao.getExternalIdByInternal(new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
