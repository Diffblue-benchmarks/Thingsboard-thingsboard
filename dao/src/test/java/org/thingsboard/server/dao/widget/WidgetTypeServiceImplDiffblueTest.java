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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.widget.DeprecatedFilter;
import org.thingsboard.server.common.data.widget.WidgetType;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter.WidgetTypeFilterBuilder;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.common.data.widget.WidgetsBundleWidget;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {WidgetTypeServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class WidgetTypeServiceImplDiffblueTest {
  @MockBean private DataValidator<WidgetTypeDetails> dataValidator;

  @MockBean private ImageService imageService;

  @MockBean private WidgetTypeDao widgetTypeDao;

  @Autowired private WidgetTypeServiceImpl widgetTypeServiceImpl;

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType WidgetTypeServiceImpl.findWidgetTypeById(TenantId, WidgetTypeId)"})
  public void testFindWidgetTypeById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetType);

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetType actualFindWidgetTypeByIdResult =
        widgetTypeServiceImpl.findWidgetTypeById(ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetType, actualFindWidgetTypeByIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@link WidgetType#WidgetType()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeById(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetType WidgetTypeServiceImpl.findWidgetTypeById(TenantId, WidgetTypeId)"})
  public void testFindWidgetTypeById_whenWidgetTypeIdWithIdIsNull_uuid_thenReturnWidgetType() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetType);

    // Act
    WidgetType actualFindWidgetTypeByIdResult =
        widgetTypeServiceImpl.findWidgetTypeById(
            ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetType, actualFindWidgetTypeByIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId,
   * WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeServiceImpl.findWidgetTypeDetailsById(TenantId, WidgetTypeId)"
  })
  public void testFindWidgetTypeDetailsById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetails);

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByIdResult =
        widgetTypeServiceImpl.findWidgetTypeDetailsById(ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeId, atLeast(1)).getId();
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeDetailsById(TenantId,
   * WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeServiceImpl.findWidgetTypeDetailsById(TenantId, WidgetTypeId)"
  })
  public void testFindWidgetTypeDetailsById_whenWidgetTypeIdWithIdIsNull_uuid() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetails);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByIdResult =
        widgetTypeServiceImpl.findWidgetTypeDetailsById(
            ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId,
   * WidgetTypeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)"
  })
  public void testWidgetTypeExistsByTenantIdAndWidgetTypeId_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(widgetTypeDao.existsByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult =
        widgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(
            ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeId, atLeast(1)).getId();
    verify(widgetTypeDao).existsByTenantIdAndId(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId,
   * WidgetTypeId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)"
  })
  public void testWidgetTypeExistsByTenantIdAndWidgetTypeId_thenReturnFalse() {
    // Arrange
    when(widgetTypeDao.existsByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult =
        widgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(
            ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeId, atLeast(1)).getId();
    verify(widgetTypeDao).existsByTenantIdAndId(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId,
   * WidgetTypeId)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WidgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(TenantId, WidgetTypeId)"
  })
  public void testWidgetTypeExistsByTenantIdAndWidgetTypeId_whenWidgetTypeIdWithIdIsNull_uuid() {
    // Arrange
    when(widgetTypeDao.existsByTenantIdAndId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult =
        widgetTypeServiceImpl.widgetTypeExistsByTenantIdAndWidgetTypeId(
            ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).existsByTenantIdAndId(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualWidgetTypeExistsByTenantIdAndWidgetTypeIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>Given {@link ImageService}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeServiceImpl.saveWidgetType(WidgetTypeDetails)"})
  public void testSaveWidgetType_givenImageService_thenThrowRuntimeException() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetTypeServiceImpl.saveWidgetType(new WidgetTypeDetails()));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDao} {@link WidgetTypeDao#save(TenantId, WidgetTypeDetails)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeServiceImpl.saveWidgetType(WidgetTypeDetails)"})
  public void testSaveWidgetType_givenWidgetTypeDaoSaveThrowRuntimeException() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<WidgetTypeDetails>any())).thenReturn(true);
    when(widgetTypeDao.save(Mockito.<TenantId>any(), Mockito.<WidgetTypeDetails>any()))
        .thenThrow(new RuntimeException());
    when(dataValidator.validate(
            Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenReturn(new WidgetTypeDetails());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> widgetTypeServiceImpl.saveWidgetType(new WidgetTypeDetails()));
    verify(imageService).replaceBase64WithImageUrl(isA(WidgetTypeDetails.class));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
    verify(widgetTypeDao).save(isNull(), isA(WidgetTypeDetails.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then return Descriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeServiceImpl.saveWidgetType(WidgetTypeDetails)"})
  public void testSaveWidgetType_givenWidgetTypeIdWithIdIsNull_uuid_thenReturnDescriptorIsNull() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<WidgetTypeDetails>any())).thenReturn(true);
    when(widgetTypeDao.save(Mockito.<TenantId>any(), Mockito.<WidgetTypeDetails>any()))
        .thenReturn(new WidgetTypeDetails());
    when(dataValidator.validate(
            Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenReturn(new WidgetTypeDetails());

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setId(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    WidgetTypeDetails actualSaveWidgetTypeResult =
        widgetTypeServiceImpl.saveWidgetType(widgetTypeDetails);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(WidgetTypeDetails.class));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
    verify(widgetTypeDao).save(isNull(), isA(WidgetTypeDetails.class));
    assertNull(actualSaveWidgetTypeResult.getDescriptor());
    assertNull(actualSaveWidgetTypeResult.getVersion());
    assertNull(actualSaveWidgetTypeResult.getFqn());
    assertNull(actualSaveWidgetTypeResult.getName());
    assertNull(actualSaveWidgetTypeResult.getDescription());
    assertNull(actualSaveWidgetTypeResult.getImage());
    assertNull(actualSaveWidgetTypeResult.getTags());
    assertNull(actualSaveWidgetTypeResult.getUuidId());
    assertNull(actualSaveWidgetTypeResult.getTenantId());
    assertNull(actualSaveWidgetTypeResult.getId());
    assertNull(actualSaveWidgetTypeResult.getExternalId());
    assertEquals(0L, actualSaveWidgetTypeResult.getCreatedTime());
    assertFalse(actualSaveWidgetTypeResult.isDeprecated());
    assertFalse(actualSaveWidgetTypeResult.isScada());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#saveWidgetType(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeServiceImpl.saveWidgetType(WidgetTypeDetails)"})
  public void testSaveWidgetType_thenReturnWidgetTypeDetails() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<WidgetTypeDetails>any())).thenReturn(true);
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.save(Mockito.<TenantId>any(), Mockito.<WidgetTypeDetails>any()))
        .thenReturn(widgetTypeDetails);
    when(dataValidator.validate(
            Mockito.<WidgetTypeDetails>any(), Mockito.<Function<WidgetTypeDetails, TenantId>>any()))
        .thenReturn(new WidgetTypeDetails());

    // Act
    WidgetTypeDetails actualSaveWidgetTypeResult =
        widgetTypeServiceImpl.saveWidgetType(new WidgetTypeDetails());

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(WidgetTypeDetails.class));
    verify(dataValidator).validate(isA(WidgetTypeDetails.class), isA(Function.class));
    verify(widgetTypeDao).save(isNull(), isA(WidgetTypeDetails.class));
    assertSame(widgetTypeDetails, actualSaveWidgetTypeResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteWidgetType(TenantId, WidgetTypeId)"})
  public void testDeleteWidgetType_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteWidgetType(ModelConstants.SYSTEM_TENANT, widgetTypeId);

    // Assert
    verify(widgetTypeId, atLeast(1)).getId();
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetType(TenantId, WidgetTypeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteWidgetType(TenantId, WidgetTypeId)"})
  public void testDeleteWidgetType_whenWidgetTypeIdWithIdIsNull_uuid_thenCallsRemoveById() {
    // Arrange
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    widgetTypeServiceImpl.deleteWidgetType(
        ModelConstants.SYSTEM_TENANT, new WidgetTypeId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindSystemWidgetTypesByPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult =
        widgetTypeServiceImpl.findSystemWidgetTypesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindSystemWidgetTypesByPageLink_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult =
        widgetTypeServiceImpl.findSystemWidgetTypesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindSystemWidgetTypesByPageLink_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult =
        widgetTypeServiceImpl.findSystemWidgetTypesByPageLink(null, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findSystemWidgetTypesByPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindSystemWidgetTypesByPageLink_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findSystemWidgetTypes(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<WidgetTypeInfo> actualFindSystemWidgetTypesByPageLinkResult =
        widgetTypeServiceImpl.findSystemWidgetTypesByPageLink(
            null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao).findSystemWidgetTypes(isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSystemWidgetTypesByPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao)
        .findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_thenCallsGetProperty() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindAllTenantWidgetTypesByTenantIdAndPageLink_whenFirst_page() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<WidgetTypeInfo> actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findAllTenantWidgetTypesByTenantIdAndPageLink(
            tenantIdResult.widgetTypes(new ArrayList<>()).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao)
        .findAllTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantIdAndPageLink() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(tenantId);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_thenCallsGetProperty() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);
    WidgetTypeFilter widgetTypeFilter = tenantIdResult.widgetTypes(new ArrayList<>()).build();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(
            widgetTypeFilter, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(WidgetTypeFilter, PageLink)"
  })
  public void testFindTenantWidgetTypesByTenantIdAndPageLink_whenFirst_page() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    WidgetTypeFilterBuilder tenantIdResult =
        WidgetTypeFilter.builder()
            .deprecatedFilter(DeprecatedFilter.ALL)
            .fullSearch(true)
            .scadaFirst(true)
            .tenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<WidgetTypeInfo> actualFindTenantWidgetTypesByTenantIdAndPageLinkResult =
        widgetTypeServiceImpl.findTenantWidgetTypesByTenantIdAndPageLink(
            tenantIdResult.widgetTypes(new ArrayList<>()).build(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantWidgetTypesByTenantIdAndPageLinkResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesByWidgetsBundleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(
            tenantId, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypesByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesByWidgetsBundleId_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(tenantId, widgetsBundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypesByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypesByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetType> actualFindWidgetTypesByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypesByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesDetailsByWidgetsBundleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(
            tenantId, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesDetailsByWidgetsBundleId_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(tenantId, widgetsBundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetTypesDetailsByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetTypesDetailsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<WidgetTypeDetails> actualFindWidgetTypesDetailsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesDetailsByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetTypesDetailsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetTypesDetailsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given a string.
   *   <li>When {@link ArrayList#ArrayList()} add a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenAString_whenArrayListAddAString() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add(
        "Executing findWidgetTypesInfosByWidgetsBundleId, tenantId [{}], widgetsBundleId [{}], fullSearch [{}],"
            + " deprecatedFilter [{}], widgetTypes [{}], pageLink [{}]");

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            tenantId, widgetsBundleId, true, DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenBy_created_time_desc() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenFoo_whenArrayListAddFoo() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> widgetTypes = new ArrayList<>();
    widgetTypes.add("foo");
    widgetTypes.add(
        "Executing findWidgetTypesInfosByWidgetsBundleId, tenantId [{}], widgetsBundleId [{}], fullSearch [{}],"
            + " deprecatedFilter [{}], widgetTypes [{}], pageLink [{}]");

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            tenantId, widgetsBundleId, true, DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            tenantId, widgetsBundleId, true, DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            tenantId, widgetsBundleId, true, DeprecatedFilter.ALL, widgetTypes, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_thenCallsGetProperty() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    ArrayList<String> widgetTypes = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            widgetTypes,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId,
   * WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean,
   * DeprecatedFilter, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData WidgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(TenantId, WidgetsBundleId, boolean, DeprecatedFilter, List, PageLink)"
  })
  public void testFindWidgetTypesInfosByWidgetsBundleId_whenFirst_page() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    PageData<WidgetTypeInfo> actualFindWidgetTypesInfosByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetTypesInfosByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT,
            widgetsBundleId,
            true,
            DeprecatedFilter.ALL,
            new ArrayList<>(),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(true),
            eq(DeprecatedFilter.ALL),
            isA(List.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindWidgetTypesInfosByWidgetsBundleIdResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetFqnsByWidgetsBundleId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(
            tenantId, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetFqnsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetFqnsByWidgetsBundleId_thenCallsGetId() {
    // Arrange
    when(widgetTypeDao.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(tenantId, widgetsBundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetFqnsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetFqnsByWidgetsBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List WidgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(TenantId, WidgetsBundleId)"
  })
  public void testFindWidgetFqnsByWidgetsBundleId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(widgetTypeDao.findWidgetFqnsByWidgetsBundleId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindWidgetFqnsByWidgetsBundleIdResult =
        widgetTypeServiceImpl.findWidgetFqnsByWidgetsBundleId(
            ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao).findWidgetFqnsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindWidgetFqnsByWidgetsBundleIdResult.isEmpty());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetType WidgetTypeServiceImpl.findWidgetTypeByTenantIdAndFqn(TenantId, String)"
  })
  public void testFindWidgetTypeByTenantIdAndFqn_givenNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetType);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetType actualFindWidgetTypeByTenantIdAndFqnResult =
        widgetTypeServiceImpl.findWidgetTypeByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetType, actualFindWidgetTypeByTenantIdAndFqnResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link WidgetType#WidgetType()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findWidgetTypeByTenantIdAndFqn(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetType WidgetTypeServiceImpl.findWidgetTypeByTenantIdAndFqn(TenantId, String)"
  })
  public void testFindWidgetTypeByTenantIdAndFqn_thenReturnWidgetType() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetType);

    // Act
    WidgetType actualFindWidgetTypeByTenantIdAndFqnResult =
        widgetTypeServiceImpl.findWidgetTypeByTenantIdAndFqn(ModelConstants.SYSTEM_TENANT, "Fqn");

    // Assert
    verify(widgetTypeDao).findByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetType, actualFindWidgetTypeByTenantIdAndFqnResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeServiceImpl.findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)"
  })
  public void testFindWidgetTypeDetailsByTenantIdAndFqn_givenNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findDetailsByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetails);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByTenantIdAndFqnResult =
        widgetTypeServiceImpl.findWidgetTypeDetailsByTenantIdAndFqn(tenantId, "Fqn");

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findDetailsByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByTenantIdAndFqnResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeServiceImpl#findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "WidgetTypeDetails WidgetTypeServiceImpl.findWidgetTypeDetailsByTenantIdAndFqn(TenantId, String)"
  })
  public void testFindWidgetTypeDetailsByTenantIdAndFqn_thenReturnWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    when(widgetTypeDao.findDetailsByTenantIdAndFqn(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(widgetTypeDetails);

    // Act
    WidgetTypeDetails actualFindWidgetTypeDetailsByTenantIdAndFqnResult =
        widgetTypeServiceImpl.findWidgetTypeDetailsByTenantIdAndFqn(
            ModelConstants.SYSTEM_TENANT, "Fqn");

    // Assert
    verify(widgetTypeDao).findDetailsByTenantIdAndFqn(isA(UUID.class), eq("Fqn"));
    assertSame(widgetTypeDetails, actualFindWidgetTypeDetailsByTenantIdAndFqnResult);
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeId() {
    // Arrange
    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(new WidgetsBundleId(ModelConstants.NULL_UUID), widgetTypeId, 1);

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(mock(WidgetTypeId.class));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsNull() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(UUID.randomUUID()), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(null));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsNull2() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(
            new WidgetsBundleId(ModelConstants.NULL_UUID), mock(WidgetTypeId.class), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(null));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsRandomUUID() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(UUID.randomUUID()), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsRandomUUID2() {
    // Arrange
    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(UUID.randomUUID()), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId2, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsGetId() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsGetId2() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_thenCallsGetId3() {
    // Arrange
    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(new WidgetsBundleId(ModelConstants.NULL_UUID), widgetTypeId, 1);

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(tenantId, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_whenArrayList() {
    // Arrange
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_whenSystem_tenant() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetTypes(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetTypes_whenSystem_tenant2() {
    // Arrange
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIds.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetTypes(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, widgetTypeIds);

    // Assert
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add(
        "Executing updateWidgetsBundleWidgetFqns, tenantId [{}], widgetsBundleId [{}], widgetFqns [{}]");

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(tenantId, widgetsBundleId, widgetFqns);

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add(
        "Executing updateWidgetsBundleWidgetTypes, tenantId [{}], widgetsBundleId [{}], widgetTypeIds [{}]");
    widgetFqns.add(
        "Executing updateWidgetsBundleWidgetFqns, tenantId [{}], widgetsBundleId [{}], widgetFqns [{}]");

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(tenantId, widgetsBundleId, widgetFqns);

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns3() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(UUID.randomUUID()));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId2, new ArrayList<>());

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_givenArrayListAddWidgetTypeId() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(mock(WidgetTypeId.class));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId2, new ArrayList<>());

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link WidgetTypeId#WidgetTypeId(UUID)} with id
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_givenArrayListAddWidgetTypeIdWithIdIsNull() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(null));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId2, new ArrayList<>());

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link WidgetTypeId#WidgetTypeId(UUID)} with id
   *       is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_givenArrayListAddWidgetTypeIdWithIdIsNull2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(null));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(
            new WidgetsBundleId(ModelConstants.NULL_UUID), mock(WidgetTypeId.class), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_givenWidgetTypeIdWithIdIsNull_uuid() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(widgetsBundleId, new WidgetTypeId(ModelConstants.NULL_UUID), 1);
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId2 = mock(WidgetsBundleId.class);
    when(widgetsBundleId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId2, new ArrayList<>());

    // Assert
    verify(widgetsBundleId2, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsGetId() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsGetId2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(UUID.randomUUID()));

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(new WidgetsBundleId(ModelConstants.NULL_UUID), widgetTypeId, 1);

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_thenCallsGetId3() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIdList.add(new WidgetTypeId(UUID.randomUUID()));

    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleWidget widgetsBundleWidget =
        new WidgetsBundleWidget(new WidgetsBundleId(ModelConstants.NULL_UUID), widgetTypeId, 1);

    ArrayList<WidgetsBundleWidget> widgetsBundleWidgetList = new ArrayList<>();
    widgetsBundleWidgetList.add(widgetsBundleWidget);
    doNothing()
        .when(widgetTypeDao)
        .removeWidgetTypeFromWidgetsBundle(Mockito.<UUID>any(), Mockito.<UUID>any());
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleWidgetList);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId widgetsBundleId = mock(WidgetsBundleId.class);
    when(widgetsBundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(widgetsBundleId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).removeWidgetTypeFromWidgetsBundle(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_whenSystem_tenant() {
    // Arrange
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_whenSystem_tenant2() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_whenSystem_tenant3() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        ModelConstants.SYSTEM_TENANT, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao, atLeast(1)).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundleId#WidgetsBundleId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId,
   * WidgetsBundleId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)"
  })
  public void testUpdateWidgetsBundleWidgetFqns_whenWidgetsBundleIdWithIdIsNull_uuid() {
    // Arrange
    ArrayList<WidgetTypeId> widgetTypeIdList = new ArrayList<>();
    widgetTypeIdList.add(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDao).saveWidgetsBundleWidget(Mockito.<WidgetsBundleWidget>any());
    when(widgetTypeDao.findWidgetTypeIdsByTenantIdAndFqns(
            Mockito.<UUID>any(), Mockito.<List<String>>any()))
        .thenReturn(widgetTypeIdList);
    when(widgetTypeDao.findWidgetsBundleWidgetsByWidgetsBundleId(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.updateWidgetsBundleWidgetFqns(
        tenantId, widgetsBundleId, new ArrayList<>());

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao).findWidgetTypeIdsByTenantIdAndFqns(isA(UUID.class), isA(List.class));
    verify(widgetTypeDao)
        .findWidgetsBundleWidgetsByWidgetsBundleId(isA(UUID.class), isA(UUID.class));
    verify(widgetTypeDao).saveWidgetsBundleWidget(isA(WidgetsBundleWidget.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeDao#findTenantWidgetTypesByTenantId(WidgetTypeFilter,
   *       PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteWidgetTypesByTenantId(TenantId)"})
  public void testDeleteWidgetTypesByTenantId_thenCallsFindTenantWidgetTypesByTenantId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeDao#findWidgetTypesInfosByWidgetsBundleId(UUID, UUID,
   *       boolean, DeprecatedFilter, List, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetTypesByBundleId_thenCallsFindWidgetTypesInfosByWidgetsBundleId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(
        ModelConstants.SYSTEM_TENANT, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(false),
            eq(DeprecatedFilter.ALL),
            isNull(),
            isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetTypesByBundleId_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(
        tenantId, new WidgetsBundleId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(false),
            eq(DeprecatedFilter.ALL),
            isNull(),
            isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetsBundleId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetTypesByBundleId_thenCallsGetId2() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId bundleId = mock(WidgetsBundleId.class);
    when(bundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(tenantId, bundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(bundleId, atLeast(1)).getId();
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(false),
            eq(DeprecatedFilter.ALL),
            isNull(),
            isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetTypesByBundleId_thenCallsGetId3() {
    // Arrange
    WidgetTypeId widgetTypeId = mock(WidgetTypeId.class);
    when(widgetTypeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setId(widgetTypeId);

    ArrayList<WidgetTypeInfo> data = new ArrayList<>();
    data.add(widgetTypeInfo);
    PageData<WidgetTypeInfo> pageData = new PageData<>(data, 100, 100L, false);
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId bundleId = mock(WidgetsBundleId.class);
    when(bundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(tenantId, bundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(widgetTypeId, atLeast(1)).getId();
    verify(bundleId, atLeast(1)).getId();
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(false),
            eq(DeprecatedFilter.ALL),
            isNull(),
            isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteWidgetTypesByBundleId(TenantId,
   * WidgetsBundleId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WidgetTypeServiceImpl.deleteWidgetTypesByBundleId(TenantId, WidgetsBundleId)"
  })
  public void testDeleteWidgetTypesByBundleId_thenCallsRemoveById() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setId(new WidgetTypeId(ModelConstants.NULL_UUID));

    ArrayList<WidgetTypeInfo> data = new ArrayList<>();
    data.add(widgetTypeInfo);
    PageData<WidgetTypeInfo> pageData = new PageData<>(data, 100, 100L, false);
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetTypeDao.findWidgetTypesInfosByWidgetsBundleId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            anyBoolean(),
            Mockito.<DeprecatedFilter>any(),
            Mockito.<List<String>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    WidgetsBundleId bundleId = mock(WidgetsBundleId.class);
    when(bundleId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteWidgetTypesByBundleId(tenantId, bundleId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(bundleId, atLeast(1)).getId();
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetTypeDao)
        .findWidgetTypesInfosByWidgetsBundleId(
            isA(UUID.class),
            isA(UUID.class),
            eq(false),
            eq(DeprecatedFilter.ALL),
            isNull(),
            isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    widgetTypeServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    PageData<WidgetTypeInfo> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link WidgetTypeDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenWidgetTypeIdWithIdIsNull_uuid_thenCallsRemoveById() {
    // Arrange
    ArrayList<WidgetTypeInfo> widgetTypeInfoList = new ArrayList<>();
    widgetTypeInfoList.add(new WidgetTypeInfo(new WidgetTypeId(ModelConstants.NULL_UUID)));

    PageData<WidgetTypeInfo> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(widgetTypeInfoList);
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link WidgetTypeInfo#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsGetUuidId() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = mock(WidgetTypeInfo.class);
    when(widgetTypeInfo.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<WidgetTypeInfo> widgetTypeInfoList = new ArrayList<>();
    widgetTypeInfoList.add(widgetTypeInfo);

    PageData<WidgetTypeInfo> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(widgetTypeInfoList);
    doNothing().when(widgetTypeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(widgetTypeDao.findTenantWidgetTypesByTenantId(
            Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    widgetTypeServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(widgetTypeInfo).getUuidId();
    verify(tenantId).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(widgetTypeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(widgetTypeDao)
        .findTenantWidgetTypesByTenantId(isA(WidgetTypeFilter.class), isA(PageLink.class));
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WidgetTypeServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetType);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        widgetTypeServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetType, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WidgetTypeServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    when(widgetTypeDao.findWidgetTypeById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(widgetType);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        widgetTypeServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(widgetTypeDao).findWidgetTypeById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(widgetType, actualFindEntityResult.get());
  }

  /**
   * Test {@link WidgetTypeServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link WidgetTypeServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType WidgetTypeServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGET_TYPE, new WidgetTypeServiceImpl().getEntityType());
  }
}
