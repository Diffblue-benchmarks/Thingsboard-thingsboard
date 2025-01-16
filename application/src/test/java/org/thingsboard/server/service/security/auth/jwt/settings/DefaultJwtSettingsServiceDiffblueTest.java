package org.thingsboard.server.service.security.auth.jwt.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

@ContextConfiguration(classes = {DefaultJwtSettingsService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultJwtSettingsServiceDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @Autowired
  private DefaultJwtSettingsService defaultJwtSettingsService;

  @MockBean
  private JwtSettingsValidator jwtSettingsValidator;

  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @MockBean
  private TbClusterService tbClusterService;

  /**
   * Test {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings)")
  void testSaveJwtSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    doNothing().when(jwtSettingsValidator).validate(Mockito.<JwtSettings>any());
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualSaveJwtSettingsResult = defaultJwtSettingsService.saveJwtSettings(new JwtSettings());

    // Assert
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.UPDATED));
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    verify(jwtSettingsValidator).validate(isA(JwtSettings.class));
    verify(jwtTokenFactory).reload();
    assertNull(actualSaveJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings); given AdminSettingsService findAdminSettingsByKey(TenantId, String) return 'null'")
  void testSaveJwtSettings_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    doNothing().when(jwtSettingsValidator).validate(Mockito.<JwtSettings>any());
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualSaveJwtSettingsResult = defaultJwtSettingsService.saveJwtSettings(new JwtSettings());

    // Assert
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.UPDATED));
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    verify(jwtSettingsValidator).validate(isA(JwtSettings.class));
    verify(jwtTokenFactory).reload();
    assertNull(actualSaveJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings); given ArrayNode asToken() return 'END_OBJECT'; then return 'null'")
  void testSaveJwtSettings_givenArrayNodeAsTokenReturnEndObject_thenReturnNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettings.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    doNothing().when(jwtSettingsValidator).validate(Mockito.<JwtSettings>any());
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualSaveJwtSettingsResult = defaultJwtSettingsService.saveJwtSettings(new JwtSettings());

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.UPDATED));
    verify(adminSettings).getId();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    verify(jwtSettingsValidator).validate(isA(JwtSettings.class));
    verify(jwtTokenFactory).reload();
    assertNull(actualSaveJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code START_OBJECT}.</li>
   *   <li>Then return {@link JwtSettings#JwtSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings); given ArrayNode asToken() return 'START_OBJECT'; then return JwtSettings()")
  void testSaveJwtSettings_givenArrayNodeAsTokenReturnStartObject_thenReturnJwtSettings() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettings.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    doNothing().when(jwtSettingsValidator).validate(Mockito.<JwtSettings>any());
    doNothing().when(jwtTokenFactory).reload();
    JwtSettings jwtSettings = new JwtSettings();

    // Act
    JwtSettings actualSaveJwtSettingsResult = defaultJwtSettingsService.saveJwtSettings(jwtSettings);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.UPDATED));
    verify(adminSettings).getId();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    verify(jwtSettingsValidator).validate(isA(JwtSettings.class));
    verify(jwtTokenFactory).reload();
    assertEquals(jwtSettings, actualSaveJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}.
   * <ul>
   *   <li>Then return RefreshTokenExpTime is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings); then return RefreshTokenExpTime is 'null'")
  void testSaveJwtSettings_thenReturnRefreshTokenExpTimeIsNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettings.getId()).thenReturn(new AdminSettingsId(UUID.randomUUID()));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(tbClusterService)
        .broadcastEntityStateChangeEvent(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
            Mockito.<ComponentLifecycleEvent>any());
    doNothing().when(jwtSettingsValidator).validate(Mockito.<JwtSettings>any());
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualSaveJwtSettingsResult = defaultJwtSettingsService
        .saveJwtSettings(new JwtSettings(1, 1, "ABC123", "ABC123"));

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(tbClusterService).broadcastEntityStateChangeEvent(isA(TenantId.class), isA(EntityId.class),
        eq(ComponentLifecycleEvent.UPDATED));
    verify(adminSettings).getId();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    verify(jwtSettingsValidator).validate(isA(JwtSettings.class));
    verify(jwtTokenFactory).reload();
    assertNull(actualSaveJwtSettingsResult.getRefreshTokenExpTime());
    assertNull(actualSaveJwtSettingsResult.getTokenExpirationTime());
    assertNull(actualSaveJwtSettingsResult.getTokenIssuer());
    assertNull(actualSaveJwtSettingsResult.getTokenSigningKey());
  }

  /**
   * Test {@link DefaultJwtSettingsService#reloadJwtSettings()}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#reloadJwtSettings()}
   */
  @Test
  @DisplayName("Test reloadJwtSettings()")
  void testReloadJwtSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualReloadJwtSettingsResult = defaultJwtSettingsService.reloadJwtSettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(jwtTokenFactory).reload();
    assertNull(actualReloadJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#reloadJwtSettings()}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#reloadJwtSettings()}
   */
  @Test
  @DisplayName("Test reloadJwtSettings(); given AdminSettingsService findAdminSettingsByKey(TenantId, String) return 'null'")
  void testReloadJwtSettings_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualReloadJwtSettingsResult = defaultJwtSettingsService.reloadJwtSettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(jwtTokenFactory).reload();
    assertNull(actualReloadJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#reloadJwtSettings()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#reloadJwtSettings()}
   */
  @Test
  @DisplayName("Test reloadJwtSettings(); given ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  void testReloadJwtSettings_givenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualReloadJwtSettingsResult = defaultJwtSettingsService.reloadJwtSettings();

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(jwtTokenFactory).reload();
    assertNull(actualReloadJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#reloadJwtSettings()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#reloadJwtSettings()}
   */
  @Test
  @DisplayName("Test reloadJwtSettings(); given ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  void testReloadJwtSettings_givenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualReloadJwtSettingsResult = defaultJwtSettingsService.reloadJwtSettings();

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(jwtTokenFactory).reload();
    assertNull(actualReloadJwtSettingsResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#reloadJwtSettings()}.
   * <ul>
   *   <li>Then return RefreshTokenExpTime is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#reloadJwtSettings()}
   */
  @Test
  @DisplayName("Test reloadJwtSettings(); then return RefreshTokenExpTime is 'null'")
  void testReloadJwtSettings_thenReturnRefreshTokenExpTimeIsNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    doNothing().when(jwtTokenFactory).reload();

    // Act
    JwtSettings actualReloadJwtSettingsResult = defaultJwtSettingsService.reloadJwtSettings();

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    verify(jwtTokenFactory).reload();
    assertNull(actualReloadJwtSettingsResult.getRefreshTokenExpTime());
    assertNull(actualReloadJwtSettingsResult.getTokenExpirationTime());
    assertNull(actualReloadJwtSettingsResult.getTokenIssuer());
    assertNull(actualReloadJwtSettingsResult.getTokenSigningKey());
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings()}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings()")
  void testGetJwtSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings(boolean)}
   */
  @Test
  @DisplayName("Test getJwtSettings(boolean) with 'boolean'")
  void testGetJwtSettingsWithBoolean() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings(true);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings(boolean)}
   */
  @Test
  @DisplayName("Test getJwtSettings(boolean) with 'boolean'")
  void testGetJwtSettingsWithBoolean2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings(true);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings(boolean)}
   */
  @Test
  @DisplayName("Test getJwtSettings(boolean) with 'boolean'; given ArrayNode asToken() return 'END_ARRAY'")
  void testGetJwtSettingsWithBoolean_givenArrayNodeAsTokenReturnEndArray() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings(true);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings(boolean)}
   */
  @Test
  @DisplayName("Test getJwtSettings(boolean) with 'boolean'; given ArrayNode asToken() return 'END_OBJECT'")
  void testGetJwtSettingsWithBoolean_givenArrayNodeAsTokenReturnEndObject() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings(true);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>Then return RefreshTokenExpTime is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings(boolean)}
   */
  @Test
  @DisplayName("Test getJwtSettings(boolean) with 'boolean'; then return RefreshTokenExpTime is 'null'")
  void testGetJwtSettingsWithBoolean_thenReturnRefreshTokenExpTimeIsNull() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings(true);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings.getRefreshTokenExpTime());
    assertNull(actualJwtSettings.getTokenExpirationTime());
    assertNull(actualJwtSettings.getTokenIssuer());
    assertNull(actualJwtSettings.getTokenSigningKey());
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings()}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); given AdminSettingsService findAdminSettingsByKey(TenantId, String) return 'null'")
  void testGetJwtSettings_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings);
  }

  /**
   * Test {@link DefaultJwtSettingsService#getJwtSettings()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#fields()} return
   * {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); given ArrayNode fields() return ArrayList() iterator; then calls fields()")
  void testGetJwtSettings_givenArrayNodeFieldsReturnArrayListIterator_thenCallsFields() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    JwtSettings actualJwtSettings = defaultJwtSettingsService.getJwtSettings();

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("jwt"));
    assertNull(actualJwtSettings.getRefreshTokenExpTime());
    assertNull(actualJwtSettings.getTokenExpirationTime());
    assertNull(actualJwtSettings.getTokenIssuer());
    assertNull(actualJwtSettings.getTokenSigningKey());
  }

  /**
   * Test {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}.
   * <ul>
   *   <li>Given {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}
   */
  @Test
  @DisplayName("Test isSigningKeyDefault(JwtSettings); given 'ABC123'")
  void testIsSigningKeyDefault_givenAbc123() {
    // Arrange
    JwtSettings settings = mock(JwtSettings.class);
    when(settings.getTokenSigningKey()).thenReturn("ABC123");

    // Act
    boolean actualIsSigningKeyDefaultResult = DefaultJwtSettingsService.isSigningKeyDefault(settings);

    // Assert
    verify(settings).getTokenSigningKey();
    assertFalse(actualIsSigningKeyDefaultResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}.
   * <ul>
   *   <li>Given {@link JwtSettingsService#TOKEN_SIGNING_KEY_DEFAULT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}
   */
  @Test
  @DisplayName("Test isSigningKeyDefault(JwtSettings); given TOKEN_SIGNING_KEY_DEFAULT; then return 'true'")
  void testIsSigningKeyDefault_givenToken_signing_key_default_thenReturnTrue() {
    // Arrange
    JwtSettings settings = mock(JwtSettings.class);
    when(settings.getTokenSigningKey()).thenReturn(JwtSettingsService.TOKEN_SIGNING_KEY_DEFAULT);

    // Act
    boolean actualIsSigningKeyDefaultResult = DefaultJwtSettingsService.isSigningKeyDefault(settings);

    // Assert
    verify(settings).getTokenSigningKey();
    assertTrue(actualIsSigningKeyDefaultResult);
  }

  /**
   * Test {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}.
   * <ul>
   *   <li>When {@link JwtSettings#JwtSettings()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}
   */
  @Test
  @DisplayName("Test isSigningKeyDefault(JwtSettings); when JwtSettings(); then return 'false'")
  void testIsSigningKeyDefault_whenJwtSettings_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultJwtSettingsService.isSigningKeyDefault(new JwtSettings()));
  }

  /**
   * Test {@link DefaultJwtSettingsService#validateKeyLength(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultJwtSettingsService#validateKeyLength(String)}
   */
  @Test
  @DisplayName("Test validateKeyLength(String); when 'Key'; then return 'false'")
  void testValidateKeyLength_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultJwtSettingsService.validateKeyLength("Key"));
  }
}
