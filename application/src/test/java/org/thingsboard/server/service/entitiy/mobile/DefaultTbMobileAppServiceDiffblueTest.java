package org.thingsboard.server.service.entitiy.mobile;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbMobileAppService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbMobileAppServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbMobileAppService defaultTbMobileAppService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private MobileAppService mobileAppService;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test {@link DefaultTbMobileAppService#save(MobileApp, List, User)}.
   * <ul>
   *   <li>Given {@link MobileAppService}
   * {@link MobileAppService#saveMobileApp(TenantId, MobileApp)} return
   * {@link MobileApp#MobileApp()}.</li>
   *   <li>Then return {@link MobileApp#MobileApp()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbMobileAppService#save(MobileApp, List, User)}
   */
  @Test
  @DisplayName("Test save(MobileApp, List, User); given MobileAppService saveMobileApp(TenantId, MobileApp) return MobileApp(); then return MobileApp()")
  void testSave_givenMobileAppServiceSaveMobileAppReturnMobileApp_thenReturnMobileApp() throws Exception {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    MobileApp mobileApp = new MobileApp();
    when(mobileAppService.saveMobileApp(Mockito.<TenantId>any(), Mockito.<MobileApp>any())).thenReturn(mobileApp);
    MobileApp mobileApp2 = new MobileApp();
    ArrayList<OAuth2ClientId> oauth2Clients = new ArrayList<>();

    // Act
    MobileApp actualSaveResult = defaultTbMobileAppService.save(mobileApp2, oauth2Clients, new User());

    // Assert
    verify(mobileAppService).saveMobileApp(isNull(), isA(MobileApp.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.ADDED),
        isA(User.class), isA(Object[].class));
    assertSame(mobileApp, actualSaveResult);
  }

  /**
   * Test
   * {@link DefaultTbMobileAppService#updateOauth2Clients(MobileApp, List, User)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbMobileAppService#updateOauth2Clients(MobileApp, List, User)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(MobileApp, List, User); given 'null'; when ArrayList() add 'null'")
  void testUpdateOauth2Clients_givenNull_whenArrayListAddNull() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(mobileAppService)
        .updateOauth2Clients(Mockito.<TenantId>any(), Mockito.<MobileAppId>any(), Mockito.<List<OAuth2ClientId>>any());
    MobileApp mobileApp = new MobileApp();

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    defaultTbMobileAppService.updateOauth2Clients(mobileApp, oAuth2ClientIds, new User());

    // Assert
    verify(mobileAppService).updateOauth2Clients(isNull(), isNull(), isA(List.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.UPDATED),
        isA(User.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultTbMobileAppService#updateOauth2Clients(MobileApp, List, User)}.
   * <ul>
   *   <li>When {@link MobileApp#MobileApp()}.</li>
   *   <li>Then calls
   * {@link MobileAppService#updateOauth2Clients(TenantId, MobileAppId, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbMobileAppService#updateOauth2Clients(MobileApp, List, User)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(MobileApp, List, User); when MobileApp(); then calls updateOauth2Clients(TenantId, MobileAppId, List)")
  void testUpdateOauth2Clients_whenMobileApp_thenCallsUpdateOauth2Clients() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(mobileAppService)
        .updateOauth2Clients(Mockito.<TenantId>any(), Mockito.<MobileAppId>any(), Mockito.<List<OAuth2ClientId>>any());
    MobileApp mobileApp = new MobileApp();
    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();

    // Act
    defaultTbMobileAppService.updateOauth2Clients(mobileApp, oAuth2ClientIds, new User());

    // Assert
    verify(mobileAppService).updateOauth2Clients(isNull(), isNull(), isA(List.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.UPDATED),
        isA(User.class), isA(Object[].class));
  }

  /**
   * Test {@link DefaultTbMobileAppService#delete(MobileApp, User)}.
   * <ul>
   *   <li>When {@link MobileApp#MobileApp()}.</li>
   *   <li>Then calls
   * {@link MobileAppService#deleteMobileAppById(TenantId, MobileAppId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbMobileAppService#delete(MobileApp, User)}
   */
  @Test
  @DisplayName("Test delete(MobileApp, User); when MobileApp(); then calls deleteMobileAppById(TenantId, MobileAppId)")
  void testDelete_whenMobileApp_thenCallsDeleteMobileAppById() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(mobileAppService).deleteMobileAppById(Mockito.<TenantId>any(), Mockito.<MobileAppId>any());
    MobileApp mobileApp = new MobileApp();

    // Act
    defaultTbMobileAppService.delete(mobileApp, new User());

    // Assert that nothing has changed
    verify(mobileAppService).deleteMobileAppById(isNull(), isNull());
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.DELETED),
        isA(User.class), isA(Object[].class));
  }
}
