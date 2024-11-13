package org.thingsboard.server.dao.ota;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageInfoDataValidator;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageDao;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageInfoDao;

@ContextConfiguration(classes = {BaseOtaPackageService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseOtaPackageServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseOtaPackageService baseOtaPackageService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<OtaPackageInfo> dataValidator;

  @MockBean
  private DataValidator<OtaPackage> dataValidator2;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private OtaPackageDao otaPackageDao;

  @MockBean
  private OtaPackageDataCache otaPackageDataCache;

  @MockBean
  private OtaPackageInfoDao otaPackageInfoDao;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<OtaPackageCacheKey, OtaPackageInfo> tbTransactionalCache;

  /**
   * Test
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   * with {@code OtaPackageCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithOtaPackageCacheEvictEvent() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<OtaPackageCacheKey>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.handleEvictEvent(new OtaPackageCacheEvictEvent(null)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   * with {@code OtaPackageCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithOtaPackageCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());

    // Act
    baseOtaPackageService.handleEvictEvent(new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID)));

    // Assert
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   * with {@code OtaPackageCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#handleEvictEvent(OtaPackageCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithOtaPackageCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doThrow(new DataValidationException("An error occurred")).when(otaPackageDataCache).evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .handleEvictEvent(new OtaPackageCacheEvictEvent(new OtaPackageId(ModelConstants.NULL_UUID))));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenReturn(new OtaPackageInfo());
    doThrow(new DataValidationException("An error occurred")).when(otaPackageDataCache).evict(Mockito.<String>any());
    when(dataValidator.validate(Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache, atLeast(1)).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageInfo).getId();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getId()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing saveOtaPackageInfo [{}]"));
    when(otaPackage.getTenantId()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "ota_package_tenant_title_version_unq_key"));
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any())).thenReturn(otaPackage);
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());
    when(dataValidator.validate(Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache, atLeast(1)).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageInfo).getId();
    verify(otaPackage).getTenantId();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getUrl()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo_givenEmptyString_whenOtaPackageGetUrlReturnEmptyString() {
    // Arrange
    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getUrl()).thenReturn("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getUrl();
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OtaPackage} {@link OtaPackageInfo#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo_givenNull_whenOtaPackageGetIdReturnNull() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any())).thenReturn(otaPackageInfo);
    when(dataValidator.validate(Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());
    OtaPackage otaPackageInfo2 = mock(OtaPackage.class);
    when(otaPackageInfo2.getId()).thenReturn(null);
    when(otaPackageInfo2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo2.getUrl()).thenReturn("https://example.org/example");

    // Act
    OtaPackageInfo actualSaveOtaPackageInfoResult = baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo2, true);

    // Assert
    verify(otaPackageInfo2).getId();
    verify(otaPackageInfo2).getTenantId();
    verify(otaPackageInfo2, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
    assertSame(otaPackageInfo, actualSaveOtaPackageInfoResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>Given {@link OtaPackageInfoDao}.</li>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo_givenOtaPackageInfoDao_whenOtaPackageInfo() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(new OtaPackageInfo(), true));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>Then return {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  public void testSaveOtaPackageInfo_thenReturnOtaPackageInfo() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any())).thenReturn(otaPackageInfo);
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());
    when(dataValidator.validate(Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());
    OtaPackage otaPackageInfo2 = mock(OtaPackage.class);
    when(otaPackageInfo2.getId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));
    when(otaPackageInfo2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo2.getUrl()).thenReturn("https://example.org/example");

    // Act
    OtaPackageInfo actualSaveOtaPackageInfoResult = baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo2, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageInfo2).getId();
    verify(otaPackageInfo2).getTenantId();
    verify(otaPackageInfo2, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
    assertSame(otaPackageInfo, actualSaveOtaPackageInfoResult);
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   * <p>
   * Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  public void testSaveOtaPackage() {
    // Arrange
    when(dataValidator2.validate(Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService.saveOtaPackage(new OtaPackage()));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   * <ul>
   *   <li>Given {@link OtaPackageDao} {@link Dao#save(TenantId, Object)} return
   * {@link OtaPackage#OtaPackage()}.</li>
   *   <li>Then return {@link OtaPackage#OtaPackage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  public void testSaveOtaPackage_givenOtaPackageDaoSaveReturnOtaPackage_thenReturnOtaPackage() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();
    when(otaPackageDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackage>any())).thenReturn(otaPackage);
    when(dataValidator2.validate(Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenReturn(new OtaPackage());

    // Act
    OtaPackage actualSaveOtaPackageResult = baseOtaPackageService.saveOtaPackage(new OtaPackage());

    // Assert
    verify(otaPackageDao).save(isNull(), isA(OtaPackage.class));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
    assertSame(otaPackage, actualSaveOtaPackageResult);
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   * <ul>
   *   <li>Then calls {@link OtaPackageInfo#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  public void testSaveOtaPackage_thenCallsGetTenantId() {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getTenantId()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "ota_package_tenant_title_version_unq_key"));
    when(otaPackageDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackage>any())).thenReturn(otaPackage);
    when(dataValidator2.validate(Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenReturn(new OtaPackage());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService.saveOtaPackage(new OtaPackage()));
    verify(otaPackage).getTenantId();
    verify(otaPackageDao).save(isNull(), isA(OtaPackage.class));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc", baseOtaPackageService
        .generateChecksum(ChecksumAlgorithm.SHA256, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
    assertEquals("3faec37ec6c0798595943493e10f92d54f862f3afee0d45f7d2921595d5c65b35db81d53f1007045d9e147d7f350e814",
        baseOtaPackageService.generateChecksum(ChecksumAlgorithm.SHA384,
            ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code 5b00981d6d61e000f77b2f866b4a2fa4}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenA_thenReturn5b00981d6d61e000f77b2f866b4a2fa4() {
    // Arrange, Act and Assert
    assertEquals("5b00981d6d61e000f77b2f866b4a2fa4", baseOtaPackageService.generateChecksum(ChecksumAlgorithm.MD5,
        ByteBuffer.wrap(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When {@code CRC32}.</li>
   *   <li>Then return {@code db009d91}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenCrc32_thenReturnDb009d91() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("db009d91",
        baseOtaPackageService.generateChecksum(ChecksumAlgorithm.CRC32, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When {@code MD5}.</li>
   *   <li>Then return {@code a21fa8273f4d12c8c43262d4bf48b7ce}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenMd5_thenReturnA21fa8273f4d12c8c43262d4bf48b7ce()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("a21fa8273f4d12c8c43262d4bf48b7ce",
        baseOtaPackageService.generateChecksum(ChecksumAlgorithm.MD5, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.generateChecksum(ChecksumAlgorithm.MD5, null));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When {@code SHA512}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenSha512_thenReturnAString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "8d73081cf1d473d0501d98802c4adc6a193a21de5e1e2c78fb8b074578ee7daf0cf8574ad52f917058c2577c16684db98764"
            + "523762393827a58157621f64c083",
        baseOtaPackageService.generateChecksum(ChecksumAlgorithm.SHA512,
            ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   * <ul>
   *   <li>When wrap empty array of {@code byte}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}
   */
  @Test
  public void testGenerateChecksum_whenWrapEmptyArrayOfByte_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.generateChecksum(ChecksumAlgorithm.MD5, ByteBuffer.wrap(new byte[]{})));
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(otaPackage);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OtaPackage actualFindOtaPackageByIdResult = baseOtaPackageService.findOtaPackageById(ModelConstants.SYSTEM_TENANT,
        otaPackageId);

    // Assert
    verify(otaPackageId, atLeast(1)).getId();
    verify(otaPackageDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(otaPackage, actualFindOtaPackageByIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>When {@link OtaPackageId#OtaPackageId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link OtaPackage#OtaPackage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageById_whenOtaPackageIdWithIdIsNull_uuid_thenReturnOtaPackage() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(otaPackage);

    // Act
    OtaPackage actualFindOtaPackageByIdResult = baseOtaPackageService.findOtaPackageById(ModelConstants.SYSTEM_TENANT,
        new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(otaPackage, actualFindOtaPackageByIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<OtaPackageCacheKey>any(),
        Mockito.<Supplier<OtaPackageInfo>>any(), anyBoolean())).thenReturn(otaPackageInfo);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OtaPackageInfo actualFindOtaPackageInfoByIdResult = baseOtaPackageService
        .findOtaPackageInfoById(ModelConstants.SYSTEM_TENANT, otaPackageId);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
    verify(otaPackageId).getId();
    assertSame(otaPackageInfo, actualFindOtaPackageInfoByIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>When {@link OtaPackageId#OtaPackageId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageInfoById_whenOtaPackageIdWithIdIsNull_uuid() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<OtaPackageCacheKey>any(),
        Mockito.<Supplier<OtaPackageInfo>>any(), anyBoolean())).thenReturn(otaPackageInfo);

    // Act
    OtaPackageInfo actualFindOtaPackageInfoByIdResult = baseOtaPackageService
        .findOtaPackageInfoById(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(otaPackageInfo, actualFindOtaPackageInfoByIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageInfoByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<OtaPackageInfo> createResult = SettableFuture.create();
    when(otaPackageInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<OtaPackageInfo> actualFindOtaPackageInfoByIdAsyncResult = baseOtaPackageService
        .findOtaPackageInfoByIdAsync(ModelConstants.SYSTEM_TENANT, otaPackageId);

    // Assert
    verify(otaPackageId, atLeast(1)).getId();
    verify(otaPackageInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindOtaPackageInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindOtaPackageInfoByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>When {@link OtaPackageId#OtaPackageId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)}
   */
  @Test
  public void testFindOtaPackageInfoByIdAsync_whenOtaPackageIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<OtaPackageInfo> createResult = SettableFuture.create();
    when(otaPackageInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<OtaPackageInfo> actualFindOtaPackageInfoByIdAsyncResult = baseOtaPackageService
        .findOtaPackageInfoByIdAsync(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindOtaPackageInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindOtaPackageInfoByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantId() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseOtaPackageService.findTenantOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.findTenantOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, null,
            OtaPackageType.FIRMWARE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(isA(TenantId.class),
        isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData2() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, null,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(isA(TenantId.class),
        isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData4() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(Mockito.<TenantId>any(),
        Mockito.<DeviceProfileId>any(), Mockito.<OtaPackageType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult = baseOtaPackageService
        .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(ModelConstants.SYSTEM_TENANT, null,
            OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(isA(TenantId.class),
        isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred")).when(otaPackageDataCache).evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing deleteOtaPackage [{}]"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_firmware_device"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_firmware_device_profile"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_software_device"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage6() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_software_device_profile"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage7() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), null)).when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseOtaPackageService
        .deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   * <ul>
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  public void testDeleteOtaPackage_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());

    // Act
    baseOtaPackageService.deleteOtaPackage(ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict(eq("13814000-1dd2-11b2-8080-808080808080"));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseOtaPackageService#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  public void testSumDataSizeByTenantId_thenReturnOne() {
    // Arrange
    when(otaPackageDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualSumDataSizeByTenantIdResult = baseOtaPackageService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageDao).sumDataSizeByTenantId(isA(TenantId.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#sumDataSizeByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  public void testSumDataSizeByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(otaPackageDao.sumDataSizeByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseOtaPackageService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(otaPackageDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackagesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link OtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#deleteOtaPackagesByTenantId(TenantId)}
   */
  @Test
  public void testDeleteOtaPackagesByTenantId_thenCallsFindOtaPackageInfoByTenantId() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseOtaPackageService.deleteOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link OtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseOtaPackageService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindOtaPackageInfoByTenantId() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseOtaPackageService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageInfoDao).findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseOtaPackageService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<OtaPackageCacheKey>any(),
        Mockito.<Supplier<OtaPackageInfo>>any(), anyBoolean())).thenReturn(otaPackageInfo);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseOtaPackageService.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
    verify(entityId).getId();
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(otaPackageInfo, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseOtaPackageService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseOtaPackageService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<OtaPackageCacheKey>any(),
        Mockito.<Supplier<OtaPackageInfo>>any(), anyBoolean())).thenReturn(otaPackageInfo);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseOtaPackageService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(otaPackageInfo, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseOtaPackageService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseOtaPackageService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    // Act and Assert
    assertEquals(EntityType.OTA_PACKAGE, (new BaseOtaPackageService(otaPackageDao, otaPackageInfoDao,
        otaPackageDataCache, otaPackageInfoValidator, new OtaPackageDataValidator())).getEntityType());
  }
}
