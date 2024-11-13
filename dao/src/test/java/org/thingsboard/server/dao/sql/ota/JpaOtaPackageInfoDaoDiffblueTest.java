package org.thingsboard.server.dao.sql.ota;

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
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OtaPackageInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOtaPackageInfoDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaOtaPackageInfoDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOtaPackageInfoDao jpaOtaPackageInfoDao;

  @MockBean
  private OtaPackageInfoRepository otaPackageInfoRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOtaPackageInfoDao#getEntityClass()}
   *   <li>{@link JpaOtaPackageInfoDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaOtaPackageInfoDao jpaOtaPackageInfoDao = new JpaOtaPackageInfoDao();

    // Act
    Class<OtaPackageInfoEntity> actualEntityClass = jpaOtaPackageInfoDao.getEntityClass();

    // Assert
    assertNull(jpaOtaPackageInfoDao.getRepository());
    Class<OtaPackageInfoEntity> expectedEntityClass = OtaPackageInfoEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOtaPackageInfoDao#findById(TenantId, UUID)}
   */
  @Test
  public void testFindById_thenReturnOtaPackageInfo() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = mock(OtaPackageInfoEntity.class);
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoEntity.toData()).thenReturn(otaPackageInfo);
    doNothing().when(otaPackageInfoEntity).setCreatedTime(anyLong());
    doNothing().when(otaPackageInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(otaPackageInfoEntity).setChecksum(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setChecksumAlgorithm(Mockito.<ChecksumAlgorithm>any());
    doNothing().when(otaPackageInfoEntity).setContentType(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setDataSize(Mockito.<Long>any());
    doNothing().when(otaPackageInfoEntity).setDeviceProfileId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setHasData(anyBoolean());
    doNothing().when(otaPackageInfoEntity).setTag(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setTitle(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setType(Mockito.<OtaPackageType>any());
    doNothing().when(otaPackageInfoEntity).setUrl(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setVersion(Mockito.<String>any());
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");
    when(otaPackageInfoRepository.findOtaPackageInfoById(Mockito.<UUID>any())).thenReturn(otaPackageInfoEntity);

    // Act
    OtaPackageInfo actualFindByIdResult = jpaOtaPackageInfoDao.findById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(otaPackageInfoEntity).setCreatedTime(eq(1L));
    verify(otaPackageInfoEntity).setId(isA(UUID.class));
    verify(otaPackageInfoEntity).setUuid(isA(UUID.class));
    verify(otaPackageInfoEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(otaPackageInfoEntity).setChecksum(eq("Checksum"));
    verify(otaPackageInfoEntity).setChecksumAlgorithm(eq(ChecksumAlgorithm.MD5));
    verify(otaPackageInfoEntity).setContentType(eq("text/plain"));
    verify(otaPackageInfoEntity).setDataSize(eq(3L));
    verify(otaPackageInfoEntity).setDeviceProfileId(isA(UUID.class));
    verify(otaPackageInfoEntity).setFileName(eq("foo.txt"));
    verify(otaPackageInfoEntity).setHasData(eq(true));
    verify(otaPackageInfoEntity).setTag(eq("Tag"));
    verify(otaPackageInfoEntity).setTenantId(isA(UUID.class));
    verify(otaPackageInfoEntity).setTitle(eq("Dr"));
    verify(otaPackageInfoEntity).setType(eq(OtaPackageType.FIRMWARE));
    verify(otaPackageInfoEntity).setUrl(eq("https://example.org/example"));
    verify(otaPackageInfoEntity).setVersion(eq("1.0.2"));
    verify(otaPackageInfoEntity).toData();
    verify(otaPackageInfoRepository).findOtaPackageInfoById(isA(UUID.class));
    assertSame(otaPackageInfo, actualFindByIdResult);
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(
        otaPackageInfoRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository).findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantId_thenReturnDataFirstIsOtaPackageInfo() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = mock(OtaPackageInfoEntity.class);
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoEntity.toData()).thenReturn(otaPackageInfo);
    doNothing().when(otaPackageInfoEntity).setCreatedTime(anyLong());
    doNothing().when(otaPackageInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(otaPackageInfoEntity).setChecksum(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setChecksumAlgorithm(Mockito.<ChecksumAlgorithm>any());
    doNothing().when(otaPackageInfoEntity).setContentType(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setDataSize(Mockito.<Long>any());
    doNothing().when(otaPackageInfoEntity).setDeviceProfileId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setHasData(anyBoolean());
    doNothing().when(otaPackageInfoEntity).setTag(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setTitle(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setType(Mockito.<OtaPackageType>any());
    doNothing().when(otaPackageInfoEntity).setUrl(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setVersion(Mockito.<String>any());
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("42");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.SHA384);
    otaPackageInfoEntity.setContentType("Content Type");
    otaPackageInfoEntity.setCreatedTime(-1L);
    otaPackageInfoEntity.setDataSize(0L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("com.fasterxml.jackson.databind.JsonNode");
    otaPackageInfoEntity.setHasData(true);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("42");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Prof");
    otaPackageInfoEntity.setType(OtaPackageType.FIRMWARE);
    otaPackageInfoEntity.setUrl("com.fasterxml.jackson.databind.JsonNode");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("com.fasterxml.jackson.databind.JsonNode");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    PageImpl<OtaPackageInfoEntity> pageImpl = new PageImpl<>(content);
    when(
        otaPackageInfoRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(otaPackageInfoEntity).setCreatedTime(eq(-1L));
    verify(otaPackageInfoEntity).setId(isA(UUID.class));
    verify(otaPackageInfoEntity).setUuid(isA(UUID.class));
    verify(otaPackageInfoEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(otaPackageInfoEntity).setChecksum(eq("42"));
    verify(otaPackageInfoEntity).setChecksumAlgorithm(eq(ChecksumAlgorithm.SHA384));
    verify(otaPackageInfoEntity).setContentType(eq("Content Type"));
    verify(otaPackageInfoEntity).setDataSize(eq(0L));
    verify(otaPackageInfoEntity).setDeviceProfileId(isA(UUID.class));
    verify(otaPackageInfoEntity).setFileName(eq("com.fasterxml.jackson.databind.JsonNode"));
    verify(otaPackageInfoEntity).setHasData(eq(true));
    verify(otaPackageInfoEntity).setTag(eq("42"));
    verify(otaPackageInfoEntity).setTenantId(isA(UUID.class));
    verify(otaPackageInfoEntity).setTitle(eq("Prof"));
    verify(otaPackageInfoEntity).setType(eq(OtaPackageType.FIRMWARE));
    verify(otaPackageInfoEntity).setUrl(eq("com.fasterxml.jackson.databind.JsonNode"));
    verify(otaPackageInfoEntity).setVersion(eq("com.fasterxml.jackson.databind.JsonNode"));
    verify(otaPackageInfoEntity).toData();
    verify(otaPackageInfoRepository).findAllByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<OtaPackageInfo> data = actualFindOtaPackageInfoByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(otaPackageInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(
        otaPackageInfoRepository.findAllByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoRepository).findAllByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<OtaPackageType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(ModelConstants.NULL_UUID), OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoRepository).findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(isA(UUID.class),
        isA(UUID.class), eq(OtaPackageType.FIRMWARE), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData2() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<OtaPackageType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileId).getId();
    verify(otaPackageInfoRepository).findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(isA(UUID.class),
        isA(UUID.class), eq(OtaPackageType.FIRMWARE), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData3() {
    // Arrange
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<OtaPackageType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(otaPackageInfoRepository).findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(isA(UUID.class),
        isA(UUID.class), eq(OtaPackageType.FIRMWARE), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalElements());
    assertEquals(1, actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getTotalPages());
    assertFalse(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.hasNext());
    assertTrue(actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData4() {
    // Arrange
    OtaPackageInfoEntity otaPackageInfoEntity = mock(OtaPackageInfoEntity.class);
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoEntity.toData()).thenReturn(otaPackageInfo);
    doNothing().when(otaPackageInfoEntity).setCreatedTime(anyLong());
    doNothing().when(otaPackageInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(otaPackageInfoEntity).setChecksum(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setChecksumAlgorithm(Mockito.<ChecksumAlgorithm>any());
    doNothing().when(otaPackageInfoEntity).setContentType(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setDataSize(Mockito.<Long>any());
    doNothing().when(otaPackageInfoEntity).setDeviceProfileId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setFileName(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setHasData(anyBoolean());
    doNothing().when(otaPackageInfoEntity).setTag(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(otaPackageInfoEntity).setTitle(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setType(Mockito.<OtaPackageType>any());
    doNothing().when(otaPackageInfoEntity).setUrl(Mockito.<String>any());
    doNothing().when(otaPackageInfoEntity).setVersion(Mockito.<String>any());
    otaPackageInfoEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    otaPackageInfoEntity.setChecksum("Checksum");
    otaPackageInfoEntity.setChecksumAlgorithm(ChecksumAlgorithm.MD5);
    otaPackageInfoEntity.setContentType("text/plain");
    otaPackageInfoEntity.setCreatedTime(1L);
    otaPackageInfoEntity.setDataSize(3L);
    otaPackageInfoEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setFileName("foo.txt");
    otaPackageInfoEntity.setHasData(false);
    otaPackageInfoEntity.setId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTag("Tag");
    otaPackageInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setTitle("Dr");
    otaPackageInfoEntity.setType(OtaPackageType.SOFTWARE);
    otaPackageInfoEntity.setUrl("https://example.org/example");
    otaPackageInfoEntity.setUuid(ModelConstants.NULL_UUID);
    otaPackageInfoEntity.setVersion("1.0.2");

    ArrayList<OtaPackageInfoEntity> content = new ArrayList<>();
    content.add(otaPackageInfoEntity);
    PageImpl<OtaPackageInfoEntity> pageImpl = new PageImpl<>(content);
    when(otaPackageInfoRepository.findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<OtaPackageType>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<OtaPackageInfo> actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = jpaOtaPackageInfoDao
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, deviceProfileId,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(deviceProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(otaPackageInfoEntity).setCreatedTime(eq(1L));
    verify(otaPackageInfoEntity).setId(isA(UUID.class));
    verify(otaPackageInfoEntity).setUuid(isA(UUID.class));
    verify(otaPackageInfoEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(otaPackageInfoEntity).setChecksum(eq("Checksum"));
    verify(otaPackageInfoEntity).setChecksumAlgorithm(eq(ChecksumAlgorithm.MD5));
    verify(otaPackageInfoEntity).setContentType(eq("text/plain"));
    verify(otaPackageInfoEntity).setDataSize(eq(3L));
    verify(otaPackageInfoEntity).setDeviceProfileId(isA(UUID.class));
    verify(otaPackageInfoEntity).setFileName(eq("foo.txt"));
    verify(otaPackageInfoEntity).setHasData(eq(false));
    verify(otaPackageInfoEntity).setTag(eq("Tag"));
    verify(otaPackageInfoEntity).setTenantId(isA(UUID.class));
    verify(otaPackageInfoEntity).setTitle(eq("Dr"));
    verify(otaPackageInfoEntity).setType(eq(OtaPackageType.SOFTWARE));
    verify(otaPackageInfoEntity).setUrl(eq("https://example.org/example"));
    verify(otaPackageInfoEntity).setVersion(eq("1.0.2"));
    verify(otaPackageInfoEntity).toData();
    verify(otaPackageInfoRepository).findAllByTenantIdAndTypeAndDeviceProfileIdAndHasData(isA(UUID.class),
        isA(UUID.class), eq(OtaPackageType.FIRMWARE), eq("Text Search"), isA(Pageable.class));
    List<OtaPackageInfo> data = actualFindOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.getData();
    assertEquals(1, data.size());
    assertSame(otaPackageInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}
   */
  @Test
  public void testIsOtaPackageUsed_thenReturnFalse() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(false);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult = jpaOtaPackageInfoDao.isOtaPackageUsed(otaPackageId, OtaPackageType.FIRMWARE,
        new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository).isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertFalse(actualIsOtaPackageUsedResult);
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}
   */
  @Test
  public void testIsOtaPackageUsed_thenReturnTrue() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult = jpaOtaPackageInfoDao.isOtaPackageUsed(otaPackageId, OtaPackageType.FIRMWARE,
        new DeviceProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository).isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertTrue(actualIsOtaPackageUsedResult);
  }

  /**
   * Test
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}.
   * <ul>
   *   <li>When {@link DeviceProfileId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOtaPackageInfoDao#isOtaPackageUsed(OtaPackageId, OtaPackageType, DeviceProfileId)}
   */
  @Test
  public void testIsOtaPackageUsed_whenDeviceProfileIdGetIdReturnNull_uuid_thenReturnTrue() {
    // Arrange
    when(otaPackageInfoRepository.isOtaPackageUsed(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);
    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsOtaPackageUsedResult = jpaOtaPackageInfoDao.isOtaPackageUsed(otaPackageId, OtaPackageType.FIRMWARE,
        deviceProfileId);

    // Assert
    verify(deviceProfileId).getId();
    verify(otaPackageId).getId();
    verify(otaPackageInfoRepository).isOtaPackageUsed(isA(UUID.class), isA(UUID.class), eq("FIRMWARE"));
    assertTrue(actualIsOtaPackageUsedResult);
  }
}
