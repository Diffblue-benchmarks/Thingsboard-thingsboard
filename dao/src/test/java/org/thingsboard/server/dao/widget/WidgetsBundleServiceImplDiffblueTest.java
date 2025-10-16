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
package org.thingsboard.server.dao.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {WidgetsBundleServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class WidgetsBundleServiceImplDiffblueTest {
  @MockBean private DataValidator<WidgetsBundle> dataValidator;

  @MockBean private ImageService imageService;

  @MockBean private ResourceService resourceService;

  @MockBean private WidgetTypeService widgetTypeService;

  @MockBean private WidgetsBundleDao widgetsBundleDao;

  @Autowired private WidgetsBundleServiceImpl widgetsBundleServiceImpl;

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link WidgetsBundleId} {@link WidgetsBundleId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleById(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetsBundleById_givenNull_uuid_whenWidgetsBundleIdGetIdReturnNull_uuid() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundle);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundle actualFindWidgetsBundleByIdResult =
        widgetsBundleServiceImpl.findWidgetsBundleById(
            ModelConstants.SYSTEM_TENANT, widgetsBundleId);

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetsBundle, actualFindWidgetsBundleByIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleById(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetsBundleById_thenThrowIncorrectParameterException() {
    // Arrange
    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findWidgetsBundleById(
                ModelConstants.SYSTEM_TENANT, widgetsBundleId));
    verify(widgetsBundleId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findWidgetsBundleById(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleById(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetsBundleById_whenWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundle);

    // Act
    WidgetsBundle actualFindWidgetsBundleByIdResult =
        widgetsBundleServiceImpl.findWidgetsBundleById(
            ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetsBundle, actualFindWidgetsBundleByIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleServiceImpl.saveWidgetsBundle(WidgetsBundle)"})
  public void testSaveWidgetsBundle() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(widgetsBundleDao.save(Mockito.<TenantId>any(), Mockito.<WidgetsBundle>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenReturn(new WidgetsBundle());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.saveWidgetsBundle(new WidgetsBundle()));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("bundle"));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
    verify(widgetsBundleDao).save(isNull(), isA(WidgetsBundle.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   *
   * <ul>
   *   <li>Given {@link ImageService}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleServiceImpl.saveWidgetsBundle(WidgetsBundle)"})
  public void testSaveWidgetsBundle_givenImageService_thenThrowIncorrectParameterException() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.saveWidgetsBundle(new WidgetsBundle()));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   *
   * <ul>
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleServiceImpl.saveWidgetsBundle(WidgetsBundle)"})
  public void testSaveWidgetsBundle_thenReturnOrderIsNull() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(widgetsBundleDao.save(Mockito.<TenantId>any(), Mockito.<WidgetsBundle>any()))
        .thenReturn(new WidgetsBundle());
    when(dataValidator.validate(
            Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenReturn(new WidgetsBundle());

    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setId(new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Act
    WidgetsBundle actualSaveWidgetsBundleResult =
        widgetsBundleServiceImpl.saveWidgetsBundle(widgetsBundle);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("bundle"));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
    verify(widgetsBundleDao).save(isNull(), isA(WidgetsBundle.class));
    assertNull(actualSaveWidgetsBundleResult.getOrder());
    assertNull(actualSaveWidgetsBundleResult.getVersion());
    assertNull(actualSaveWidgetsBundleResult.getAlias());
    assertNull(actualSaveWidgetsBundleResult.getDescription());
    assertNull(actualSaveWidgetsBundleResult.getImage());
    assertNull(actualSaveWidgetsBundleResult.getName());
    assertNull(actualSaveWidgetsBundleResult.getTitle());
    assertNull(actualSaveWidgetsBundleResult.getUuidId());
    assertNull(actualSaveWidgetsBundleResult.getTenantId());
    assertNull(actualSaveWidgetsBundleResult.getExternalId());
    assertNull(actualSaveWidgetsBundleResult.getId());
    assertEquals(0L, actualSaveWidgetsBundleResult.getCreatedTime());
    assertFalse(actualSaveWidgetsBundleResult.isScada());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#saveWidgetsBundle(WidgetsBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleServiceImpl.saveWidgetsBundle(WidgetsBundle)"})
  public void testSaveWidgetsBundle_thenReturnWidgetsBundle() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.save(Mockito.<TenantId>any(), Mockito.<WidgetsBundle>any()))
        .thenReturn(widgetsBundle);
    when(dataValidator.validate(
            Mockito.<WidgetsBundle>any(), Mockito.<Function<WidgetsBundle, TenantId>>any()))
        .thenReturn(new WidgetsBundle());

    // Act
    WidgetsBundle actualSaveWidgetsBundleResult =
        widgetsBundleServiceImpl.saveWidgetsBundle(new WidgetsBundle());

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("bundle"));
    verify(dataValidator).validate(isA(WidgetsBundle.class), isA(Function.class));
    verify(widgetsBundleDao).save(isNull(), isA(WidgetsBundle.class));
    assertSame(widgetsBundle, actualSaveWidgetsBundleResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.deleteWidgetsBundle(
                ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID)));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle2() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(widgetsBundleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new WidgetsBundle());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.deleteWidgetsBundle(
                ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID)));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle3() {
    // Arrange
    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.deleteWidgetsBundle(
                ModelConstants.SYSTEM_TENANT, widgetsBundleId));
    verify(widgetsBundleId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link WidgetsBundleId} {@link WidgetsBundleId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle_givenNull_uuid_whenWidgetsBundleIdGetIdReturnNull_uuid() {
    // Arrange
    doNothing().when(widgetsBundleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new WidgetsBundle());

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundle(ModelConstants.SYSTEM_TENANT, widgetsBundleId);

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleDao} {@link WidgetsBundleDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle_givenWidgetsBundleDaoFindByIdReturnNull() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.deleteWidgetsBundle(
                ModelConstants.SYSTEM_TENANT, widgetsBundleId));
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundle(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetsBundleServiceImpl.deleteWidgetsBundle(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetsBundle_thenCallsRemoveById() {
    // Arrange
    doNothing().when(widgetsBundleDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new WidgetsBundle());

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundle(
        ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(TenantId, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias() {
    // Arrange
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(
                ModelConstants.SYSTEM_TENANT, "Alias"));
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(TenantId, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(tenantId, "Alias"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(TenantId, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias_givenNull_uuid() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundle);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetsBundle actualFindWidgetsBundleByTenantIdAndAliasResult =
        widgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(tenantId, "Alias");

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
    assertSame(widgetsBundle, actualFindWidgetsBundleByTenantIdAndAliasResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findWidgetsBundleByTenantIdAndAlias(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetsBundle WidgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(TenantId, String)"
  })
  public void testFindWidgetsBundleByTenantIdAndAlias_thenReturnWidgetsBundle() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findWidgetsBundleByTenantIdAndAlias(
            Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetsBundle);

    // Act
    WidgetsBundle actualFindWidgetsBundleByTenantIdAndAliasResult =
        widgetsBundleServiceImpl.findWidgetsBundleByTenantIdAndAlias(
            ModelConstants.SYSTEM_TENANT, "Alias");

    // Assert
    verify(widgetsBundleDao).findWidgetsBundleByTenantIdAndAlias(isA(UUID.class), eq("Alias"));
    assertSame(widgetsBundle, actualFindWidgetsBundleByTenantIdAndAliasResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink() {
    // Arrange
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(
                null, BaseRelatedEdgesService.FIRST_PAGE));
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink4() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindSystemWidgetsBundlesByPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindSystemWidgetsBundlesByPageLinkResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundlesByPageLink(
            null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao).findSystemWidgetsBundles(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetsBundlesByPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List WidgetsBundleServiceImpl.findSystemWidgetsBundles(TenantId)"})
  public void testFindSystemWidgetsBundles_thenReturnEmpty() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    List<WidgetsBundle> actualFindSystemWidgetsBundlesResult =
        widgetsBundleServiceImpl.findSystemWidgetsBundles(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao)
        .findSystemWidgetsBundles(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertTrue(actualFindSystemWidgetsBundlesResult.isEmpty());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findSystemWidgetsBundles(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List WidgetsBundleServiceImpl.findSystemWidgetsBundles(TenantId)"})
  public void testFindSystemWidgetsBundles_thenThrowIncorrectParameterException() {
    // Arrange
    when(widgetsBundleDao.findSystemWidgetsBundles(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findSystemWidgetsBundles(ModelConstants.SYSTEM_TENANT));
    verify(widgetsBundleDao)
        .findSystemWidgetsBundles(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId() {
    // Arrange
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId4() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
                ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId6() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
                tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId_givenZero_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(TenantId, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink() {
    // Arrange
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
                WidgetsBundleFilter.builder()
                    .fullSearch(true)
                    .scadaFirst(true)
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink2() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink3() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink4() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink5() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink6() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink7() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink8() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
                WidgetsBundleFilter.builder()
                    .fullSearch(true)
                    .scadaFirst(true)
                    .tenantId(tenantId)
                    .build(),
                mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink_thenCallsGetId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantIdAndPageLink_whenFirst_page() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantIdAndPageLink(
            WidgetsBundleFilter.builder()
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink() {
    // Arrange
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                WidgetsBundleFilter.builder()
                    .fullSearch(true)
                    .scadaFirst(true)
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .build(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink2() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink3() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink4() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink5() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink6() {
    // Arrange
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink7() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                WidgetsBundleFilter.builder()
                    .fullSearch(true)
                    .scadaFirst(true)
                    .tenantId(tenantId)
                    .build(),
                mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder().fullSearch(true).scadaFirst(true).tenantId(tenantId).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleFilter#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_thenCallsGetTenantId() {
    // Arrange
    WidgetsBundleServiceImpl widgetsBundleServiceImpl = new WidgetsBundleServiceImpl();

    WidgetsBundleFilter widgetsBundleFilter = mock(WidgetsBundleFilter.class);
    when(widgetsBundleFilter.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
                widgetsBundleFilter, pageLink));
    verify(pageLink).getPageSize();
    verify(widgetsBundleFilter).getTenantId();
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_whenFirst_page() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            WidgetsBundleFilter.builder()
                .fullSearch(true)
                .scadaFirst(true)
                .tenantId(ModelConstants.SYSTEM_TENANT)
                .build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(WidgetsBundleFilter, PageLink)"
  })
  public void testFindTenantWidgetsBundlesByTenantIdAndPageLink_whenPageLinkGetPageReturnZero() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleFilter widgetsBundleFilter =
        WidgetsBundleFilter.builder()
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetsBundle> actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult =
        widgetsBundleServiceImpl.findTenantWidgetsBundlesByTenantIdAndPageLink(
            widgetsBundleFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetsBundlesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(TenantId)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId() {
    // Arrange
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(
                ModelConstants.SYSTEM_TENANT));
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(TenantId)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(TenantId)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetsBundleServiceImpl#findAllTenantWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(TenantId)"
  })
  public void testFindAllTenantWidgetsBundlesByTenantId_thenReturnEmpty() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllTenantWidgetsBundlesByTenantId(
            Mockito.<WidgetsBundleFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    List<WidgetsBundle> actualFindAllTenantWidgetsBundlesByTenantIdResult =
        widgetsBundleServiceImpl.findAllTenantWidgetsBundlesByTenantId(
            ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao)
        .findAllTenantWidgetsBundlesByTenantId(isA(WidgetsBundleFilter.class), isA(PageLink.class));
    assertTrue(actualFindAllTenantWidgetsBundlesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId3() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));

    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleDao} {@link WidgetsBundleDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId_givenWidgetsBundleDaoFindByIdReturnNull() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));

    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId_thenCallsHasNext() {
    // Arrange
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteWidgetsBundlesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(TenantId)"})
  public void testDeleteWidgetsBundlesByTenantId_thenCallsRemoveById() {
    // Arrange
    ArrayList<WidgetsBundle> widgetsBundleList = new ArrayList<>();
    widgetsBundleList.add(new WidgetsBundle(new WidgetsBundleId(ModelConstants.NULL_UUID)));

    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(widgetsBundleList);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(widgetsBundleDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new WidgetsBundle());
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteWidgetsBundlesByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetsBundleServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetData() {
    // Arrange
    PageData<WidgetsBundle> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(widgetsBundleDao.findTenantWidgetsBundlesByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetsBundleServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(widgetsBundleDao)
        .findTenantWidgetsBundlesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(
            Mockito.<String>any(), isA(ResourceType[].class)))
        .thenReturn("Check System Resources Usage");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets2() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(
            Mockito.<String>any(), isA(ResourceType[].class)))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets3() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(
            Mockito.<String>any(), isA(ResourceType[].class)))
        .thenReturn("");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets_given42_whenArrayListAdd42_thenThrowRuntimeException() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("foo");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets_givenNull_whenArrayListAddNull_thenThrowRuntimeException() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);
    stringList.add("foo");
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}.
   *
   * <ul>
   *   <li>Given {@link ResourceService} {@link ResourceService#checkSystemResourcesUsage(String,
   *       ResourceType[])} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#updateSystemWidgets(Stream, Stream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleServiceImpl.updateSystemWidgets(Stream, Stream)"})
  public void testUpdateSystemWidgets_givenResourceServiceCheckSystemResourcesUsageReturn42() {
    // Arrange
    when(resourceService.checkSystemResourcesUsage(
            Mockito.<String>any(), isA(ResourceType[].class)))
        .thenReturn("42");

    ArrayList<String> stringList = new ArrayList<>();
    Stream<String> bundles = stringList.stream();

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("foo");
    Stream<String> widgets = stringList2.stream();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetsBundleServiceImpl.updateSystemWidgets(bundles, widgets));
    verify(resourceService).checkSystemResourcesUsage(eq("foo"), isA(ResourceType[].class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WidgetsBundleServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> widgetsBundleServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WidgetsBundleServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundle);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        widgetsBundleServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetsBundle, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WidgetsBundleServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenThrowIncorrectParameterException() {
    // Arrange
    when(widgetsBundleDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            widgetsBundleServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(widgetsBundleDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetsBundleServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link WidgetsBundleServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType WidgetsBundleServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGETS_BUNDLE, new WidgetsBundleServiceImpl().getEntityType());
  }
}
