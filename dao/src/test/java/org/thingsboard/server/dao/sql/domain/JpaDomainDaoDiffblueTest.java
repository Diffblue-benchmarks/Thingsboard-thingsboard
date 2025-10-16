/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.sql.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.domain.Domain;
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DomainEntity;
import org.thingsboard.server.dao.model.sql.DomainOauth2ClientCompositeKey;
import org.thingsboard.server.dao.model.sql.DomainOauth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDomainDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaDomainDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private DomainOauth2ClientRepository domainOauth2ClientRepository;

  @MockBean private DomainRepository domainRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaDomainDao jpaDomainDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaDomainDao#getEntityClass()}
   *   <li>{@link JpaDomainDao#getEntityType()}
   *   <li>{@link JpaDomainDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaDomainDao.getEntityClass()",
    "EntityType JpaDomainDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaDomainDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaDomainDao jpaDomainDao =
        new JpaDomainDao(mock(DomainRepository.class), mock(DomainOauth2ClientRepository.class));

    // Act
    Class<DomainEntity> actualEntityClass = jpaDomainDao.getEntityClass();
    EntityType actualEntityType = jpaDomainDao.getEntityType();
    jpaDomainDao.getRepository();

    // Assert
    assertEquals(EntityType.DOMAIN, actualEntityType);
    Class<DomainEntity> expectedEntityClass = DomainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDomainDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    UUID tenantId = UUID.randomUUID();
    domainEntity.setTenantId(tenantId);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<DomainEntity> content = new ArrayList<>();
    content.add(domainEntity);
    when(domainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId2 = mock(TenantId.class);
    when(tenantId2.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(tenantId2, pageLink);

    // Assert
    verify(tenantId2).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(domainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Domain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Domain getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", getResult.getName());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdResult.getTotalElements());
    DomainId id = getResult.getId();
    assertEquals(EntityType.DOMAIN, id.getEntityType());
    TenantId tenantId3 = getResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId3.getEntityType());
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertTrue(getResult.isOauth2Enabled());
    assertTrue(getResult.isPropagateToEdge());
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
    assertSame(tenantId, tenantId3.getId());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDomainDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenNull_uuid_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(domainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Domain> actualFindByTenantIdResult =
        jpaDomainDao.findByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId).getId();
    verify(domainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDomainDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(domainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(domainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data first TenantId is {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDomainDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_thenReturnDataFirstTenantIdIsSys_tenant_id() {
    // Arrange
    DomainEntity domainEntity = new DomainEntity();
    domainEntity.setCreatedTime(1L);
    domainEntity.setId(ModelConstants.NULL_UUID);
    domainEntity.setName("Name");
    domainEntity.setOauth2Enabled(true);
    domainEntity.setPropagateToEdge(true);
    domainEntity.setTenantId(ModelConstants.NULL_UUID);
    domainEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<DomainEntity> content = new ArrayList<>();
    content.add(domainEntity);
    when(domainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<Domain> actualFindByTenantIdResult = jpaDomainDao.findByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(domainRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Domain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(TenantId.SYS_TENANT_ID, data.get(0).getTenantId());
  }

  /**
   * Test {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaDomainDao.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_whenSystem_tenant_thenReturnTotalElementsIsZero() {
    // Arrange
    when(domainRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Domain> actualFindByTenantIdResult =
        jpaDomainDao.findByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(domainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaDomainDao.countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)"})
  public void testCountDomainByTenantIdAndOauth2Enabled_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(domainRepository.countByTenantIdAndOauth2Enabled(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(1);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualCountDomainByTenantIdAndOauth2EnabledResult =
        jpaDomainDao.countDomainByTenantIdAndOauth2Enabled(tenantId, true);

    // Assert
    verify(tenantId).getId();
    verify(domainRepository).countByTenantIdAndOauth2Enabled(isA(UUID.class), eq(true));
    assertEquals(1, actualCountDomainByTenantIdAndOauth2EnabledResult);
  }

  /**
   * Test {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#countDomainByTenantIdAndOauth2Enabled(TenantId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int JpaDomainDao.countDomainByTenantIdAndOauth2Enabled(TenantId, boolean)"})
  public void testCountDomainByTenantIdAndOauth2Enabled_whenSystem_tenant_thenReturnOne() {
    // Arrange
    when(domainRepository.countByTenantIdAndOauth2Enabled(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(1);

    // Act
    int actualCountDomainByTenantIdAndOauth2EnabledResult =
        jpaDomainDao.countDomainByTenantIdAndOauth2Enabled(ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(domainRepository).countByTenantIdAndOauth2Enabled(isA(UUID.class), eq(true));
    assertEquals(1, actualCountDomainByTenantIdAndOauth2EnabledResult);
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link DomainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDomainDao.findOauth2ClientsByDomainId(TenantId, DomainId)"})
  public void testFindOauth2ClientsByDomainId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult =
        jpaDomainDao.findOauth2ClientsByDomainId(ModelConstants.SYSTEM_TENANT, domainId);

    // Assert
    verify(domainId).getId();
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDomainDao.findOauth2ClientsByDomainId(TenantId, DomainId)"})
  public void testFindOauth2ClientsByDomainId_thenReturnSizeIsOne() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    ArrayList<DomainOauth2ClientEntity> domainOauth2ClientEntityList = new ArrayList<>();
    domainOauth2ClientEntityList.add(domainOauth2ClientEntity);
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any()))
        .thenReturn(domainOauth2ClientEntityList);
    DomainId domainId = new DomainId(ModelConstants.NULL_UUID);

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult =
        jpaDomainDao.findOauth2ClientsByDomainId(ModelConstants.SYSTEM_TENANT, domainId);

    // Assert
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertEquals(1, actualFindOauth2ClientsByDomainIdResult.size());
    DomainOauth2Client getResult = actualFindOauth2ClientsByDomainIdResult.get(0);
    OAuth2ClientId oAuth2ClientId = getResult.getOAuth2ClientId();
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertTrue(oAuth2ClientId.isNullUid());
    assertEquals(domainId, getResult.getDomainId());
  }

  /**
   * Test {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}.
   *
   * <ul>
   *   <li>When {@link DomainId#DomainId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#findOauth2ClientsByDomainId(TenantId, DomainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaDomainDao.findOauth2ClientsByDomainId(TenantId, DomainId)"})
  public void testFindOauth2ClientsByDomainId_whenDomainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(domainOauth2ClientRepository.findAllByDomainId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<DomainOauth2Client> actualFindOauth2ClientsByDomainIdResult =
        jpaDomainDao.findOauth2ClientsByDomainId(
            ModelConstants.SYSTEM_TENANT, new DomainId(ModelConstants.NULL_UUID));

    // Assert
    verify(domainOauth2ClientRepository).findAllByDomainId(isA(UUID.class));
    assertTrue(actualFindOauth2ClientsByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link OAuth2ClientId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.addOauth2Client(DomainOauth2Client)"})
  public void testAddOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);

    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#addOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.addOauth2Client(DomainOauth2Client)"})
  public void testAddOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);
    when(domainOauth2ClientRepository.save(Mockito.<DomainOauth2ClientEntity>any()))
        .thenReturn(domainOauth2ClientEntity);

    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.addOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).save(isA(DomainOauth2ClientEntity.class));
    verify(domainId).getId();
  }

  /**
   * Test {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link OAuth2ClientId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.removeOauth2Client(DomainOauth2Client)"})
  public void testRemoveOauth2Client_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing()
        .when(domainOauth2ClientRepository)
        .deleteById(Mockito.<DomainOauth2ClientCompositeKey>any());

    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(oAuth2ClientId);
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.removeOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).deleteById(isA(DomainOauth2ClientCompositeKey.class));
    verify(domainId).getId();
    verify(oAuth2ClientId).getId();
  }

  /**
   * Test {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#removeOauth2Client(DomainOauth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.removeOauth2Client(DomainOauth2Client)"})
  public void testRemoveOauth2Client_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    doNothing()
        .when(domainOauth2ClientRepository)
        .deleteById(Mockito.<DomainOauth2ClientCompositeKey>any());

    DomainId domainId = mock(DomainId.class);
    when(domainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Client.setDomainId(domainId);

    // Act
    jpaDomainDao.removeOauth2Client(domainOauth2Client);

    // Assert
    verify(domainOauth2ClientRepository).deleteById(isA(DomainOauth2ClientCompositeKey.class));
    verify(domainId).getId();
  }

  /**
   * Test {@link JpaDomainDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(domainRepository).deleteByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaDomainDao.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(domainRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaDomainDao#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link DomainRepository#deleteByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaDomainDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaDomainDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(domainRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaDomainDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(domainRepository).deleteByTenantId(isA(UUID.class));
  }
}
