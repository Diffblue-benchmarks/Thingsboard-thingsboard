/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.OtaPackageServiceTest;
import org.thingsboard.server.dao.service.validator.OtaPackageDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageInfoDataValidator;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageDao;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageInfoDao;

@ContextConfiguration(classes = {BaseOtaPackageService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseOtaPackageServiceDiffblueTest {
  @Autowired private BaseOtaPackageService baseOtaPackageService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<OtaPackageInfo> dataValidator;

  @MockBean private DataValidator<OtaPackage> dataValidator2;

  @MockBean private OtaPackageDao otaPackageDao;

  @MockBean private OtaPackageDataCache otaPackageDataCache;

  @MockBean private OtaPackageInfoDao otaPackageInfoDao;

  @MockBean private TbTransactionalCache<OtaPackageCacheKey, OtaPackageInfo> tbTransactionalCache;

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    OtaPackage otaPackageInfo = new OtaPackage((OtaPackageId) null);
    otaPackageInfo.setUrl("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, false));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo2() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<OtaPackageCacheKey>any());
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenReturn(new OtaPackageInfo());
    when(dataValidator.validate(
            Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());

    OtaPackage otaPackageInfo = new OtaPackage(new OtaPackageId(ModelConstants.NULL_UUID));
    otaPackageInfo.setUrl("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, false));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageInfoDao).save(isNull(), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenReturn(new OtaPackageInfo());
    doThrow(new DataValidationException("An error occurred"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());
    when(dataValidator.validate(
            Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());

    OtaPackage otaPackageInfo = new OtaPackage(new OtaPackageId(ModelConstants.NULL_UUID));
    otaPackageInfo.setUrl("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, false));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache, atLeast(1)).evict("13814000-1dd2-11b2-8080-808080808080");
    verify(otaPackageInfoDao).save(isNull(), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo4() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    DataValidator<OtaPackageInfo> otaPackageInfoValidator = mock(DataValidator.class);

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo5() {
    // Arrange
    OtaPackageInfoDao otaPackageInfoDao = mock(OtaPackageInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveOtaPackageInfo [{}]");
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenThrow(constraintViolationException);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    DataValidator<OtaPackageInfo> otaPackageInfoValidator = mock(DataValidator.class);

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenReturn(null);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getId();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo6() {
    // Arrange
    OtaPackageInfoDao otaPackageInfoDao = mock(OtaPackageInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "ota_package_tenant_title_version_unq_key");
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenThrow(constraintViolationException);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    DataValidator<OtaPackageInfo> otaPackageInfoValidator = mock(DataValidator.class);

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenReturn(null);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getId();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo7() {
    // Arrange
    OtaPackageInfoDao otaPackageInfoDao = mock(OtaPackageInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenThrow(constraintViolationException);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    DataValidator<OtaPackageInfo> otaPackageInfoValidator = mock(DataValidator.class);

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getId()).thenReturn(null);
    when(otaPackageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getId();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
    verify(otaPackageInfoDao).save(isA(TenantId.class), isA(OtaPackageInfo.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageInfoDao}.
   *   <li>When {@link OtaPackageId#OtaPackageId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo_givenOtaPackageInfoDao_whenOtaPackageIdWithIdIsNull_uuid() {
    // Arrange
    OtaPackage otaPackageInfo = new OtaPackage(new OtaPackageId(ModelConstants.NULL_UUID));
    otaPackageInfo.setUrl("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageInfoDao}.
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo_givenOtaPackageInfoDao_whenOtaPackageInfo() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(new OtaPackageInfo(), true));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link OtaPackage#getAdditionalInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo_thenCallsGetAdditionalInfo() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackage otaPackageInfo = mock(OtaPackage.class);
    when(otaPackageInfo.getAdditionalInfo())
        .thenThrow(new DataValidationException("An error occurred"));
    when(otaPackageInfo.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(otaPackageInfo.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo, true));
    verify(otaPackageInfo).getAdditionalInfo();
    verify(otaPackageInfo).getTenantId();
    verify(otaPackageInfo, atLeast(1)).getUrl();
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link OtaPackageInfo#OtaPackageInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo_thenReturnOtaPackageInfo() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenReturn(otaPackageInfo);
    when(dataValidator.validate(
            Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());

    OtaPackage otaPackageInfo2 = new OtaPackage((OtaPackageId) null);
    otaPackageInfo2.setUrl("");

    // Act
    OtaPackageInfo actualSaveOtaPackageInfoResult =
        baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo2, false);

    // Assert
    verify(otaPackageInfoDao).save(isNull(), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
    assertSame(otaPackageInfo, actualSaveOtaPackageInfoResult);
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link OtaPackageInfo#OtaPackageInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackageInfo(OtaPackageInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.saveOtaPackageInfo(OtaPackageInfo, boolean)"
  })
  public void testSaveOtaPackageInfo_thenReturnOtaPackageInfo2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(otaPackageInfoDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackageInfo>any()))
        .thenReturn(otaPackageInfo);
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());
    when(dataValidator.validate(
            Mockito.<OtaPackageInfo>any(), Mockito.<Function<OtaPackageInfo, TenantId>>any()))
        .thenReturn(new OtaPackageInfo());

    OtaPackage otaPackageInfo2 = new OtaPackage(new OtaPackageId(ModelConstants.NULL_UUID));
    otaPackageInfo2.setUrl("");

    // Act
    OtaPackageInfo actualSaveOtaPackageInfoResult =
        baseOtaPackageService.saveOtaPackageInfo(otaPackageInfo2, false);

    // Assert
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict("13814000-1dd2-11b2-8080-808080808080");
    verify(otaPackageInfoDao).save(isNull(), isA(OtaPackageInfo.class));
    verify(dataValidator).validate(isA(OtaPackageInfo.class), isA(Function.class));
    assertSame(otaPackageInfo, actualSaveOtaPackageInfoResult);
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.saveOtaPackage(OtaPackage)"})
  public void testSaveOtaPackage() {
    // Arrange
    when(dataValidator2.validate(
            Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackage(new OtaPackage((OtaPackageId) null)));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.saveOtaPackage(OtaPackage)"})
  public void testSaveOtaPackage2() {
    // Arrange
    when(otaPackageDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackage>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    OtaPackage createFirmwareResult =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    when(dataValidator2.validate(
            Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenReturn(createFirmwareResult);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.saveOtaPackage(new OtaPackage((OtaPackageId) null)));
    verify(otaPackageDao).save(isNull(), isA(OtaPackage.class));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#saveOtaPackage(OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.saveOtaPackage(OtaPackage)"})
  public void testSaveOtaPackage_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveOtaPackage [{}]");
    when(otaPackageDao.save(Mockito.<TenantId>any(), Mockito.<OtaPackage>any()))
        .thenThrow(constraintViolationException);
    OtaPackage createFirmwareResult =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    when(dataValidator2.validate(
            Mockito.<OtaPackage>any(), Mockito.<Function<OtaPackage, TenantId>>any()))
        .thenReturn(createFirmwareResult);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseOtaPackageService.saveOtaPackage(new OtaPackage((OtaPackageId) null)));
    verify(otaPackageDao).save(isNull(), isA(OtaPackage.class));
    verify(dataValidator2).validate(isA(OtaPackage.class), isA(Function.class));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA256, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "3faec37ec6c0798595943493e10f92d54f862f3afee0d45f7d2921595d5c65b35db81d53f1007045d9e147d7f350e814",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA384, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum3() {
    // Arrange, Act and Assert
    assertEquals(
        "4d666c2aca4d9d481ea70be57a0a551b878a4e089d36ca30415cece7ea329519",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA256,
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum4() {
    // Arrange, Act and Assert
    assertEquals(
        "696b9a63d55f1eac519a97e36febb59d070991d540d114ef011496c885bfe9c69668262df474b2d14a0f5d58301e78e6",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA384,
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code CRC32}.
   *   <li>Then return {@code 36c200b8}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenCrc32_thenReturn36c200b8() {
    // Arrange, Act and Assert
    assertEquals(
        "36c200b8",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.CRC32,
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code CRC32}.
   *   <li>Then return {@code db009d91}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenCrc32_thenReturnDb009d91()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "db009d91",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.CRC32, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code MD5}.
   *   <li>Then return {@code 5b00981d6d61e000f77b2f866b4a2fa4}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenMd5_thenReturn5b00981d6d61e000f77b2f866b4a2fa4() {
    // Arrange, Act and Assert
    assertEquals(
        "5b00981d6d61e000f77b2f866b4a2fa4",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.MD5,
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code MD5}.
   *   <li>Then return {@code a21fa8273f4d12c8c43262d4bf48b7ce}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenMd5_thenReturnA21fa8273f4d12c8c43262d4bf48b7ce()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "a21fa8273f4d12c8c43262d4bf48b7ce",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.MD5, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code MURMUR3_32}.
   *   <li>Then return {@code fbe6dcb4}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenMurmur332_thenReturnFbe6dcb4()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "fbe6dcb4",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.MURMUR3_32, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code MURMUR3_128}.
   *   <li>Then return {@code 2a9fb5d0fb7dd12fb974a8adb5d7498a}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenMurmur3128_thenReturn2a9fb5d0fb7dd12fb974a8adb5d7498a()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "2a9fb5d0fb7dd12fb974a8adb5d7498a",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.MURMUR3_128, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.generateChecksum(ChecksumAlgorithm.MD5, null));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code SHA512}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenSha512_thenReturnAString()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "8d73081cf1d473d0501d98802c4adc6a193a21de5e1e2c78fb8b074578ee7daf0cf8574ad52f917058c2577c16684db98764"
            + "523762393827a58157621f64c083",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA512, ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code SHA512}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenSha512_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "7cd93b858420ea8a370225ca44839c208f709e4a6068ea50c65c0cfed038122e021f414ec3c097b54727254c22957e52e868"
            + "3717307186734883c1b3746d02e8",
        baseOtaPackageService.generateChecksum(
            ChecksumAlgorithm.SHA512,
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm, ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap empty array of {@code byte}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#generateChecksum(ChecksumAlgorithm,
   * ByteBuffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseOtaPackageService.generateChecksum(ChecksumAlgorithm, ByteBuffer)"
  })
  public void testGenerateChecksum_whenWrapEmptyArrayOfByte_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.generateChecksum(
                ChecksumAlgorithm.MURMUR3_32, ByteBuffer.wrap(new byte[] {})));
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.findOtaPackageById(TenantId, OtaPackageId)"})
  public void testFindOtaPackageById() {
    // Arrange
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findOtaPackageById(
                ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(otaPackageDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.findOtaPackageById(TenantId, OtaPackageId)"})
  public void testFindOtaPackageById2() {
    // Arrange
    OtaPackage createFirmwareResult =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createFirmwareResult);

    // Act
    OtaPackage actualFindOtaPackageByIdResult =
        baseOtaPackageService.findOtaPackageById(
            ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(createFirmwareResult, actualFindOtaPackageByIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.findOtaPackageById(TenantId, OtaPackageId)"})
  public void testFindOtaPackageById3() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageService.findOtaPackageById(ModelConstants.SYSTEM_TENANT, otaPackageId));
    verify(otaPackageId).getId();
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaOtaPackageDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageById(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage BaseOtaPackageService.findOtaPackageById(TenantId, OtaPackageId)"})
  public void testFindOtaPackageById_thenCallsFindById() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = mock(JpaOtaPackageDao.class);
    OtaPackage createFirmwareResult =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createFirmwareResult);
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OtaPackage actualFindOtaPackageByIdResult =
        baseOtaPackageService.findOtaPackageById(ModelConstants.SYSTEM_TENANT, otaPackageId);

    // Assert
    verify(otaPackageId, atLeast(1)).getId();
    verify(otaPackageDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(createFirmwareResult, actualFindOtaPackageByIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId,
   * OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.findOtaPackageInfoById(TenantId, OtaPackageId)"
  })
  public void testFindOtaPackageInfoById() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<OtaPackageCacheKey>any(),
            Mockito.<Supplier<OtaPackageInfo>>any(),
            anyBoolean()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findOtaPackageInfoById(
                ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then calls {@link OtaPackageId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId,
   * OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.findOtaPackageInfoById(TenantId, OtaPackageId)"
  })
  public void testFindOtaPackageInfoById_thenCallsGetId() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    OtaPackageId otaPackageId = mock(OtaPackageId.class);
    when(otaPackageId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findOtaPackageInfoById(
                ModelConstants.SYSTEM_TENANT, otaPackageId));
    verify(otaPackageId).getId();
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then return {@link OtaPackageInfo#OtaPackageInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageInfoById(TenantId,
   * OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OtaPackageInfo BaseOtaPackageService.findOtaPackageInfoById(TenantId, OtaPackageId)"
  })
  public void testFindOtaPackageInfoById_thenReturnOtaPackageInfo() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<OtaPackageCacheKey>any(),
            Mockito.<Supplier<OtaPackageInfo>>any(),
            anyBoolean()))
        .thenReturn(otaPackageInfo);

    // Act
    OtaPackageInfo actualFindOtaPackageInfoByIdResult =
        baseOtaPackageService.findOtaPackageInfoById(
            ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(OtaPackageCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(otaPackageInfo, actualFindOtaPackageInfoByIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findOtaPackageInfoByIdAsync(TenantId,
   * OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseOtaPackageService.findOtaPackageInfoByIdAsync(TenantId, OtaPackageId)"
  })
  public void testFindOtaPackageInfoByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<OtaPackageInfo> createResult = SettableFuture.create();
    when(otaPackageInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<OtaPackageInfo> actualFindOtaPackageInfoByIdAsyncResult =
        baseOtaPackageService.findOtaPackageInfoByIdAsync(
            ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(otaPackageInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindOtaPackageInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindOtaPackageInfoByIdAsyncResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findTenantOtaPackagesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findTenantOtaPackagesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findTenantOtaPackagesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.findTenantOtaPackagesByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId_givenBy_created_time_desc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult =
        baseOtaPackageService.findTenantOtaPackagesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId_givenNull_uuid_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult =
        baseOtaPackageService.findTenantOtaPackagesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId_thenCallsGetProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult =
        baseOtaPackageService.findTenantOtaPackagesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#findTenantOtaPackagesByTenantId(TenantId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaOtaPackageInfoDao otaPackageInfoDao = mock(JpaOtaPackageInfoDao.class);
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());

    // Act
    PageData<OtaPackageInfo> actualFindTenantOtaPackagesByTenantIdResult =
        baseOtaPackageService.findTenantOtaPackagesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantOtaPackagesByTenantIdResult);
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            Mockito.<TenantId>any(),
            Mockito.<DeviceProfileId>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<OtaPackageInfo>
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT,
                    null,
                    OtaPackageType.FIRMWARE,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            isA(TenantId.class), isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData2() {
    // Arrange
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            Mockito.<TenantId>any(),
            Mockito.<DeviceProfileId>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT,
                    null,
                    OtaPackageType.FIRMWARE,
                    BaseRelatedEdgesService.FIRST_PAGE));
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            isA(TenantId.class), isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData4() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            Mockito.<TenantId>any(),
            Mockito.<DeviceProfileId>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo>
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            isA(TenantId.class), isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData5() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData6() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            Mockito.<TenantId>any(),
            Mockito.<DeviceProfileId>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo>
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            isA(TenantId.class), isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData7() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    ModelConstants.SYSTEM_TENANT, null, OtaPackageType.FIRMWARE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData8() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            Mockito.<TenantId>any(),
            Mockito.<DeviceProfileId>any(),
            Mockito.<OtaPackageType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<OtaPackageInfo>
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult =
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    tenantId, null, OtaPackageType.FIRMWARE, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantIdAndDeviceProfileIdAndTypeAndHasData(
            isA(TenantId.class), isNull(), eq(OtaPackageType.FIRMWARE), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasDataResult);
  }

  /**
   * Test {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseOtaPackageService#findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId,
   * DeviceProfileId, OtaPackageType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseOtaPackageService.findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(TenantId, DeviceProfileId, OtaPackageType, PageLink)"
  })
  public void testFindTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData9() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService
                .findTenantOtaPackagesByTenantIdAndDeviceProfileIdAndTypeAndHasData(
                    tenantId, null, OtaPackageType.FIRMWARE, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteOtaPackage(TenantId, OtaPackageId)"})
  public void testDeleteOtaPackage() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(otaPackageDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.deleteOtaPackage(
                ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteOtaPackage(TenantId, OtaPackageId)"})
  public void testDeleteOtaPackage2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(otaPackageDataCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseOtaPackageService.deleteOtaPackage(
                ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict("13814000-1dd2-11b2-8080-808080808080");
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteOtaPackage(TenantId, OtaPackageId)"})
  public void testDeleteOtaPackage_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<OtaPackageCacheKey>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(otaPackageDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(otaPackageDataCache).evict(Mockito.<String>any());

    // Act
    baseOtaPackageService.deleteOtaPackage(
        ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(OtaPackageCacheKey.class));
    verify(otaPackageDataCache).evict("13814000-1dd2-11b2-8080-808080808080");
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteOtaPackage(TenantId, OtaPackageId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteOtaPackage(TenantId, OtaPackageId)"})
  public void testDeleteOtaPackage_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteOtaPackage [{}]");
    doThrow(constraintViolationException)
        .when(otaPackageDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseOtaPackageService.deleteOtaPackage(
                ModelConstants.SYSTEM_TENANT, new OtaPackageId(ModelConstants.NULL_UUID)));
    verify(otaPackageDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteOtaPackagesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link OtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteOtaPackagesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteOtaPackagesByTenantId(TenantId)"})
  public void testDeleteOtaPackagesByTenantId_thenCallsFindOtaPackageInfoByTenantId() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseOtaPackageService.deleteOtaPackagesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseOtaPackageService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link OtaPackageInfoDao#findOtaPackageInfoByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindOtaPackageInfoByTenantId() {
    // Arrange
    PageData<OtaPackageInfo> emptyPageDataResult = PageData.emptyPageData();
    when(otaPackageInfoDao.findOtaPackageInfoByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseOtaPackageService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(otaPackageInfoDao)
        .findOtaPackageInfoByTenantId(isA(TenantId.class), isA(PageLink.class));
  }
}
