package org.thingsboard.server.service.entitiy.domain;

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
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.service.entitiy.TbLogEntityActionService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;

@ContextConfiguration(classes = {DefaultTbDomainService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbDomainServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbDomainService defaultTbDomainService;

  @MockBean
  private DomainService domainService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntitiesVersionControlService entitiesVersionControlService;

  @MockBean
  private Environment environment;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbLogEntityActionService tbLogEntityActionService;

  /**
   * Test {@link DefaultTbDomainService#save(Domain, List, User)}.
   * <ul>
   *   <li>Given {@link DomainService}
   * {@link DomainService#saveDomain(TenantId, Domain)} return
   * {@link Domain#Domain()}.</li>
   *   <li>When {@link Domain#Domain()}.</li>
   *   <li>Then return {@link Domain#Domain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbDomainService#save(Domain, List, User)}
   */
  @Test
  @DisplayName("Test save(Domain, List, User); given DomainService saveDomain(TenantId, Domain) return Domain(); when Domain(); then return Domain()")
  void testSave_givenDomainServiceSaveDomainReturnDomain_whenDomain_thenReturnDomain() throws Exception {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    Domain domain = new Domain();
    when(domainService.saveDomain(Mockito.<TenantId>any(), Mockito.<Domain>any())).thenReturn(domain);
    Domain domain2 = new Domain();
    ArrayList<OAuth2ClientId> oAuth2Clients = new ArrayList<>();

    // Act
    Domain actualSaveResult = defaultTbDomainService.save(domain2, oAuth2Clients, new User());

    // Assert
    verify(domainService).saveDomain(isNull(), isA(Domain.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.ADDED),
        isA(User.class), isA(Object[].class));
    assertSame(domain, actualSaveResult);
  }

  /**
   * Test {@link DefaultTbDomainService#updateOauth2Clients(Domain, List, User)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDomainService#updateOauth2Clients(Domain, List, User)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(Domain, List, User); given 'null'; when ArrayList() add 'null'")
  void testUpdateOauth2Clients_givenNull_whenArrayListAddNull() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(domainService)
        .updateOauth2Clients(Mockito.<TenantId>any(), Mockito.<DomainId>any(), Mockito.<List<OAuth2ClientId>>any());
    Domain domain = new Domain();

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    defaultTbDomainService.updateOauth2Clients(domain, oAuth2ClientIds, new User());

    // Assert
    verify(domainService).updateOauth2Clients(isNull(), isNull(), isA(List.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.UPDATED),
        isA(User.class), isA(Object[].class));
  }

  /**
   * Test {@link DefaultTbDomainService#updateOauth2Clients(Domain, List, User)}.
   * <ul>
   *   <li>When {@link Domain#Domain()}.</li>
   *   <li>Then calls
   * {@link DomainService#updateOauth2Clients(TenantId, DomainId, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDomainService#updateOauth2Clients(Domain, List, User)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(Domain, List, User); when Domain(); then calls updateOauth2Clients(TenantId, DomainId, List)")
  void testUpdateOauth2Clients_whenDomain_thenCallsUpdateOauth2Clients() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(domainService)
        .updateOauth2Clients(Mockito.<TenantId>any(), Mockito.<DomainId>any(), Mockito.<List<OAuth2ClientId>>any());
    Domain domain = new Domain();
    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();

    // Act
    defaultTbDomainService.updateOauth2Clients(domain, oAuth2ClientIds, new User());

    // Assert
    verify(domainService).updateOauth2Clients(isNull(), isNull(), isA(List.class));
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.UPDATED),
        isA(User.class), isA(Object[].class));
  }

  /**
   * Test {@link DefaultTbDomainService#delete(Domain, User)}.
   * <ul>
   *   <li>When {@link Domain#Domain()}.</li>
   *   <li>Then calls
   * {@link DomainService#deleteDomainById(TenantId, DomainId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbDomainService#delete(Domain, User)}
   */
  @Test
  @DisplayName("Test delete(Domain, User); when Domain(); then calls deleteDomainById(TenantId, DomainId)")
  void testDelete_whenDomain_thenCallsDeleteDomainById() {
    // Arrange
    doNothing().when(tbLogEntityActionService)
        .logEntityAction(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(),
            Mockito.<ActionType>any(), Mockito.<User>any(), isA(Object[].class));
    doNothing().when(domainService).deleteDomainById(Mockito.<TenantId>any(), Mockito.<DomainId>any());
    Domain domain = new Domain();

    // Act
    defaultTbDomainService.delete(domain, new User());

    // Assert that nothing has changed
    verify(domainService).deleteDomainById(isNull(), isNull());
    verify(tbLogEntityActionService).logEntityAction(isNull(), isNull(), isA(HasName.class), eq(ActionType.DELETED),
        isA(User.class), isA(Object[].class));
  }
}
