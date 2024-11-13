package org.thingsboard.server.dao.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.domain.DomainInfo;
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {DomainServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DomainServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DomainDao domainDao;

  @Autowired
  private DomainServiceImpl domainServiceImpl;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  @MockBean
  private RelationService relationService;

  /**
   * Test {@link DomainServiceImpl#saveDomain(TenantId, Domain)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#save(TenantId, Object)} return
   * {@link Domain#Domain()}.</li>
   *   <li>Then return {@link Domain#Domain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#saveDomain(TenantId, Domain)}
   */
  @Test
  public void testSaveDomain_givenDomainDaoSaveReturnDomain_thenReturnDomain() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.save(Mockito.<TenantId>any(), Mockito.<Domain>any())).thenReturn(domain);

    // Act
    Domain actualSaveDomainResult = domainServiceImpl.saveDomain(ModelConstants.SYSTEM_TENANT, new Domain());

    // Assert
    verify(domainDao).save(isA(TenantId.class), isA(Domain.class));
    assertSame(domain, actualSaveDomainResult);
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link DomainDao#addOauth2Client(DomainOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_givenArrayListAddNull_thenCallsAddOauth2Client() {
    // Arrange
    ArrayList<DomainOauth2Client> domainOauth2ClientList = new ArrayList<>();
    domainOauth2ClientList.add(null);
    doNothing().when(domainDao).addOauth2Client(Mockito.<DomainOauth2Client>any());
    doNothing().when(domainDao).removeOauth2Client(Mockito.<DomainOauth2Client>any());
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(domainOauth2ClientList);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, oAuth2ClientIds);

    // Assert
    verify(domainDao).addOauth2Client(isA(DomainOauth2Client.class));
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
    verify(domainDao).removeOauth2Client(isNull());
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<DomainOauth2Client> domainOauth2ClientList = new ArrayList<>();
    domainOauth2ClientList.add(new DomainOauth2Client());
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(domainOauth2ClientList);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, oAuth2ClientIds);

    // Assert
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   * <ul>
   *   <li>Then calls {@link DomainDao#removeOauth2Client(DomainOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_thenCallsRemoveOauth2Client() {
    // Arrange
    ArrayList<DomainOauth2Client> domainOauth2ClientList = new ArrayList<>();
    domainOauth2ClientList.add(new DomainOauth2Client());
    doNothing().when(domainDao).removeOauth2Client(Mockito.<DomainOauth2Client>any());
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(domainOauth2ClientList);

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
    verify(domainDao).removeOauth2Client(isA(DomainOauth2Client.class));
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   * <ul>
   *   <li>Then calls {@link DomainDao#removeOauth2Client(DomainOauth2Client)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_thenCallsRemoveOauth2Client2() {
    // Arrange
    ArrayList<DomainOauth2Client> domainOauth2ClientList = new ArrayList<>();
    domainOauth2ClientList.add(new DomainOauth2Client());
    domainOauth2ClientList.add(new DomainOauth2Client());
    doNothing().when(domainDao).removeOauth2Client(Mockito.<DomainOauth2Client>any());
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(domainOauth2ClientList);

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
    verify(domainDao, atLeast(1)).removeOauth2Client(isA(DomainOauth2Client.class));
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  public void testUpdateOauth2Clients_whenArrayList() {
    // Arrange
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#removeById(TenantId, UUID)} does
   * nothing.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}
   */
  @Test
  public void testDeleteDomainById_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    domainServiceImpl.deleteDomainById(ModelConstants.SYSTEM_TENANT, new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link Domain#Domain()}.</li>
   *   <li>Then return {@link Domain#Domain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}
   */
  @Test
  public void testFindDomainById_givenDomainDaoFindByIdReturnDomain_thenReturnDomain() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(domain);

    // Act
    Domain actualFindDomainByIdResult = domainServiceImpl.findDomainById(ModelConstants.SYSTEM_TENANT,
        new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(domain, actualFindDomainByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDomainInfosByTenantId() {
    // Arrange
    PageData<Domain> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult = domainServiceImpl
        .findDomainInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(pageData, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link DomainDao}
   * {@link DomainDao#findByTenantId(TenantId, PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDomainInfosByTenantId_givenDomainDaoFindByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Domain> emptyPageDataResult = PageData.emptyPageData();
    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult = domainServiceImpl
        .findDomainInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(actualFindDomainInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindDomainInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<Domain> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<Domain, Object>>any())).thenReturn(emptyPageDataResult);
    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult = domainServiceImpl
        .findDomainInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindDomainInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link Domain#Domain()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  public void testFindDomainInfoById_givenDomainDaoFindByIdReturnDomain_thenReturnNameIsNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Domain());
    when(oAuth2ClientDao.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    DomainInfo actualFindDomainInfoByIdResult = domainServiceImpl.findDomainInfoById(ModelConstants.SYSTEM_TENANT,
        new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(oAuth2ClientDao).findByDomainId(isNull());
    assertNull(actualFindDomainInfoByIdResult.getName());
    assertNull(actualFindDomainInfoByIdResult.getUuidId());
    assertNull(actualFindDomainInfoByIdResult.getId());
    assertNull(actualFindDomainInfoByIdResult.getTenantId());
    assertEquals(0L, actualFindDomainInfoByIdResult.getCreatedTime());
    assertFalse(actualFindDomainInfoByIdResult.isOauth2Enabled());
    assertFalse(actualFindDomainInfoByIdResult.isPropagateToEdge());
    assertTrue(actualFindDomainInfoByIdResult.getOauth2ClientInfos().isEmpty());
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  public void testFindDomainInfoById_givenDomainDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    DomainInfo actualFindDomainInfoByIdResult = domainServiceImpl.findDomainInfoById(ModelConstants.SYSTEM_TENANT,
        new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindDomainInfoByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#isOauth2Enabled(TenantId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#isOauth2Enabled(TenantId)}
   */
  @Test
  public void testIsOauth2Enabled_thenReturnFalse() {
    // Arrange
    when(domainDao.countDomainByTenantIdAndOauth2Enabled(Mockito.<TenantId>any(), anyBoolean())).thenReturn(0);

    // Act
    boolean actualIsOauth2EnabledResult = domainServiceImpl.isOauth2Enabled(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).countDomainByTenantIdAndOauth2Enabled(isA(TenantId.class), eq(true));
    assertFalse(actualIsOauth2EnabledResult);
  }

  /**
   * Test {@link DomainServiceImpl#isOauth2Enabled(TenantId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#isOauth2Enabled(TenantId)}
   */
  @Test
  public void testIsOauth2Enabled_thenReturnTrue() {
    // Arrange
    when(domainDao.countDomainByTenantIdAndOauth2Enabled(Mockito.<TenantId>any(), anyBoolean())).thenReturn(1);

    // Act
    boolean actualIsOauth2EnabledResult = domainServiceImpl.isOauth2Enabled(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).countDomainByTenantIdAndOauth2Enabled(isA(TenantId.class), eq(true));
    assertTrue(actualIsOauth2EnabledResult);
  }

  /**
   * Test {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteDomainsByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteDomainsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DomainServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(domain);

    // Act
    Optional<HasId<?>> actualFindEntityResult = domainServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(domain, actualFindEntityResult.get());
  }

  /**
   * Test {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#removeById(TenantId, UUID)} does
   * nothing.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    domainServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, new DomainId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(domainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DomainServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DomainServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DOMAIN, (new DomainServiceImpl()).getEntityType());
  }
}
