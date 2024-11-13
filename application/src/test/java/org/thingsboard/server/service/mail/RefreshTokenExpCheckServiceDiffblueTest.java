package org.thingsboard.server.service.mail;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.settings.AdminSettingsService;

class RefreshTokenExpCheckServiceDiffblueTest {
  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given AdminSettings getJsonValue() return Instance; then calls getJsonValue()")
  void testCheck_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }

  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given AdminSettingsService findAdminSettingsByKey(TenantId, String) return 'null'")
  void testCheck_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }

  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#asText()} return
   * {@code As Text}.</li>
   *   <li>Then calls {@link JsonNode#asBoolean()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given JsonNode asText() return 'As Text'; then calls asBoolean()")
  void testCheck_givenJsonNodeAsTextReturnAsText_thenCallsAsBoolean() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.asText()).thenReturn("As Text");
    when(jsonNode.asBoolean()).thenReturn(true);
    JsonNode jsonNode2 = mock(JsonNode.class);
    when(jsonNode2.get(Mockito.<String>any())).thenReturn(jsonNode);
    when(jsonNode2.has(Mockito.<String>any())).thenReturn(true);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode2);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(jsonNode).asBoolean();
    verify(jsonNode).asText();
    verify(jsonNode2, atLeast(1)).get(Mockito.<String>any());
    verify(jsonNode2).has(eq("enableOauth2"));
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }

  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return False.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given JsonNode get(String) return False; then calls get(String)")
  void testCheck_givenJsonNodeGetReturnFalse_thenCallsGet() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(jsonNode).get(eq("enableOauth2"));
    verify(jsonNode).has(eq("enableOauth2"));
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }

  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   *   <li>Then calls {@link JsonNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given JsonNode get(String) return Instance; then calls get(String)")
  void testCheck_givenJsonNodeGetReturnInstance_thenCallsGet() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(jsonNode).get(eq("enableOauth2"));
    verify(jsonNode).has(eq("enableOauth2"));
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }

  /**
   * Test {@link RefreshTokenExpCheckService#check()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#longValue()} return
   * {@link Long#MAX_VALUE}.</li>
   *   <li>Then calls {@link JsonNode#longValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenExpCheckService#check()}
   */
  @Test
  @DisplayName("Test check(); given JsonNode longValue() return MAX_VALUE; then calls longValue()")
  void testCheck_givenJsonNodeLongValueReturnMax_value_thenCallsLongValue() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.longValue()).thenReturn(Long.MAX_VALUE);
    when(jsonNode.asText()).thenReturn("OFFICE_365");
    when(jsonNode.asBoolean()).thenReturn(true);
    JsonNode jsonNode2 = mock(JsonNode.class);
    when(jsonNode2.get(Mockito.<String>any())).thenReturn(jsonNode);
    when(jsonNode2.has(Mockito.<String>any())).thenReturn(true);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode2);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    (new RefreshTokenExpCheckService(adminSettingsService)).check();

    // Assert
    verify(jsonNode).asBoolean();
    verify(jsonNode).asText();
    verify(jsonNode2, atLeast(1)).get(Mockito.<String>any());
    verify(jsonNode2, atLeast(1)).has(Mockito.<String>any());
    verify(jsonNode).longValue();
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
  }
}
