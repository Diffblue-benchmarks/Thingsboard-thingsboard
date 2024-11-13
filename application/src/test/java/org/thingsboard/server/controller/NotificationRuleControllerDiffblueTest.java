package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRuleInfo;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.NotificationRuleDao;
import org.thingsboard.server.service.security.model.SecurityUser;

class NotificationRuleControllerDiffblueTest {
  /**
   * Test
   * {@link NotificationRuleController#getNotificationRules(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleController#getNotificationRules(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRules(int, int, String, String, String, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationRules_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleDao notificationRuleDao = mock(NotificationRuleDao.class);
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationRuleController notificationRuleController = new NotificationRuleController(
        new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    PageData<NotificationRuleInfo> actualNotificationRules = notificationRuleController.getNotificationRules(3, 1,
        "Text Search", "U", "asc", new SecurityUser());

    // Assert
    verify(notificationRuleDao).findInfosByTenantIdAndPageLink(isNull(), isA(PageLink.class));
    assertSame(actualNotificationRules.EMPTY_PAGE_DATA, actualNotificationRules);
  }

  /**
   * Test
   * {@link NotificationRuleController#getNotificationRules(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleController#getNotificationRules(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationRules(int, int, String, String, String, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotificationRules_whenEmptyString_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleDao notificationRuleDao = mock(NotificationRuleDao.class);
    PageData<NotificationRuleInfo> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleDao.findInfosByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationRuleController notificationRuleController = new NotificationRuleController(
        new DefaultNotificationRuleService(notificationRuleDao));

    // Act
    PageData<NotificationRuleInfo> actualNotificationRules = notificationRuleController.getNotificationRules(3, 1,
        "Text Search", "U", "", new SecurityUser());

    // Assert
    verify(notificationRuleDao).findInfosByTenantIdAndPageLink(isNull(), isA(PageLink.class));
    assertSame(actualNotificationRules.EMPTY_PAGE_DATA, actualNotificationRules);
  }
}
