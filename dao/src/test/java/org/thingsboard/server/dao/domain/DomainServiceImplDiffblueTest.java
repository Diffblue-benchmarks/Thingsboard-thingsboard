package org.thingsboard.server.dao.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.domain.DomainInfo;
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;

@ContextConfiguration(classes = {DomainServiceImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DomainServiceImplDiffblueTest {
  @MockBean private CleanUpService cleanUpService;

  @MockBean private DomainDao domainDao;

  @Autowired private DomainServiceImpl domainServiceImpl;

  @MockBean private OAuth2ClientDao oAuth2ClientDao;

  /**
   * Test {@link DomainServiceImpl#saveDomain(TenantId, Domain)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#save(TenantId, Object)} return {@link
   *       Domain#Domain()}.
   *   <li>Then return {@link Domain#Domain()}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#saveDomain(TenantId, Domain)}
   */
  @Test
  @DisplayName(
      "Test saveDomain(TenantId, Domain); given DomainDao save(TenantId, Object) return Domain(); then return Domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Domain DomainServiceImpl.saveDomain(TenantId, Domain)"})
  void testSaveDomain_givenDomainDaoSaveReturnDomain_thenReturnDomain() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.save(Mockito.<TenantId>any(), Mockito.<Domain>any())).thenReturn(domain);

    // Act
    Domain actualSaveDomainResult =
        domainServiceImpl.saveDomain(ModelConstants.SYSTEM_TENANT, new Domain());

    // Assert
    verify(domainDao).save(isA(TenantId.class), isA(Domain.class));
    assertSame(domain, actualSaveDomainResult);
  }

  /**
   * Test {@link DomainServiceImpl#saveDomain(TenantId, Domain)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#save(TenantId, Object)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#saveDomain(TenantId, Domain)}
   */
  @Test
  @DisplayName(
      "Test saveDomain(TenantId, Domain); given DomainDao save(TenantId, Object) throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Domain DomainServiceImpl.saveDomain(TenantId, Domain)"})
  void testSaveDomain_givenDomainDaoSaveThrowRuntimeException_thenThrowRuntimeException() {
    // Arrange
    when(domainDao.save(Mockito.<TenantId>any(), Mockito.<Domain>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> domainServiceImpl.saveDomain(ModelConstants.SYSTEM_TENANT, new Domain()));
    verify(domainDao).save(isA(TenantId.class), isA(Domain.class));
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   *
   * <p>Method under test: {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  @DisplayName("Test updateOauth2Clients(TenantId, DomainId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.updateOauth2Clients(TenantId, DomainId, List)"})
  void testUpdateOauth2Clients() {
    // Arrange
    when(domainDao.findOauth2ClientsByDomainId(Mockito.<TenantId>any(), Mockito.<DomainId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    domainServiceImpl.updateOauth2Clients(ModelConstants.SYSTEM_TENANT, null, new ArrayList<>());

    // Assert
    verify(domainDao).findOauth2ClientsByDomainId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link DomainDao#removeOauth2Client(DomainOauth2Client)}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, DomainId, List); then calls removeOauth2Client(DomainOauth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.updateOauth2Clients(TenantId, DomainId, List)"})
  void testUpdateOauth2Clients_thenCallsRemoveOauth2Client() {
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
   *
   * <ul>
   *   <li>Then calls {@link DomainDao#removeOauth2Client(DomainOauth2Client)}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#updateOauth2Clients(TenantId, DomainId, List)}
   */
  @Test
  @DisplayName(
      "Test updateOauth2Clients(TenantId, DomainId, List); then calls removeOauth2Client(DomainOauth2Client)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.updateOauth2Clients(TenantId, DomainId, List)"})
  void testUpdateOauth2Clients_thenCallsRemoveOauth2Client2() {
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
   * Test {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#removeById(TenantId, UUID)} does nothing.
   *   <li>Then calls {@link DomainDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}
   */
  @Test
  @DisplayName(
      "Test deleteDomainById(TenantId, DomainId); given DomainDao removeById(TenantId, UUID) does nothing; then calls removeById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.deleteDomainById(TenantId, DomainId)"})
  void testDeleteDomainById_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    domainServiceImpl.deleteDomainById(
        ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#findById(TenantId, UUID)} return {@link
   *       Domain#Domain()}.
   *   <li>Then return {@link Domain#Domain()}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}
   */
  @Test
  @DisplayName(
      "Test findDomainById(TenantId, DomainId); given DomainDao findById(TenantId, UUID) return Domain(); then return Domain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Domain DomainServiceImpl.findDomainById(TenantId, DomainId)"})
  void testFindDomainById_givenDomainDaoFindByIdReturnDomain_thenReturnDomain() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(domain);

    // Act
    Domain actualFindDomainByIdResult =
        domainServiceImpl.findDomainById(
            ModelConstants.SYSTEM_TENANT,
            new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(domain, actualFindDomainByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDomainInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DomainServiceImpl.findDomainInfosByTenantId(TenantId, PageLink)"})
  void testFindDomainInfosByTenantId() {
    // Arrange
    PageData<Domain> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);
    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult =
        domainServiceImpl.findDomainInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(pageData, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#findByTenantId(TenantId, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findDomainInfosByTenantId(TenantId, PageLink); given DomainDao findByTenantId(TenantId, PageLink) return emptyPageData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DomainServiceImpl.findDomainInfosByTenantId(TenantId, PageLink)"})
  void testFindDomainInfosByTenantId_givenDomainDaoFindByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Domain> emptyPageDataResult = PageData.emptyPageData();
    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult =
        domainServiceImpl.findDomainInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertEquals(PageData.EMPTY_PAGE_DATA, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#mapData(Function)}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findDomainInfosByTenantId(TenantId, PageLink); then calls mapData(Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DomainServiceImpl.findDomainInfosByTenantId(TenantId, PageLink)"})
  void testFindDomainInfosByTenantId_thenCallsMapData() {
    // Arrange
    PageData<Domain> pageData = mock(PageData.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(pageData.mapData(Mockito.<Function<Domain, Object>>any())).thenReturn(emptyPageDataResult);
    when(domainDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<DomainInfo> actualFindDomainInfosByTenantIdResult =
        domainServiceImpl.findDomainInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData).mapData(isA(Function.class));
    verify(domainDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindDomainInfosByTenantIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#findById(TenantId, UUID)} return {@link
   *       Domain#Domain()}.
   *   <li>Then return Name is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  @DisplayName(
      "Test findDomainInfoById(TenantId, DomainId); given DomainDao findById(TenantId, UUID) return Domain(); then return Name is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainInfo DomainServiceImpl.findDomainInfoById(TenantId, DomainId)"})
  void testFindDomainInfoById_givenDomainDaoFindByIdReturnDomain_thenReturnNameIsNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Domain());
    when(oAuth2ClientDao.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    DomainInfo actualFindDomainInfoByIdResult =
        domainServiceImpl.findDomainInfoById(
            ModelConstants.SYSTEM_TENANT,
            new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  @DisplayName(
      "Test findDomainInfoById(TenantId, DomainId); given DomainDao findById(TenantId, UUID) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainInfo DomainServiceImpl.findDomainInfoById(TenantId, DomainId)"})
  void testFindDomainInfoById_givenDomainDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    DomainInfo actualFindDomainInfoByIdResult =
        domainServiceImpl.findDomainInfoById(
            ModelConstants.SYSTEM_TENANT,
            new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindDomainInfoByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#isOauth2Enabled(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#isOauth2Enabled(TenantId)}
   */
  @Test
  @DisplayName("Test isOauth2Enabled(TenantId); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DomainServiceImpl.isOauth2Enabled(TenantId)"})
  void testIsOauth2Enabled_thenReturnFalse() {
    // Arrange
    when(domainDao.countDomainByTenantIdAndOauth2Enabled(Mockito.<TenantId>any(), anyBoolean()))
        .thenReturn(0);

    // Act
    boolean actualIsOauth2EnabledResult =
        domainServiceImpl.isOauth2Enabled(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).countDomainByTenantIdAndOauth2Enabled(isA(TenantId.class), eq(true));
    assertFalse(actualIsOauth2EnabledResult);
  }

  /**
   * Test {@link DomainServiceImpl#isOauth2Enabled(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#isOauth2Enabled(TenantId)}
   */
  @Test
  @DisplayName("Test isOauth2Enabled(TenantId); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DomainServiceImpl.isOauth2Enabled(TenantId)"})
  void testIsOauth2Enabled_thenReturnTrue() {
    // Arrange
    when(domainDao.countDomainByTenantIdAndOauth2Enabled(Mockito.<TenantId>any(), anyBoolean()))
        .thenReturn(1);

    // Act
    boolean actualIsOauth2EnabledResult =
        domainServiceImpl.isOauth2Enabled(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).countDomainByTenantIdAndOauth2Enabled(isA(TenantId.class), eq(true));
    assertTrue(actualIsOauth2EnabledResult);
  }

  /**
   * Test {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteDomainsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.deleteDomainsByTenantId(TenantId)"})
  void testDeleteDomainsByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteDomainsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DomainServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findEntity(TenantId, EntityId); when NULL_CUSTOMER_ID; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DomainServiceImpl.findEntity(TenantId, EntityId)"})
  void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(domain);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        domainServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(domain, actualFindEntityResult.get());
  }

  /**
   * Test {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DomainDao} {@link DomainDao#removeById(TenantId, UUID)} does nothing.
   *   <li>Then calls {@link DomainDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given DomainDao removeById(TenantId, UUID) does nothing; then calls removeById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DomainServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    domainServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        true);

    // Assert
    verify(domainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DomainServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DomainServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DomainServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DOMAIN, new DomainServiceImpl().getEntityType());
  }
}
