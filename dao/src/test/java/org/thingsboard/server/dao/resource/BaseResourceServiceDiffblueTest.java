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
package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertArrayEquals;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.cache.resourceInfo.ResourceInfoCacheKey;
import org.thingsboard.server.cache.resourceInfo.ResourceInfoEvictEvent;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.TbResourceInfoFilter.TbResourceInfoFilterBuilder;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;

@ContextConfiguration(classes = {BaseResourceService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseResourceServiceDiffblueTest {
  @Autowired private BaseResourceService baseResourceService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private ResourceDataValidator resourceDataValidator;

  @MockBean private TbResourceDao tbResourceDao;

  @MockBean private TbResourceInfoDao tbResourceInfoDao;

  @MockBean private TbTransactionalCache<ResourceInfoCacheKey, TbResourceInfo> tbTransactionalCache;

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(new TbResource()));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource2() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource());

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource3() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(tbResource.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(new TbResource()));
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource5() throws UnsupportedEncodingException {
    // Arrange
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    doThrow(constraintViolationException).when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource, atLeast(1)).getData();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource6() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getResourceType()).thenThrow(constraintViolationException);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource7() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getData()).thenThrow(constraintViolationException);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource).getData();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource8() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getResourceKey()).thenThrow(constraintViolationException);
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource9() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getId()).thenThrow(constraintViolationException);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource10() throws UnsupportedEncodingException {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    doThrow(constraintViolationException).when(resource).setEtag(Mockito.<String>any());
    when(resource.getId()).thenReturn(null);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseImageService.saveResource(resource));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource, atLeast(1)).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource11() throws UnsupportedEncodingException {
    // Arrange
    TbResourceDao resourceDao = mock(TbResourceDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenThrow(constraintViolationException);

    ResourceDataValidator resourceValidator = mock(ResourceDataValidator.class);
    when(resourceValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, new JpaTbResourceInfoDao(), resourceValidator);

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getId()).thenReturn(null);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource, atLeast(1)).getData();
    verify(resource).getId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource = new TbResource();
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource(), true);

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(new TbResource(), true));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate3() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource(), true);

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate4() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(tbResource.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(new TbResource(), true));
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate6() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate7() throws UnsupportedEncodingException {
    // Arrange
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    doThrow(constraintViolationException).when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(resource, atLeast(1)).getData();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate8() throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate9() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getResourceType()).thenThrow(constraintViolationException);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate10() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getData()).thenThrow(constraintViolationException);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(resource).getData();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate11() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getResourceKey()).thenThrow(constraintViolationException);
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate12() {
    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(constraintViolationException);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData(null);
    resource.setId(null);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(resource, false));
    verify(resourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate13() {
    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(resourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(constraintViolationException);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData(null);
    resource.setId(null);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.saveResource(resource, false));
    verify(resourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate_givenOne() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link ResourceDataValidator}.
   *   <li>Then calls {@link TbResourceDao#save(TenantId, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate_givenResourceDataValidator_thenCallsSave()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource, false);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@code Resource Key}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate_givenResourceKey() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing saveResource [{}]");
    when(resource.getId()).thenThrow(constraintViolationException);
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getData()).thenReturn(null);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.saveResource(resource, true));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getId();
    verify(resource).getResourceKey();
    verify(resource).getResourceType();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#save(TenantId, Object)} return {@link
   *       TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate_givenTbResourceDaoSaveReturnTbResource()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource, boolean)} with {@code resource},
   * {@code doValidate}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource, boolean)"})
  public void testSaveResourceWithResourceDoValidate_thenThrowDataValidationException() {
    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "resource_unq_key");
    when(resourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(constraintViolationException);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData(null);
    resource.setId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseResourceService.saveResource(resource, false));
    verify(resourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TbResource} {@link TbResource#getCreatedTime()} return one.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_givenOne_whenTbResourceGetCreatedTimeReturnOne() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#save(TenantId, Object)} return {@link
   *       TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_givenTbResourceDaoSaveReturnTbResource()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(resource, atLeast(1)).getId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResource#getTenantId()} return {@link
   *       ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_givenTbResourceGetTenantIdReturnSystem_tenant()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = mock(TbResource.class);
    doNothing().when(resource).setEtag(Mockito.<String>any());
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource, atLeast(1)).getData();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(resource).getTenantId();
    verify(resource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resource).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfoDao} {@link TbResourceInfoDao#save(TenantId, Object)} return
   *       {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_givenTbResourceInfoDaoSaveReturnTbResourceInfo() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource = new TbResource();
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(new TbResource());

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource, actualSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_thenThrowDataValidationException() {
    // Arrange
    ResourceDataValidator resourceValidator = mock(ResourceDataValidator.class);
    when(resourceValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, new JpaTbResourceInfoDao(), resourceValidator);

    TbResource resource = mock(TbResource.class);
    when(resource.getCreatedTime()).thenThrow(new DataValidationException("An error occurred"));
    when(resource.getId()).thenReturn(null);
    when(resource.getData()).thenReturn(null);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseResourceService.saveResource(resource));
    verify(resource, atLeast(1)).getData();
    verify(resource).getCreatedTime();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resourceValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#saveResource(TbResource)} with {@code resource}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Id is {@link TbResourceId#TbResourceId(UUID)} with
   *       id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#saveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.saveResource(TbResource)"})
  public void testSaveResourceWithResource_whenTbResourceIdIsTbResourceIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualSaveResourceResult = baseResourceService.saveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.doSaveResource(new TbResource()));
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource2() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tbResource.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.doSaveResource(new TbResource()));
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.doSaveResource(resource));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenThrow(constraintViolationException);

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData("Resource");
    resource.setId(null);
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.doSaveResource(resource));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TbResource} {@link TbResource#getData()} return {@code null}.
   *   <li>Then calls {@link TbResource#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_givenOne_whenTbResourceGetDataReturnNull_thenCallsGetData() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);

    TbResource resource = mock(TbResource.class);
    when(resource.getData()).thenReturn(null);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(resource).setEncodedData(Mockito.<String>any());
    doNothing().when(resource).setId(Mockito.<TbResourceId>any());
    resource.setEncodedData("Resource");
    resource.setId(null);
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(resource).getData();
    verify(resource).setEncodedData("Resource");
    verify(tbResource).getCreatedTime();
    verify(resource).getCreatedTime();
    verify(tbResource).getId();
    verify(resource, atLeast(1)).getId();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource, atLeast(1)).setId(Mockito.<TbResourceId>any());
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#save(TenantId, Object)} return {@link
   *       TbResource#TbResource()}.
   *   <li>Then return {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_givenTbResourceDaoSaveReturnTbResource_thenReturnTbResource() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData("Resource");
    resource.setId(null);
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    assertSame(tbResource, actualDoSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResource#getTenantId()} return {@link
   *       ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_givenTbResourceGetTenantIdReturnSystem_tenant() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);

    TbResource resource = new TbResource(new TbResource());
    resource.setEncodedData("Resource");
    resource.setId(null);
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfoDao} {@link TbResourceInfoDao#save(TenantId, Object)} return
   *       {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_givenTbResourceInfoDaoSaveReturnTbResourceInfo() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource resource = new TbResource();

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals(resource, actualDoSaveResourceResult);
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(new TbResource());

    // Assert
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_thenThrowDataValidationException() {
    // Arrange
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseResourceService.doSaveResource(new TbResource()));
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
  }

  /**
   * Test {@link BaseResourceService#doSaveResource(TbResource)}.
   *
   * <ul>
   *   <li>When {@link TbResource#TbResource()} Id is {@link TbResourceId#TbResourceId(UUID)} with
   *       id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#doSaveResource(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.doSaveResource(TbResource)"})
  public void testDoSaveResource_whenTbResourceIdIsTbResourceIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(tbResource.getId()).thenReturn(tbResourceId);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource);

    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbResource actualDoSaveResourceResult = baseResourceService.doSaveResource(resource);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getCreatedTime();
    verify(tbResource).getId();
    verify(tbResourceInfoDao).save(isNull(), isA(TbResourceInfo.class));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualDoSaveResourceResult.getUuidId().toString());
    assertEquals(1L, actualDoSaveResourceResult.getCreatedTime());
    assertSame(tbResourceId, actualDoSaveResourceResult.getId());
  }

  /**
   * Test {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}.
   *
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.findResourceByTenantIdAndKey(TenantId, ResourceType, String)"
  })
  public void testFindResourceByTenantIdAndKey_thenReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualFindResourceByTenantIdAndKeyResult =
        baseResourceService.findResourceByTenantIdAndKey(
            ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    assertSame(tbResource, actualFindResourceByTenantIdAndKeyResult);
  }

  /**
   * Test {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId, ResourceType, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceByTenantIdAndKey(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.findResourceByTenantIdAndKey(TenantId, ResourceType, String)"
  })
  public void testFindResourceByTenantIdAndKey_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceByTenantIdAndKey(
                ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key"));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.findResourceById(TenantId, TbResourceId)"})
  public void testFindResourceById() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findResourceById [{}] [{}]");
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceById(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.findResourceById(TenantId, TbResourceId)"})
  public void testFindResourceById_thenCallsGetId() {
    // Arrange
    TbResourceId resourceId = mock(TbResourceId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(resourceId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.findResourceById(ModelConstants.SYSTEM_TENANT, resourceId));
    verify(resourceId).getId();
  }

  /**
   * Test {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then return {@link TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResource BaseResourceService.findResourceById(TenantId, TbResourceId)"})
  public void testFindResourceById_thenReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tbResource);

    // Act
    TbResource actualFindResourceByIdResult =
        baseResourceService.findResourceById(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tbResource, actualFindResourceByIdResult);
  }

  /**
   * Test {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BaseResourceService.getResourceData(TenantId, TbResourceId)"})
  public void testGetResourceData_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualResourceData =
        baseResourceService.getResourceData(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualResourceData);
  }

  /**
   * Test {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#getResourceData(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BaseResourceService.getResourceData(TenantId, TbResourceId)"})
  public void testGetResourceData_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing getResourceData [{}] [{}]");
    when(tbResourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.getResourceData(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(tbResourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseResourceService.findResourceInfoById(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoById() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findResourceInfoById [{}] [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<ResourceInfoCacheKey>any(),
            Mockito.<Supplier<TbResourceInfo>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceInfoById(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseResourceService.findResourceInfoById(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoById_thenCallsGetId() {
    // Arrange
    TbResourceId resourceId = mock(TbResourceId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(resourceId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.findResourceInfoById(ModelConstants.SYSTEM_TENANT, resourceId));
    verify(resourceId).getId();
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoById(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseResourceService.findResourceInfoById(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoById_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<ResourceInfoCacheKey>any(),
            Mockito.<Supplier<TbResourceInfo>>any(),
            anyBoolean()))
        .thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindResourceInfoByIdResult =
        baseResourceService.findResourceInfoById(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(tbResourceInfo, actualFindResourceInfoByIdResult);
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseResourceService.findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)"
  })
  public void testFindResourceInfoByTenantIdAndKey_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindResourceInfoByTenantIdAndKeyResult =
        baseResourceService.findResourceInfoByTenantIdAndKey(
            ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key");

    // Assert
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    assertSame(tbResourceInfo, actualFindResourceInfoByTenantIdAndKeyResult);
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId, ResourceType,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoByTenantIdAndKey(TenantId,
   * ResourceType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseResourceService.findResourceInfoByTenantIdAndKey(TenantId, ResourceType, String)"
  })
  public void testFindResourceInfoByTenantIdAndKey_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceInfoByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceInfoByTenantIdAndKey(
                ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, "Resource Key"));
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoByIdAsync(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoByIdAsync(TenantId,
   * TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseResourceService.findResourceInfoByIdAsync(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoByIdAsync() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findResourceInfoById [{}] [{}]");
    when(tbResourceInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceInfoByIdAsync(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(tbResourceInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoByIdAsync(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoByIdAsync(TenantId,
   * TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseResourceService.findResourceInfoByIdAsync(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoByIdAsync_thenCallsGetId() {
    // Arrange
    TbResourceId resourceId = mock(TbResourceId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(resourceId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findResourceInfoByIdAsync(
                ModelConstants.SYSTEM_TENANT, resourceId));
    verify(resourceId).getId();
  }

  /**
   * Test {@link BaseResourceService#findResourceInfoByIdAsync(TenantId, TbResourceId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findResourceInfoByIdAsync(TenantId,
   * TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseResourceService.findResourceInfoByIdAsync(TenantId, TbResourceId)"
  })
  public void testFindResourceInfoByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<TbResourceInfo> createResult = SettableFuture.create();
    when(tbResourceInfoDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<TbResourceInfo> actualFindResourceInfoByIdAsyncResult =
        baseResourceService.findResourceInfoByIdAsync(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceInfoDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindResourceInfoByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindResourceInfoByIdAsyncResult);
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    baseResourceService.deleteResource(
        ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    doThrow(constraintViolationException)
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID)));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    doThrow(constraintViolationException)
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(UUID.randomUUID())));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    doThrow(constraintViolationException)
        .when(tbResourceDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(UUID.randomUUID())));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    doThrow(constraintViolationException)
        .when(tbResourceDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce3() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act
    baseResourceService.deleteResource(
        ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), false);

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteResource [{}] [{}]");
    doThrow(constraintViolationException)
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.deleteResource(
                ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), false));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <ul>
   *   <li>Then calls {@link JpaTbResourceDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce_thenCallsFindById() {
    // Arrange
    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    baseImageService.deleteResource(
        ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(resourceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce_thenCallsGetId() {
    // Arrange
    TbResourceId resourceId = mock(TbResourceId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(resourceId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, resourceId, true));
    verify(resourceId).getId();
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId, boolean)} with {@code
   * tenantId}, {@code resourceId}, {@code force}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId, boolean)"})
  public void testDeleteResourceWithTenantIdResourceIdForce_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(tbResourceDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.deleteResource(
        ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tbResourceDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <ul>
   *   <li>Then calls {@link JpaTbResourceDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId_thenCallsFindById() {
    // Arrange
    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    ResourceDataValidator resourceValidator = mock(ResourceDataValidator.class);
    doNothing()
        .when(resourceValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, new JpaTbResourceInfoDao(), resourceValidator);

    // Act
    baseResourceService.deleteResource(
        ModelConstants.SYSTEM_TENANT, new TbResourceId(new UUID(1L, 1L)));

    // Assert
    verify(resourceValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    verify(resourceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResource(TenantId, TbResourceId)} with {@code tenantId},
   * {@code resourceId}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResource(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResource(TenantId, TbResourceId)"})
  public void testDeleteResourceWithTenantIdResourceId_thenCallsGetId() {
    // Arrange
    TbResourceId resourceId = mock(TbResourceId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(resourceId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.deleteResource(ModelConstants.SYSTEM_TENANT, resourceId));
    verify(resourceId).getId();
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findAllTenantResourcesByTenantId [{}]");
    when(tbResourceInfoDao.findAllTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findAllTenantResourcesByTenantId(
                resourceSubTypesResult
                    .resourceTypes(new HashSet<>())
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceInfoDao)
        .findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findAllTenantResourcesByTenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findAllTenantResourcesByTenantId(
                resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findAllTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindAllTenantResourcesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findAllTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindAllTenantResourcesByTenantIdResult =
        baseResourceService.findAllTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao)
        .findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantResourcesByTenantIdResult);
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByTenantId [{}]");
    when(tbResourceInfoDao.findTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByTenantId(
                resourceSubTypesResult
                    .resourceTypes(new HashSet<>())
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceInfoDao)
        .findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByTenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByTenantId(
                resourceSubTypesResult.resourceTypes(new HashSet<>()).tenantId(tenantId).build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByTenantId(TbResourceInfoFilter, PageLink)"
  })
  public void testFindTenantResourcesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TbResourceInfoFilterBuilder builderResult = TbResourceInfoFilter.builder();

    TbResourceInfoFilterBuilder resourceSubTypesResult =
        builderResult.resourceSubTypes(new HashSet<>());

    // Act
    PageData<TbResourceInfo> actualFindTenantResourcesByTenantIdResult =
        baseResourceService.findTenantResourcesByTenantId(
            resourceSubTypesResult
                .resourceTypes(new HashSet<>())
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao)
        .findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantResourcesByTenantIdResult);
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId,
   * ResourceType, String[])}.
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseResourceService.findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])"
  })
  public void testFindTenantResourcesByResourceTypeAndObjectIds() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndObjectIds [{}][{}][{}]");
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(
            Mockito.<TenantId>any(),
            Mockito.<ResourceType>any(),
            Mockito.<ResourceSubType>any(),
            Mockito.<String[]>any(),
            Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByResourceTypeAndObjectIds(
                ModelConstants.SYSTEM_TENANT,
                ResourceType.LWM2M_MODEL,
                new String[] {"Object Ids"}));
    verify(tbResourceDao)
        .findResourcesByTenantIdAndResourceType(
            isA(TenantId.class),
            eq(ResourceType.LWM2M_MODEL),
            isNull(),
            isA(String[].class),
            isNull());
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId,
   * ResourceType, String[])}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseResourceService.findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])"
  })
  public void testFindTenantResourcesByResourceTypeAndObjectIds_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndObjectIds [{}][{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByResourceTypeAndObjectIds(
                tenantId, ResourceType.LWM2M_MODEL, new String[] {"Object Ids"}));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId,
   * ResourceType, String[])}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseResourceService.findTenantResourcesByResourceTypeAndObjectIds(TenantId, ResourceType, String[])"
  })
  public void testFindTenantResourcesByResourceTypeAndObjectIds_thenReturnEmpty() {
    // Arrange
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(
            Mockito.<TenantId>any(),
            Mockito.<ResourceType>any(),
            Mockito.<ResourceSubType>any(),
            Mockito.<String[]>any(),
            Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TbResource> actualFindTenantResourcesByResourceTypeAndObjectIdsResult =
        baseResourceService.findTenantResourcesByResourceTypeAndObjectIds(
            ModelConstants.SYSTEM_TENANT, ResourceType.LWM2M_MODEL, new String[] {"Object Ids"});

    // Assert
    verify(tbResourceDao)
        .findResourcesByTenantIdAndResourceType(
            isA(TenantId.class),
            eq(ResourceType.LWM2M_MODEL),
            isNull(),
            isA(String[].class),
            isNull());
    assertTrue(actualFindTenantResourcesByResourceTypeAndObjectIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseResourceService.findAllTenantResources(TenantId, PageLink)"})
  public void testFindAllTenantResources_thenThrowConstraintViolationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findAllTenantResources [{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findAllTenantResources(
                tenantId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findAllTenantResources(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseResourceService.findAllTenantResources(TenantId, PageLink)"})
  public void testFindAllTenantResources_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResource> actualFindAllTenantResourcesResult =
        baseResourceService.findAllTenantResources(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantResourcesResult);
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId,
   * ResourceType, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)"
  })
  public void testFindTenantResourcesByResourceTypeAndPageLink() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndPageLink [{}][{}][{}]");
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(
            Mockito.<TenantId>any(),
            Mockito.<ResourceType>any(),
            Mockito.<ResourceSubType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByResourceTypeAndPageLink(
                ModelConstants.SYSTEM_TENANT,
                ResourceType.LWM2M_MODEL,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(tbResourceDao)
        .findResourcesByTenantIdAndResourceType(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), isNull(), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId,
   * ResourceType, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)"
  })
  public void testFindTenantResourcesByResourceTypeAndPageLink_thenCallsGetId() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findTenantResourcesByResourceTypeAndPageLink [{}][{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findTenantResourcesByResourceTypeAndPageLink(
                tenantId, ResourceType.LWM2M_MODEL, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId,
   * ResourceType, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseResourceService#findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseResourceService.findTenantResourcesByResourceTypeAndPageLink(TenantId, ResourceType, PageLink)"
  })
  public void testFindTenantResourcesByResourceTypeAndPageLink_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findResourcesByTenantIdAndResourceType(
            Mockito.<TenantId>any(),
            Mockito.<ResourceType>any(),
            Mockito.<ResourceSubType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResource> actualFindTenantResourcesByResourceTypeAndPageLinkResult =
        baseResourceService.findTenantResourcesByResourceTypeAndPageLink(
            ModelConstants.SYSTEM_TENANT,
            ResourceType.LWM2M_MODEL,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceDao)
        .findResourcesByTenantIdAndResourceType(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantResourcesByResourceTypeAndPageLinkResult);
  }

  /**
   * Test {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResourcesByTenantId(TenantId)"})
  public void testDeleteResourcesByTenantId_thenCallsFindAllByTenantId() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseResourceService.deleteResourcesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteResourcesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteResourcesByTenantId(TenantId)"})
  public void testDeleteResourcesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteResourcesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.deleteResourcesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceDao#findAllByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindAllByTenantId() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceDao.findAllByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseResourceService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).findAllByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseResourceService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteResourcesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseResourceService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseResourceService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<ResourceInfoCacheKey>any(),
            Mockito.<Supplier<TbResourceInfo>>any(),
            anyBoolean()))
        .thenReturn(tbResourceInfo);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseResourceService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tbResourceInfo, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseResourceService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseResourceService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findResourceInfoById [{}] [{}]");
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<ResourceInfoCacheKey>any(),
            Mockito.<Supplier<TbResourceInfo>>any(),
            anyBoolean()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(ResourceInfoCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link BaseResourceService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseResourceService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseResourceService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertEquals(EntityType.TB_RESOURCE, baseResourceService.getEntityType());
  }

  /**
   * Test {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseResourceService.sumDataSizeByTenantId(TenantId)"})
  public void testSumDataSizeByTenantId_thenReturnOne() {
    // Arrange
    when(tbResourceDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualSumDataSizeByTenantIdResult =
        baseResourceService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbResourceDao).sumDataSizeByTenantId(isA(TenantId.class));
    assertEquals(1L, actualSumDataSizeByTenantIdResult);
  }

  /**
   * Test {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#sumDataSizeByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseResourceService.sumDataSizeByTenantId(TenantId)"})
  public void testSumDataSizeByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tbResourceDao.sumDataSizeByTenantId(Mockito.<TenantId>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseResourceService.sumDataSizeByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbResourceDao).sumDataSizeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource2() {
    // Arrange
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(new TbResource());
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource3() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResource.getTenantId()).thenThrow(constraintViolationException);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(new TbResource());
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    TbResource tbResource2 = new TbResource();
    tbResource2.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource2);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(
        ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource5() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = new TbResource();
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(mock(TbResource.class));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource6() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    doThrow(constraintViolationException).when(tbResource).setEtag(Mockito.<String>any());
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getId();
    verify(tbResource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource7() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getData()).thenReturn(null);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenThrow(constraintViolationException);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getCreatedTime();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource8() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getData()).thenReturn(null);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);

    TbResource tbResource2 = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResource2.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource2);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getCreatedTime();
    verify(tbResource2).getId();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource9() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getData()).thenReturn(null);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);

    TbResource tbResource2 = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(tbResource2.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource2);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getCreatedTime();
    verify(tbResource2).getId();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource10() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    doThrow(constraintViolationException).when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource).setData(isA(byte[].class));
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource11() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResource.getResourceType()).thenThrow(constraintViolationException);
    when(tbResource.getTitle()).thenReturn("Dr");
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getId();
    verify(tbResource).getResourceType();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).getTitle();
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource12() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResource.getData()).thenThrow(constraintViolationException);
    when(tbResource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource.getTitle()).thenReturn("Dr");
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getId();
    verify(tbResource).getResourceType();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).getTitle();
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource13() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    when(tbResource.getResourceKey()).thenThrow(constraintViolationException);
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource.getFileName()).thenReturn("foo.txt");
    when(tbResource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource.getTitle()).thenReturn("Dr");
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource, atLeast(1)).getFileName();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource).getResourceKey();
    verify(tbResource).getResourceType();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).getTitle();
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#save(TenantId, Object)} return {@link
   *       TbResource#TbResource()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_givenTbResourceDaoSaveReturnTbResource() {
    // Arrange
    TbResource tbResource = new TbResource();
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(new TbResource());
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    TbResource actualCreateOrUpdateSystemResourceResult =
        baseResourceService.createOrUpdateSystemResource(
            ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertSame(tbResource, actualCreateOrUpdateSystemResourceResult);
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResource#getResourceKey()} return {@code Resource Key}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_givenTbResourceGetResourceKeyReturnResourceKey()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    doThrow(constraintViolationException).when(tbResource).setEtag(Mockito.<String>any());
    when(tbResource.getResourceKey()).thenReturn("Resource Key");
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource.getFileName()).thenReturn("foo.txt");
    when(tbResource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource.getTitle()).thenReturn("Dr");
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource, atLeast(1)).getFileName();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource).getResourceKey();
    verify(tbResource, atLeast(1)).getResourceType();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).getTitle();
    verify(tbResource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResource#getResourceType()} return {@code JS_MODULE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_givenTbResourceGetResourceTypeReturnJsModule()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findResourceByTenantIdAndKey [{}] [{}] [{}]");
    doThrow(constraintViolationException).when(tbResource).setEtag(Mockito.<String>any());
    when(tbResource.getResourceKey()).thenReturn("Resource Key");
    when(tbResource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource.getFileName()).thenReturn("foo.txt");
    when(tbResource.getResourceType()).thenReturn(ResourceType.JS_MODULE);
    when(tbResource.getTitle()).thenReturn("Dr");
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());

    JpaTbResourceDao resourceDao = mock(JpaTbResourceDao.class);
    when(resourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource, atLeast(1)).getFileName();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource).getResourceKey();
    verify(tbResource, atLeast(1)).getResourceType();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).getTitle();
    verify(tbResource).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(resourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfoDao} {@link TbResourceInfoDao#save(TenantId, Object)} return
   *       {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_givenTbResourceInfoDaoSaveReturnTbResourceInfo() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getData()).thenReturn(null);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(new TbResourceInfo());
    TbResource tbResource2 = new TbResource();
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(tbResource2);

    // Act
    TbResource actualCreateOrUpdateSystemResourceResult =
        baseResourceService.createOrUpdateSystemResource(
            ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getCreatedTime();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
    assertEquals(tbResource2, actualCreateOrUpdateSystemResourceResult);
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResource#setEtag(String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_givenTbResourceSetEtagDoesNothing()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    TbResource tbResource2 = mock(TbResource.class);
    doNothing().when(tbResource2).setEtag(Mockito.<String>any());
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource2).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource2).setId(Mockito.<TbResourceId>any());
    tbResource2.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource2);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(
        ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource2, atLeast(1)).getData();
    verify(tbResource2).setData(isA(byte[].class));
    verify(tbResource).getId();
    verify(tbResource2, atLeast(1)).getId();
    verify(tbResource).getTenantId();
    verify(tbResource2).getTenantId();
    verify(tbResource2).setEtag("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc");
    verify(tbResource2).setId(isA(TbResourceId.class));
    verify(tbResourceDao).save(isA(TenantId.class), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceDao#save(TenantId, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_thenCallsSave() {
    // Arrange
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(tbResourceDao.save(Mockito.<TenantId>any(), Mockito.<TbResource>any()))
        .thenReturn(tbResource);
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(new TbResource());
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act
    baseResourceService.createOrUpdateSystemResource(
        ResourceType.LWM2M_MODEL, "Resource Key", "Data");

    // Assert
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(tbResourceDao).save(isNull(), isA(TbResource.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#createOrUpdateSystemResource(ResourceType, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#createOrUpdateSystemResource(ResourceType,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResource BaseResourceService.createOrUpdateSystemResource(ResourceType, String, String)"
  })
  public void testCreateOrUpdateSystemResource_thenThrowDataValidationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());

    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getData()).thenReturn(null);
    when(tbResource.getCreatedTime()).thenReturn(1L);
    when(tbResource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tbResource).setData(Mockito.<byte[]>any());
    doNothing().when(tbResource).setId(Mockito.<TbResourceId>any());
    tbResource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    when(tbResourceDao.findResourceByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);

    TbResource tbResource2 = mock(TbResource.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "resource_unq_key");
    when(tbResource2.getId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.save(Mockito.<TenantId>any(), Mockito.<TbResourceInfo>any()))
        .thenReturn(tbResource2);
    when(resourceDataValidator.validate(
            Mockito.<TbResource>any(), Mockito.<Function<TbResource, TenantId>>any()))
        .thenReturn(new TbResource());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseResourceService.createOrUpdateSystemResource(
                ResourceType.LWM2M_MODEL, "Resource Key", "Data"));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
    verify(tbResource, atLeast(1)).getData();
    verify(tbResource).setData(isA(byte[].class));
    verify(tbResource).getCreatedTime();
    verify(tbResource2).getId();
    verify(tbResource, atLeast(1)).getId();
    verify(tbResource, atLeast(1)).getTenantId();
    verify(tbResource).setId(isA(TbResourceId.class));
    verify(tbResourceInfoDao).save(isA(TenantId.class), isA(TbResourceInfo.class));
    verify(tbResourceDao)
        .findResourceByTenantIdAndKey(
            isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("Resource Key"));
    verify(resourceDataValidator).validate(isA(TbResource.class), isA(Function.class));
  }

  /**
   * Test {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   *
   * <p>Method under test: {@link BaseResourceService#checkSystemResourcesUsage(String,
   * ResourceType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseResourceService.checkSystemResourcesUsage(String, ResourceType[])"
  })
  public void testCheckSystemResourcesUsage() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "${RESOURCE:U}");
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.checkSystemResourcesUsage(
                "${RESOURCE:U}", ResourceType.LWM2M_MODEL));
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
  }

  /**
   * Test {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#checkSystemResourcesUsage(String,
   * ResourceType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseResourceService.checkSystemResourcesUsage(String, ResourceType[])"
  })
  public void testCheckSystemResourcesUsage_thenCallsGetUuidId() {
    // Arrange
    TbResourceInfo tbResourceInfo = mock(TbResourceInfo.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(tbResourceInfo.getUuidId()).thenThrow(constraintViolationException);
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseResourceService.checkSystemResourcesUsage(
                "${RESOURCE:U}", ResourceType.LWM2M_MODEL));
    verify(tbResourceInfo).getUuidId();
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
  }

  /**
   * Test {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   *
   * <ul>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#checkSystemResourcesUsage(String,
   * ResourceType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseResourceService.checkSystemResourcesUsage(String, ResourceType[])"
  })
  public void testCheckSystemResourcesUsage_thenReturn138140001dd211b28080808080808080() {
    // Arrange
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(new TbResourceInfo(new TbResourceId(ModelConstants.NULL_UUID)));

    // Act
    String actualCheckSystemResourcesUsageResult =
        baseResourceService.checkSystemResourcesUsage("${RESOURCE:U}", ResourceType.LWM2M_MODEL);

    // Assert
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCheckSystemResourcesUsageResult);
  }

  /**
   * Test {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#checkSystemResourcesUsage(String,
   * ResourceType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseResourceService.checkSystemResourcesUsage(String, ResourceType[])"
  })
  public void testCheckSystemResourcesUsage_thenReturnEmptyString() {
    // Arrange
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    String actualCheckSystemResourcesUsageResult =
        baseResourceService.checkSystemResourcesUsage("${RESOURCE:U}", ResourceType.LWM2M_MODEL);

    // Assert
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.LWM2M_MODEL), eq("U"));
    assertEquals("", actualCheckSystemResourcesUsageResult);
  }

  /**
   * Test {@link BaseResourceService#checkSystemResourcesUsage(String, ResourceType[])}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#checkSystemResourcesUsage(String,
   * ResourceType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BaseResourceService.checkSystemResourcesUsage(String, ResourceType[])"
  })
  public void testCheckSystemResourcesUsage_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "Not all who wander are lost",
        baseResourceService.checkSystemResourcesUsage(
            "Not all who wander are lost", ResourceType.LWM2M_MODEL));
  }

  /**
   * Test {@link BaseResourceService#calculateEtag(byte[])}.
   *
   * <p>Method under test: {@link BaseResourceService#calculateEtag(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseResourceService.calculateEtag(byte[])"})
  public void testCalculateEtag() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseResourceService.calculateEtag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)} with {@code
   * ResourceInfoEvictEvent}.
   *
   * <p>Method under test: {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.handleEvictEvent(ResourceInfoEvictEvent)"})
  public void testHandleEvictEventWithResourceInfoEvictEvent() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    doThrow(constraintViolationException)
        .when(tbTransactionalCache)
        .evict(Mockito.<ResourceInfoCacheKey>any());
    ResourceInfoEvictEvent event =
        new ResourceInfoEvictEvent(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseResourceService.handleEvictEvent(event));
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
  }

  /**
   * Test {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)} with {@code
   * ResourceInfoEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseResourceService#handleEvictEvent(ResourceInfoEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseResourceService.handleEvictEvent(ResourceInfoEvictEvent)"})
  public void testHandleEvictEventWithResourceInfoEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<ResourceInfoCacheKey>any());
    ResourceInfoEvictEvent event =
        new ResourceInfoEvictEvent(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    baseResourceService.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(ResourceInfoCacheKey.class));
  }
}
