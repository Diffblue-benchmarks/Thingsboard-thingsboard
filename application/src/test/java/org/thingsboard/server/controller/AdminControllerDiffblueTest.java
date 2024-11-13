package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.server.common.data.FeaturesInfo;
import org.thingsboard.server.common.data.SystemInfo;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.SystemSecurityService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.sync.vc.autocommit.TbAutoCommitSettingsService;
import org.thingsboard.server.service.system.SystemInfoService;
import org.thingsboard.server.service.update.UpdateService;

class AdminControllerDiffblueTest {
  /**
   * Test {@link AdminController#checkUpdates()}.
   * <p>
   * Method under test: {@link AdminController#checkUpdates()}
   */
  @Test
  @DisplayName("Test checkUpdates()")
  void testCheckUpdates() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateService updateService = mock(UpdateService.class);
    UpdateMessage updateMessage = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    when(updateService.checkUpdates()).thenReturn(updateMessage);

    // Act
    UpdateMessage actualCheckUpdatesResult = (new AdminController(mock(MailService.class), mock(SmsService.class),
        mock(AdminSettingsService.class), mock(SystemSecurityService.class), mock(SecuritySettingsService.class),
        mock(JwtSettingsService.class), mock(JwtTokenFactory.class), mock(EntitiesVersionControlService.class),
        mock(TbAutoCommitSettingsService.class), updateService, mock(SystemInfoService.class),
        mock(AuditLogService.class))).checkUpdates();

    // Assert
    verify(updateService).checkUpdates();
    assertSame(updateMessage, actualCheckUpdatesResult);
  }

  /**
   * Test {@link AdminController#getSystemInfo()}.
   * <p>
   * Method under test: {@link AdminController#getSystemInfo()}
   */
  @Test
  @DisplayName("Test getSystemInfo()")
  void testGetSystemInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());
    SystemInfoService systemInfoService = mock(SystemInfoService.class);
    when(systemInfoService.getSystemInfo()).thenReturn(systemInfo);

    // Act
    SystemInfo actualSystemInfo = (new AdminController(mock(MailService.class), mock(SmsService.class),
        mock(AdminSettingsService.class), mock(SystemSecurityService.class), mock(SecuritySettingsService.class),
        mock(JwtSettingsService.class), mock(JwtTokenFactory.class), mock(EntitiesVersionControlService.class),
        mock(TbAutoCommitSettingsService.class), mock(UpdateService.class), systemInfoService,
        mock(AuditLogService.class))).getSystemInfo();

    // Assert
    verify(systemInfoService).getSystemInfo();
    assertSame(systemInfo, actualSystemInfo);
  }

  /**
   * Test {@link AdminController#getFeaturesInfo()}.
   * <p>
   * Method under test: {@link AdminController#getFeaturesInfo()}
   */
  @Test
  @DisplayName("Test getFeaturesInfo()")
  void testGetFeaturesInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);
    SystemInfoService systemInfoService = mock(SystemInfoService.class);
    when(systemInfoService.getFeaturesInfo()).thenReturn(featuresInfo);

    // Act
    FeaturesInfo actualFeaturesInfo = (new AdminController(mock(MailService.class), mock(SmsService.class),
        mock(AdminSettingsService.class), mock(SystemSecurityService.class), mock(SecuritySettingsService.class),
        mock(JwtSettingsService.class), mock(JwtTokenFactory.class), mock(EntitiesVersionControlService.class),
        mock(TbAutoCommitSettingsService.class), mock(UpdateService.class), systemInfoService,
        mock(AuditLogService.class))).getFeaturesInfo();

    // Assert
    verify(systemInfoService).getFeaturesInfo();
    assertSame(featuresInfo, actualFeaturesInfo);
  }

  /**
   * Test
   * {@link AdminController#codeProcessingUrl(String, String, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminController#codeProcessingUrl(String, String, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test codeProcessingUrl(String, String, HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then throw ThingsboardException")
  void testCodeProcessingUrl_whenMockHttpServletRequest_thenThrowThingsboardException()
      throws IOException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SystemSecurityService systemSecurityService = mock(SystemSecurityService.class);
    when(systemSecurityService.getBaseUrl(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<HttpServletRequest>any())).thenReturn("https://example.org/example");
    AdminController adminController = new AdminController(mock(MailService.class), mock(SmsService.class),
        mock(AdminSettingsService.class), systemSecurityService, mock(SecuritySettingsService.class),
        mock(JwtSettingsService.class), mock(JwtTokenFactory.class), mock(EntitiesVersionControlService.class),
        mock(TbAutoCommitSettingsService.class), mock(UpdateService.class), mock(SystemInfoService.class),
        mock(AuditLogService.class));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> adminController.codeProcessingUrl("https://example.org/example",
        "https://example.org/example", request, new Response()));
    verify(systemSecurityService).getBaseUrl(isA(TenantId.class), isA(CustomerId.class), isA(HttpServletRequest.class));
  }
}
