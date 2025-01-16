package org.thingsboard.server.service.entitiy.oauth2client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbOauth2ClientService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbOauth2ClientServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbOauth2ClientService defaultTbOauth2ClientService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private OAuth2ClientService oAuth2ClientService;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test {@link DefaultTbOauth2ClientService#save(OAuth2Client, User)}.
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * randomUUID.</li>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbOauth2ClientService#save(OAuth2Client, User)}
   */
  @Test
  @DisplayName("Test save(OAuth2Client, User); when OAuth2ClientId(UUID) with id is randomUUID; then return AdditionalInfo is 'null'")
  void testSave_whenOAuth2ClientIdWithIdIsRandomUUID_thenReturnAdditionalInfoIsNull() throws Exception {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    when(oAuth2ClientService.saveOAuth2Client(Mockito.<TenantId>any(), Mockito.<OAuth2Client>any()))
        .thenReturn(new OAuth2Client());
    OAuth2Client oAuth2Client = new OAuth2Client(new OAuth2ClientId(UUID.randomUUID()));

    // Act
    OAuth2Client actualSaveResult = defaultTbOauth2ClientService.save(oAuth2Client, new User());

    // Assert
    verify(oAuth2ClientService).saveOAuth2Client(isNull(), isA(OAuth2Client.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.UPDATED),
        isA(User.class), isA(Object[].class));
    assertNull(actualSaveResult.getAdditionalInfo());
    assertNull(actualSaveResult.getAccessTokenUri());
    assertNull(actualSaveResult.getAuthorizationUri());
    assertNull(actualSaveResult.getClientAuthenticationMethod());
    assertNull(actualSaveResult.getClientId());
    assertNull(actualSaveResult.getClientSecret());
    assertNull(actualSaveResult.getJwkSetUri());
    assertNull(actualSaveResult.getLoginButtonIcon());
    assertNull(actualSaveResult.getLoginButtonLabel());
    assertNull(actualSaveResult.getName());
    assertNull(actualSaveResult.getTitle());
    assertNull(actualSaveResult.getUserInfoUri());
    assertNull(actualSaveResult.getUserNameAttributeName());
    assertNull(actualSaveResult.getScope());
    assertNull(actualSaveResult.getPlatforms());
    assertNull(actualSaveResult.getUuidId());
    assertNull(actualSaveResult.getId());
    assertNull(actualSaveResult.getTenantId());
    assertNull(actualSaveResult.getMapperConfig());
    assertEquals(0L, actualSaveResult.getCreatedTime());
  }

  /**
   * Test {@link DefaultTbOauth2ClientService#save(OAuth2Client, User)}.
   * <ul>
   *   <li>When {@link OAuth2Client#OAuth2Client()}.</li>
   *   <li>Then return {@link OAuth2Client#OAuth2Client()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbOauth2ClientService#save(OAuth2Client, User)}
   */
  @Test
  @DisplayName("Test save(OAuth2Client, User); when OAuth2Client(); then return OAuth2Client()")
  void testSave_whenOAuth2Client_thenReturnOAuth2Client() throws Exception {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientService.saveOAuth2Client(Mockito.<TenantId>any(), Mockito.<OAuth2Client>any()))
        .thenReturn(oAuth2Client);
    OAuth2Client oAuth2Client2 = new OAuth2Client();

    // Act
    OAuth2Client actualSaveResult = defaultTbOauth2ClientService.save(oAuth2Client2, new User());

    // Assert
    verify(oAuth2ClientService).saveOAuth2Client(isNull(), isA(OAuth2Client.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.ADDED),
        isA(User.class), isA(Object[].class));
    assertSame(oAuth2Client, actualSaveResult);
  }

  /**
   * Test {@link DefaultTbOauth2ClientService#delete(OAuth2Client, User)}.
   * <ul>
   *   <li>When {@link OAuth2Client#OAuth2Client()}.</li>
   *   <li>Then calls
   * {@link OAuth2ClientService#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbOauth2ClientService#delete(OAuth2Client, User)}
   */
  @Test
  @DisplayName("Test delete(OAuth2Client, User); when OAuth2Client(); then calls deleteOAuth2ClientById(TenantId, OAuth2ClientId)")
  void testDelete_whenOAuth2Client_thenCallsDeleteOAuth2ClientById() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(oAuth2ClientService)
        .deleteOAuth2ClientById(Mockito.<TenantId>any(), Mockito.<OAuth2ClientId>any());
    OAuth2Client oAuth2Client = new OAuth2Client();

    // Act
    defaultTbOauth2ClientService.delete(oAuth2Client, new User());

    // Assert that nothing has changed
    verify(oAuth2ClientService).deleteOAuth2ClientById(isNull(), isNull());
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.DELETED),
        isA(User.class), isA(Object[].class));
  }
}
