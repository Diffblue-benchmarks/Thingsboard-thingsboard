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
package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;

@ContextConfiguration(classes = {DefaultNotificationTemplateService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationTemplateServiceDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @Autowired private DefaultNotificationTemplateService defaultNotificationTemplateService;

  @MockBean private NotificationRequestDao notificationRequestDao;

  @MockBean private NotificationTemplateDao notificationTemplateDao;

  /**
   * Test {@link DefaultNotificationTemplateService#findNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.findNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testFindNotificationTemplateById_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplate);

    // Act
    NotificationTemplate actualFindNotificationTemplateByIdResult =
        defaultNotificationTemplateService.findNotificationTemplateById(
            ModelConstants.SYSTEM_TENANT, new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(notificationTemplate, actualFindNotificationTemplateByIdResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#findNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.findNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testFindNotificationTemplateById_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.findNotificationTemplateById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTemplateId(ModelConstants.NULL_UUID)));
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate() {
    // Arrange
    when(notificationTemplateDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.saveNotificationTemplate(
                ModelConstants.SYSTEM_TENANT, new NotificationTemplate()));
    verify(notificationTemplateDao)
        .saveAndFlush(isA(TenantId.class), isA(NotificationTemplate.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate2() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplate);
    when(notificationTemplateDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(new NotificationTemplate());

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setId(new NotificationTemplateId(UUID.randomUUID()));

    // Act
    NotificationTemplate actualSaveNotificationTemplateResult =
        defaultNotificationTemplateService.saveNotificationTemplate(
            ModelConstants.SYSTEM_TENANT, notificationTemplate2);

    // Assert
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(notificationTemplateDao)
        .saveAndFlush(isA(TenantId.class), isA(NotificationTemplate.class));
    assertEquals(notificationTemplate, actualSaveNotificationTemplateResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate3() {
    // Arrange
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setId(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.saveNotificationTemplate(
                ModelConstants.SYSTEM_TENANT, notificationTemplate));
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTemplateDao}.
   *   <li>Then calls {@link NotificationTemplateId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate_givenNotificationTemplateDao_thenCallsGetId() {
    // Arrange
    NotificationTemplateId notificationTemplateId = mock(NotificationTemplateId.class);
    when(notificationTemplateId.getId()).thenThrow(new IllegalArgumentException());

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setId(notificationTemplateId);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.saveNotificationTemplate(
                ModelConstants.SYSTEM_TENANT, notificationTemplate));
    verify(notificationTemplateId).getId();
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTemplate#getNotificationType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate_thenCallsGetNotificationType() {
    // Arrange
    NotificationTemplate notificationTemplate = mock(NotificationTemplate.class);
    when(notificationTemplate.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplate);

    NotificationTemplate notificationTemplate2 = new NotificationTemplate();
    notificationTemplate2.setId(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.saveNotificationTemplate(
                ModelConstants.SYSTEM_TENANT, notificationTemplate2));
    verify(notificationTemplate).getNotificationType();
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#saveNotificationTemplate(TenantId,
   * NotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#saveNotificationTemplate(TenantId, NotificationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplate DefaultNotificationTemplateService.saveNotificationTemplate(TenantId, NotificationTemplate)"
  })
  public void testSaveNotificationTemplate_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<NotificationTemplate>any()))
        .thenReturn(notificationTemplate);

    // Act
    NotificationTemplate actualSaveNotificationTemplateResult =
        defaultNotificationTemplateService.saveNotificationTemplate(
            ModelConstants.SYSTEM_TENANT, new NotificationTemplate());

    // Assert
    verify(notificationTemplateDao)
        .saveAndFlush(isA(TenantId.class), isA(NotificationTemplate.class));
    assertSame(notificationTemplate, actualSaveNotificationTemplateResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List, PageLink)"
  })
  public void testFindNotificationTemplatesByTenantIdAndNotificationTypes() {
    // Arrange
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService
                .findNotificationTemplatesByTenantIdAndNotificationTypes(
                    ModelConstants.SYSTEM_TENANT,
                    new ArrayList<>(),
                    BaseRelatedEdgesService.FIRST_PAGE));
    verify(notificationTemplateDao)
        .findByTenantIdAndNotificationTypesAndPageLink(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List, PageLink)"
  })
  public void testFindNotificationTemplatesByTenantIdAndNotificationTypes_givenAlarm() {
    // Arrange
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    PageData<NotificationTemplate>
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult =
            defaultNotificationTemplateService
                .findNotificationTemplatesByTenantIdAndNotificationTypes(
                    ModelConstants.SYSTEM_TENANT,
                    notificationTypes,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateDao)
        .findByTenantIdAndNotificationTypesAndPageLink(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code GENERAL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List, PageLink)"
  })
  public void testFindNotificationTemplatesByTenantIdAndNotificationTypes_givenGeneral() {
    // Arrange
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    PageData<NotificationTemplate>
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult =
            defaultNotificationTemplateService
                .findNotificationTemplatesByTenantIdAndNotificationTypes(
                    ModelConstants.SYSTEM_TENANT,
                    notificationTypes,
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateDao)
        .findByTenantIdAndNotificationTypesAndPageLink(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData DefaultNotificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List, PageLink)"
  })
  public void testFindNotificationTemplatesByTenantIdAndNotificationTypes_whenArrayList() {
    // Arrange
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(
            Mockito.<TenantId>any(),
            Mockito.<List<NotificationType>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<NotificationTemplate>
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult =
            defaultNotificationTemplateService
                .findNotificationTemplatesByTenantIdAndNotificationTypes(
                    ModelConstants.SYSTEM_TENANT,
                    new ArrayList<>(),
                    BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(notificationTemplateDao)
        .findByTenantIdAndNotificationTypesAndPageLink(
            isA(TenantId.class), isA(List.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService
                .countNotificationTemplatesByTenantIdAndNotificationTypes(
                    ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(notificationTemplateDao)
        .countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_givenAlarm() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult =
        defaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateDao)
        .countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code GENERAL}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_givenGeneral() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult =
        defaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateDao)
        .countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"
  })
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_whenArrayList() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(
            Mockito.<TenantId>any(), Mockito.<List<NotificationType>>any()))
        .thenReturn(1);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult =
        defaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTemplateDao)
        .countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testDeleteNotificationTemplateById() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteNotificationTemplateById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTemplateId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testDeleteNotificationTemplateById2() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteNotificationTemplateById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTemplateId(ModelConstants.NULL_UUID)));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testDeleteNotificationTemplateById3() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteNotificationTemplateById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTemplateId(ModelConstants.NULL_UUID)));
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTemplateRepository#deleteById(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testDeleteNotificationTemplateById_thenCallsDeleteById() {
    // Arrange
    NotificationTemplateRepository notificationTemplateRepository =
        mock(NotificationTemplateRepository.class);
    doThrow(new IllegalArgumentException())
        .when(notificationTemplateRepository)
        .deleteById(Mockito.<UUID>any());
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(notificationTemplateRepository);

    JpaNotificationRequestDao notificationRequestDao = mock(JpaNotificationRequestDao.class);
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(false);

    DefaultNotificationTemplateService defaultNotificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteNotificationTemplateById(
                ModelConstants.SYSTEM_TENANT,
                new NotificationTemplateId(ModelConstants.NULL_UUID)));
    verify(notificationTemplateRepository).deleteById(isA(UUID.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationTemplateDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplateById(TenantId,
   * NotificationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplateById(TenantId, NotificationTemplateId)"
  })
  public void testDeleteNotificationTemplateById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(false);

    // Act
    defaultNotificationTemplateService.deleteNotificationTemplateById(
        ModelConstants.SYSTEM_TENANT, new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity3() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, null, false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class), eq(NotificationRequestStatus.SCHEDULED), isNull());
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity4() {
    // Arrange
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, null, false));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class), eq(NotificationRequestStatus.SCHEDULED), isNull());
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>When {@link NotificationTemplateId#NotificationTemplateId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_whenNotificationTemplateIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(notificationRequestDao.existsByTenantIdAndStatusAndTemplateId(
            Mockito.<TenantId>any(),
            Mockito.<NotificationRequestStatus>any(),
            Mockito.<NotificationTemplateId>any()))
        .thenReturn(false);

    // Act
    defaultNotificationTemplateService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, new NotificationTemplateId(ModelConstants.NULL_UUID), false);

    // Assert
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(notificationRequestDao)
        .existsByTenantIdAndStatusAndTemplateId(
            isA(TenantId.class),
            eq(NotificationRequestStatus.SCHEDULED),
            isA(NotificationTemplateId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteEntity(TenantId,
   * EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteEntity(TenantId, EntityId, boolean)"
  })
  public void testDeleteEntity_whenNull_customer_id_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(notificationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    defaultNotificationTemplateService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(notificationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplatesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplatesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplatesByTenantId(TenantId)"
  })
  public void testDeleteNotificationTemplatesByTenantId() {
    // Arrange
    doNothing().when(notificationTemplateDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTemplateService.deleteNotificationTemplatesByTenantId(
        ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplatesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationTemplateService#deleteNotificationTemplatesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultNotificationTemplateService.deleteNotificationTemplatesByTenantId(TenantId)"
  })
  public void testDeleteNotificationTemplatesByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationTemplateDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.deleteNotificationTemplatesByTenantId(
                ModelConstants.SYSTEM_TENANT));
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTemplateDao} {@link
   *       NotificationTemplateDao#removeByTenantId(TenantId)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultNotificationTemplateService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNotificationTemplateDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationTemplateDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTemplateService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultNotificationTemplateService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(notificationTemplateDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultNotificationTemplateService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultNotificationTemplateService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenReturnPresent() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplate);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        defaultNotificationTemplateService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(notificationTemplate, actualFindEntityResult.get());
  }

  /**
   * Test {@link DefaultNotificationTemplateService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultNotificationTemplateService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(notificationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultNotificationTemplateService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(notificationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#getEntityType()}.
   *
   * <p>Method under test: {@link DefaultNotificationTemplateService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DefaultNotificationTemplateService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService defaultNotificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);

    // Act and Assert
    assertEquals(
        EntityType.NOTIFICATION_TEMPLATE, defaultNotificationTemplateService.getEntityType());
  }
}
