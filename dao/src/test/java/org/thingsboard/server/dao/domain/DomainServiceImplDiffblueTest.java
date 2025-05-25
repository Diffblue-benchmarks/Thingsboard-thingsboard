package org.thingsboard.server.dao.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.domain.DomainInfo;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;

@ContextConfiguration(classes = {DomainServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DomainServiceImplDiffblueTest {
  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DomainDao domainDao;

  @Autowired
  private DomainServiceImpl domainServiceImpl;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  /**
   * Test {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#removeById(TenantId, UUID)} does nothing.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#deleteDomainById(TenantId, DomainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DomainServiceImpl.deleteDomainById(TenantId, DomainId)"})
  public void testDeleteDomainById_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    domainServiceImpl.deleteDomainById(ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return {@link Domain#Domain()}.</li>
   *   <li>Then return {@link Domain#Domain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#findDomainById(TenantId, DomainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Domain DomainServiceImpl.findDomainById(TenantId, DomainId)"})
  public void testFindDomainById_givenDomainDaoFindByIdReturnDomain_thenReturnDomain() {
    // Arrange
    Domain domain = new Domain();
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(domain);

    // Act
    Domain actualFindDomainByIdResult = domainServiceImpl.findDomainById(ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(domain, actualFindDomainByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return {@link Domain#Domain()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DomainInfo DomainServiceImpl.findDomainInfoById(TenantId, DomainId)"})
  public void testFindDomainInfoById_givenDomainDaoFindByIdReturnDomain_thenReturnNameIsNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Domain());
    when(oAuth2ClientDao.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    DomainInfo actualFindDomainInfoByIdResult = domainServiceImpl.findDomainInfoById(ModelConstants.SYSTEM_TENANT,
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
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#findById(TenantId, UUID)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#findDomainInfoById(TenantId, DomainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DomainInfo DomainServiceImpl.findDomainInfoById(TenantId, DomainId)"})
  public void testFindDomainInfoById_givenDomainDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(domainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    DomainInfo actualFindDomainInfoByIdResult = domainServiceImpl.findDomainInfoById(ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(domainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindDomainInfoByIdResult);
  }

  /**
   * Test {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DomainServiceImpl#deleteDomainsByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DomainServiceImpl.deleteDomainsByTenantId(TenantId)"})
  public void testDeleteDomainsByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteDomainsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DomainServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DomainServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(domainDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    domainServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link DomainDao} {@link Dao#removeById(TenantId, UUID)} does nothing.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DomainServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenDomainDaoRemoveByIdDoesNothing_thenCallsRemoveById() {
    // Arrange
    doNothing().when(domainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    domainServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT,
        new DomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DomainServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DOMAIN, (new DomainServiceImpl()).getEntityType());
  }
}
