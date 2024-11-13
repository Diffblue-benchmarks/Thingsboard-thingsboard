package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientLoginInfo;
import org.thingsboard.server.common.data.oauth2.PlatformType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {OAuth2ClientServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class OAuth2ClientServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<OAuth2Client> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  @Autowired
  private OAuth2ClientServiceImpl oAuth2ClientServiceImpl;

  @MockBean
  private RelationService relationService;

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}
   */
  @Test
  public void testFindOAuth2ClientLoginInfosByDomainName_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findEnabledByDomainName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientLoginInfo> actualFindOAuth2ClientLoginInfosByDomainNameResult = oAuth2ClientServiceImpl
        .findOAuth2ClientLoginInfosByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientDao).findEnabledByDomainName(eq("Domain Name"));
    assertTrue(actualFindOAuth2ClientLoginInfosByDomainNameResult.isEmpty());
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByDomainName(String)}
   */
  @Test
  public void testFindOAuth2ClientLoginInfosByDomainName_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<OAuth2Client> oAuth2ClientList = new ArrayList<>();
    oAuth2ClientList.add(new OAuth2Client(new OAuth2ClientId(ModelConstants.NULL_UUID)));
    when(oAuth2ClientDao.findEnabledByDomainName(Mockito.<String>any())).thenReturn(oAuth2ClientList);

    // Act
    List<OAuth2ClientLoginInfo> actualFindOAuth2ClientLoginInfosByDomainNameResult = oAuth2ClientServiceImpl
        .findOAuth2ClientLoginInfosByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientDao).findEnabledByDomainName(eq("Domain Name"));
    assertEquals(1, actualFindOAuth2ClientLoginInfosByDomainNameResult.size());
    OAuth2ClientLoginInfo getResult = actualFindOAuth2ClientLoginInfosByDomainNameResult.get(0);
    assertEquals("/oauth2/authorization/13814000-1dd2-11b2-8080-808080808080", getResult.getUrl());
    assertNull(getResult.getIcon());
    assertNull(getResult.getName());
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String, PlatformType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String, PlatformType)}
   */
  @Test
  public void testFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findEnabledByPkgNameAndPlatformType(Mockito.<String>any(), Mockito.<PlatformType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientLoginInfo> actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult = oAuth2ClientServiceImpl
        .findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientDao).findEnabledByPkgNameAndPlatformType(eq("Pkg Name"), eq(PlatformType.WEB));
    assertTrue(actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String, PlatformType)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType(String, PlatformType)}
   */
  @Test
  public void testFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<OAuth2Client> oAuth2ClientList = new ArrayList<>();
    oAuth2ClientList.add(new OAuth2Client(new OAuth2ClientId(ModelConstants.NULL_UUID)));
    when(oAuth2ClientDao.findEnabledByPkgNameAndPlatformType(Mockito.<String>any(), Mockito.<PlatformType>any()))
        .thenReturn(oAuth2ClientList);

    // Act
    List<OAuth2ClientLoginInfo> actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult = oAuth2ClientServiceImpl
        .findOAuth2ClientLoginInfosByMobilePkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientDao).findEnabledByPkgNameAndPlatformType(eq("Pkg Name"), eq(PlatformType.WEB));
    assertEquals(1, actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult.size());
    OAuth2ClientLoginInfo getResult = actualFindOAuth2ClientLoginInfosByMobilePkgNameAndPlatformTypeResult.get(0);
    assertEquals("/oauth2/authorization/13814000-1dd2-11b2-8080-808080808080", getResult.getUrl());
    assertNull(getResult.getIcon());
    assertNull(getResult.getName());
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#saveOAuth2Client(TenantId, OAuth2Client)}.
   * <ul>
   *   <li>Then return {@link OAuth2Client#OAuth2Client()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#saveOAuth2Client(TenantId, OAuth2Client)}
   */
  @Test
  public void testSaveOAuth2Client_thenReturnOAuth2Client() {
    // Arrange
    when(dataValidator.validate(Mockito.<OAuth2Client>any(), Mockito.<Function<OAuth2Client, TenantId>>any()))
        .thenReturn(new OAuth2Client());
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.save(Mockito.<TenantId>any(), Mockito.<OAuth2Client>any())).thenReturn(oAuth2Client);

    // Act
    OAuth2Client actualSaveOAuth2ClientResult = oAuth2ClientServiceImpl.saveOAuth2Client(ModelConstants.SYSTEM_TENANT,
        new OAuth2Client());

    // Assert
    verify(oAuth2ClientDao).save(isA(TenantId.class), isA(OAuth2Client.class));
    verify(dataValidator).validate(isA(OAuth2Client.class), isA(Function.class));
    assertSame(oAuth2Client, actualSaveOAuth2ClientResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testFindOAuth2ClientById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(oAuth2Client);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OAuth2Client actualFindOAuth2ClientByIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientById(ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2Client, actualFindOAuth2ClientByIdResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testFindOAuth2ClientById_whenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(oAuth2Client);

    // Act
    OAuth2Client actualFindOAuth2ClientByIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientById(ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2Client, actualFindOAuth2ClientByIdResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}
   */
  @Test
  public void testFindOAuth2ClientsByTenantId() {
    // Arrange
    PageData<OAuth2Client> emptyPageDataResult = PageData.emptyPageData();
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    List<OAuth2Client> actualFindOAuth2ClientsByTenantIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualFindOAuth2ClientsByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link PageData#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientsByTenantId(TenantId)}
   */
  @Test
  public void testFindOAuth2ClientsByTenantId_thenCallsGetData() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    List<OAuth2Client> actualFindOAuth2ClientsByTenantIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualFindOAuth2ClientsByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  public void testFindAppSecret_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    String actualFindAppSecretResult = oAuth2ClientServiceImpl.findAppSecret(oAuth2ClientId, "Pkg Name");

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code App Secret}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  public void testFindAppSecret_whenOAuth2ClientIdWithIdIsNull_uuid_thenReturnAppSecret() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult = oAuth2ClientServiceImpl
        .findAppSecret(new OAuth2ClientId(ModelConstants.NULL_UUID), "Pkg Name");

    // Assert
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testDeleteOAuth2ClientById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(oAuth2ClientDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    oAuth2ClientServiceImpl.deleteOAuth2ClientById(ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>When {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testDeleteOAuth2ClientById_whenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(oAuth2ClientDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOAuth2ClientById(ModelConstants.SYSTEM_TENANT,
        new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteOauth2ClientsByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOAuth2ClientInfosByTenantId() {
    // Arrange
    PageData<OAuth2Client> emptyPageDataResult = PageData.emptyPageData();
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertEquals(actualFindOAuth2ClientInfosByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOAuth2ClientInfosByTenantId2() {
    // Arrange
    PageData<OAuth2Client> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertEquals(pageData, actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindOAuth2ClientInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<OAuth2Client> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<OAuth2Client, Object>>any())).thenReturn(emptyPageDataResult);
    when(oAuth2ClientDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<OAuth2ClientInfo> actualFindOAuth2ClientInfosByTenantIdResult = oAuth2ClientServiceImpl
        .findOAuth2ClientInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(oAuth2ClientDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindOAuth2ClientInfosByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindOAuth2ClientInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findOAuth2ClientInfosByIds(TenantId, List)}
   */
  @Test
  public void testFindOAuth2ClientInfosByIds_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientDao.findByIds(Mockito.<UUID>any(), Mockito.<List<OAuth2ClientId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientInfo> actualFindOAuth2ClientInfosByIdsResult = oAuth2ClientServiceImpl
        .findOAuth2ClientInfosByIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(oAuth2ClientDao).findByIds(isA(UUID.class), isA(List.class));
    assertTrue(actualFindOAuth2ClientInfosByIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testIsPropagateOAuth2ClientToEdge_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult = oAuth2ClientServiceImpl
        .isPropagateOAuth2ClientToEdge(ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testIsPropagateOAuth2ClientToEdge_thenReturnFalse() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult = oAuth2ClientServiceImpl
        .isPropagateOAuth2ClientToEdge(ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#isPropagateOAuth2ClientToEdge(TenantId, OAuth2ClientId)}
   */
  @Test
  public void testIsPropagateOAuth2ClientToEdge_thenReturnTrue() {
    // Arrange
    when(oAuth2ClientDao.isPropagateToEdge(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualIsPropagateOAuth2ClientToEdgeResult = oAuth2ClientServiceImpl
        .isPropagateOAuth2ClientToEdge(ModelConstants.SYSTEM_TENANT, new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientDao).isPropagateToEdge(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualIsPropagateOAuth2ClientToEdgeResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(oAuth2Client);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = oAuth2ClientServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(oAuth2Client, actualFindEntityResult.get());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2ClientServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(oAuth2Client);

    // Act
    Optional<HasId<?>> actualFindEntityResult = oAuth2ClientServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(oAuth2ClientDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(oAuth2Client, actualFindEntityResult.get());
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.OAUTH2_CLIENT, (new OAuth2ClientServiceImpl()).getEntityType());
  }
}
