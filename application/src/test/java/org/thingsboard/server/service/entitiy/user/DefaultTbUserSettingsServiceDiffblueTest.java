package org.thingsboard.server.service.entitiy.user;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserDashboardsInfo;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsService;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

class DefaultTbUserSettingsServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbUserSettingsService#saveUserSettings(TenantId, UserSettings)}.
   * <ul>
   *   <li>Then calls {@link UserSettings#setSettingsBytes(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#saveUserSettings(TenantId, UserSettings)}
   */
  @Test
  @DisplayName("Test saveUserSettings(TenantId, UserSettings); then calls setSettingsBytes(byte[])")
  void testSaveUserSettings_thenCallsSetSettingsBytes() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsService settingsService = mock(UserSettingsService.class);
    when(settingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserSettings userSettings2 = mock(UserSettings.class);
    doNothing().when(userSettings2).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings2).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings2).setType(Mockito.<UserSettingsType>any());
    userSettings2.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    // Act
    defaultTbUserSettingsService.saveUserSettings(tenantId, userSettings2);

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings2).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings2).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettings2).setUserId(isNull());
    verify(settingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)}.
   * <ul>
   *   <li>Then calls
   * {@link UserSettingsServiceImpl#updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)}
   */
  @Test
  @DisplayName("Test updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode); then calls updateUserSettings(TenantId, UserId, UserSettingsType, JsonNode)")
  void testUpdateUserSettings_thenCallsUpdateUserSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    doNothing().when(settingsService)
        .updateUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any(),
            Mockito.<JsonNode>any());
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId userId = new UserId(UUID.randomUUID());

    // Act
    defaultTbUserSettingsService.updateUserSettings(tenantId, userId, UserSettingsType.GENERAL,
        MissingNode.getInstance());

    // Assert that nothing has changed
    verify(settingsService).updateUserSettings(isA(TenantId.class), isA(UserId.class), eq(UserSettingsType.GENERAL),
        isA(JsonNode.class));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#findUserSettings(TenantId, UserId, UserSettingsType)}.
   * <ul>
   *   <li>Then calls {@link UserSettings#setSettingsBytes(byte[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#findUserSettings(TenantId, UserId, UserSettingsType)}
   */
  @Test
  @DisplayName("Test findUserSettings(TenantId, UserId, UserSettingsType); then calls setSettingsBytes(byte[])")
  void testFindUserSettings_thenCallsSetSettingsBytes() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    when(settingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());

    // Act
    defaultTbUserSettingsService.findUserSettings(new TenantId(UUID.randomUUID()), null, UserSettingsType.GENERAL);

    // Assert
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(settingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.GENERAL));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(TenantId, UserId, UserSettingsType, List); given '42'; when ArrayList() add '42'; then calls deleteUserSettings(TenantId, UserId, UserSettingsType, List)")
  void testDeleteUserSettings_given42_whenArrayListAdd42_thenCallsDeleteUserSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    doNothing().when(settingsService)
        .deleteUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any(),
            Mockito.<List<String>>any());
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId userId = new UserId(UUID.randomUUID());

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("42");
    jsonPaths.add("foo");

    // Act
    defaultTbUserSettingsService.deleteUserSettings(tenantId, userId, UserSettingsType.GENERAL, jsonPaths);

    // Assert that nothing has changed
    verify(settingsService).deleteUserSettings(isA(TenantId.class), isA(UserId.class), eq(UserSettingsType.GENERAL),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(TenantId, UserId, UserSettingsType, List); given 'foo'; when ArrayList() add 'foo'; then calls deleteUserSettings(TenantId, UserId, UserSettingsType, List)")
  void testDeleteUserSettings_givenFoo_whenArrayListAddFoo_thenCallsDeleteUserSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    doNothing().when(settingsService)
        .deleteUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any(),
            Mockito.<List<String>>any());
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId userId = new UserId(UUID.randomUUID());

    ArrayList<String> jsonPaths = new ArrayList<>();
    jsonPaths.add("foo");

    // Act
    defaultTbUserSettingsService.deleteUserSettings(tenantId, userId, UserSettingsType.GENERAL, jsonPaths);

    // Assert that nothing has changed
    verify(settingsService).deleteUserSettings(isA(TenantId.class), isA(UserId.class), eq(UserSettingsType.GENERAL),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls
   * {@link UserSettingsServiceImpl#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#deleteUserSettings(TenantId, UserId, UserSettingsType, List)}
   */
  @Test
  @DisplayName("Test deleteUserSettings(TenantId, UserId, UserSettingsType, List); when ArrayList(); then calls deleteUserSettings(TenantId, UserId, UserSettingsType, List)")
  void testDeleteUserSettings_whenArrayList_thenCallsDeleteUserSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    doNothing().when(settingsService)
        .deleteUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any(),
            Mockito.<List<String>>any());
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UserId userId = new UserId(UUID.randomUUID());

    // Act
    defaultTbUserSettingsService.deleteUserSettings(tenantId, userId, UserSettingsType.GENERAL, new ArrayList<>());

    // Assert that nothing has changed
    verify(settingsService).deleteUserSettings(isA(TenantId.class), isA(UserId.class), eq(UserSettingsType.GENERAL),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test findUserDashboardsInfo(TenantId, UserId); given UserSettings getSettings() return Instance")
  void testFindUserDashboardsInfo_givenUserSettingsGetSettingsReturnInstance() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(MissingNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    when(settingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());

    // Act
    UserDashboardsInfo actualFindUserDashboardsInfoResult = defaultTbUserSettingsService
        .findUserDashboardsInfo(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(settingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.VISITED_DASHBOARDS));
    assertSame(actualFindUserDashboardsInfoResult.EMPTY, actualFindUserDashboardsInfoResult);
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test findUserDashboardsInfo(TenantId, UserId); given UserSettings getSettings() return Instance")
  void testFindUserDashboardsInfo_givenUserSettingsGetSettingsReturnInstance2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(NullNode.getInstance());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    when(settingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());

    // Act
    UserDashboardsInfo actualFindUserDashboardsInfoResult = defaultTbUserSettingsService
        .findUserDashboardsInfo(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(settingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.VISITED_DASHBOARDS));
    assertSame(actualFindUserDashboardsInfoResult.EMPTY, actualFindUserDashboardsInfoResult);
  }

  /**
   * Test
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbUserSettingsService#findUserDashboardsInfo(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test findUserDashboardsInfo(TenantId, UserId); given UserSettings getSettings() return 'null'")
  void testFindUserDashboardsInfo_givenUserSettingsGetSettingsReturnNull() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    UserSettingsServiceImpl settingsService = mock(UserSettingsServiceImpl.class);
    when(settingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);
    DefaultTbUserSettingsService defaultTbUserSettingsService = new DefaultTbUserSettingsService(settingsService,
        new DashboardServiceImpl());

    // Act
    UserDashboardsInfo actualFindUserDashboardsInfoResult = defaultTbUserSettingsService
        .findUserDashboardsInfo(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(settingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.VISITED_DASHBOARDS));
    assertSame(actualFindUserDashboardsInfoResult.EMPTY, actualFindUserDashboardsInfoResult);
  }
}
